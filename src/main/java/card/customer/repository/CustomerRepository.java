//package card.bank.customer.repository;
//
//
//import card.bank.customer.model.Customer;
//import card.bank.auth.model.UserSecurityDetails;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Optional;
//
//
//public interface CustomerRepository extends JpaRepository<Customer, Long> {
//
//    Optional<Customer> findByUserSecurityDetails_Id(Long userSecurityDetailsId);
//
//    Optional<Customer> findCustomerByUserSecurityDetails_Email(String email);
//
//    Customer findByUserSecurityDetails(UserSecurityDetails userSecurityDetails);
//
//}
