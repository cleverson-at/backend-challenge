package com.widesoftware.backendchallenge.gateways.rest.dtos;

import java.util.HashSet;
import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@EqualsAndHashCode
@Accessors(chain=true)
public class SuggestedSongsDTO {
	@Getter @Setter private Set<String> names = new HashSet<String>();
}
