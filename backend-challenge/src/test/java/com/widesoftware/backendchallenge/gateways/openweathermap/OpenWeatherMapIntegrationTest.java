package com.widesoftware.backendchallenge.gateways.openweathermap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.widesoftware.backendchallenge.gateways.GetTemperatureGateway;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OpenWeatherMapIntegrationTest {

	public static final String CITY_NAME = "Campinas";
	
	@Autowired
	@Qualifier("getTemperatureOpenWeatherMap")
	public GetTemperatureGateway getTemperatureGateway;
	
	@Test
	public void shouldGetTemperatureFromCityName() {
		Integer temparature = getTemperatureGateway.execute(CITY_NAME);
		
		assertThat(temparature, is(notNullValue()));
	}
	
}
