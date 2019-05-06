package com.widesoftware.backendchallenge.gateways.openweathermap;

import java.text.MessageFormat;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.widesoftware.backendchallenge.gateways.GetTemperatureGateway;
import com.widesoftware.backendchallenge.gateways.openweathermap.dtos.CityWeatherDTO;

import lombok.Getter;

@Component
public class GetTemperatureOpenWeatherMap implements GetTemperatureGateway {

	@Value("${openweathermap.authentication.key}")
	@Getter private String key;
	
	@Value("${openweathermap.endpoints.resource.weather}")
	@Getter private String getLocalWeatherEndpoint;
	
	@Override
	public int execute(String cityName) {
		CityWeatherDTO cityWeather = getLocalWeather(cityName);
		return cityWeather.getMain().getTemp().intValue();
	}

	private CityWeatherDTO getLocalWeather(String cityName) {
		String exceptionMessage = "It wasn't possible to get the weather information about the city";
		CityWeatherDTO cityWeather = performHttpRequest(this::requestLocalWeather, cityName, exceptionMessage);
		return cityWeather;
	}
	
	private ResponseEntity<CityWeatherDTO> requestLocalWeather(String cityName) {
		String url = MessageFormat.format(getLocalWeatherEndpoint, cityName, this.key);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CityWeatherDTO> response = restTemplate.getForEntity(url, CityWeatherDTO.class);
		
		return response;
	}
	
	private <T, R> T performHttpRequest(Function<R, ResponseEntity<T>> function, R arg, String exceptionMessage) {
		ResponseEntity<T> response = function.apply(arg);
		
		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		} else {
			throw new RuntimeException(exceptionMessage);
		}
	}
	
}
