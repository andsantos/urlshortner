package com.andsantos.urlshortner.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RedisHash("urls")
public class Url {

    @Id
	private String urlReduzida;

    @Indexed
	private String urlOriginal;
}
