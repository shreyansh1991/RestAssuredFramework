package com.spotify.developer.oauth2.tests;

import com.spotify.developer.oauth2.api.SpecBuilder;
import com.spotify.developer.oauth2.api.StatusCode;
import com.spotify.developer.oauth2.api.applicationapi.PlayListAPi;
import com.spotify.developer.oauth2.pojos.ErrorRoot;
import com.spotify.developer.oauth2.pojos.Playlist;
import com.spotify.developer.oauth2.reports.FrameworkLogger;
import com.spotify.developer.oauth2.utils.FakerUtils;
import com.spotify.developer.oauth2.utils.PropertyUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.spotify.developer.oauth2.enums.LogType.*;
import static com.spotify.developer.oauth2.reports.FrameworkLogger.log;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PlaylistTest extends  BaseTest{

    @Test
    public void shouldBeAbleToCreateAPlayList() {
        Playlist requestPlaylist = playListBuilder(FakerUtils.generateName(), FakerUtils.generateDescription(), false);

        Response response = PlayListAPi.post(requestPlaylist);
        assertStatusCode(response.getStatusCode(),StatusCode.CODE_201);
        Playlist responsePlaylist = response.as(Playlist.class);
        assertPlayListEqual(responsePlaylist, requestPlaylist);

    }

    @Test
    public void shouldBeAbleToGetAPlayList() {
        Response response = PlayListAPi.get("5VQgEq63hJMKehMcTvZsRC");
        assertStatusCode(response.getStatusCode(),StatusCode.CODE_200);
        Playlist responsePlaylist = response.as(Playlist.class);
        assertThat(responsePlaylist.get_public(), equalTo(false));
    }

    @Test
    public void shouldBeAbleToUpdateAPlayList() {
        Playlist requestPlaylist = playListBuilder(FakerUtils.generateName(), FakerUtils.generateDescription(), false);
        Response response = PlayListAPi.update(requestPlaylist, PropertyUtils.getProperty("playlist_id"));
        assertStatusCode(response.getStatusCode(),StatusCode.CODE_200);
    }

    @Test
    public void shouldBeAbleToCreateAPlayListWithOutName() {

        Playlist requestPlaylistWithOutName = playListBuilder("",FakerUtils.generateDescription(), false);
        Response response = PlayListAPi.post(requestPlaylistWithOutName);
        assertStatusCode(response.getStatusCode(),StatusCode.CODE_400);
        ErrorRoot errorRoot = response.as(ErrorRoot.class);
        assertErrorMessage(errorRoot,StatusCode.CODE_400);

    }

    @Test
    public void shouldBeAbleToCreateAPlayListWithInvalidToken() {
        Playlist requestPlaylist = playListBuilder(FakerUtils.generateName(), FakerUtils.generateDescription(), false);
        Response response = PlayListAPi.post("12snajdnasjd3", requestPlaylist);
        ErrorRoot errorRoot = response.as(ErrorRoot.class);
        assertErrorMessage(errorRoot,StatusCode.CODE_401);
        assertStatusCode(errorRoot.getError().getStatus(),StatusCode.CODE_401);
    }

    public Playlist playListBuilder(String name, String description, boolean _public) {
        Playlist playlist = new Playlist();
        playlist.setName(name);
        playlist.setDescription(description);
        playlist.set_public(_public);
        return playlist;
    }

    public void assertPlayListEqual(Playlist responsePlaylist, Playlist requestPlaylist) {
        assertThat(requestPlaylist.getName(), equalTo(responsePlaylist.getName()));
        assertThat(requestPlaylist.getDescription(), equalTo(responsePlaylist.getDescription()));
        assertThat(requestPlaylist.get_public(), equalTo(responsePlaylist.get_public()));
    }
    public void assertStatusCode(int actualCode,StatusCode statusCode)
    {
        assertThat(actualCode, equalTo(statusCode.getCode()));
    }
    public void assertErrorMessage(ErrorRoot errorRoot,StatusCode statusMessage)
    {
        assertThat(errorRoot.getError().getMessage(), equalTo(statusMessage.getMessage()));
    }

}
