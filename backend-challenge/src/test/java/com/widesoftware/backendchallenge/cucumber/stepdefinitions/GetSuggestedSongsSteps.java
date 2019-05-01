package com.widesoftware.backendchallenge.cucumber.stepdefinitions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.widesoftware.backendchallenge.builders.SongsBuilder;
import com.widesoftware.backendchallenge.domain.TemperatureToSongCategory;
import com.widesoftware.backendchallenge.entities.Songs;
import com.widesoftware.backendchallenge.entities.SongsCategory;
import com.widesoftware.backendchallenge.gateways.GetSongsGateway;
import com.widesoftware.backendchallenge.gateways.GetTemperatureGateway;
import com.widesoftware.backendchallenge.usecases.GetSuggestedSongs;

import  static org.mockito.Mockito.when;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetSuggestedSongsSteps {
	
	public static final String CITY_NAME = "Campinas";
	
	public static final int ROCK_TEMPERATURE = 14;
	public static final int CLASSIC_TEMPERATURE = 16;
	public static final int HIP_HOP_TEMPERATURE = 22;
	public static final int PARTY_TEMPERATURE = 31;
	
	@Mock private GetTemperatureGateway getTemperatureGateway;
	@Mock private GetSongsGateway getSongsGateway;
	
	private TemperatureToSongCategory temperatureToSongCategory;
	
	private GetSuggestedSongs getSuggestedSongs;
	
	private Songs suggestedSongs;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		this.temperatureToSongCategory = new TemperatureToSongCategory();
		this.getSuggestedSongs = new GetSuggestedSongs(this.getTemperatureGateway,
				this.temperatureToSongCategory,
				this.getSongsGateway);
	}
	
	@Given("^the temperature is bellow 15 degrees Celsius$")
	public void theTemperatureIsBellow15DegreesCelsius() throws Throwable {
		when(getTemperatureGateway.execute(CITY_NAME)).thenReturn(ROCK_TEMPERATURE);
		when(getSongsGateway.execute(SongsCategory.ROCK)).thenReturn(new SongsBuilder()
				.withRockSuggestedSongs().build());
	}

	@Given("^the temperature is greater than or equal to 15 degrees Celsius and lower than or equal to 20$")
	public void theTemperatureIsGreaterThanOrEqualTo15DegreesCelsiusAndLowerThanOrEqualTo20() throws Throwable {
		when(getTemperatureGateway.execute(CITY_NAME)).thenReturn(CLASSIC_TEMPERATURE);
		when(getSongsGateway.execute(SongsCategory.CLASSIC)).thenReturn(new SongsBuilder()
				.withRockSuggestedSongs().build());
	}
	
	@Given("^the temperature is greater than or equal to 21 degrees Celsius and lower than or equal to 30$")
	public void theTemperatureIsGreaterThanOrEqualTo21DegreesCelsiusAndLowerThanOrEqualTo30() throws Throwable {
		when(getTemperatureGateway.execute(CITY_NAME)).thenReturn(HIP_HOP_TEMPERATURE);
		when(getSongsGateway.execute(SongsCategory.HIP_HOP)).thenReturn(new SongsBuilder()
				.withRockSuggestedSongs().build());
	}
	
	@Given("^the temperature is greater than 30 degrees Celsius$")
	public void theTemperatureIsGreaterThan30DegreesCelsius() throws Throwable {
		when(getTemperatureGateway.execute(CITY_NAME)).thenReturn(PARTY_TEMPERATURE);
		when(getSongsGateway.execute(SongsCategory.PARTY)).thenReturn(new SongsBuilder()
				.withRockSuggestedSongs().build());
	}
	
	@When("^I check the song suggestions$")
	public void iCheckTheSongSuggestions() throws Throwable {
		this.suggestedSongs = getSuggestedSongs.execute(CITY_NAME);
	}

	@Then("^I get songs of the Rock category suggested$")
	public void iGetSongsOfTheRockCategorySuggested() throws Throwable {
		assertThat(this.suggestedSongs.getCategory(), is(equalTo(SongsCategory.ROCK)));
	}

	@Then("^I get songs of the Classic category suggested$")
	public void iGetSongsOfTheClassicCategorySuggested() throws Throwable {
		assertThat(this.suggestedSongs.getCategory(), is(equalTo(SongsCategory.CLASSIC)));
	}

	@Then("^I get songs of the Hip Hop category suggested$")
	public void iGetSongsOfTheHipHopCategorySuggested() throws Throwable {
		assertThat(this.suggestedSongs.getCategory(), is(equalTo(SongsCategory.HIP_HOP)));
	}

	@Then("^I get songs of the Party category suggested$")
	public void iGetSongsOfThePartyCategorySuggested() throws Throwable {
		assertThat(this.suggestedSongs.getCategory(), is(equalTo(SongsCategory.PARTY)));
	}
}
