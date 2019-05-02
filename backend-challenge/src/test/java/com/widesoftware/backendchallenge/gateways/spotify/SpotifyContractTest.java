package com.widesoftware.backendchallenge.gateways.spotify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.text.IsEmptyString.emptyOrNullString;

import lombok.Getter;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpotifyContractTest {

	@Value("${endpoints.authenticate}")
	@Getter private String authenticate;
	
	@Value("${authentication.client.id}")
	@Getter private String clientId;
	
	@Value("${authentication.client.secret}")
	@Getter private String clientSecret;
	
	@Value("${endpoints.baseurl}")
	@Getter private String baseUrl;
	
	@Value("${endpoints.resource.browse.category}")
	@Getter private String getCategoryEndpoint;
	
	@Value("${endpoints.resource.playlist}")
	@Getter private String getPlaylistsEndpoint;
	
	@Value("${endpoints.resource.playlist.tracks}")
	@Getter private String getPlaylistTracksEndpoint;
	
	@Test
	public void shouldGetSameDataAsBeforeWhenAuthenticateExceptByToken() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setBasicAuth(clientId, clientSecret);
		
		MultiValueMap<String, String> body= new LinkedMultiValueMap<String, String>();
		body.add("grant_type", "client_credentials");
		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(body, headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<AuthenticationDTO> response = restTemplate.postForEntity(this.authenticate, request, AuthenticationDTO.class);
		
		assertThat(response.getBody().getAccess_token(), is(notNullValue()));
		assertThat(response.getBody().getToken_type(), is(equalTo("Bearer")));
		assertThat(response.getBody().getExpires_in(), is(equalTo("3600")));
		assertThat(response.getBody().getScope(), is(emptyOrNullString()));
	}

}
