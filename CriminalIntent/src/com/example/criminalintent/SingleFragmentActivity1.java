package com.example.criminalintent;

import android.R;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;


public abstract class SingleFragmentActivity1 extends FragmentActivity {
	protected abstract Fragment createFragment();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment);
		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
		
		if (fragment == null) {
			fragment = createFragment();
			fm.beginTransaction()
			.add(R.id.addToDictionary, fragment)
			.commit();
		}
	}
}