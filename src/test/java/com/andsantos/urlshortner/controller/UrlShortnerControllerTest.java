package com.andsantos.urlshortner.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.andsantos.urlshortner.UrlshortnerApplication;

@SpringBootTest(classes = UrlshortnerApplication.class)
@AutoConfigureMockMvc
class UrlShortnerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void encurtarURL() throws Exception {
        String content = obterResultado();
        String outroContent = obterResultado();
        assertThat(content).isEqualTo(outroContent);
    }

    protected String obterResultado() throws Exception {
        String json = "{\"url\":\"https://urlmuitomuitolonga.com\"}";

        MvcResult result = mockMvc.perform(post("/api/url")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk()).andReturn();

        return result.getResponse().getContentAsString();
    }
}
