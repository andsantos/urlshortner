package com.andsantos.urlshortner.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;

import com.andsantos.urlshortner.model.response.UrlDTO;
import com.andsantos.urlshortner.service.UrlShortnerService;

@Controller
public class UrlShortnerController {
    private UrlShortnerService service;

    public UrlShortnerController(UrlShortnerService urlService) {
        this.service = urlService;
    }

    @PostMapping("/api/url")
    public ResponseEntity<UrlDTO> encurtar(@RequestBody UrlDTO url) {
        UrlDTO dto = service.encurtar(url.getUrl());
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/u/{codigo}")
    public RedirectView redirecionar(@PathVariable String codigo) {
        RedirectView redirectView = new RedirectView();
        String url = service.obterURL(codigo);
        if (url == null) {
            redirectView.setUrl("URL_PAGINA_404");
        }
        redirectView.setUrl(url);
        return redirectView;
    }
}
