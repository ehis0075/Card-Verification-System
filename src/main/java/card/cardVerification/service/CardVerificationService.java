package card.cardVerification.service;


import card.processor.dto.response.ClientResponse;
import card.processor.dto.response.StatsResponse;
import reactor.core.publisher.Mono;

public interface CardVerificationService {

    Mono<ClientResponse> verifyCard(String card);

    ClientResponse verifyCard2(String bin);

    StatsResponse getCardStats(int start, int limit);
}
