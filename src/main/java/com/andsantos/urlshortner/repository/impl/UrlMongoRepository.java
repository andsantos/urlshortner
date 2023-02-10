package com.andsantos.urlshortner.repository.impl;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.andsantos.urlshortner.model.entity.Url;
import com.andsantos.urlshortner.repository.UrlRepository;

@Repository
public interface UrlMongoRepository extends MongoRepository<Url, String>, UrlRepository {
}
