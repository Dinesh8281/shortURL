package com.example.ShortUrl.repository;

import com.example.ShortUrl.model.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ShortUrlRepository extends JpaRepository<ShortUrl,Long> {

    ShortUrl findByShortUrl(String shortUrl);
}
