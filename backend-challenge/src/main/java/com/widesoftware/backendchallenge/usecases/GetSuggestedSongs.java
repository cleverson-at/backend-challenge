package com.widesoftware.backendchallenge.usecases;

import com.widesoftware.backendchallenge.domain.TemperatureToSongCategory;
import com.widesoftware.backendchallenge.entities.Songs;
import com.widesoftware.backendchallenge.entities.SongsCategory;
import com.widesoftware.backendchallenge.gateways.GetSongsGateway;
import com.widesoftware.backendchallenge.gateways.GetTemperatureGateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;;

@Component
public class GetSuggestedSongs {
	
	private Logger logger = LoggerFactory.getLogger(GetSuggestedSongs.class);
	
	private GetTemperatureGateway getTemperatureGateway;
	private GetSongsGateway getSongsGateway;
	
	private TemperatureToSongCategory temperatureToSongCategory;
	
	@Autowired
	public GetSuggestedSongs(
			@Qualifier("getTemperatureOpenWeatherMap") GetTemperatureGateway getTemperatureGateway, 
			TemperatureToSongCategory temperatureToSongCategory,
			@Qualifier("getSongsSpotify") GetSongsGateway getSongsGateway) {
		
		this.getTemperatureGateway = getTemperatureGateway;
		this.getSongsGateway = getSongsGateway;
		
		this.temperatureToSongCategory = temperatureToSongCategory;
	}
	
	public Songs execute(String cityName) {
		int temperature = getTemperatureGateway.execute(cityName);
		SongsCategory songsCategory = temperatureToSongCategory.convert(temperature);
		Songs songs = getSongsGateway.execute(songsCategory);
		
		logger.info("Songs suggestion request received for {} city. "
				+ "Suggested song are: {}", cityName, songs);
		return songs;
	}
}
