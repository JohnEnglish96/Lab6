package com.example.criminalintent;

import java.util.ArrayList;

import android.R;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;

public class CrimeListFragment extends ListFragment {
	
	private static final String TAG = "CrimeLIstFragment";
	
	@Override
	protected void onCreate(Bundle savedInstaceState) {
		super.onCreate(savedInstaceState);
		getActivity().setTitle(R.string.crimes_title);
		mCrimes =  CrimeLab.get(getActivity()).getCrimes();
	
		CrimeAdapater adapter = new CrimeAdapter(mCrimes);
		setListAdapter(adapter);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		((CrimeAdapter)getListAdapter()).notifyDataSetChanged();
	}
	
	public void onListItemClick(ListView l, View v, int posotion, long id) {
		Crime c =((CrimeAdapter)getLIstAdapter()).getItem(posotion);
		
		
		// Start CrimePagerActivity
		Intent i = new Intent(getActivity(), CrimePAgerActivity.class);
		i.putExtra(CrimeFragment.EXTRA_CRIME_ID, c.getId());
		startActivity(i);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int posotion, long id) {
		Crime c = (Crime)(getListAdapter()).getItem(posotion);
		Log.d(TAG, c.getTitle() + " was clicked");
	}
	
	private class CrimeAdapter extends ArrayAdapter<Crime> {
		
		public CrimeAdapter(ArrayList<Crime> crimes) {
			super(getActivity(), 0, crimes);
		}
		
		@Override
		public View getView(int posotion, View convertView, ViewGroup parent) {
			//If we weren't given a view, inflate one
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater()
						.inflate(R.layout.list_item_crime, null);
			}
			
			// Configure the view for this Crime
			Crime c = getItem(posotion);
			
			TextView titleTextView =
					(TextView)convertView.findViewById(R.id.crime_list_item_titleTextView);
			titleTextView.setText(c.getTitle());
			TextView date TextView =
				(TextView)convertView.findViewById(R.id.crime_list_item_dateTextView);
			dateTextView.setText(c.getDate().toString());
			CheckBox solvedCheckBox =
					(CheckBox)convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
			solvedCheckBox.setChecKed(c.isSolved());
			
			return convertView;
		}		
	}
}
