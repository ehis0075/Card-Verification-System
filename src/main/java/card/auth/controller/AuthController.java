//package card.bank.auth.controller;
//
//
//import card.bank.auth.dto.LoginRequestDto;
//import card.bank.auth.dto.LoginResponseDTO;
//import card.bank.auth.service.AuthService;
//import card.bank.general.dto.Response;
//import card.bank.general.enums.ResponseCodeAndMessage;
//import card.bank.general.service.GeneralService;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.security.Principal;
//
//@RestController
//@AllArgsConstructor
//@RequestMapping("/api/v1/auth")
//@Slf4j
//public class AuthController {
//    private final AuthService authService;
//    private final GeneralService generalService;
//
//    @PostMapping("/login")
//    public Response authenticateUser(@RequestBody LoginRequestDto loginRequestDto) {
//        LoginResponseDTO data = authService.authenticateUser(loginRequestDto);
//        Response response = generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
//        log.info(response.toString());
//        log.info("done---->");
//        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
//    }
//
//    @PostMapping("/logOut")
//    public Response signOut(Principal principal) {
//        boolean data = authService.logout(principal);
//        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
//    }
//
//}
