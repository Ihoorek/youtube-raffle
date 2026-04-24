package com.example.youtube_raffle;

import com.example.youtube_raffle.common.model.YoutubeProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(YoutubeProperties.class)
@SpringBootApplication
public class YoutubeRaffleApplication {
    public static void main(String[] args) {
        SpringApplication.run(YoutubeRaffleApplication.class, args);
    }
}
