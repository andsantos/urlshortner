package com.andsantos.urlshortner.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.andsantos.urlshortner.model.response.UrlDTO;
import com.andsantos.urlshortner.service.UrlShortnerService;

@Controller
public class UrlShortnerController {
    private UrlShortnerService service;

    public UrlShortnerController(UrlShortnerService urlService) {
        this.service = urlService;
    }

    @PostMapping("/api/novo")
    public ResponseEntity<UrlDTO> encurtar(@RequestBody UrlDTO url) {
        UrlDTO dto = service.encurtar(url.getUrl());
        return ResponseEntity.ok().body(dto);
    }
}
