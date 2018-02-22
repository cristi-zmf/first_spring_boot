package com.cristi.web.firstweb.infra;

import com.cristi.web.firstweb.domain.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadersSdj  extends JpaRepository<Reader, String>{
}
