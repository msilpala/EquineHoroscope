package com.gdinwiddie.equinehoroscope.cache;

public interface HoroscopeCache {

	String horoscopeFor(String horsename, String effectiveDate) throws Exception;

	void putHoroscope(String horsename, String effectiveDate, String horoscope) throws Exception;

}