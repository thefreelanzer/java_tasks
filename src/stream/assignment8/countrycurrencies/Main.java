package stream.assignment8.countrycurrencies;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<CountryCurrencies> countryCurrenciesList = Arrays.asList(
                new CountryCurrencies("India", "INR"),
                new CountryCurrencies("UAE", "AED")
        );

        Map<String, String> countryCurrencyMap = countryCurrenciesList.stream()
                .collect(Collectors.toMap(
                        CountryCurrencies::getCountryName,
                        CountryCurrencies::getCurrency
                ));

        countryCurrencyMap.forEach((country, currency) ->
                System.out.println("Country: " + country + ", Currency: " + currency));

    }
}
