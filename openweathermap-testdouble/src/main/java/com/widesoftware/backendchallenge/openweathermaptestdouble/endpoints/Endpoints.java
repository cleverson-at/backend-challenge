package com.widesoftware.backendchallenge.openweathermaptestdouble.endpoints;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.widesoftware.backendchallenge.openweathermaptestdouble.dtos.CityWeatherDTO;
import com.widesoftware.backendchallenge.openweathermaptestdouble.dtos.MainDTO;

@Controller
public class Endpoints {

	private Logger logger = LoggerFactory.getLogger(Endpoints.class);
	
	public static Double TEMPERATURE = 22.;

	@GetMapping("/weather")
	@ResponseBody
	public CityWeatherDTO getLocalWeather() {
		CityWeatherDTO cityWeather = CityWeatherDTO.builder()
				.main(MainDTO.builder()
						.temp(TEMPERATURE)
						.build())
				.build();
		
		logger.info("Get loacal weather request received. City weather -> {}", cityWeather);
		return cityWeather;
	}
}
