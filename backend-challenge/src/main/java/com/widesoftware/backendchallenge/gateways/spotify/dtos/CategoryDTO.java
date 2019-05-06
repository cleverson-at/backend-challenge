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
public class CategoryDTO {
	@Getter @Setter private String href;
	@Getter @Setter private List<IconDTO> icons;
	@Getter @Setter private String id;
	@Getter @Setter private String name;
}
