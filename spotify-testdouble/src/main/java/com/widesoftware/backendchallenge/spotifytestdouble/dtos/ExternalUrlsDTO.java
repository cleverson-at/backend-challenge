package com.widesoftware.backendchallenge.spotifytestdouble.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@EqualsAndHashCode
@Accessors(chain=true)
public class ExternalUrlsDTO {
	@Getter @Setter private String spotify;
}
