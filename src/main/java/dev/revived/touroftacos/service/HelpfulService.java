package dev.revived.touroftacos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class HelpfulService {

    private WebClient webClient;

    @Autowired
    public HelpfulService(WebClient webClient) {
        this.webClient = webClient;
    }

    public String getHelp() {
        webClient.get().uri("http://localhost:8080/frum/grib")
                .retrieve().bodyToMono(String.class).block();
        return "I'M HELPING";
    }
}