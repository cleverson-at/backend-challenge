package com.widesoftware.backendchallenge.usecases;

import com.widesoftware.backendchallenge.domain.TemperatureToSongCategory;
import com.widesoftware.backendchallenge.entities.Songs;
import com.widesoftware.backendchallenge.entities.SongsCategory;
import com.widesoftware.backendchallenge.gateways.GetSongsGateway;
import com.widesoftware.backendchallenge.gateways.GetTemperatureGateway;

public class GetSuggestedSongs {
	
	private GetTemperatureGateway getTemperatureGateway;
	private GetSongsGateway getSongsGateway;
	
	private TemperatureToSongCategory temperatureToSongCategory;
	
	public GetSuggestedSongs(GetTemperatureGateway getTemperatureGateway, 
			TemperatureToSongCategory temperatureToSongCategory,
			GetSongsGateway getSongsGateway) {
		
		this.getTemperatureGateway = getTemperatureGateway;
		this.getSongsGateway = getSongsGateway;
		
		this.temperatureToSongCategory = temperatureToSongCategory;
	}
	
	public Songs execute(String cityName) {
		int temperature = getTemperatureGateway.execute(cityName);
		SongsCategory songsCategory = temperatureToSongCategory.convert(temperature);
		Songs songs = getSongsGateway.execute(songsCategory);
		
		return songs;
	}
}
