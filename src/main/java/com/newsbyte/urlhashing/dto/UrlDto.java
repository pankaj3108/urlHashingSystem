package com.newsbyte.urlhashing.dto;

import com.sun.istack.NotNull;

public class UrlDto {

    private @NotNull String url;

    public UrlDto() {

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
