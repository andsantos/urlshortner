package com.andsantos.urlshortner.service;

import com.andsantos.urlshortner.model.response.UrlDTO;


public interface UrlShortnerService {

    UrlDTO encurtar(String urlOriginal);

    String obterURL(String chave);
}