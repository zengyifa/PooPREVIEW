package com.example.bathroomreview.listings;

import java.util.ArrayList;

public class Bathroom {
	public String id;
	public String content;
	public String description;

	public Bathroom(String id, String content, String description) {
		this.id = id;
		this.content = content;
		this.description = description;
	}

	public Bathroom(String id, String content, ArrayList<Bathroom> a) {
		this.id = id;
		this.content = content;

	}

	public String toString() {
		return content;
	}

}