package com.widesoftware.backendchallenge.cucumber.stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdviseSongCommandSteps {
	@Given("^the temperature is bellow (\\d+) degrees Celsius$")
	public void theTemperatureIsBellowDegreesCelsius(int arg1) throws Throwable {
	    throw new PendingException();
	}

	@When("^I check the song suggestions$")
	public void iCheckTheSongSuggestions() throws Throwable {
	    throw new PendingException();
	}

	@Then("^I get songs of the Rock category suggested$")
	public void iGetSongsOfTheRockCategorySuggested() throws Throwable {
	    throw new PendingException();
	}

	@Given("^the temperature is greater than or equal to (\\d+) degrees Celsius$")
	public void theTemperatureIsGreaterThanOrEqualToDegreesCelsius(int arg1) throws Throwable {
	    throw new PendingException();
	}

	@Given("^lower than or equal to (\\d+)$")
	public void lowerThanOrEqualTo(int arg1) throws Throwable {
	    throw new PendingException();
	}

	@Then("^I get songs of the Classic category suggested$")
	public void iGetSongsOfTheClassicCategorySuggested() throws Throwable {
	    throw new PendingException();
	}

	@Then("^I get songs of the Hip Hop category suggested$")
	public void iGetSongsOfTheHipHopCategorySuggested() throws Throwable {
	    throw new PendingException();
	}

	@Given("^the temperature is greater than (\\d+) degrees Celsius$")
	public void theTemperatureIsGreaterThanDegreesCelsius(int arg1) throws Throwable {
	    throw new PendingException();
	}

	@Then("^I get songs of the Party category suggested$")
	public void iGetSongsOfThePartyCategorySuggested() throws Throwable {
	    throw new PendingException();
	}
}
