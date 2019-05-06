package com.widesoftware.backendchallenge.gateways.spotify.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@EqualsAndHashCode
@Accessors(chain=true)
public class AuthenticationDTO {
	@Getter @Setter private String access_token;
	@Getter @Setter private String token_type;
	@Getter @Setter private Integer expires_in;
	@Getter @Setter private String scope;
}
