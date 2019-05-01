package com.widesoftware.backendchallenge.domain;

import com.widesoftware.backendchallenge.entities.SongsCategory;

public class TemperatureToSongCategory {
	
	public SongsCategory convert(int temperature) {
		if (temperature < 15) {
			return SongsCategory.ROCK;
		} else if (isInBetween(temperature, 15, 20)) {
			return SongsCategory.CLASSIC;
		} else if (isInBetween(temperature, 21, 30)) {
			return SongsCategory.HIP_HOP;
		} else if (temperature > 30) {
			return SongsCategory.PARTY;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	private boolean isInBetween(int value, int lowerBound, int upperBound) {
		return ((value >= lowerBound) && (value <= upperBound)) ? true : false;
	}
	
}
