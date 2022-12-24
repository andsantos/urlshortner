package com.andsantos.urlshortner.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "urls")
public class Url {

    @Id
	private String urlReduzida;

    @Column
	private String urlOriginal;
}
