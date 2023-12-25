package card.general.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class Response {
    private String responseCode;

    private String responseMessage;

    private Object data;
}
