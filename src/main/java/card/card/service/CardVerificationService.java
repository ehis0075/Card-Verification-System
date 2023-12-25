package card.card.service;


import card.processor.dto.response.ClientResponse;
import card.processor.dto.response.StatsResponse;
import reactor.core.publisher.Mono;

public interface CardVerificationService {

    Mono<ClientResponse> verifyCard(String card);

    Mono<ClientResponse> verifyCard2(String card);

    StatsResponse getCardStats(int start, int limit);
}
