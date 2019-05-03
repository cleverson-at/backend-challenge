package com.widesoftware.backendchallenge.gateways.spotify;

import org.springframework.stereotype.Component;

import com.widesoftware.backendchallenge.entities.Songs;
import com.widesoftware.backendchallenge.entities.SongsCategory;
import com.widesoftware.backendchallenge.gateways.GetSongsGateway;

@Component
public class GetSongsSpotify implements GetSongsGateway {

	@Override
	public Songs execute(SongsCategory category) {
		throw new UnsupportedOperationException("Not implemented yed.");
	}

}
