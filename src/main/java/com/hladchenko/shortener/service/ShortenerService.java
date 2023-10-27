package com.hladchenko.shortener.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ShortenerService {

    private static final Map<String, String> STORAGE = new ConcurrentHashMap<>();

    public String createShortUrl(String fullUrl) {
        String shortUrl = getShortUrl(fullUrl);
        STORAGE.put(shortUrl, fullUrl);
        return ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString() + "/" + shortUrl;
    }

    public String getFullUrl(String shortUrl) {
        return STORAGE.get(shortUrl);
    }

    private String getShortUrl(String fullUrl) {
        return String.valueOf(fullUrl.hashCode());
    }
}
