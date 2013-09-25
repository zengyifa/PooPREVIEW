package com.example.bathroomreview;



import android.app.Activity;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;

public class ShowLocationActivity extends Activity {
 
  private LocationManager locationManager;
  private String provider;

  
/** Called when the activity is first created. */

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_item_reviews);
    
  }
  public void submitReview(View view)
  {
	  //onClick method
	 
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