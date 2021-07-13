package com.battybuilds.shortcutskata;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LegacyService {
    public LegacyResponse convert(LegacyRequest request, String identificationNo) {
        if (!identificationNo.startsWith("1")) {
            return LegacyResponse.builder().incomingRequest(null).id("Invalid").build();
        }
        if (request.vin.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This vin is not valid");
        }
        LegacyResponse response = LegacyResponse.builder().id(identificationNo).incomingRequest(request).build();
        return response;
    }
}
