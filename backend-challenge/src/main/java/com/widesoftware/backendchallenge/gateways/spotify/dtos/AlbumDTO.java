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
public class AlbumDTO {
	@Getter @Setter private String album_type;
	@Getter @Setter private List<ArtistDTO> artists;
	@Getter @Setter private List<String> available_markets; 
	@Getter @Setter private ExternalUrlsDTO external_urls;
	@Getter @Setter private String href;
	@Getter @Setter private String id;
	@Getter @Setter private List<ImageDTO> images;
	@Getter @Setter private String name;
	@Getter @Setter private String release_date;
	@Getter @Setter private String release_date_precision;
	@Getter @Setter private Integer total_tracks;
	@Getter @Setter private String type;
	@Getter @Setter private String uri;
}
