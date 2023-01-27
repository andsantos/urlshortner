package com.andsantos.urlshortner.repository.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andsantos.urlshortner.model.entity.Url;
import com.andsantos.urlshortner.repository.UrlRepository;

@Repository
public interface UrlCrudRepository extends CrudRepository<Url, String>, UrlRepository {
}
