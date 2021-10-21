
package com.spotify.developer.oauth2.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Playlist {

    @JsonProperty("collaborative")
    private Boolean collaborative;
    @JsonProperty("description")
    private String description;
    @JsonProperty("external_urls")
    private ExternalUrls externalUrls;
    @JsonProperty("followers")
    private Followers followers;
    @JsonProperty("href")
    private String href;
    @JsonProperty("id")
    private String id;
    @JsonProperty("images")
    private List<Object> images = null;
    @JsonProperty("name")
    private String name;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("primary_color")
    private Object primaryColor;
    @JsonProperty("public")
    private Boolean _public;
    @JsonProperty("snapshot_id")
    private String snapshotId;
    @JsonProperty("tracks")
    private Tracks tracks;
    @JsonProperty("type")
    private String type;
    @JsonProperty("uri")
    private String uri;

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Playlist)) return false;
        final Playlist other = (Playlist) o;
        if (!other.canEqual((Object) this)) return false;
//        final Object this$collaborative = this.getCollaborative();
//        final Object other$collaborative = other.getCollaborative();
//        if (this$collaborative == null ? other$collaborative != null : !this$collaborative.equals(other$collaborative))
//            return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();

        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
//        final Object this$externalUrls = this.getExternalUrls();
//        final Object other$externalUrls = other.getExternalUrls();
//        if (this$externalUrls == null ? other$externalUrls != null : !this$externalUrls.equals(other$externalUrls))
//            return false;
//        final Object this$followers = this.getFollowers();
//        final Object other$followers = other.getFollowers();
//        if (this$followers == null ? other$followers != null : !this$followers.equals(other$followers)) return false;
//        final Object this$href = this.getHref();
//        final Object other$href = other.getHref();
//        if (this$href == null ? other$href != null : !this$href.equals(other$href)) return false;
//        final Object this$id = this.getId();
//        final Object other$id = other.getId();
//        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
//        final Object this$images = this.getImages();
//        final Object other$images = other.getImages();
//        if (this$images == null ? other$images != null : !this$images.equals(other$images)) return false;
//



        
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
//        final Object this$owner = this.getOwner();
//        final Object other$owner = other.getOwner();
//        if (this$owner == null ? other$owner != null : !this$owner.equals(other$owner)) return false;
//        final Object this$primaryColor = this.getPrimaryColor();
//        final Object other$primaryColor = other.getPrimaryColor();
//        if (this$primaryColor == null ? other$primaryColor != null : !this$primaryColor.equals(other$primaryColor))
//            return false;
        final Object this$_public = this.get_public();
        final Object other$_public = other.get_public();
        if (this$_public == null ? other$_public != null : !this$_public.equals(other$_public)) return false;
//        final Object this$snapshotId = this.getSnapshotId();
//        final Object other$snapshotId = other.getSnapshotId();
//        if (this$snapshotId == null ? other$snapshotId != null : !this$snapshotId.equals(other$snapshotId))
//            return false;
//        final Object this$tracks = this.getTracks();
//        final Object other$tracks = other.getTracks();
//        if (this$tracks == null ? other$tracks != null : !this$tracks.equals(other$tracks)) return false;
//        final Object this$type = this.getType();
//        final Object other$type = other.getType();
//        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
//        final Object this$uri = this.getUri();
//        final Object other$uri = other.getUri();
//        if (this$uri == null ? other$uri != null : !this$uri.equals(other$uri)) return false;
//        return true;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Playlist;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
//        final Object $collaborative = this.getCollaborative();
//        result = result * PRIME + ($collaborative == null ? 43 : $collaborative.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
//        final Object $externalUrls = this.getExternalUrls();
//        result = result * PRIME + ($externalUrls == null ? 43 : $externalUrls.hashCode());
//        final Object $followers = this.getFollowers();
//        result = result * PRIME + ($followers == null ? 43 : $followers.hashCode());
//        final Object $href = this.getHref();
//        result = result * PRIME + ($href == null ? 43 : $href.hashCode());
//        final Object $id = this.getId();
//        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
//        final Object $images = this.getImages();
//        result = result * PRIME + ($images == null ? 43 : $images.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
//        final Object $owner = this.getOwner();
//        result = result * PRIME + ($owner == null ? 43 : $owner.hashCode());
//        final Object $primaryColor = this.getPrimaryColor();
//        result = result * PRIME + ($primaryColor == null ? 43 : $primaryColor.hashCode());
        final Object $_public = this.get_public();
        result = result * PRIME + ($_public == null ? 43 : $_public.hashCode());
//        final Object $snapshotId = this.getSnapshotId();
//        result = result * PRIME + ($snapshotId == null ? 43 : $snapshotId.hashCode());
//        final Object $tracks = this.getTracks();
//        result = result * PRIME + ($tracks == null ? 43 : $tracks.hashCode());
//        final Object $type = this.getType();
//        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
//        final Object $uri = this.getUri();
//        result = result * PRIME + ($uri == null ? 43 : $uri.hashCode());
        return result;
    }
}
