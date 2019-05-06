package com.widesoftware.backendchallenge.spotifytestdouble.dtos;

import java.util.List;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Builder
@ToString
@EqualsAndHashCode
@Accessors(chain=true)
public class PlaylistDTO {
	@Getter @Setter private Boolean collaborative;
	@Getter @Setter private ExternalUrlsDTO external_urls;
	@Getter @Setter private String href;
	@Getter @Setter private String id;
	@Getter @Setter private List<ImageDTO> images;
	@Getter @Setter private String name;
	@Getter @Setter private OwnerDTO owner;
	@Getter @Setter private String primary_color;
	
	/* TODO: 
	 * In need of this attribute, implement replacer of the keyword attribute name.
	 */
	//@Getter @Setter private Boolean public;
	
	@Getter @Setter private String snapshot_id;
	@Getter @Setter private TracksDTO tracks;
	@Getter @Setter private String type;
	@Getter @Setter private String uri;
}
