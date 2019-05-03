package com.widesoftware.backendchallenge.gateways.openweathermap;

import org.springframework.stereotype.Component;

import com.widesoftware.backendchallenge.gateways.GetTemperatureGateway;

@Component
public class GetTemperatureOpenWeatherMap implements GetTemperatureGateway {

	@Override
	public int execute(String cityName) {
		throw new UnsupportedOperationException("Not implemented yed.");
	}

}
