package com.cristi.web.firstweb.infra;

import com.cristi.web.firstweb.domain.local.LocalRisk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRisksSdj extends JpaRepository<LocalRisk, String> {

}
