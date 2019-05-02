package com.widesoftware.backendchallenge.gateways.spotify.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class IconDTO {
	@Getter @Setter private Integer height;
	@Getter @Setter private String url;
	@Getter @Setter private Integer width;
}
