package com.widesoftware.backendchallenge.spotifytestdouble.dtos;

import java.time.LocalDateTime;

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
public class ItemDTO {
	@Getter @Setter private LocalDateTime added_at;
	@Getter @Setter private UserDTO added_by; 
	@Getter @Setter private Boolean is_local;
	@Getter @Setter private String primary_color;
	@Getter @Setter private TrackDTO track;
	@Getter @Setter private VideoThumbnailDTO video_thumbnail;
}
