package card.cardVerification.service.implementation;

import card.cardVerification.repository.CardHitRepository;
import card.processor.dto.response.CardVerificationResponse;
import card.processor.dto.response.ClientResponse;
import card.processor.service.ProcessorService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@SpringBootTest
class CardVerificationServiceImplTest {

    @Mock
    private CardHitRepository cardHitRepository;
    @Mock
    private ProcessorService processorService;

    @InjectMocks
    private CardVerificationServiceImpl cardVerificationService;

//    @Test
//    void verifyCard_ShouldReturnClientResponse() {
//        // Arrange
//        String card = "1234567890123456";
//        CardVerificationResponse mockResponse = createMockCardVerificationResponse();
//        when(processorService.verifyCardSchemeWithWebClient(anyString())).thenReturn(Mono.just(mockResponse));
//
//        // Act
//        Mono<ClientResponse> result = cardVerificationService.verifyCard(card).log();
//
//        // Assert
//        assertNotNull(result.block());
//        assertTrue(result.block().isSuccess());
//        assertNotNull(result.block().getPayload());
//        assertNotNull(result.block().getPayload().getScheme());
//        assertNotNull(result.block().getPayload().getType());
//        assertNotNull(result.block().getPayload().getBank());
//    }

//    @Test
//    void verifyCard2_ShouldReturnClientResponse() {
//        // Arrange
//        String card = "1234567890123456";
//        CardVerificationResponse mockResponse = createMockCardVerificationResponse();
//        when(processorService.verifyCardSchemeWithUnirest(anyString())).thenReturn(mockResponse);
//
//        // Act
//        Mono<ClientResponse> result = cardVerificationService.verifyCard2(card).log();
//
//        // Assert
//        assertNotNull(result.block());
//        assertTrue(result.block().isSuccess());
//        assertNotNull(result.block().getPayload());
//        assertNotNull(result.block().getPayload().getScheme());
//        assertNotNull(result.block().getPayload().getType());
//        assertNotNull(result.block().getPayload().getBank());
//    }

    private CardVerificationResponse createMockCardVerificationResponse() {
        // Implement this method to create a mock CardVerificationResponse for testing
        // You can use a mocking library like Mockito or create a simple instance manually
        return Mockito.mock(CardVerificationResponse.class);
    }
}