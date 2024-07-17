import org.json.JSONObject;

public class CurrencyConverter {
    private String baseCurrency;
    private JSONObject rates;

    public CurrencyConverter(String baseCurrency) throws Exception {
        this.baseCurrency = baseCurrency;
        this.rates = APIClient.getRates(baseCurrency);
    }

    public double convertTo(String targetCurrency, double amount) {
        double rate = rates.getJSONObject("conversion_rates").getDouble(targetCurrency);
        return amount * rate;
    }
}
