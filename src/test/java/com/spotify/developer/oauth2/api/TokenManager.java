package com.spotify.developer.oauth2.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.spotify.developer.oauth2.utils.JacksonUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TokenManager {
    private static String accessToken;
    private static Instant expiryTime;

    public static synchronized String getToken() {
        try {
            if (accessToken == null || Instant.now().isAfter(expiryTime)) {
                System.out.println("Renewing Token..");
                Response response = renewToken();
                int expires_in = response.path("expires_in");
                expiryTime = Instant.now().plusSeconds(expires_in - 300);
                accessToken = response.path("access_token");
            } else
                System.out.println("Token is good to use..");
        } catch (Exception e) {
            throw new RuntimeException("Failed to get the Token." + e.getMessage());
        }
        return accessToken;
    }

    public static Response renewToken() {
        Map<String, String> formParameters = null;
        try {
            formParameters = JacksonUtils.deserializeJson("config.json", Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        formParameters.put("client_id", formParameters.get("client_id"));
        formParameters.put("client_secret", formParameters.get("client_secret"));
        formParameters.put("grant_type", formParameters.get("grant_type"));
        formParameters.put("refresh_token", formParameters.get("refresh_token"));

        Response response = RestResource.postAccount(formParameters);

        int statusCode = response.getStatusCode();
        if (statusCode != 200) {
            throw new RuntimeException("ABORT!!! Access Token renew failed.");
        }
        return response;

    }
}
