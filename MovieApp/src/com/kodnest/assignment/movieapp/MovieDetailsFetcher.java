package com.kodnest.assignment.movieapp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import java.util.Scanner;

public class MovieDetailsFetcher {
    // Replace with your OMDb API Key
    private static final String API_KEY = "6b59a29f";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Ask the user to enter a movie title
            System.out.print("\nEnter the movie title to fetch details (or type 'exit' to quit): ");
            String movieTitle = scanner.nextLine();  // Read user input

            // If the user wants to exit, break the loop
            if (movieTitle.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                // Create the URL to access the API
                String apiUrl = "http://www.omdbapi.com/?t=" + movieTitle + "&apikey=" + API_KEY;

                // Send HTTP request
                URL url = new URL(apiUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                // Get the response
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parse the response into a JSONObject
                JSONObject movie = new JSONObject(response.toString());

                // Check if the movie was found
                if (movie.getString("Response").equals("True")) {
                    // Print the formatted movie details
                    System.out.println("\nMovie Title: " + movie.getString("Title"));
                    System.out.println("Year: " + movie.getString("Year"));
                    System.out.println("Rated: " + movie.getString("Rated"));
                    System.out.println("Released: " + movie.getString("Released"));
                    System.out.println("Runtime: " + movie.getString("Runtime"));
                    System.out.println("Genre: " + movie.getString("Genre"));
                    System.out.println("Director: " + movie.getString("Director"));
                    System.out.println("Writer: " + movie.getString("Writer"));
                    System.out.println("Actors: " + movie.getString("Actors"));
                    System.out.println("Plot: " + movie.getString("Plot"));
                    System.out.println("Language: " + movie.getString("Language"));
                    System.out.println("Country: " + movie.getString("Country"));
                    System.out.println("Awards: " + movie.getString("Awards"));
                    System.out.println("IMDB Rating: " + movie.getString("imdbRating"));
                    System.out.println("IMDB Votes: " + movie.getString("imdbVotes"));
                    System.out.println("BoxOffice: " + movie.getString("BoxOffice"));
                    System.out.println("Poster URL: " + movie.getString("Poster"));
                } else {
                    System.out.println("Sorry, movie not found.");
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error fetching movie details.");
            }
        }

        scanner.close();
    }
}
