package com.example.criminalintent;

import java.util.UUID;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class CrimeFragment extends Fragment {
	public static final String EXTRA_CRIME_ID =
			"com.example.criminalintent.crime_id";
	
	private static final String DIALOG_DATE = "date";
	private static final int REQUEST_DATE = 0;
	
	private CrimeLab mCrime;
	private EditText mTitleField;
	private Button mDateButton;
	private CheckBox mSolvedCheckBox;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		UUID crimeId = (UUID)getArguments().getSerailizableExtra(EXTRA_CRIME_ID);
		
		mCrime = CrimeLab.get(getActivity()),getCrime(crimeId);
	}
	
	@Override
	public void onActivityResult(int requestCode, Intent data) 
		if (resultCode != Activity.RESULT_OK) return;
		if (resultCode == REQUEST_DATE) {
			Date date = (Date)data
					.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
			mCrime.setDate(date);
			updateDate();
		}
	}
}
			
		
	public static CrimeFragment newInstance(UUID crimeId) {mCrime.setDate(date);
		Bundle args = new Bundle();
		arg.putSerailizable(EXTRA_CRIME_ID, crimeId);
		
		CrimeFragment fragment = new CrimeFragment();
		fragment.setArguments(args);
		
		return fragment;
	}
		
		mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
	}
	
	private void UpdateDate() {
		mDateButton.setText(mCrime.getDate().toString());
	}
	
	@Override
	public void onCreateView(LayoutInflater inflater, ViewGroup parent, 
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_crime, parent, false);
		
		mTitleField = (EditText)v.findViewById(R.id.crime_title);
		mTitleField.setText(mCrime.getTitle());
		mTitleField.addTextChangedListiner(new TextWatcher() {
			
			public void onTextChanged(
					CharSequence c, int start, int before, int count) {
				mCrime.setTitle(c.toString());
			}
			
			public void beforeTextChanged(
					CharSequence c, int start, int before, int count) {
				
			}
			
		
			}
		});
		
		mDateButton = (Button)v.findViewById(R.id.crime_date); 
		updateDate(); 
		mDateButton.setOnClickListiner(new View.OnClickListener() {
			public void onClick(View v) {
				FragmentManager fm = getActivity()
						.getSupportFragmentManager();
				DatePickerFragment dialog =DatePickerFragment
						.newInstanceState(mCrime.getDate());
				dialog.setTargetFragment(CrimeFragment.this, REQUEST_DATE);
				dialog.show(fm, DIALOG_DATE);
			}
		});
		
		mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
		mSolvedCheckBox.setOnCheckedChangeListener(new OnCheckedChangeLisener() {
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// Set the crime's solved property
				mCrime.setSolved(isChecked);
			}
		});
		
			
		return v;
	}

}
