package com.codsoft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;
import com.google.gson.Gson;

class CurrencyConverter {
	private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

	// Method to fetch exchange rate
	public static double getExchangeRate(String baseCurrency, String targetCurrency) {
		try {
			String urlString = API_URL + baseCurrency;
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder response = new StringBuilder();
			String line;

			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();

			// Parse JSON response
			Gson gson = new Gson();
			Map<?, ?> jsonResponse = gson.fromJson(response.toString(), Map.class);
			Map<?, ?> rates = (Map<?, ?>) jsonResponse.get("rates");

			if (rates.containsKey(targetCurrency)) {
				return ((Number) rates.get(targetCurrency)).doubleValue();
			} else {
				System.out.println("❌ Invalid currency code!");
				return -1;
			}
		} catch (Exception e) {
			System.out.println("⚠ Error fetching exchange rate: " + e.getMessage());
			return -1;
		}
	}

	// Method to convert currency
	public static void convertCurrency(String baseCurrency, String targetCurrency, double amount) {
		double rate = getExchangeRate(baseCurrency, targetCurrency);

		if (rate != -1) {
			double convertedAmount = amount * rate;
			System.out.printf("💰 Converted Amount: %.2f %s\n", convertedAmount, targetCurrency);
		} else {
			System.out.println("❌ Conversion failed. Please check your currency codes.");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n===== Welcome to Currency Converter =====");
		System.out.print("Enter base currency (e.g., USD, EUR, INR): ");
		String baseCurrency = scanner.next().toUpperCase();

		System.out.print("Enter target currency (e.g., USD, EUR, INR): ");
		String targetCurrency = scanner.next().toUpperCase();

		System.out.print("Enter amount to convert: ");
		double amount = scanner.nextDouble();

		convertCurrency(baseCurrency, targetCurrency, amount);

		scanner.close();
	}
}