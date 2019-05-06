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
public class AuthenticationDTO {
	@Getter @Setter private String access_token;
	@Getter @Setter private String token_type;
	@Getter @Setter private Integer expires_in;
	@Getter @Setter private String scope;
}
