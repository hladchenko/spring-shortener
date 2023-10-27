package com.hladchenko.shortener.controller;

import com.hladchenko.shortener.service.ShortenerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/shortener")
@RestController
public class ShortenerController {

    ShortenerService shortenerService;

    public ShortenerController(ShortenerService shortenerService) {
        this.shortenerService = shortenerService;
    }

    @PostMapping
    public ResponseEntity<String> createShortUrl(@RequestParam String fullUrl) {
        String shortUrl = shortenerService.createShortUrl(fullUrl);
        return ResponseEntity.ok(shortUrl);
    }

    @GetMapping("/{shortUrl}")
    public String getFullUrl(@PathVariable String shortUrl) {
        return shortenerService.getFullUrl(shortUrl);
    }
}
