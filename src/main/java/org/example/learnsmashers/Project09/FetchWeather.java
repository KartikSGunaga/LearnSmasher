package org.example.learnsmashers.Project09;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FetchWeather {
    private String city, apiKey;

    public FetchWeather(String city, String apiKey) {
        this.apiKey = apiKey;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void currentWeather() throws Exception {
        String endPoint = "http://api.weatherapi.com/v1/current.json?key="
                + this.apiKey + "&q=" + this.city + "&aqi=yes";

        HttpClient client = HttpClient.newHttpClient();

        URI uri = new URI(endPoint);

        HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            System.out.println("\nRequest successful!");
            JSONObject json = new JSONObject(response.body());
            JSONObject location = json.getJSONObject("location");
            JSONObject current = json.getJSONObject("current");

            String lastUpdated = current.getString("last_updated");
            String place = location.getString("name") + ", "
                    + location.getString("region")+ ", "
                    + location.getString("country");
            String timeZone = location.getString( "tz_id");
            String localTime = location.getString("localtime");
            float tempCelsius = current.getFloat("temp_c");
            String feelsLike = current.getJSONObject("condition").getString("text");

            System.out.println("\nFetched data for " + place);
            System.out.println("Fetched at: " + lastUpdated + " (TimeZone: " + timeZone + ")");
            System.out.println("Local time in " + location.getString("name") + ": " + localTime + " (TimeZone: " + timeZone + ")");
            System.out.println("Current temperature: " + tempCelsius);
            System.out.println("Feels like " + feelsLike);

        } else {
            System.out.println("Oops!");
            throw new RuntimeException("Error calling API response: " + response.body());
        }
    }
}
