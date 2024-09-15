package com.example.ShortUrl.service;

public interface ShortUrlService {

    String shorten(String originalUrl);
    String getOriginalUrl(String shortUrl);

}
