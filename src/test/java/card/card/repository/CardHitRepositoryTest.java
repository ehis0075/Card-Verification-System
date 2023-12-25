package card.card.repository;

import card.card.model.CardHit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class CardHitRepositoryTest {

    @Autowired
    private CardHitRepository cardHitRepository;

    @Test
    void findByBin_ShouldReturnCardHit() {

        // Arrange
        CardHit cardHit = CardHit.builder()
                .bin("123456")
                .hitCount(3)
                .build();

        cardHitRepository.save(cardHit);

        // Act
        CardHit foundCardHit = cardHitRepository.findByBin("123456");

        // Assert
        assertNotNull(foundCardHit);
        assertEquals("123456", foundCardHit.getBin());
        assertEquals(3, foundCardHit.getHitCount());
    }

    @Test
    void findByBin_ShouldReturnNullWhenNotFound() {
        // Act
        CardHit foundCardHit = cardHitRepository.findByBin("nonexistentBin");

        // Assert
        assertNull(foundCardHit);
    }
}