package com.spotify.developer.oauth2.api.applicationapi;

import com.spotify.developer.oauth2.api.EndPoint;
import com.spotify.developer.oauth2.api.RestResource;
import com.spotify.developer.oauth2.api.TokenManager;
import com.spotify.developer.oauth2.pojos.Playlist;
import com.spotify.developer.oauth2.utils.ConfigLoader;
import com.spotify.developer.oauth2.utils.PropertyUtils;
import io.restassured.response.Response;

public class PlayListAPi {

    public static Response post(Playlist requestPlaylist) {
        return RestResource.post(EndPoint.USERS + "/" + PropertyUtils.getProperty("user_id") + EndPoint.PLAYLIST, TokenManager.getToken(), requestPlaylist);
    }

    public static Response post(String accessToken, Playlist requestPlaylist) {
        return RestResource.post(EndPoint.USERS + "/" + PropertyUtils.getProperty("user_id") + EndPoint.PLAYLIST, accessToken, requestPlaylist);
    }

    public static Response get(String playlistID) {
        return RestResource.get(EndPoint.PLAYLIST + "/" + playlistID, TokenManager.getToken());
    }

    public static Response update(Playlist requestPlaylist, String playlistID) {
        return RestResource.update(EndPoint.PLAYLIST + "/" + playlistID, TokenManager.getToken(), requestPlaylist);
    }
}
