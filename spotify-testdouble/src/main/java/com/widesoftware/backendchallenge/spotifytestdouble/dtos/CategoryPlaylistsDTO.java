package com.widesoftware.backendchallenge.spotifytestdouble.dtos;

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
public class CategoryPlaylistsDTO {
	@Getter @Setter private PlaylistsDTO playlists;
}
