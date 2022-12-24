package com.andsantos.urlshortner.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlDTO {
    private String url;

    public UrlDTO() {
    }

    public UrlDTO(String link) {
        this.url = link;
    }
    
}
