package com.linkedin.javacodechallenges;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // TODO: Call https://icanhazdadjoke.com/ API and display joke
        try {

            String API_URL = "https://icanhazdadjoke.com/";

            HttpRequest request = HttpRequest.newBuilder().GET()
                    .setHeader("Accept", "application/json")
                    .uri(URI.create(API_URL)).build();

            java.net.http.HttpClient client = HttpClient.newBuilder().build();

            java.net.http.HttpResponse<String> response = client.send(
                    request, java.net.http.HttpResponse.BodyHandlers.ofString());

            String jsonData = response.body();
            System.out.println(jsonData);

            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            Joke resObject = gson.fromJson(jsonData, Joke.class);

            System.out.println("Joke ID: " + resObject.getId());
            System.out.println("Joke: " + resObject.getJoke());
            System.out.println("Status: " + resObject.getStatus());

        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
