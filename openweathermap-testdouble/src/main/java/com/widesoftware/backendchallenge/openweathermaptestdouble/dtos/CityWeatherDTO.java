package com.widesoftware.backendchallenge.openweathermaptestdouble.dtos;

import java.util.List;

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
public class CityWeatherDTO {
	@Getter @Setter private CoordinateDTO coord;
	@Getter @Setter private List<WeatherDTO> weather;
	@Getter @Setter private String base;
	@Getter @Setter private MainDTO main;
	@Getter @Setter private Integer visibility;
	@Getter @Setter private WindDTO wind;
	@Getter @Setter private CloudsDTO clouds;
	@Getter @Setter private String dt;
	@Getter @Setter private SysDTO sys;
	@Getter @Setter private String id;
	@Getter @Setter private String name;
	@Getter @Setter private Integer cod;
}
