package com.andsantos.urlshortner.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andsantos.urlshortner.model.entity.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, String> {

	Url findByUrlOriginal(String urlOriginal);

	Optional<Url> findById(String id);
}
