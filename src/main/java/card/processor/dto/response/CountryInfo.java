package card.processor.dto.response;


import lombok.Data;

@Data
public class CountryInfo {

    private String numeric;
    private String alpha2;
    private String name;
    private String emoji;
    private String currency;
    private double latitude;
    private double longitude;


    @Override
    public String toString() {
        return "Country{" +
               "numeric='" + numeric + '\'' +
               ", alpha2='" + alpha2 + '\'' +
               ", name='" + name + '\'' +
               ", emoji='" + emoji + '\'' +
               ", currency='" + currency + '\'' +
               ", latitude=" + latitude +
               ", longitude=" + longitude +
               '}';
    }
}
