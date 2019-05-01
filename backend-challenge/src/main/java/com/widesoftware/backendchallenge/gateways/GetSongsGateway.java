package com.widesoftware.backendchallenge.gateways;

import com.widesoftware.backendchallenge.entities.Songs;
import com.widesoftware.backendchallenge.entities.SongsCategory;

public interface GetSongsGateway {
	public Songs execute(SongsCategory category);
}
