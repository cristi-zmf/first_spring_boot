package com.cristi.web.firstweb.infra;

import com.cristi.web.firstweb.domain.generic.GenericRisk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericRisksSdj extends JpaRepository<GenericRisk, String> {
}
