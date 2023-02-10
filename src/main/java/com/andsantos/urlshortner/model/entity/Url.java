package com.andsantos.urlshortner.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "urls")
public class Url {

    @Id
	private String urlReduzida;

	private String urlOriginal;
}
