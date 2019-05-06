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
public class PlaylistsDTO {
	@Getter @Setter private String href;
	@Getter @Setter private List<PlaylistDTO> items;
	@Getter @Setter private Integer limit;
	@Getter @Setter private String next;
	@Getter @Setter private Integer offset;
	@Getter @Setter private String previous;
	@Getter @Setter private Integer total;
}
