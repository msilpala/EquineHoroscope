package com.gdinwiddie.equinehoroscope;

import java.util.ArrayList;
import java.util.List;

public class FakeHoroscopeProvider implements HoroscopeProvider {
	private final List<String> horoscopeList = new ArrayList<>();

	void addHoroscope(String horoscope) {
		horoscopeList.add(horoscope);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gdinwiddie.equinehoroscope.HoroscopeProvider#horoscopeFor(java.
	 * lang.String, java.lang.String)
	 */
	@Override
	public String horoscopeFor(String horse, String date) {
		return horoscopeList.remove(0);
	}
}