package com.newsbyte.urlhashing.controller;

import com.newsbyte.urlhashing.dto.UrlDto;
import com.newsbyte.urlhashing.model.URL;
import com.newsbyte.urlhashing.service.UrlService;
import com.newsbyte.urlhashing.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/add-url")
    public ResponseEntity<ApiResponse> addUrl(@RequestBody UrlDto url) {

        String hash = this.urlService.convertLongUrlToShortUrl(url);

        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "http://www.localhost:5000/"+hash), HttpStatus.CREATED);

    }

    @GetMapping("/{hash_key}")
    public URL getUrl(@PathVariable("hash_key") String hash) {

        URL urlBody = this.urlService.getURLByHash(hash);

        return urlBody;

    }

}
