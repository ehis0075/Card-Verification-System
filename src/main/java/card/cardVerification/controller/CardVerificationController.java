package card.cardVerification.controller;

import card.processor.dto.response.ClientResponse;
import card.processor.dto.response.StatsResponse;
import card.cardVerification.service.CardVerificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("card-scheme")
public class CardVerificationController {
    private final CardVerificationService cardVerificationService;

    public CardVerificationController(CardVerificationService cardVerificationService) {
        this.cardVerificationService = cardVerificationService;
    }

    @RequestMapping(path = "/verify/{bin}", method = RequestMethod.GET, produces = "application/json")
    public Mono<ClientResponse> verifyCard(@PathVariable String bin) {
        logMe(bin, 1);
        Mono<ClientResponse> response = cardVerificationService.verifyCard2(bin);
        logMe(response, 2);
        return response;
    }

    @RequestMapping(path = "/stats", method = RequestMethod.GET, produces = "application/json")
    public StatsResponse getCardStats(@RequestParam(name = "start", defaultValue = "1") int start,
                                      @RequestParam(name = "limit", defaultValue = "3") int limit) {
        logMe("", 1);
        StatsResponse response = cardVerificationService.getCardStats(start, limit);
        logMe(response, 2);
        return response;
    }

    private void logMe(Object toLog, int type) {
        if (type == 1) {
            log.info("Incoming Request {}", toLog);
        } else {
            log.info("Outgoing Response {}", toLog);
        }
    }

}
