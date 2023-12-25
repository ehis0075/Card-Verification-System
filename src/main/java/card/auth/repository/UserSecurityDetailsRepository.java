//package card.bank.auth.repository;
//
//
//import card.bank.auth.model.UserSecurityDetails;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Optional;
//
//public interface UserSecurityDetailsRepository extends JpaRepository<UserSecurityDetails, Long> {
//    boolean existsByEmail(String email);
//    Optional<UserSecurityDetails> findByEmail(String email);
//
//}
