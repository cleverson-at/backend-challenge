package com.widesoftware.backendchallenge.entities;

import java.util.HashSet;
import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@EqualsAndHashCode
@Accessors(chain=true)
public class Songs {
	@Getter private SongsCategory category;
	
	private Set<String> names = new HashSet<String>();
	
	public Songs(SongsCategory category, Set<String> names) {
		this.category = category;
		this.setNames(names);
	}
	
	public Set<String> getNames() {
		return new HashSet<String>(this.names);
	}
	
	public Songs setNames(Set<String> names) {
		this.names.clear();
		if (names != null) {
			this.names.addAll(names);
		}
		return this;
	}
}
