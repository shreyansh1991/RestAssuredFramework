
package com.spotify.developer.oauth2.pojos;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Owner {

    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("external_urls")
    private ExternalUrls__1 externalUrls;
    @JsonProperty("href")
    private String href;
    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("uri")
    private String uri;

}
