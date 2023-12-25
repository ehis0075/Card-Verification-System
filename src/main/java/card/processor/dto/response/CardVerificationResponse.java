package card.processor.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CardVerificationResponse {

    @JsonProperty("number")
    private NumberInfo number;
    private String scheme;
    private String type;
    private String brand;
    private boolean prepaid;

    @JsonProperty("country")
    private CountryInfo country;

    @JsonProperty("bank")
    private BankInfo bank;

    @Override
    public String toString() {
        return "CreditCardInfo{" +
               "number=" + number +
               ", scheme='" + scheme + '\'' +
               ", type='" + type + '\'' +
               ", brand='" + brand + '\'' +
               ", prepaid=" + prepaid +
               ", country=" + country +
               ", bank=" + bank +
               '}';
    }
}
