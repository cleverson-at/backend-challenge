package com.widesoftware.backendchallenge.openweathermaptestdouble.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@EqualsAndHashCode
@Accessors(chain=true)
public class SysDTO {
	@Getter @Setter private Integer type;
	@Getter @Setter private Integer id;
	@Getter @Setter private Double message;
	@Getter @Setter private String country;
	@Getter @Setter private String sunrise;
	@Getter @Setter private String sunset;
}
