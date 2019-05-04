package com.widesoftware.backendchallenge.gateways.spotify;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.widesoftware.backendchallenge.entities.Songs;
import com.widesoftware.backendchallenge.entities.SongsCategory;
import com.widesoftware.backendchallenge.gateways.GetSongsGateway;
import com.widesoftware.backendchallenge.gateways.spotify.dtos.AuthenticationDTO;
import com.widesoftware.backendchallenge.gateways.spotify.dtos.CategoryPlaylistsDTO;
import com.widesoftware.backendchallenge.gateways.spotify.dtos.ItemDTO;
import com.widesoftware.backendchallenge.gateways.spotify.dtos.PlaylistDTO;
import com.widesoftware.backendchallenge.gateways.spotify.dtos.PlaylistTracksDTO;

@Component
public class GetSongsSpotify implements GetSongsGateway {

	@Value("${spotify.endpoints.authenticate}")
	private String authenticate;
	
	@Value("${spotify.authentication.client.id}")
	private String clientId;
	
	@Value("${spotify.authentication.client.secret}")
	private String clientSecret;
	
	@Value("${spotify.endpoints.resource.browse.category.playlists}")
	private String getCategoryPlaylistsEndpoint;
	
	@Value("${spotify.endpoints.resource.playlist.tracks}")
	private String getPlaylistTracksEndpoint;
	
	private String bearerToken;

	private void authenticate() {
		String exceptionMessage = "It wasn't possible to authenticate.";
		AuthenticationDTO auth = performHttpRequest(this::requestAuthentication, exceptionMessage);
		this.bearerToken = auth.getAccess_token();
	}
	
	@Override
	public Songs execute(SongsCategory category) {
		CategoryPlaylistsDTO categoryPlaylists = getCategoryPlaylists(systemToSpotifySongCategory(category));
		
		Set<String> names = new HashSet<String>();
		if (!categoryPlaylists.getPlaylists().getItems().isEmpty()) {
			addSongsFromPlaylist(names, categoryPlaylists.getPlaylists().getItems().get(0));
		}
		
		return new Songs(category, names);
	}
	
	private void addSongsFromPlaylist(Set<String> names, PlaylistDTO playlist) {
		String playlistId = playlist.getId();
		PlaylistTracksDTO playlistTracks = getPlaylistTracks(playlistId);
		
		if (!playlistTracks.getItems().isEmpty()) {
			names.addAll(getSongsFromItems(names, playlistTracks.getItems()));
		}
	}
	
	private Set<String> getSongsFromItems(Set<String> names, List<ItemDTO> items) {
		return items.stream().map(item -> item.getTrack().getName()).collect(Collectors.toSet());
	}
	
	private SpotifySongsCategory systemToSpotifySongCategory(SongsCategory systemCategory) {
		switch (systemCategory) {
			case ROCK: return SpotifySongsCategory.ROCK;
			case CLASSIC: return SpotifySongsCategory.CLASSICAL;
			case HIP_HOP: return SpotifySongsCategory.HIP_HOP;
			case PARTY: return SpotifySongsCategory.PARTY;
			default: throw new IllegalArgumentException();
		}
	}
	
	private CategoryPlaylistsDTO getCategoryPlaylists(SpotifySongsCategory songCategory) {
		String exceptionMessage = "It wasn't possible to get the playlists from the category";
		CategoryPlaylistsDTO categoryPlaylists = performAuthenticatedHttpRequest(this::requestCategoryPlaylists, songCategory, exceptionMessage);
		return categoryPlaylists;
	}
	
	private PlaylistTracksDTO getPlaylistTracks(String playlistId) {
		String exceptionMessage = "It wasn't possible to get the tracks from the playlist";
		PlaylistTracksDTO playlistTracks = performAuthenticatedHttpRequest(this::requestPlaylistTracks, playlistId, exceptionMessage);
		return playlistTracks;
	}
	
	private ResponseEntity<AuthenticationDTO> requestAuthentication() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setBasicAuth(clientId, clientSecret);
		
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("grant_type", "client_credentials");
		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(body, headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<AuthenticationDTO> response = restTemplate.postForEntity(this.authenticate, request, AuthenticationDTO.class);
		
		return response;
	}
	
	private ResponseEntity<CategoryPlaylistsDTO> requestCategoryPlaylists(SpotifySongsCategory songCategory) {
		String url = MessageFormat.format(getCategoryPlaylistsEndpoint, songCategory);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(this.bearerToken);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CategoryPlaylistsDTO> response = restTemplate.exchange(url, HttpMethod.GET, entity, CategoryPlaylistsDTO.class);
		
		return response;
	}
	
	private ResponseEntity<PlaylistTracksDTO> requestPlaylistTracks(String playlistId) {
		String url = MessageFormat.format(getPlaylistTracksEndpoint, playlistId);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(this.bearerToken);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<PlaylistTracksDTO> response = restTemplate.exchange(url, HttpMethod.GET, entity, PlaylistTracksDTO.class);
		
		return response;
	}
	
	private <T> T performHttpRequest(Supplier<ResponseEntity<T>> supplier, String exceptionMessage) {
		ResponseEntity<T> response = supplier.get();
		
		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		} else {
			throw new RuntimeException(exceptionMessage);
		}
	}
	
	private <T, R> T performAuthenticatedHttpRequest(Function<R, ResponseEntity<T>> function, R arg, String exceptionMessage) {
		ResponseEntity<T> response = null;
		try {
			response = function.apply(arg);
		} catch (HttpClientErrorException e) {
			if (e.getStatusCode() == HttpStatus.UNAUTHORIZED) {
				authenticate();
				response = function.apply(arg);
			}
		}
		
		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		} else {
			throw new RuntimeException(exceptionMessage);
		}
	}
	
}
