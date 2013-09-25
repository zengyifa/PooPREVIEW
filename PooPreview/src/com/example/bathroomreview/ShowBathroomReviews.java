package com.example.bathroomreview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class ShowBathroomReviews extends Activity {

	private LocationManager locationManager;
	private String provider;

	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_reviews);
		initializeView();
	}

	public void initializeView() {
		TextView review1 = (TextView) findViewById(R.id.review1);
		TextView review2 = (TextView) findViewById(R.id.review2);
		TextView review3 = (TextView) findViewById(R.id.review3);
		List<ParseObject> reviewsList = new ArrayList<ParseObject>();

		ParseQuery<ParseObject> query = ParseQuery.getQuery("BathroomReview");
		query.whereEqualTo("Building",
				getIntent().getExtras().getString("Building").toString());
		query.setLimit(3);
		query.orderByDescending("createdAt");
		try {
			reviewsList = query.find();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ParseObject obj1;
		ParseObject obj2;
		ParseObject obj3;
		switch (reviewsList.size()) {
		case 0:
			review1.setText("no reviews will ever be available");
			break;
		case 1:
			obj1 = reviewsList.get(0);
			break;
		case 2:
			obj1 = reviewsList.get(0);
			review1.setText(obj1.get("Review").toString());
			obj2 = reviewsList.get(1);
			review2.setText(obj2.get("Review").toString());
			break;
		case 3:
			obj1 = reviewsList.get(0);
			review1.setText(obj1.get("Review").toString());
			obj2 = reviewsList.get(1);
			review2.setText(obj2.get("Review").toString());
			obj3 = reviewsList.get(2);
			review3.setText(obj3.get("Review").toString());
			break;
		}
		review1.bringToFront();
		review2.bringToFront();
		review3.bringToFront();
	}

	public void submitReview(View view) {
		// onClick method
		TextView view1 = (TextView) findViewById(R.id.editText1);

		CharSequence sequence = view1.getText();
		String value = sequence.toString();
		String title = getIntent().getExtras().getString("Building").toString();
		RatingBar bar = (RatingBar) findViewById(R.id.ratingBar1);
		float rating = bar.getRating();
		ParseObject reviewObject = new ParseObject("BathroomReview");
		reviewObject.put("Building", title);
		reviewObject.put("Review", value);
		reviewObject.put("Rating", rating);
		try {
			reviewObject.save();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		view1.setText("");

	}

	/* Request updates at startup */
	@Override
	protected void onResume() {
		super.onResume();

	}

	/* Remove the locationlistener updates when Activity is paused */
	@Override
	protected void onPause() {
		super.onPause();

	}

}