package com.widesoftware.backendchallenge.domain;

import org.junit.Before;
import org.junit.Test;

import com.widesoftware.backendchallenge.entities.SongsCategory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

public class TemperatureToSongCategoryTest {

	private TemperatureToSongCategory temperatureToSongCategory;
	
	@Before
	public void setUp() {
		this.temperatureToSongCategory = new TemperatureToSongCategory();
	}
	
	@Test
	public void shouldReturnRockWhenTemperatureEqualsMinus20() {
		assertThat(this.temperatureToSongCategory.convert(-20), is(equalTo(SongsCategory.ROCK)));
	}
	
	@Test
	public void shouldReturnRockWhenTemperatureEquals14() {
		assertThat(this.temperatureToSongCategory.convert(14), is(equalTo(SongsCategory.ROCK)));
	}
	
	@Test
	public void shouldReturnClassicWhenTemperatureEquals15() {
		assertThat(this.temperatureToSongCategory.convert(15), is(equalTo(SongsCategory.CLASSIC)));
	}
	
	@Test
	public void shouldReturnClassicWhenTemperatureEquals17() {
		assertThat(this.temperatureToSongCategory.convert(17), is(equalTo(SongsCategory.CLASSIC)));
	}
	
	@Test
	public void shouldReturnClassicWhenTemperatureEquals20() {
		assertThat(this.temperatureToSongCategory.convert(20), is(equalTo(SongsCategory.CLASSIC)));
	}
	
	@Test
	public void shouldReturnHipHopWhenTemperatureEquals21() {
		assertThat(this.temperatureToSongCategory.convert(21), is(equalTo(SongsCategory.HIP_HOP)));
	}
	
	@Test
	public void shouldReturnHipHopWhenTemperatureEquals25() {
		assertThat(this.temperatureToSongCategory.convert(25), is(equalTo(SongsCategory.HIP_HOP)));
	}
	
	@Test
	public void shouldReturnHipHopWhenTemperatureEquals30() {
		assertThat(this.temperatureToSongCategory.convert(30), is(equalTo(SongsCategory.HIP_HOP)));
	}
	
	@Test
	public void shouldReturnPartyWhenTemperatureEquals31() {
		assertThat(this.temperatureToSongCategory.convert(31), is(equalTo(SongsCategory.PARTY)));
	}
	
	@Test
	public void shouldReturnPartyWhenTemperatureEquals40() {
		assertThat(this.temperatureToSongCategory.convert(40), is(equalTo(SongsCategory.PARTY)));
	}
}
