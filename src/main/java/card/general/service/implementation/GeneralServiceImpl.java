package card.general.service.implementation;


import card.exception.RemoteServiceException;
import card.general.dto.Response;
import card.general.enums.ResponseCodeAndMessage;
import card.general.service.GeneralService;
import kong.unirest.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class GeneralServiceImpl implements GeneralService {

    public GeneralServiceImpl() {

    }

    @Override
    public Response prepareResponse(ResponseCodeAndMessage codeAndMessage, Object data) {
        return getResponse(codeAndMessage.responseCode, codeAndMessage.responseMessage, data);
    }

    @Override
    public Response prepareResponse(String responseCode, String responseMessage, Object data) {
        return getResponse(responseCode, responseMessage, data);
    }

    @Override
    public void createDTOFromModel(Object from, Object to) {
        log.info("Creating DTO from Model entity");
        BeanUtils.copyProperties(from, to);
    }

    @Override
    public String getResponseAsString2(HttpResponse<String> response) {
        log.info("getting JSON response as a string");

        if (Objects.nonNull(response)) {
            if (Objects.nonNull(response.getBody())) {
                String body = response.getBody();
                log.info(body);
                return body;
            }
        }
        throw new RemoteServiceException("No Response from Host");
    }

    private Response getResponse(String responseCode, String responseMessage, Object data) {
        Response response = new Response();
        response.setResponseCode(responseCode);
        response.setResponseMessage(responseMessage);
        response.setData(data);

        log.info("ResponseCode => {}, message => {} and data => {}", responseCode, responseMessage, data);

        return response;
    }
}
