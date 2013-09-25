package com.example.bathroomreview.listings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.widget.ListView;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class BathroomListings {

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<Bathroom> ITEMS = new ArrayList<Bathroom>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, Bathroom> ITEM_MAP = new HashMap<String, Bathroom>();

	public static String header = "Bathroom's Near You:";

	static {
		// Add 3 sample items.
		addItem(new Bathroom("1", "North Campus",
				"This is Bathroom 1's description."));
		addItem(new Bathroom("2", "Central Campus", "B2 descrip"));
		addItem(new Bathroom("3", "South Campus", "B3 descrip"));
	}

	private static void addItem(Bathroom item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

	/**
	 * A dummy item representing a piece of content.
	 */
	public static class Bathroom {
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
			ITEMS = a;

		}

		public String toString() {
			return content;
		}

	}

}
