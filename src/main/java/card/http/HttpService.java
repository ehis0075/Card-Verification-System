package card.http;

import card.exception.RemoteServiceException;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;

import java.util.Map;

public interface HttpService {
    HttpResponse<String> post(Map<String, String> headerList, String jsonPayload, String url);

    HttpResponse<String> get(Map<String, String> headerList, Map<String, Object> params, String url);

    HttpResponse<String> get2(Map<String, String> headerList, Map<String, Object> params, String url);

    HttpResponse<JsonNode> getForBasicAuth(String username, String password, String url);

    HttpResponse<JsonNode> post2(Map<String, String> headerList, String jsonPayload, String url) throws RemoteServiceException;
}
