package com.example.criminalintent;

import java.util.UUID;

public class Crime {
	private UUID mID;
	private String mTitle;
	private Date mDate;
	private boolean mSolved
	
	public Crime() {
		mID = UUID.randomUUID();
		mDate = new Date();
	}
	
	@Override
	public String toString() {
		return mTitle;
	}
	
	public UUID getmID() {
		return mID;
	}


	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String Title) {
		mTitle = title;
	}
	
	public Date getDate() {
		return mDate;
	}

	public void setDate(Date date) {
		mDate = date;
	}

	public boolean isSolved() {
		return mSolved;
	}

	public void setSolved(boolean solved) {
		mSolved = solved;
	}

	
}
