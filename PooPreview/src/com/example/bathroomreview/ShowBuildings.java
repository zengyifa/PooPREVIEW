package com.example.bathroomreview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ShowBuildings extends Activity {
	ArrayList<String> buildingArray = new ArrayList<String>();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_buildings);

		final ListView listview = (ListView) findViewById(R.id.listview);
		final String[] northArray = { "Art & Architecture Building",
				"Walter E. Lay Automotive Lab",
				" 	Blanch Anderson Moore Hall, School of Music",
				"Bob and Betty Beyster Building", "Bursley Hall",
				"Chrysler Center", "Cooley Building", "Duderstadt Center",
				"Dow Engineering Building",
				"Electrical Engineering and Computer Science Building",
				"Engineering Research Building 1 ",
				"Engineering Research Building 2",
				"Environmental & Water Resources Engineering Building",
				"Ford Library", "Francois-Xavier Bagnoud Building",
				" 	Gorguze Family Laboratory", "G. G. Brown Laboratory",
				" 	Industrial and Operations Engineering Building",
				"Lurie Biomedical Engineering Building",
				" 	Lurie Engineering Center",
				"Naval Architecture and Marine Engineering Building",
				"North Campus Recreation Building",
				"Phoenix Memorial Laboratory", "Pierpont Commons",
				"Earl V. Moore Building, School of Music",
				"Space Research Building", "Stamps Auditorium",
				"Sterns Building", "Charles R. Walgreen, Jr. Drama Center" };
		final String[] centralArray = { "Angell Hall", "Public Policy Annex",
				"Burton Memorial Tower", "Clarence Cook Little Building",
				"Chemistry Building", "Dana Building",
				"David M. Dennison Building", "Dental Building",
				"Executive Education", "East Hall", "East Quadrangle",
				"Harlan Hatcher Graduate Library", "Haven Hall",
				"Hutchins Hall", "Institute for Social Research",
				"Kresge Library", "Kelsey Museum of Archaeology", "Lane Hall",
				"Michigan League", "Law Library", "Lorch Hall",
				" 	Literature, Science, and the Arts Building",
				"Life Sciences Institute", "Law School South Hall",
				"Mason Hall", "Modern Languages Building", "North Hall",
				"North Quad", "Edward Henry Kraus Natural Science Building",
				"Palmer Commons", "Power Center for the Performing Arts",
				"Horace H. Rackham, School of Graduate Studies",
				" 	Randall Laboratory", "Ross School of Business Building",
				"A. G. Ruthven Museums Building (Natural History Museum)",
				"School of Education Building",
				"Shapiro Undergraduate Library",
				"School of Social Work Building", "202 South Thayer Building",
				"Tappan Hall", "Tisch Hall", "Tyler East Quadrangle",
				"University of Michigan Museum of Art", "Michigan Union",
				"Undergraduate Science Building",
				"University Towers, 1225 S. University", "Wyly Hall",
				"Weill Hall", "West Hall" };
		final String[] southArray = { "Crisler Arena",
				"Campus Safety Services Building", "Intramural Building",
				"William D. Revelli Hall", "Stephen M. Ross Academic Center",
				"Glenn E. Schembechler Hall" };
		if (ShowCampuses.list.get(ShowCampuses.campus).equals("North Campus")) {
			for (int i = 0; i < northArray.length; i++) {
				buildingArray.add(northArray[i]);
			}
		} else if (ShowCampuses.list.get(ShowCampuses.campus).equals("Central Campus")) {
			for (int i = 0; i < centralArray.length; i++) {
				buildingArray.add(centralArray[i]);
			}
		} else if (ShowCampuses.list.get(ShowCampuses.campus).equals("South Campus")) {
			for (int i = 0; i < southArray.length; i++) {
				buildingArray.add(southArray[i]);
			}
		}

		final StableArrayAdapter adapter = new StableArrayAdapter(this,
				android.R.layout.simple_list_item_1, buildingArray);

		listview.setAdapter(adapter);

		listview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent i = new Intent(getApplicationContext(),
						ShowBathroomReviews.class);
				i.putExtra("Building", buildingArray.get(position));
				startActivity(i);
			}
		});

	}
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
