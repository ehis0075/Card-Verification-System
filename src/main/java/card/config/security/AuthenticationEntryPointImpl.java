//package card.bank.config.security;
//
//import card.bank.general.dto.Response;
//import card.bank.general.enums.ResponseCodeAndMessage;
//import com.google.gson.Gson;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.MediaType;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//@AllArgsConstructor
//@Slf4j
//public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
//
//    private Gson gson;
//
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//        response.setStatus(401);
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        Response responseObject = getResponseObject();
//        String responsePayload = gson.toJson(responseObject);
//        log.error(responsePayload);
//        response.getWriter().write(responsePayload);
//
//    }
//
//    private Response getResponseObject() {
//        Response response = new Response();
//        response.setResponseMessage(ResponseCodeAndMessage.AUTHENTICATION_FAILED_95.responseMessage);
//        response.setResponseCode(ResponseCodeAndMessage.AUTHENTICATION_FAILED_95.responseCode);
//        response.setData("Invalid credentials");
//        return response;
//    }
//
//}
