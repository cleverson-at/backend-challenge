package com.widesoftware.backendchallenge.gateways;

import com.widesoftware.backendchallenge.entities.Songs;

public interface GetSongsGateway {
	public Songs execute(String category);
}
