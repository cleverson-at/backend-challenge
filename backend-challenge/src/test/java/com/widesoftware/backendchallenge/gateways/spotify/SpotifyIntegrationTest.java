package com.widesoftware.backendchallenge.gateways.spotify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.widesoftware.backendchallenge.entities.Songs;
import com.widesoftware.backendchallenge.entities.SongsCategory;
import com.widesoftware.backendchallenge.gateways.GetSongsGateway;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.equalTo;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpotifyIntegrationTest {

	public static final SongsCategory SONGS_CATEGORY = SongsCategory.CLASSIC;
	
	@Autowired
	@Qualifier("getSongsSpotify")
	public GetSongsGateway getSongsGateway;
	
	@Test
	public void shouldGetSongsFromCategory() {
		Songs songs = getSongsGateway.execute(SONGS_CATEGORY);
		
		assertThat(songs.getCategory(), is(equalTo(SONGS_CATEGORY)));
		assertThat(songs.getNames(), is(notNullValue()));
	}
	
}
