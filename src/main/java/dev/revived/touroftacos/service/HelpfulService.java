package dev.revived.touroftacos.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class HelpfulService {

    private WebClient webClient;
    private Logger logger = LoggerFactory.getLogger(HelpfulService.class);

    @Autowired
    public HelpfulService(WebClient weebClient) {
        this.webClient = weebClient;
    }

    public String getHelp() {
        String help = "I'M HELPING";
        logger.error(help);

        var response = webClient.get().uri("http://localhost:8080/derp")
                .retrieve().bodyToMono(String.class).block();
        logger.error(String.format("I HELPED %s", response));

        return help;
    }
}