package card.processor.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Payload {

    private String scheme;
    private String type;
    private String bank;

    @JsonProperty("scheme")
    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("bank")
    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Payload{" +
               "scheme='" + scheme + '\'' +
               ", type='" + type + '\'' +
               ", bank='" + bank + '\'' +
               '}';
    }
}
