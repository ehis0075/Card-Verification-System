package card.processor.service.implementation;

import card.http.HttpService;
import card.processor.dto.response.CardVerificationResponse;
import card.processor.service.ProcessorService;
import card.exception.GeneralException;
import card.general.service.GeneralService;
import com.google.gson.Gson;
import kong.unirest.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class ProcessorServiceImpl implements ProcessorService {

    private final WebClient webClient;

    @Value("${binList.baseUrl}")
    private String baseUrl;
    private final Gson gson;
    private final HttpService httpService;
    private final GeneralService generalService;

    public ProcessorServiceImpl(Gson gson, HttpService httpService, GeneralService generalService) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
        this.gson = gson;
        this.httpService = httpService;
        this.generalService = generalService;
    }

    @Override
    public Mono<CardVerificationResponse> verifyCardScheme(String bin) {
        return webClient.get()
                .uri("/{bin}", bin)
                .retrieve()
                .bodyToMono(CardVerificationResponse.class);
    }

    @Override
    public CardVerificationResponse getCardDetails(String card) {
        log.info("Making Request to Card details {}", card);

        String fullUrl = baseUrl + card;

        HttpResponse<String> httpResponse = httpService.get(getHeaders(), null, fullUrl);
        String responseAsString = generalService.getResponseAsString2(httpResponse);
        log.info("Card details Response {}", responseAsString);

        int status = httpResponse.getStatus();
        log.info("status {}", status);

        //check if response is valid
        if (status == 200 && Objects.nonNull(httpResponse.getBody())) {
            return getResponse(httpResponse);
        }

        //if status code is 500 or any other response
        throw new GeneralException("Service unavailable");
    }

    private CardVerificationResponse getResponse(HttpResponse<String> httpResponse) {
        String body = httpResponse.getBody();
        CardVerificationResponse cardInfoResponse = gson.fromJson(body, CardVerificationResponse.class);

        if (Objects.isNull(cardInfoResponse)) {
            throw new GeneralException("An error occurred");
        }

        return cardInfoResponse;
    }

    private Map<String, String> getHeaders() {
        log.info("Getting headers ...");

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return headers;
    }

}
