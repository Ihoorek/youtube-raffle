package com.example.youtube_raffle;

import com.google.api.services.youtube.YouTube;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RaffleService {

    @Value("${youtube.api.key}")
    private String apiKey;

    private YouTube buildYouTubeClient() {
        return new YouTube.Builder(
                new com.google.api.client.http.javanet.NetHttpTransport(),
                new com.google.api.client.json.jackson2.JacksonFactory(),
                request -> {
                }
        ).setApplicationName("youtube-raffle").build();
    }

    public String extractVideoId(String url) {
        String pattern = "v=([a-zA-Z0-9_-]{11})";
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile(pattern).matcher(url);
        if (matcher.find()) return matcher.group(1);
        throw new IllegalArgumentException("Invalid YouTube URL");
    }

    public List<String> getCommenters(String videoId) throws IOException {
        YouTube youtube = buildYouTubeClient();
        List<String> commenters = new ArrayList<>();
        String nextPageToken = null;

        do {
            var response = youtube.commentThreads()
                    .list("snippet")
                    .setVideoId(videoId)
                    .setTextFormat("plainText")
                    .setMaxResults(100L)
                    .setPageToken(nextPageToken)
                    .setKey(apiKey)
                    .execute();
            response.getItems().stream()
                    .map(th -> th.getSnippet().getTopLevelComment().getSnippet().getAuthorDisplayName())
                    .forEach(commenters::add);
            nextPageToken = response.getNextPageToken();
        } while (nextPageToken != null);
        return commenters;
    }

    public Map<String, String> pickWinners(List<String> commenters) {
        commenters = commenters.stream().distinct().toList();
        Collections.shuffle(commenters);
        Map<String, String> winners = new LinkedHashMap<>();
        if (commenters.isEmpty()) {
            throw new IllegalStateException("This video has not been commented yet");
        }
        for (int i = 0; i < Math.min(3, commenters.size()); i++) {
            winners.put((i + 1) + " place", commenters.get(i));
        }
        return winners;
    }
}