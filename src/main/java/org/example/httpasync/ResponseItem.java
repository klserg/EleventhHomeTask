package org.example.httpasync;

import lombok.Data;

@Data
public class ResponseItem {
    private String response;

    @Override
    public String toString() {
        return response;
    }
}