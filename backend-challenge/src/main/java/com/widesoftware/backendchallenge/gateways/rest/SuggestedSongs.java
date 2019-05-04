package com.widesoftware.backendchallenge.gateways.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.widesoftware.backendchallenge.entities.Songs;
import com.widesoftware.backendchallenge.gateways.rest.dto.SuggestedSongsDTO;
import com.widesoftware.backendchallenge.usecases.GetSuggestedSongs;

@Controller
public class SuggestedSongs {

	@Autowired
	private GetSuggestedSongs getSuggestedSongs;
	
	@GetMapping("/suggestedsongs/{cityName}")
	@ResponseBody
	public SuggestedSongsDTO getSuggestedSongs(@PathVariable String cityName) {
		Songs songs = getSuggestedSongs.execute(cityName);
		return songsToSuggestedSongsDTO(songs);
	}
	
	private SuggestedSongsDTO songsToSuggestedSongsDTO(Songs songs) {
		return new SuggestedSongsDTO().setNames(songs.getNames());
	}
}
