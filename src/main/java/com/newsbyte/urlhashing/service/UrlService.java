package com.newsbyte.urlhashing.service;

import com.newsbyte.urlhashing.dto.UrlDto;
import com.newsbyte.urlhashing.model.URL;
import com.newsbyte.urlhashing.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public String convertLongUrlToShortUrl(UrlDto url) {

        String hash =calculateHash();

        Optional<URL> present = this.urlRepository.findByUrlHashKey(hash);

        while(present.isPresent()) {

            hash = calculateHash();

            present = this.urlRepository.findById(hash);

        }

        URL newURL = new URL(hash, url.getUrl(), new Date());

        this.urlRepository.save(newURL);

        return hash;

    }

    private String calculateHash() {

        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";

        char[] hash = new char[6];

        Random random = new Random();

        for(int i=0;i<hash.length;i++) {

            int chIdx = random.nextInt(characters.length());

            hash[i] = characters.charAt(chIdx);

        }

        String hashCode = "";

        for(char h : hash)
            hashCode += h;

        return hashCode;

    }

    public URL getURLByHash(String hash)  {

        Optional<URL> url = this.urlRepository.findByUrlHashKey(hash);

        Date expDate = url.get().getExpiaryDate();
        Date today = new Date();

        if(today.after(expDate)) {

            this.urlRepository.deleteByUrlHashKey(hash);

            throw new RuntimeException("Url has been expired");
        }

        if(url.isPresent())
            return url.get();

        return null;

    }
}
