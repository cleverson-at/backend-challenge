package com.widesoftware.backendchallenge.builders;

import java.util.HashSet;
import java.util.Set;

import com.widesoftware.backendchallenge.entities.Songs;
import com.widesoftware.backendchallenge.entities.SongsCategory;

public class SongsBuilder {
	private SongsCategory category;
	private Set<String> names = new HashSet<String>();
	
	public SongsBuilder() {}
	
	public SongsBuilder withRockSuggestedSongs() {
		this.category = SongsCategory.ROCK;
		this.names.add("Highway to Hell");
		return this;
	}
	
	public SongsBuilder withClassicSuggestedSongs() {
		this.category = SongsCategory.CLASSIC;
		this.names.add("Symphony No 5");
		return this;
	}
	
	public SongsBuilder withHipHopSuggestedSongs() {
		this.category = SongsCategory.HIP_HOP;
		this.names.add("Lose Yourself");
		return this;
	}
	
	public SongsBuilder withPartySuggestedSongs() {
		this.category = SongsCategory.PARTY;
		this.names.add("Yeah!");
		return this;
	}
	
	public Songs build() {
		return new Songs(this.category, this.names);
	}
}
