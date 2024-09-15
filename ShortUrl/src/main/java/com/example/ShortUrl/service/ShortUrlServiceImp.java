package com.example.ShortUrl.service;

import com.example.ShortUrl.model.ShortUrl;
import com.example.ShortUrl.repository.ShortUrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class ShortUrlServiceImp implements ShortUrlService{
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_URL_LENGTH=6;

    private  final ShortUrlRepository shortUrlRepository;
    @Override
    public String shorten(String originalUrl) {
        String shortUrl=generateShortUrl();
        ShortUrl shortUrl1=new ShortUrl();
        shortUrl1.setOriginalUrl(originalUrl);
        shortUrl1.setShortUrl(shortUrl);
        return shortUrl;
    }
    public String getOriginalUrl(String shortUrl) {
        ShortUrl url = shortUrlRepository.findByShortUrl(shortUrl);
        return url != null ? url.getOriginalUrl() : null;
    }

    private  String generateShortUrl(){
        StringBuilder shortUrl=new StringBuilder(SHORT_URL_LENGTH);
        Random random=new Random();
        for(int i=0;i<SHORT_URL_LENGTH;i++){
            shortUrl.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return shortUrl.toString();
    }
}
