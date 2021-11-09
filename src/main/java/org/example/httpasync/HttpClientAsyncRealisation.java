package org.example.httpasync;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RequiredArgsConstructor
public class HttpClientAsyncRealisation implements HttpClientAsync {
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;
    ResponseItem response = new ResponseItem();

    @Override
    public void get(String uri) {
        Thread thread = new Thread(()->{
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(uri))
                    .header("Accept", "application/json")
                    .build();
            try {
                HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                if (httpResponse.statusCode() == 200) {
                    response.setResponse(httpResponse.body());
                    System.out.println(response.toString());
                } else {
                    System.out.println("Error request");
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    @Override
    public void post(String uri, String body) {
        Thread thread = new Thread(()->{
            try {
                String requestBody = objectMapper.writeValueAsString(body);
                HttpRequest request = HttpRequest.newBuilder()
                        .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                        .uri(URI.create(uri))
                        .header("Content-Type", "application/json")
                        .build();
                HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                if (httpResponse.statusCode() == 200) {
                    response.setResponse(httpResponse.body());
                    System.out.println(response.toString());
                } else {
                    System.out.println("Error request");
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    @Override
    public void put(String uri, String body) {
        Thread thread = new Thread(()->{
            try {
                String requestBody = objectMapper.writeValueAsString(body);
                HttpRequest request = HttpRequest.newBuilder()
                        .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                        .uri(URI.create(uri))
                        .header("Content-Type", "application/json")
                        .build();
                HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                if (httpResponse.statusCode() == 200) {
                    response.setResponse(httpResponse.body());
                    System.out.println(response.toString());
                } else {
                    System.out.println("Error request");
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    @Override
    public void delete(String uri, String body) {
        Thread thread = new Thread(()->{
            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .DELETE()
                        .uri(URI.create(uri))
                        .header("Content-Type", "application/json")
                        .build();
                HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                if (httpResponse.statusCode() == 200) {
                    response.setResponse(httpResponse.body());
                    System.out.println(response.toString());
                } else {
                    System.out.println("Error request");
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
}
