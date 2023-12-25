package card.general.service;


import card.general.dto.Response;
import card.general.enums.ResponseCodeAndMessage;
import kong.unirest.HttpResponse;
import org.springframework.data.domain.Pageable;

public interface GeneralService {

    boolean isStringInvalid(String string);

    //used to format response body
    Response prepareResponse(ResponseCodeAndMessage codeAndMessage, Object data);

    Response prepareResponse(String responseCode, String responseMessage, Object data);


    Pageable getPageableObject(int size, int page);

    void createDTOFromModel(Object from, Object to);

    String getResponseAsString2(HttpResponse<String> response);
}
