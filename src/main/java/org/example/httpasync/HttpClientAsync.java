package org.example.httpasync;

public interface HttpClientAsync {
    void get(String url);
    void post(String url, String payload);
    void put(String url, String payload);
    void delete(String url, String payload);
}
