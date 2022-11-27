package com.company.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {

    private static final String URL = "https://http.cat/";
    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    public String getStatusImage(int code) throws Exception {

        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL.concat(code + ".jpg")))
                .headers("Content-Type", "application/json")
                .GET()
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 404) {
            System.out.println("There is not image for HTTP status "+code+"\n");
            throw new Exception("Error 404: file not found for code: "+code);
        }
        return URL.concat(code + ".jpg");
    }
}
