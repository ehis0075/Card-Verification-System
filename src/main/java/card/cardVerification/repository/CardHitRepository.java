package card.cardVerification.repository;

import card.cardVerification.model.CardHit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardHitRepository extends JpaRepository<CardHit, Long> {

    CardHit findByBin(String bankName);

}
