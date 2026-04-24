package com.example.youtube_raffle.controller;

import com.example.youtube_raffle.service.RaffleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/youtube")
public class RaffleController {

    private final RaffleService raffleService;

    @GetMapping
    public String index() {
        return "index";
    }

    @PostMapping("/raffle")
    public String raffle(@RequestParam("videoUrl") String videoUrl, Model model) throws IOException {
        String videoId = raffleService.extractVideoId(videoUrl);
        List<String> commenters = raffleService.getCommenters(videoId);
        Map<String, String> winners = raffleService.pickWinners(commenters);
        model.addAttribute("winners", winners);
        return "result";
    }
}
