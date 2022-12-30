package com.andsantos.urlshortner.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andsantos.urlshortner.model.entity.Url;
import com.andsantos.urlshortner.repository.UrlRepository;

@Repository
public interface UrlJPARepository extends JpaRepository<Url, String>, UrlRepository {
}
