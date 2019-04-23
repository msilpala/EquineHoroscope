package com.gdinwiddie.equinehoroscope;

import com.gdinwiddie.equinehoroscope.cache.derby.DerbyHoroscopeCache;
import com.gdinwiddie.equinehoroscope.mumbler.MumblerAdapter;

public class CrystalBall {

	private final HoroscopeProvider horoscopeProvider;

	CrystalBall(HoroscopeProvider horoscopeProvider) {
		this.horoscopeProvider = horoscopeProvider;
	}

	private CrystalBall() {
		this(new CachingHoroscopeProvider(MumblerAdapter.instance(), DerbyHoroscopeCache.instance()));
	}

	public static CrystalBall instance() {
		return new CrystalBall();
	}

	public String fetchHoroscope(String horse, String effectiveDate) {
		return horoscopeProvider.horoscopeFor(horse, effectiveDate);
	}

}
