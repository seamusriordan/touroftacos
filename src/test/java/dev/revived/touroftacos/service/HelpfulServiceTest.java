package dev.revived.touroftacos.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HelpfulServiceTest {

    @Mock
    private ExchangeFunction exchangeFunction;

    @Test
    public void testThing() {
        WebClient webClient = WebClient.builder()
                .exchangeFunction(exchangeFunction)
                .build();

        when(exchangeFunction.exchange(any(ClientRequest.class)))
                .thenReturn(Mono.just(
                      ClientResponse.create(HttpStatus.OK)
                        .body("fffffffffffffffffff")
                        .build()
                ));

        var service = new HelpfulService(webClient);

        service.getHelp();

        verify(exchangeFunction).exchange(any(ClientRequest.class));
    }

}