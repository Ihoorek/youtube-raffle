package com.example.youtube_raffle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class RaffleController {

    private final RaffleService raffleService;

    public RaffleController(RaffleService raffleService) {
        this.raffleService = raffleService;
    }

    @GetMapping("/youtube")
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
