package com.example.criminalintent;

import java.util.Calendar;

import android.R;
import android.support.v4.app.DialogFragment;

public class DatePickerFragment extends DialogFragment 
{
	public static final String EXTRA_DATE =
			"com.example.criminalintent.date";
	 
	private Date mDate;
	
	public static DatePickerFragment newInstanceState(Date date) {
		Bundle args = new Bundle(); 
		args.putSerializable(EXTRA_DATE, date);
		
		DatePickerFragment fragment = new DatePickerFragment();
		fragment.setArguments(args);
		
		return fragment;
		
	private void sendResult(int resultCode) {
		if (getTargetFragment() == null)
			return;
		
		Intent i = new Intent();
		i.putExtra(EXTRA_DATE, mDate);
		
		getTargetFragment()
			.onActivityResult(getTargetRequestCode(), resultCode, i);
	}
	
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		mDate = (Date)getArguments().getSerializable(EXTRA_DATE);
		
		// Create a Calendar to get the year, month, and day
		Calendar calendar = Calender.getInstance();
		calendar.setTime(mDate);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar,get(Calendar.DAY_OF_MONTH);
		
		View v = getActivity().getLayoutInflater()
			.inflater(R.layout.dialog_date, null);
		
		DatePicker datePicker = (DatePicker)v.findViewById(R.id.dialog_date_datePicker);
		datePicker.init(year, month, day, new OnDateChangedListiner() {
			public void onDateChanged(DatePicker view, int month,int day) {
				// Translate year, month, day into a Date object using a calendar
				mDate = new GregorianCalander(year, month, day).getTime();
				
				// Update argument to preserve selected value on rotation
				getArguments().putSerializable(EXTRA_DATE, mDate);
			}
		});
		
		return new AlertDialog.Builder(getActivity())
			.setView(v)
			.setTitle(R.string.date_picker_title)
			.setPositiveButton(
					android.R.string.ok,
					new DialogInterface.OnClickListiner() {
						public void onClick(DialogInterface dialog,int which) {
							sendResult(Activity.RESULT_OK);
						}
					})
			.create();
	}
}