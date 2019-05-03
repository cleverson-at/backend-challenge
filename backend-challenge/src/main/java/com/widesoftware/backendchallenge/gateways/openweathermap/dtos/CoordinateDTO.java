package com.widesoftware.backendchallenge.gateways.openweathermap.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@EqualsAndHashCode
@Accessors(chain=true)
public class CoordinateDTO {
	@Getter @Setter private Integer lon;
	@Getter @Setter private Integer lat;
}
