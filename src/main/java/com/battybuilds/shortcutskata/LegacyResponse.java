package com.battybuilds.shortcutskata;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LegacyResponse {
    private String id;
    private LegacyRequest incomingRequest;
}
