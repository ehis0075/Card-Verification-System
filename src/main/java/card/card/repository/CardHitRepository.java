package card.card.repository;

import card.card.model.CardHit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardHitRepository extends JpaRepository<CardHit, Long> {

    CardHit findByBin(String bankName);

}
