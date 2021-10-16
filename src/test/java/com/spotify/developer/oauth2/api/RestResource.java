package com.spotify.developer.oauth2.api;

import com.spotify.developer.oauth2.api.SpecBuilder;
import com.spotify.developer.oauth2.enums.LogType;
import com.spotify.developer.oauth2.pojos.Playlist;
import com.spotify.developer.oauth2.reports.FrameworkLogger;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.output.WriterOutputStream;

import java.io.PrintStream;
import java.io.StringWriter;
import java.util.Map;

public class RestResource {

    public static Response post(String path, String accessToken, Object requestPlaylist) {
        StringWriter writer = new StringWriter();
        PrintStream captor = new PrintStream(new WriterOutputStream(writer), true);
        Response response = RestAssured.given(SpecBuilder.getRequestSpecification())
                .body(requestPlaylist)
                .auth()
                .oauth2(accessToken)
                //.header("Authorization", "Bearer " + accessToken)
                .filter(new RequestLoggingFilter(captor))
                .when()
                .post(path)
                .then()
                .spec(SpecBuilder.getResponseSpecification())
                .extract()
                .response();
        FrameworkLogger.log(LogType.LOGREQUESTANDRESPONSETOREPORT, writer.toString(), response.prettyPrint());
        return response;
    }

    public static Response postAccount(Map<String, String> formParameters) {
        StringWriter writer = new StringWriter();
        PrintStream captor = new PrintStream(new WriterOutputStream(writer), true);
        Response response = RestAssured.given(SpecBuilder.getAccountRequestSpecification())
                .formParams(formParameters)
                .filter(new RequestLoggingFilter(captor))
                .when()
                .post()
                .then()
                .extract()
                .response();
        FrameworkLogger.log(LogType.LOGREQUESTANDRESPONSETOREPORT, writer.toString(), response.prettyPrint());
        return response;
    }

    public static Response get(String path, String accessToken) {
        StringWriter writer = new StringWriter();
        PrintStream captor = new PrintStream(new WriterOutputStream(writer), true);
        Response response = RestAssured.given(SpecBuilder.getRequestSpecification())
                .auth()
                .oauth2(accessToken)
                //.header("Authorization", "Bearer " + accessToken)
                .filter(new RequestLoggingFilter(captor))
                .when()
                .get(path)
                .then()
                .spec(SpecBuilder.getResponseSpecification())
                .extract()
                .response();
        FrameworkLogger.log(LogType.LOGREQUESTANDRESPONSETOREPORT, writer.toString(), response.prettyPrint());
        return response;

    }

    public static Response update(String path, String accessToken, Object requestPlaylist) {
        StringWriter writer = new StringWriter();
        PrintStream captor = new PrintStream(new WriterOutputStream(writer), true);
        Response response =
                RestAssured.given(SpecBuilder.getRequestSpecification())
                        .body(requestPlaylist)
                        .auth()
                        .oauth2(accessToken)
//                .header("Authorization", "Bearer " + accessToken)
                        .filter(new RequestLoggingFilter(captor))
                        .when()
                        .put(path)
                        .then()
                        .spec(SpecBuilder.getResponseSpecification())
                        .extract()
                        .response();
        FrameworkLogger.log(LogType.LOGREQUESTANDRESPONSETOREPORT, writer.toString(), response.prettyPrint());
        return response;

    }
}
