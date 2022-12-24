package com.andsantos.urlshortner.service.impl;

import java.math.BigInteger;
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
    private String URL_BASE;

    private static final String[] BASE62CHARS = 
            "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

    private UrlRepository repository;

    public UrlShortnerServiceImpl(UrlRepository urlRepository) {
        this.repository = urlRepository;
    }

    @Override
    public UrlDTO encurtar(String urlOriginal) {

        Url url = repository.findByUrlOriginal(urlOriginal);

        if (url == null) {
            int id = gerarId();
            String hash = toBase62(id);

            url = new Url();
            url.setUrlOriginal(urlOriginal);
            url.setUrlReduzida(hash);

            repository.save(url);
        }

        return new UrlDTO(URL_BASE + url.getUrlReduzida());
    }

    protected int gerarId() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().replace("-", "");
        BigInteger bigInteger = new BigInteger(id, 16);
        int valor = bigInteger.intValue();
        return valor < 0 ? valor * -1 : valor;
    }

    protected String toBase62(int num) {
        String converted = "";

        while (num / 62 != 0) {
            int remainder = num % 62;
            converted += BASE62CHARS[remainder];
            num = num / 62;
        }

        return new StringBuilder(converted).reverse().toString();
    }

}
