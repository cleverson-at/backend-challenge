package com.widesoftware.backendchallenge.gateways.spotify.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@EqualsAndHashCode
@Accessors(chain=true)
public class IconDTO {
	@Getter @Setter private Integer height;
	@Getter @Setter private String url;
	@Getter @Setter private Integer width;
}
