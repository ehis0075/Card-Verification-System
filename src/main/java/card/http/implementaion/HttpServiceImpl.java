package card.http.implementaion;


import card.exception.RemoteServiceException;
import card.http.HttpService;
import kong.unirest.GetRequest;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class HttpServiceImpl implements HttpService {

    private static final Logger logger = LoggerFactory.getLogger(HttpServiceImpl.class);

    @Override
    public HttpResponse<String> get(Map<String, String> headerList, Map<String, Object> params, String url) {
        try {
            logger.info("Making GET request with header {}, params {} and url {}", headerList, params, url);
            GetRequest getRequest = Unirest.get(url).headers(headerList);
            if (Objects.isNull(params)) {
                return getRequest.asString();
            } else {
                return getRequest.queryString(params).asString();
            }
        } catch (Exception exception) {
            logger.info(exception.getMessage());
            throw new RemoteServiceException("Remote Service unreachable");
        }
    }

}
