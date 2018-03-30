package com.cristi.web.firstweb.infra;

import com.cristi.web.firstweb.domain.local.ImportedRisk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportedRisksSdj extends JpaRepository<ImportedRisk, String> {
}
