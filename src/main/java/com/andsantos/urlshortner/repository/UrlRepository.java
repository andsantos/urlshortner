package com.andsantos.urlshortner.repository;

import java.util.Optional;

import com.andsantos.urlshortner.model.entity.Url;

public interface UrlRepository {

    Optional<Url> findByUrlOriginal(String urlOriginal);

    Optional<Url> findByUrlReduzida(String urlReduzida);

    Url save(Url save);
}