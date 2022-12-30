package com.andsantos.urlshortner.repository;

import java.util.Optional;

import com.andsantos.urlshortner.model.entity.Url;

public interface UrlRepository {

    Url findByUrlOriginal(String urlOriginal);

    Optional<Url> findById(String id);

    Url save(Url save);
}