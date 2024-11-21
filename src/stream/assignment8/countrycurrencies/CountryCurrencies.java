package stream.assignment8.countrycurrencies;

public class CountryCurrencies {
    String countryName;
    String currency;

    public CountryCurrencies(String countryName, String currency) {
        this.countryName = countryName;
        this.currency = currency;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCurrency() {
        return currency;
    }
}
