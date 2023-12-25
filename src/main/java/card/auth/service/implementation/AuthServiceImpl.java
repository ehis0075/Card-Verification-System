//package card.bank.auth.service.implementation;
//
//
//import card.bank.auth.dto.LoginRequestDto;
//import card.bank.auth.dto.LoginResponseDTO;
//import card.bank.auth.dto.UserDetailsPayloadDTO;
//import card.bank.auth.repository.UserSecurityDetailsRepository;
//import card.bank.auth.service.AuthService;
//import card.bank.auth.service.UserSecurityDetailsService;
//import card.bank.config.security.JwtUtil;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.security.Principal;
//
//@AllArgsConstructor
//@Getter
//@Service
//@Slf4j
//public class AuthServiceImpl implements AuthService {
//
//    private final JwtUtil jwtUtil;
//    private AuthenticationManager authenticationManager;
//    private UserSecurityDetailsService userSecurityDetailsService;
//    private PasswordEncoder passwordEncoder;
//    private UserSecurityDetailsRepository userSecurityDetailsRepository;
//
//    @Override
//    public LoginResponseDTO authenticateUser(LoginRequestDto loginRequestDto) {
//        log.info("Request to login with payload {}", loginRequestDto);
//
//        Authentication authentication = authenticationManager.authenticate(new
//                UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(), loginRequestDto.getPassword()));
//
//        String token = jwtUtil.generateToken(authentication);
//
//        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
//
//        loginResponseDTO.setToken(token);
//
//        return loginResponseDTO;
//    }
//
//    @Override
//    public boolean logout(Principal principal) {
//        log.info("Request to logout user with email {}", principal.getName());
//
//        UserDetailsPayloadDTO userDetailsPayloadDTO = (UserDetailsPayloadDTO) principal;
//
//        // invalidate token
//        SecurityContextHolder.clearContext();
//
//        return false;
//    }
//
//}
