package com.hladchenko.shortener.controller;

import com.hladchenko.shortener.service.ShortenerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> getFullUrl(@PathVariable String shortUrl) {
        return ResponseEntity
                .status(HttpStatus.MOVED_PERMANENTLY)
                .header(HttpHeaders.LOCATION, shortenerService.getFullUrl(shortUrl)).build();
    }
}
