package com.example.ShortUrl.controller;

import com.example.ShortUrl.service.ShortUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/url/")
@RequiredArgsConstructor
public class ShortUrlController {

    private final ShortUrlService shortUrlService;
    @PostMapping("shorten")
    public String shorten(@RequestBody String originalUrl){
       return shortUrlService.shorten(originalUrl);
    }
    @GetMapping("{shorturl}")
    public String redirectToOriginalUrl(@PathVariable String shorturl){
        String originalUrl=shortUrlService.getOriginalUrl(shorturl);
        if (originalUrl != null) {
            return "redirect:" + originalUrl;
        } else {
            return "URL not found";
        }
    }
}
