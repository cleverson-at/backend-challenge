package com.widesoftware.backendchallenge.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.widesoftware.backendchallenge.entities.SongsCategory;

@Component
public class TemperatureToSongCategory {
	
	private Logger logger = LoggerFactory.getLogger(TemperatureToSongCategory.class);
	
	public SongsCategory convert(int temperature) {
		SongsCategory songsCategory;
		if (temperature < 15) {
			songsCategory = SongsCategory.ROCK;
		} else if (isInBetween(temperature, 15, 20)) {
			songsCategory = SongsCategory.CLASSIC;
		} else if (isInBetween(temperature, 21, 30)) {
			songsCategory = SongsCategory.HIP_HOP;
		} else if (temperature > 30) {
			songsCategory = SongsCategory.PARTY;
		} else {
			throw new IllegalArgumentException();
		}
		
		logger.info("Temperature convertion to song category request received. "
				+ "Temperture: {} -> Song category: {}.", temperature, songsCategory);
		return songsCategory;
	}
	
	private boolean isInBetween(int value, int lowerBound, int upperBound) {
		return ((value >= lowerBound) && (value <= upperBound)) ? true : false;
	}
	
}
