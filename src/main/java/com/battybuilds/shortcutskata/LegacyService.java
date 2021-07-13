package com.battybuilds.shortcutskata;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class LegacyService {
    public LegacyResponse convert(LegacyRequest request, String identificationNo) {
        if (!identificationNo.startsWith("1")) {
            return LegacyResponse.builder().incomingRequest(null).id("Invalid").build();
        }
        LegacyResponse response = LegacyResponse.builder().id(identificationNo).incomingRequest(request).build();
        return response;
    }
}
