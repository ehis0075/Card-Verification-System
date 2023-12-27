package card.processor.service;


import card.processor.dto.response.CardVerificationResponse;
import reactor.core.publisher.Mono;

public interface ProcessorService {

    Mono<CardVerificationResponse> verifyCardSchemeWithWebClient(String cardNumber);

    CardVerificationResponse verifyCardSchemeWithUnirest(String card);

}
