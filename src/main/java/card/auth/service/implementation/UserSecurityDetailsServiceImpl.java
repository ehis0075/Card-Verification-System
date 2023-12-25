//package card.bank.auth.service.implementation;
//
//
//import card.bank.customer.dto.CreateCustomerDTO;
//import card.bank.auth.model.UserSecurityDetails;
//import card.bank.auth.repository.UserSecurityDetailsRepository;
//import card.bank.auth.service.UserSecurityDetailsService;
//import card.bank.exception.GeneralException;
//import card.bank.general.enums.ResponseCodeAndMessage;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//
//@AllArgsConstructor
//@Getter
//@Service
//@Slf4j
//public class UserSecurityDetailsServiceImpl implements UserSecurityDetailsService {
//
//    private PasswordEncoder passwordEncoder;
//    private UserSecurityDetailsRepository userSecurityDetailsRepository;
//
//    @Override
//    public UserSecurityDetails createUserSecurityDetails(Object requestObject) {
//        return createCustomerSecurityDetails((CreateCustomerDTO) requestObject);
//    }
//
//    public boolean validateEmail(String email) {
//        log.info("Request to validate {}", email);
//        return userSecurityDetailsRepository.existsByEmail(email);
//    }
//
//    @Override
//    public UserSecurityDetails findUserSecurityDetailsByEmail(String email) {
//        return userSecurityDetailsRepository.findByEmail(email).orElseThrow(() -> new GeneralException(ResponseCodeAndMessage.RECORD_NOT_FOUND_88.responseCode, "User with provided email does not exist"));
//    }
//
//    @Override
//    public UserSecurityDetails saveUserSecurityDetails(UserSecurityDetails userSecurityDetails) {
//        return userSecurityDetailsRepository.save(userSecurityDetails);
//    }
//
//    private UserSecurityDetails createCustomerSecurityDetails(CreateCustomerDTO createAdminUserDTO) {
//        UserSecurityDetails userSecurityDetails = UserSecurityDetails.builder()
//                .enabled(true)
//                .locked(true)
//                .authorities(new HashSet<>())
//                .password(passwordEncoder.encode(createAdminUserDTO.getPassword()))
//                .email(createAdminUserDTO.getEmail())
//                .isLoggedIn(false)
//                .build();
//        return userSecurityDetailsRepository.save(userSecurityDetails);
//    }
//
//}
