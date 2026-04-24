package com.example.youtube_raffle.common.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "youtube.api")
@Getter
@Setter
public class YoutubeProperties {
    private String key;
}
