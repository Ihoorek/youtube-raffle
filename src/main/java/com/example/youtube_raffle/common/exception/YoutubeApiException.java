package com.example.youtube_raffle.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class YoutubeApiException extends RuntimeException {

    private HttpStatus status;

    public YoutubeApiException(String message, HttpStatus status) {
        super(message);
    }

    public static YoutubeApiException notFound(String message) {
        return new YoutubeApiException(message, HttpStatus.NOT_FOUND);
    }

    public static YoutubeApiException internalError(String message) {
        return new YoutubeApiException(message, HttpStatus.BAD_REQUEST);
    }

    public static YoutubeApiException badGateway(String message) {
        return new YoutubeApiException(message, HttpStatus.BAD_GATEWAY);
    }
}
