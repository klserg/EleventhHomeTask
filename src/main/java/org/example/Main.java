package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.httpasync.HttpClientAsyncRealisation;

import java.net.http.HttpClient;

public class Main {
    public static void main(String[] args) {

        String baseUrl = "https://httpbin.org";
        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient client = HttpClient.newBuilder().build();
        HttpClientAsyncRealisation httpClient = new HttpClientAsyncRealisation(client, objectMapper);

        String body = "Check POST request";
        String body1 = "Check PUT request";
        String body2 = "Check DELETE request";

        httpClient.get(baseUrl + "/get");
        httpClient.post(baseUrl + "/post", body);
        httpClient.put(baseUrl + "/put", body1);
        httpClient.delete(baseUrl + "/delete", body2);
    }
}
