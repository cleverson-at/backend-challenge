package com.widesoftware.backendchallenge.gateways.spotify;

public enum SpotifySongsCategory {
	ROCK {
		@Override
		public String toString() {
			return "rock";
		}
	},
	CLASSICAL {
		@Override
		public String toString() {
			return "classical";
		}
	},
	HIP_HOP {
		@Override
		public String toString() {
			return "hiphop";
		}
	},
	PARTY {
		@Override
		public String toString() {
			return "party";
		}
	}
}
