package com.battybuilds.shortcutskata;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LegacyController {
    LegacyService service;

    public LegacyController(LegacyService service) {
        this.service = service;
    }

    @PostMapping("/do-stuff")
    public ResponseEntity<LegacyResponse> wakeUp(@RequestHeader(value = "Identification-No")
                                                         String identificationNo,
                                                 @RequestBody
                                                         LegacyRequest request) {
        LegacyResponse response = service.convert(request, identificationNo);
        return ResponseEntity.ok(response);
    }
}
