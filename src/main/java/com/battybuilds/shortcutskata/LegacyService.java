package com.battybuilds.shortcutskata;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LegacyService {

    public LegacyResponse convert(LegacyRequest request, String identificationNo) {
        nameChecker(request);
        if (!identificationNo.startsWith("1")) {
            return LegacyResponse.builder().incomingRequest(null).id("Invalid").build();
        }

        LegacyResponse response = LegacyResponse.builder().id(identificationNo).incomingRequest(request).build();

        if (request.vin.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This vin is not valid");
        }
        if (request.vin.contains("test")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This vin is not valid");
        }
        return response;
    }

    private void nameChecker(LegacyRequest request) {
        if ("Bill Ford".equals(request.getName())) throw new RuntimeException("Unexpected!");
    }

}
