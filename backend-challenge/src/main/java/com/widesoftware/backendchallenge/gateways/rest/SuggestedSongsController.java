package com.widesoftware.backendchallenge.gateways.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.widesoftware.backendchallenge.entities.Songs;
import com.widesoftware.backendchallenge.gateways.rest.dto.SuggestedSongsDTO;
import com.widesoftware.backendchallenge.usecases.GetSuggestedSongs;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping(path="/api/suggested-songs")
@Api(value="SuggestedSongsControllerAPI", produces=MediaType.APPLICATION_JSON_VALUE)
public class SuggestedSongsController {

	private Logger logger = LoggerFactory.getLogger(SuggestedSongsController.class);
	
	@Autowired
	private GetSuggestedSongs getSuggestedSongs;
	
	@RequestMapping(path = "/{cityName}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation("Gets the suggested songs accordingly with the temperature on the city")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = SuggestedSongsDTO.class)})
	public SuggestedSongsDTO getSuggestedSongs(@ApiParam(value = "The name of the city", required = true) @PathVariable String cityName) {
		Songs songs = getSuggestedSongs.execute(cityName);
		SuggestedSongsDTO suggestedSongs = songsToSuggestedSongsDTO(songs);
		
		logger.debug("Songs suggestion rest request received for {} city. "
				+ "Suggested songs are: {}", cityName, suggestedSongs);
		return suggestedSongs;
	}
	
	private SuggestedSongsDTO songsToSuggestedSongsDTO(Songs songs) {
		return new SuggestedSongsDTO().setNames(songs.getNames());
	}
}
