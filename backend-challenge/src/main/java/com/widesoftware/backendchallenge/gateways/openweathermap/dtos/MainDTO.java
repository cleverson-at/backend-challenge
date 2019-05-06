package com.widesoftware.backendchallenge.gateways.openweathermap.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@EqualsAndHashCode
@Accessors(chain=true)
public class MainDTO {
	@Getter @Setter private Double temp;
	@Getter @Setter private Integer pressure;
	@Getter @Setter private Integer humidity;
	@Getter @Setter private Integer temp_min;
	@Getter @Setter private Double temp_max;
}
