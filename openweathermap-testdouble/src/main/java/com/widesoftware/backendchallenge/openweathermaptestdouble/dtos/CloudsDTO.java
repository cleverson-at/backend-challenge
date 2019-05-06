package com.widesoftware.backendchallenge.openweathermaptestdouble.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@EqualsAndHashCode
@Accessors(chain=true)
public class CloudsDTO {
	@Getter @Setter private Integer all;
}
