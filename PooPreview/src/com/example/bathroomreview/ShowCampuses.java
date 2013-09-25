package com.example.bathroomreview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.Parse;

/**
 * An activity representing a single Item detail screen. This activity is only
 * used on handset devices. On tablet-size devices, item details are presented
 * side-by-side with a list of items in a {@link ItemListActivity}.
 * <p>
 * This activity is mostly just a 'shell' activity containing nothing more than
 * a {@link ItemDetailFragment}.
 */

public class ShowCampuses extends Activity {
	static public ArrayList<String> northBuildingArray = new ArrayList();
	static public ArrayList<String> centralBuildingArray = new ArrayList();
	static public ArrayList<String> southBuildingArray = new ArrayList();
	static public final ArrayList<String> list = new ArrayList();
	static public int campus = 0;
	public void onBackPressed() {
		super.onBackPressed();
		northBuildingArray.clear();
		centralBuildingArray.clear();
		southBuildingArray.clear();

	}

	public void noob() {

		final ListView listview = (ListView) findViewById(R.id.listview);
		String[] values = new String[] { "North Campus", "Central Campus",
				"South Campus" };
		
		

		for (int i = 0; i < values.length; i++) {
			list.add(values[i]);
		}
		final StableArrayAdapter adapter = new StableArrayAdapter(this,
				android.R.layout.simple_list_item_1, list);
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				campus = position;
				Intent buildings = new Intent(getApplicationContext(),
						ShowBuildings.class);
				startActivity(buildings);

			}
		});

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_campuses);
		Parse.initialize(this, "Pv4IBjwlV0eEHxDS75Db8fotj5OW0G1n0CNdQl0m",
				"4MHvP8hgIPIDgSvZBykiPOoQKMyQzWitrdb4RzAS");
		noob();

	}

	class StableArrayAdapter extends ArrayAdapter<String> {

		HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

		public StableArrayAdapter(Context context, int textViewResourceId,
				List<String> objects) {
			super(context, textViewResourceId, objects);
			for (int i = 0; i < objects.size(); ++i) {
				mIdMap.put(objects.get(i), i);
			}
		}
		
		 

		
		@Override
		public long getItemId(int position) {
			String item = getItem(position);
			return mIdMap.get(item);
		}

		@Override
		public boolean hasStableIds() {
			return true;
		}
		

}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpTo(this, new Intent(this, ShowCampuses.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
