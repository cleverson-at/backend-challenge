package com.widesoftware.backendchallenge.spotifytestdouble.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@EqualsAndHashCode
@Accessors(chain=true)
public class ExternalIdsDTO {
	@Getter @Setter private String isrc;
}
