package com.cristi.web.firstweb.infra;

import com.cristi.web.firstweb.domain.local.SpecificRisk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecificRisksSdj extends JpaRepository<SpecificRisk, String> {

}
