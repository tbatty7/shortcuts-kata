package com.battybuilds.shortcutskata;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.*;

class LegacyServiceTest {

    private LegacyService legacyService;

    @BeforeEach
    void setUp() {
        legacyService = new LegacyService();
    }

    @Test
    void returnsRequestIfIdStartsWith_1() {
        LegacyRequest request = LegacyRequest.builder().vin("1234").build();

        LegacyResponse actualResponse = legacyService.convert(request, "1-myId");

        LegacyResponse expectedResponse = LegacyResponse.builder().id("1-myId").incomingRequest(request).build();
        Assertions.assertThat(actualResponse).isEqualTo(expectedResponse);
    }

    @Test
    void returnsInvalidIfIdDoesNotStartWith_1() {
        LegacyRequest request = LegacyRequest.builder().vin("1234").build();

        LegacyResponse actualResponse = legacyService.convert(request, "myId");

        LegacyResponse expectedResponse = LegacyResponse.builder().id("Invalid").incomingRequest(null).build();
        Assertions.assertThat(actualResponse).isEqualTo(expectedResponse);
    }

    @Test
    void throwsBadRequestIfRequestHasNoVIN() throws HttpClientErrorException.BadRequest {
        LegacyRequest request = LegacyRequest.builder().build();

        legacyService.convert(request, "myId");
    }


}