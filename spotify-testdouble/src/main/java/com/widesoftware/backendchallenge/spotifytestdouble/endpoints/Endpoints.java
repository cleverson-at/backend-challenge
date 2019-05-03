package com.widesoftware.backendchallenge.spotifytestdouble.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.widesoftware.backendchallenge.spotifytestdouble.dtos.AuthenticationDTO;
import com.widesoftware.backendchallenge.spotifytestdouble.dtos.CategoryDTO;
import com.widesoftware.backendchallenge.spotifytestdouble.dtos.CategoryPlaylistsDTO;
import com.widesoftware.backendchallenge.spotifytestdouble.dtos.ItemDTO;
import com.widesoftware.backendchallenge.spotifytestdouble.dtos.PlaylistDTO;
import com.widesoftware.backendchallenge.spotifytestdouble.dtos.PlaylistTracksDTO;
import com.widesoftware.backendchallenge.spotifytestdouble.dtos.PlaylistsDTO;
import com.widesoftware.backendchallenge.spotifytestdouble.dtos.TrackDTO;

@Controller
public class Endpoints {

	private Logger logger = LoggerFactory.getLogger(Endpoints.class);
	
	public static final String TOKEN = "BQB1T-7QO_7qbEqjiJbaJvwU30q7V3zrL429YB2A9TVLQV06KLsmoBBW-qPvfLG302o42-RTa78yHvgjpIk";
	
	public static final String PLAYLIST_ID = "37i9dQZF1DWWEJlAGA9gs0";
	public static final String SONG_NAME = "Cool song name";
	
	@PostMapping("/")
	@ResponseBody
	public AuthenticationDTO authenticate() {
		AuthenticationDTO authetication = AuthenticationDTO.builder()
				.access_token(TOKEN)
				.token_type("Bearer")
				.expires_in(3600)
				.build();
		
		logger.info("Authentication request received. Authentication data -> {}", authetication);
		return authetication;
	}

	@GetMapping("/browse/categories/{categoryId}")
	@ResponseBody
	public CategoryDTO getCategory(@PathVariable String categoryId) {
		CategoryDTO category = CategoryDTO.builder()
				.id(categoryId)
				.build();
		
		logger.info("Get category request recived. Category -> {}", category);
		return category;
	}
	
	@GetMapping("/browse/categories/{categoryId}/playlists")
	@ResponseBody
	public CategoryPlaylistsDTO getCategoryPlaylist(@PathVariable String categoryId) {
		List<PlaylistDTO> plaslists = new ArrayList<>();
		plaslists.add(PlaylistDTO.builder().id(PLAYLIST_ID).build());
		
		CategoryPlaylistsDTO categoryPlaylist = CategoryPlaylistsDTO.builder()
				.playlists(PlaylistsDTO.builder()
						.items(plaslists)
						.build())
				.build();
		
		logger.info("Get category's playlists request received. Category's playlists -> {}", categoryPlaylist);
		return categoryPlaylist;
	}
	
	@GetMapping("playlists/{playlistId}/tracks")
	@ResponseBody
	public PlaylistTracksDTO getPlaylistTracks(@PathVariable String playlistId) {
		List<ItemDTO> items = new ArrayList<>();
		items.add(ItemDTO.builder()
				.track(TrackDTO.builder()
						.name(SONG_NAME)
						.build())
				.build());
		
		PlaylistTracksDTO playlistTracks = PlaylistTracksDTO.builder()
				.items(items)
				.build();
		
		logger.info("Get playlist's track request receeived. Playlist's track -> {}", playlistTracks);
		return playlistTracks;
	}
	
}
