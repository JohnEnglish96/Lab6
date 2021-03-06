package com.example.criminalintent;

import android.R;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;

public class CrimeActivity extends SingleFragmentActivity1 {
	Fragment createFragment() {
		
		
		UUID crimeId = (UUID)getIntent()
			 .getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
		
		return CrimeFragment.newInstance(crimeId);
	}
}
