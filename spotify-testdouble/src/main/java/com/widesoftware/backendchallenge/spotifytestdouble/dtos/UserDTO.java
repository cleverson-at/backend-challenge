package com.widesoftware.backendchallenge.spotifytestdouble.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@EqualsAndHashCode
@Accessors(chain=true)
public class UserDTO {
	@Getter @Setter private ExternalUrlsDTO external_urls;
	@Getter @Setter private String href;
	@Getter @Setter private String id;
	@Getter @Setter private String type;
	@Getter @Setter private String uri;
}
