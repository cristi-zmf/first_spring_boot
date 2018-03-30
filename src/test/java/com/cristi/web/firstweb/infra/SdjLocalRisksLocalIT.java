package com.cristi.web.firstweb.infra;

import com.cristi.web.firstweb.domain.generic.GenericRisk;
import com.cristi.web.firstweb.domain.local.ImportedRisk;
import com.cristi.web.firstweb.domain.local.LocalRisk;
import com.cristi.web.firstweb.domain.local.SpecificRisk;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("H2")
@Transactional
public class SdjLocalRisksLocalIT {

    public static final String GEN_LABEL_FR = "mumu";
    public static final String GEN_LABEL_EN = "cucu";
    public static final String SPEC_RISK_ID = "SPE1";
    public static final String SPE_LABEL_FR = "susu";
    public static final String SPE_LABEL_EN = "tutu";
    public static final String OE_1 = "OE1";
    public static final String GENERIC_RISK_ID = "GEN1";
    public static final String IMPORTED_RE_ID = "IMP1";
    @Autowired GenericRisksSdj genericRisksSdj;
    @Autowired ImportedRisksSdj importedRisksSdj;
    @Autowired SpecificRisksSdj specificRisksSdj;

    @Autowired LocalRisksSdj sdj;
    @Autowired SdjLocalRisks sut;


    @Before
    public void setupTestData() {
        GenericRisk genericRisk = new GenericRisk(
                GENERIC_RISK_ID, new HashSet<>(asList(GEN_LABEL_EN, GEN_LABEL_FR))
        );

        SpecificRisk specificRisk = new SpecificRisk(
                SPEC_RISK_ID, new HashSet<>(asList(SPE_LABEL_EN, SPE_LABEL_FR)), "SPECIFIC", OE_1
        );

        ImportedRisk importedRisk = new ImportedRisk(IMPORTED_RE_ID, GENERIC_RISK_ID, OE_1);

        genericRisksSdj.saveAndFlush(genericRisk);
        specificRisksSdj.saveAndFlush(specificRisk);
        importedRisksSdj.saveAndFlush(importedRisk);
    }

    @Test
    public void find_all_should_return_all_local_risk_events_regardless_of_their_type() {
        Set<LocalRisk> localRisks = sut.findAll();
        assertThat(localRisks).hasSize(2);
        LocalRisk localRiskFromSpecific = localRisks.stream()
                .filter(r -> r.getRiskId().equals(SPEC_RISK_ID))
                .findFirst()
                .get();
        assertThat(localRiskFromSpecific.getOeId()).isEqualTo(OE_1);
        Set<String> labelsSpecificRe = localRiskFromSpecific.getLabelValue();
        assertThat(labelsSpecificRe).contains(SPE_LABEL_EN, SPE_LABEL_FR);

        LocalRisk localRiskFromImported = localRisks.stream()
                .filter(
                        r -> r.getRiskId().equals(GENERIC_RISK_ID)
                        && r.getOeId().equals(OE_1)
                ).findFirst()
                .get();

        assertThat(localRiskFromImported.getLabelValue()).hasSize(2);
        assertThat(localRiskFromImported.getLabelValue()).contains(GEN_LABEL_EN, GEN_LABEL_FR);

    }
}
