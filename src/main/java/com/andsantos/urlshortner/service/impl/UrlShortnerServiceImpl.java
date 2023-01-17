package com.andsantos.urlshortner.service.impl;

import java.math.BigInteger;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andsantos.urlshortner.model.entity.Url;
import com.andsantos.urlshortner.model.response.UrlDTO;
import com.andsantos.urlshortner.repository.UrlRepository;
import com.andsantos.urlshortner.service.UrlShortnerService;

@Service
@Transactional
public class UrlShortnerServiceImpl implements UrlShortnerService {
    @Value("${urlshortner.urlbase}")
    private String urlBase;

    private static final String[] BASE62CHARS = 
            "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

    private UrlRepository repository;

    public UrlShortnerServiceImpl(UrlRepository urlRepository) {
        this.repository = urlRepository;
    }

    @Override
    public UrlDTO encurtar(String urlOriginal) {

        Optional<Url> optional = repository.findByUrlOriginal(urlOriginal);

        if (optional.isPresent()) {
            return new UrlDTO(urlBase + optional.get().getUrlReduzida());
        }

        int id = gerarId();
        String hash = toBase62(id);

        Url url = new Url();
        url.setUrlOriginal(urlOriginal);
        url.setUrlReduzida(hash);

        repository.save(url);

        return new UrlDTO(urlBase + url.getUrlReduzida());
    }

    protected int gerarId() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().replace("-", "");
        BigInteger bigInteger = new BigInteger(id, 16);
        int valor = bigInteger.intValue();
        return valor < 0 ? valor * -1 : valor;
    }

    protected String toBase62(int num) {
        StringBuilder converted = new StringBuilder();

        while (num / 62 != 0) {
            int remainder = num % 62;
            converted.append(BASE62CHARS[remainder]);
            num = num / 62;
        }

        return converted.reverse().toString();
    }

    @Override
    public String obterURL(String chave) {
        Optional<Url> optional = repository.findByUrlReduzida(chave);

        if (optional.isPresent()) {
            return optional.get().getUrlOriginal();
        }

        return null;
    }

}
