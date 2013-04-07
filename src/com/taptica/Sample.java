package com.taptica;

import java.util.GregorianCalendar;

import com.Taptica.AdCore.TapticaAdManager;
import com.Taptica.AdCore.TapticaAdView;
import com.Taptica.AdCore.TapticaAdManager.Education;
import com.Taptica.AdCore.TapticaAdManager.Gender;
import com.Taptica.AdCore.TapticaAdManager.MaritalStatus;
import com.taptica.sample.R;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;



public class Sample extends Activity
{
	TapticaAdView			adView;
	// parameters for sending to AdyxSdk (written values are only the initial values):
	private String		applicationId		= "d1b1de27-50f5-40a6-ace3-e35dcf2b65ad";
	
	
	private String		keywords			= "android cellphones";
	private String		interests			= "cars,sports,F1,stocks";
	private String		ethnicity			= "Jewish";
	// input views:
	
	

	public void prepareAd(TapticaAdView adView)
	{
		// getting most updated settings from the views:
//		enableTestMode = checkBoxTestmode.isChecked();
//		keywords = editTextKeywords.getText().toString();
//		applicationId = (String)spinnerApplicationId.getSelectedItem();
//		interests = editTextInterests.getText().toString();
//		ethnicity = editTextEthnicity.getText().toString();
		// must have clues:
		TapticaAdManager.settapticaAdApplicationId(this,applicationId);
		// optional clues:
		adView.settapticaAdUserKeywords(keywords);
		Location location = new Location("");
		location.setLatitude(32);
		location.setLongitude(34);
		TapticaAdManager.settapticaAdGeoLocation(location);
//		//tapticaAdManager.setTestMode(enableTestMode);
		TapticaAdManager.settapticaAdUserBirthdate(new GregorianCalendar(2012, 2, 1));
		TapticaAdManager.settapticaAdUserEducation(Education.PG);
		TapticaAdManager.settapticaAdUserEthnicity(ethnicity);
		TapticaAdManager.settapticaAdUserGender(Gender.MALE);
		TapticaAdManager.settapticaAdUserInterests(interests);
		TapticaAdManager.settapticaAdUserMaritalStatus(MaritalStatus.SINGLE);
	}

	private void prepareViews()
	{
//		editTextEthnicity = (EditText) findViewById(R.id.edittext_ethnicity);
//		editTextEthnicity.setText(ethnicity);
//		checkBoxTestmode = (CheckBox) findViewById(R.id.checkbox_testmode);
//		checkBoxTestmode.setChecked(enableTestMode);
//		editTextKeywords = (EditText) findViewById(R.id.edittext_keywords);
//		editTextKeywords.setText(keywords);
//		spinnerApplicationId = (Spinner)findViewById(R.id.spinnerApplicationId);
//		
//		
//		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.GIUDS,android.R.layout.simple_spinner_item);
//		adapter.setDropDownViewResource(R.layout.spinner_item);
//		spinnerApplicationId.setAdapter(adapter);
//		editTextInterests = (EditText) findViewById(R.id.edittext_interests);
//		editTextInterests.setText(interests);

		
		adView = new TapticaAdView(this);
		FrameLayout adviewContainer = (FrameLayout) findViewById(R.id.adview_container);
		adView.setGravity(Gravity.CENTER_HORIZONTAL);
		adviewContainer.addView(adView);
		
		Button buttonRequestNewAd = (Button) findViewById(R.id.button_request_new_ad);
		buttonRequestNewAd.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				prepareAd(adView);
				adView.requestAd();
			}
		});
		
		

		
		
		Button buttonRequestNewFullScreenAd = (Button) findViewById(R.id.fullScreenButton);
		buttonRequestNewFullScreenAd.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				adView.requestFullScreenAd();
			}
		});


		
		
		
//		Button buttonRequestOfferWallAd = (Button) findViewById(R.id.offerWallButton);
//		buttonRequestOfferWallAd.setOnClickListener(new View.OnClickListener()
//		{
//			@Override
//			public void onClick(View v)
//			{
//				prepareAd(adView);
//				adView.requestOfferWallAd();
//			}
//		});

		
		
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		prepareViews();
		prepareAd(adView);
	}
}
