package com.battybuilds.shortcutskata;

import org.springframework.stereotype.Service;

@Service
public class LegacyService {
    public LegacyResponse convert(LegacyRequest request, String identificationNo) {
        LegacyResponse response = LegacyResponse.builder().id(identificationNo).incomingRequest(request).build();
        return response;
    }
}
