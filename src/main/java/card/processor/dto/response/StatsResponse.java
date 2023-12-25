package card.processor.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class StatsResponse {

    private boolean success;
    private int start;
    private int limit;
    private int size;
    private Map<String, String> payload;
}
