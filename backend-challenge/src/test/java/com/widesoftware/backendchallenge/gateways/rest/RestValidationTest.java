package com.widesoftware.backendchallenge.gateways.rest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.text.MessageFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.widesoftware.backendchallenge.gateways.rest.dto.SuggestedSongsDTO;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RestValidationTest {

	public static final String CITY_NAME = "Campinas";
	
	@Value("${application.endpoints.resource.suggestedsongs}")
	private String getSuggestedSongsEndpoint;
	
	@Test
	public void shouldExistsGetSuggestedSongs() {
		ResponseEntity<SuggestedSongsDTO> response = requestSongs(CITY_NAME);
		
		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));
	}

	@Test
	public void shouldUnmarshalSuggestedSongs() {
		ResponseEntity<SuggestedSongsDTO> response = requestSongs(CITY_NAME);
		
		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));
		assertThat(response.getBody().getNames(), is(notNullValue()));
		
		response.getBody().getNames().forEach(name -> assertThat(name, is(notNullValue())));
	}
	
	private ResponseEntity<SuggestedSongsDTO> requestSongs(String cityName) {
		String url = MessageFormat.format(getSuggestedSongsEndpoint, cityName);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<SuggestedSongsDTO> response = restTemplate.getForEntity(url, SuggestedSongsDTO.class);
		
		return response;
	}
}
