package com.spotify.developer.oauth2.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {

    public static RequestSpecification getRequestSpecification() {

        return new RequestSpecBuilder()
                .setBaseUri("https://api.spotify.com")
                .setBasePath(EndPoint.BASE_PATH)
                .log(LogDetail.ALL)
                .build();

    }


    public static RequestSpecification getAccountRequestSpecification() {

        return new RequestSpecBuilder()
                .setBaseUri("https://accounts.spotify.com")
                .setBasePath(EndPoint.API+EndPoint.TOKEN)
                .setContentType(ContentType.URLENC)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification getResponseSpecification() {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
}
