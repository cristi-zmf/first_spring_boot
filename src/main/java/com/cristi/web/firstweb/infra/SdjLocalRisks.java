package com.cristi.web.firstweb.infra;

import com.cristi.web.firstweb.domain.local.LocalRisk;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class SdjLocalRisks  {
    private final LocalRisksSdj sdj;

    public SdjLocalRisks(LocalRisksSdj sdj) {
        this.sdj = sdj;
    }

    public Set<LocalRisk> findAll() {
        return new HashSet<>(sdj.findAll());
    }
}
