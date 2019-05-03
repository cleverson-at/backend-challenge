package com.widesoftware.backendchallenge.gateways.spotify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.widesoftware.backendchallenge.gateways.spotify.dtos.AuthenticationDTO;
import com.widesoftware.backendchallenge.gateways.spotify.dtos.CategoryDTO;
import com.widesoftware.backendchallenge.gateways.spotify.dtos.CategoryPlaylistsDTO;
import com.widesoftware.backendchallenge.gateways.spotify.dtos.PlaylistTracksDTO;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.text.IsEmptyString.emptyOrNullString;

import java.text.MessageFormat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpotifyContractTest {

	@Value("${endpoints.authenticate}")
	private String authenticate;
	
	@Value("${authentication.client.id}")
	private String clientId;
	
	@Value("${authentication.client.secret}")
	private String clientSecret;
	
	@Value("${endpoints.resource.browse.category}")
	private String getCategoryEndpoint;
	
	@Value("${endpoints.resource.browse.category.playlists}")
	private String getCategoryPlaylistsEndpoint;
	
	@Value("${endpoints.resource.playlist.tracks}")
	private String getPlaylistTracksEndpoint;
	
	private String bearerToken;
	
	private AuthenticationDTO authenticationResponseBody = null;
	
	@Before
	public void setUp() {
		if (isNotAuthenticated()) {
			authenticate();
		}
	}
	
	private boolean isNotAuthenticated() {
		return this.authenticationResponseBody == null ? true : false;
	}
	
	private void authenticate() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setBasicAuth(clientId, clientSecret);
		
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("grant_type", "client_credentials");
		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(body, headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<AuthenticationDTO> response = restTemplate.postForEntity(this.authenticate, request, AuthenticationDTO.class);
		if (!response.getStatusCode().equals(HttpStatus.OK)) {
			throw new RuntimeException("It wasn't possible to authenticate.");
		} else {
			this.authenticationResponseBody = response.getBody();
			this.bearerToken = this.authenticationResponseBody.getAccess_token();
		}
	}
	
	@Test
	public void shouldGetSameDataAsBeforeWhenAuthenticateExceptByToken() {
		assertThat(this.authenticationResponseBody.getAccess_token(), is(notNullValue()));
		assertThat(this.authenticationResponseBody.getToken_type(), is(equalTo("Bearer")));
		assertThat(this.authenticationResponseBody.getExpires_in(), is(equalTo(3600)));
		assertThat(this.authenticationResponseBody.getScope(), is(emptyOrNullString()));

	}
	
	@Test
	public void shouldExistRockCategory() {
		String url = MessageFormat.format(getCategoryEndpoint, SpotifySongsCategory.ROCK);
		ResponseEntity<CategoryDTO> response = spotifyGetCategory(url);
		
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}
	
	@Test
	public void shouldExistClassicalCategory() {
		String url = MessageFormat.format(getCategoryEndpoint, SpotifySongsCategory.CLASSICAL);
		ResponseEntity<CategoryDTO> response = spotifyGetCategory(url);
		
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}
	
	@Test
	public void shouldExistHipHopCategory() {
		String url = MessageFormat.format(getCategoryEndpoint, SpotifySongsCategory.HIP_HOP);
		ResponseEntity<CategoryDTO> response = spotifyGetCategory(url);
		
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}
	
	@Test
	public void shouldExistPartyCategory() {
		String url = MessageFormat.format(getCategoryEndpoint, SpotifySongsCategory.PARTY);
		ResponseEntity<CategoryDTO> response = spotifyGetCategory(url);
		
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}
	
	private ResponseEntity<CategoryDTO> spotifyGetCategory(String url) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(this.bearerToken);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CategoryDTO> response = restTemplate.exchange(url, HttpMethod.GET, entity, CategoryDTO.class);
		
		return response;
	}
	
	@Test
	public void shouldExistsGetPlaylist() {
		String url = MessageFormat.format(getCategoryPlaylistsEndpoint, SpotifySongsCategory.PARTY);
		ResponseEntity<CategoryPlaylistsDTO> response = spotifyGetPlaylist(url);
		
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}
	
	private ResponseEntity<CategoryPlaylistsDTO> spotifyGetPlaylist(String url) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(this.bearerToken);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CategoryPlaylistsDTO> response = restTemplate.exchange(url, HttpMethod.GET, entity, CategoryPlaylistsDTO.class);
		
		return response;
	}
	
	@Test
	public void shouldExistsGetPlaylistTracks() {
		String playlistsUrl = MessageFormat.format(getCategoryPlaylistsEndpoint, SpotifySongsCategory.PARTY);
		ResponseEntity<CategoryPlaylistsDTO> playlistsResponse = spotifyGetPlaylist(playlistsUrl);
		
		assertThat(playlistsResponse.getStatusCode(), equalTo(HttpStatus.OK));
		if (!playlistsResponse.getBody().getPlaylists().getItems().isEmpty()) {
			String playlistId = playlistsResponse.getBody().getPlaylists().getItems().get(0).getId();
					
			String url = MessageFormat.format(getPlaylistTracksEndpoint, playlistId);
			ResponseEntity<PlaylistTracksDTO> response = spotifyGetPlaylistTracks(url);
			
			assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));			
		}
	}
	
	private ResponseEntity<PlaylistTracksDTO> spotifyGetPlaylistTracks(String url) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(this.bearerToken);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<PlaylistTracksDTO> response = restTemplate.exchange(url, HttpMethod.GET, entity, PlaylistTracksDTO.class);
		
		return response;
	}

}
