package card.http;

import kong.unirest.HttpResponse;

import java.util.Map;

public interface HttpService {
    HttpResponse<String> get(Map<String, String> headerList, Map<String, Object> params, String url);

}
