package card.processor.dto.response;


import lombok.Data;

@Data
public class NumberInfo {

    private int length;
    private boolean luhn;

    @Override
    public String toString() {
        return "Number{" +
               "length=" + length +
               ", luhn=" + luhn +
               '}';
    }
}
