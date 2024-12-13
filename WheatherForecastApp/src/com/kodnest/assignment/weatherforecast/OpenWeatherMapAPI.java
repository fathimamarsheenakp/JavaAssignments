package com.kodnest.assignment.weatherforecast;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class OpenWeatherMapAPI {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String city;
            do {
                // Retrieve user input
                System.out.println("===================================================");
                System.out.print("Enter City (Say No to Quit): ");
                city = scanner.nextLine();

                if (city.equalsIgnoreCase("No")) break;

                // Fetch and display weather data using OpenWeatherMap
                displayWeatherData(city);
            } while (!city.equalsIgnoreCase("No"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void displayWeatherData(String city) {
        try {
            String apiKey = "ca0fb1b5ec446132352e7d507c2f082d"; // Add your OpenWeatherMap API key here
            String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";
            HttpURLConnection apiConnection = fetchApiResponse(url);

            if (apiConnection.getResponseCode() != 200) {
                System.out.println("Error: Could not connect to API");
                return;
            }

            String jsonResponse = readApiResponse(apiConnection);
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonResponse);

            // Extract main weather data
            JSONObject mainData = (JSONObject) jsonObject.get("main");
            JSONArray weatherArray = (JSONArray) jsonObject.get("weather");
            JSONObject weather = (JSONObject) weatherArray.get(0);
            JSONObject wind = (JSONObject) jsonObject.get("wind");

            // Extract temperature, humidity, wind speed, and description
            double temperature = (double) mainData.get("temp");
            long humidity = (long) mainData.get("humidity");
            double windSpeed = (double) wind.get("speed");
            String description = (String) weather.get("description");

            // Extract Unix timestamp (dt) and convert it to readable date/time
            long timestamp = (long) jsonObject.get("dt");
            Date date = new Date(timestamp * 1000); // Convert seconds to milliseconds
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getDefault()); // Set time zone
            String formattedDate = sdf.format(date);

            // Display weather information
            System.out.println("Current Time: " + formattedDate);
            System.out.println("Current Temperature (C): " + temperature);
            System.out.println("Relative Humidity (%): " + humidity);
            System.out.println("Wind Speed (m/s): " + windSpeed);
            System.out.println("Weather Description: " + description);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String readApiResponse(HttpURLConnection apiConnection) {
        try {
            StringBuilder resultJson = new StringBuilder();
            Scanner scanner = new Scanner(apiConnection.getInputStream());

            while (scanner.hasNext()) {
                resultJson.append(scanner.nextLine());
            }

            scanner.close();
            return resultJson.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static HttpURLConnection fetchApiResponse(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            return conn;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

