package com.widesoftware.backendchallenge.gateways.spotify.dtos;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@EqualsAndHashCode
@Accessors(chain=true)
public class TrackDTO {
	@Getter @Setter private AlbumDTO album;
	@Getter @Setter private List<ArtistDTO> artists; 
	@Getter @Setter private List<String> available_markets;
	@Getter @Setter private Integer disc_number;
	@Getter @Setter private Integer duration_ms;
	@Getter @Setter private Boolean episode;
	@Getter @Setter private Boolean explicit;
	@Getter @Setter private ExternalIdsDTO external_ids;
	@Getter @Setter private ExternalUrlsDTO external_urls;
	@Getter @Setter private String href;
	@Getter @Setter private String id;
	@Getter @Setter private Boolean is_local;
	@Getter @Setter private String name;
	@Getter @Setter private Integer popularity;
	@Getter @Setter private String preview_url;
	@Getter @Setter private Boolean track;
	@Getter @Setter private Integer track_number;
	@Getter @Setter private String type;
	@Getter @Setter private String uri;
}
