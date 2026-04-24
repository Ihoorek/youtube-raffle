package com.example.youtube_raffle.common.model;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Builder
@Getter
public class ErrorResponse {

    private final Instant timestamp = Instant.now();
    private final String message;
    private final List<ErrorList> errors;

    @Builder
    @Getter
    public static class ErrorList {
        private final String field;
        private final String error;
    }
}
