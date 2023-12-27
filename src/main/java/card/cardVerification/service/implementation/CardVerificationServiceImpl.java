package card.cardVerification.service.implementation;

import card.cardVerification.model.CardHit;
import card.cardVerification.repository.CardHitRepository;
import card.cardVerification.service.CardVerificationService;
import card.processor.dto.response.*;
import card.processor.service.ProcessorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardVerificationServiceImpl implements CardVerificationService {

    private final CardHitRepository cardHitRepository;

    private final ProcessorService processorService;

    @Override
    public Mono<ClientResponse> verifyCard(String card) {

        Mono<CardVerificationResponse> cardDetails = processorService.verifyCardScheme(card);

        return getClientResponse(cardDetails, card);
    }

    @Override
    public Mono<ClientResponse> verifyCard2(String bin) {

        CardVerificationResponse cardDetails = processorService.getCardDetails(bin);

        return getClientResponse2(cardDetails, bin);
    }

    @Override
    public StatsResponse getCardStats(int start, int limit) {

        List<CardHit> cardHitList = getLimitedCardHits(limit);

        Map<String, String> data = convertToMap(cardHitList);

        int size = data.size();

        Map<String, String> paginatedHits = data.entrySet()
                .stream()
                .skip(start - 1)
                .limit(limit)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return new StatsResponse(true, start, limit, size, paginatedHits);
    }

    public List<CardHit> getLimitedCardHits(int limit) {
        return cardHitRepository.findAll(PageRequest.of(0, limit)).getContent();
    }

    public Map<String, String> convertToMap(List<CardHit> cardHitList) {

        return cardHitList.stream()
                .collect(Collectors.toMap(CardHit::getBin, hit -> String.valueOf(hit.getHitCount())));
    }

//    private ClientResponse getClientResponse(Mono<CardVerificationResponse> cardInfoResponse) {
//
//        return cardInfoResponse.map(response -> {
//            Payload payload = new Payload();
//
//            if (!Objects.isNull(response.getBank())) {
//                payload.setBank(getBankName(response));
//            }
//
//            payload.setScheme(response.getScheme());
//            payload.setType(response.getType());
//
//            saveCardHit(response);
//
//            return ClientResponse.builder()
//                    .success(true)
//                    .payload(payload)
//                    .build();
//        }).block();
//    }

    private Mono<ClientResponse> getClientResponse(Mono<CardVerificationResponse> cardInfoResponse, String bin) {
        return cardInfoResponse.flatMap(response -> {
            Payload payload = new Payload();

            if (!Objects.isNull(response.getBank())) {
                payload.setBank(getBankName(response));
            }

            payload.setScheme(response.getScheme());
            payload.setType(response.getType());

            saveCardHit(bin);

            ClientResponse clientResponse = ClientResponse.builder()
                    .success(true)
                    .payload(payload)
                    .build();

            return Mono.just(clientResponse);
        });
    }

    private Mono<ClientResponse> getClientResponse2(CardVerificationResponse cardInfoResponse, String card) {
        Payload payload = new Payload();

        payload.setScheme(cardInfoResponse.getScheme());
        payload.setType(cardInfoResponse.getType());
        payload.setBank(cardInfoResponse.getBank().getName());

        saveCardHit(card);

        ClientResponse clientResponse = ClientResponse.builder()
                .success(true)
                .payload(payload)
                .build();

        return Mono.just(clientResponse);
    }

    private void saveCardHit(String bin) {
        CardHit savedCardHit = cardHitRepository.findByBin(bin);
        log.info("saved c {}", savedCardHit);

        if (Objects.isNull(savedCardHit)) {
            CardHit cardHit = new CardHit();
            cardHit.setBin(bin);
            cardHit.setHitCount(1);
            cardHitRepository.save(cardHit);
        } else {
            savedCardHit.setHitCount(savedCardHit.getHitCount() + 1);
            cardHitRepository.save(savedCardHit);
        }
    }


    private String getBankName(CardVerificationResponse cardInfoResponse) {
        return Optional.ofNullable(cardInfoResponse.getBank())
                .map(BankInfo::getName)
                .orElse(null);
    }


}
