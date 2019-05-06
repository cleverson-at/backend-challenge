package com.widesoftware.backendchallenge.openweathermaptestdouble.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@EqualsAndHashCode
@Accessors(chain=true)
public class WeatherDTO {
	@Getter @Setter private Integer id;
	@Getter @Setter private String main;
	@Getter @Setter private String description;
	@Getter @Setter private String icon;
}
