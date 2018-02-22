package com.cristi.web.firstweb.infra;

import com.cristi.web.firstweb.domain.Reader;
import com.cristi.web.firstweb.domain.Readers;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SdjReaders implements Readers{

    private final ReadersSdj sdj;

    public SdjReaders(ReadersSdj sdj) {
        this.sdj = sdj;
    }


    @Override
    public Optional<Reader> get(String username) {
        return Optional.ofNullable(sdj.findOne(username));
    }
}
