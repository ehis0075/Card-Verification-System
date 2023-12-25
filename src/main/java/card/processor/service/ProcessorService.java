package card.processor.service;


import card.processor.dto.response.CardVerificationResponse;
import reactor.core.publisher.Mono;

public interface ProcessorService {

    Mono<CardVerificationResponse> verifyCardScheme(String cardNumber);

    CardVerificationResponse getCardDetails(String card);

}
