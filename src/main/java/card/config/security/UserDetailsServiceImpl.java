//package card.bank.config.security;
//
//
//import card.bank.auth.dto.UserDetailsPayloadDTO;
//import card.bank.auth.dto.UserResponse;
//import card.bank.auth.model.UserSecurityDetails;
//import card.bank.auth.repository.UserSecurityDetailsRepository;
//import card.bank.customer.service.CustomerService;
//import card.bank.exception.GeneralException;
//import card.bank.general.enums.ResponseCodeAndMessage;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Component
//@AllArgsConstructor
//@Slf4j
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    private UserSecurityDetailsRepository userSecurityDetailsRepository;
//
//    private CustomerService customerService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        log.info("inside load user by username method----->");
//        try{
//            UserSecurityDetails userSecurityDetails = userSecurityDetailsRepository.findByEmail(username).orElseThrow(()-> new GeneralException(ResponseCodeAndMessage.RECORD_NOT_FOUND_88.responseCode, "User does not exist"));
//            log.info("security details {}", userSecurityDetails);
//
//            UserResponse userAndMerchantIdResponse = getUserResponse(userSecurityDetails.getEmail());
//            return getUserDetailsPayload(userSecurityDetails, userAndMerchantIdResponse);
//        }catch (Exception e){
//            throw new UsernameNotFoundException("User does not exist");
//        }
//    }
//
//    private UserDetailsPayloadDTO getUserDetailsPayload(UserSecurityDetails userSecurityDetails, UserResponse userAndMerchantIdResponse){
//       return new UserDetailsPayloadDTO(userSecurityDetails.getEmail(), userSecurityDetails.getPassword(), userSecurityDetails.isEnabled(), userSecurityDetails.isLocked(),
//               (Set<? extends GrantedAuthority>) userSecurityDetails.getAuthorities(),userAndMerchantIdResponse.getId(), getPermissions(userSecurityDetails.getAuthorities()));
//    }
//    private UserResponse getUserResponse(String email){
//        return new UserResponse(customerService.getCustomerIdByEmail(email));
//    }
//
//    private Set<String> getPermissions(Collection<? extends GrantedAuthority> authorities){
//        return authorities.stream().map(String::valueOf).collect(Collectors.toSet());
//    }
//}
