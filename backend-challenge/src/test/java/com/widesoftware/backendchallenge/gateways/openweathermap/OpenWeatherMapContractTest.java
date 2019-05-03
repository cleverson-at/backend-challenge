package com.widesoftware.backendchallenge.gateways.openweathermap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.text.MessageFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import com.widesoftware.backendchallenge.gateways.openweathermap.dtos.CityWeatherDTO;

import lombok.Getter;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OpenWeatherMapContractTest {
	
	public static final String CITY_NAME = "Campinas";
	
	@Value("${openweathermap.authentication.key}")
	@Getter private String key;
	
	@Value("${openweathermap.endpoints.resource.weather}")
	@Getter private String getLocalWeatherEndpoint;
	
	@Test
	public void shouldExistsGetLocalWeather() {
		ResponseEntity<CityWeatherDTO> response = getLocalWeather(CITY_NAME);
		
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}
	
	@Test
	public void shouldUnmarshalTemperature() {
		ResponseEntity<CityWeatherDTO> response = getLocalWeather(CITY_NAME);
		
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(response.getBody().getMain().getTemp(), is(notNullValue()));
	}
	
	private ResponseEntity<CityWeatherDTO> getLocalWeather(String cityName) {
		String url = MessageFormat.format(getLocalWeatherEndpoint, cityName, this.key);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CityWeatherDTO> response = restTemplate.getForEntity(url, CityWeatherDTO.class);
		
		return response;
	}
}
