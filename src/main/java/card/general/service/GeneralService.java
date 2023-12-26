package card.general.service;


import card.general.dto.Response;
import card.general.enums.ResponseCodeAndMessage;
import kong.unirest.HttpResponse;

public interface GeneralService {

    Response prepareResponse(ResponseCodeAndMessage codeAndMessage, Object data);

    Response prepareResponse(String responseCode, String responseMessage, Object data);

    void createDTOFromModel(Object from, Object to);

    String getResponseAsString2(HttpResponse<String> response);
}
