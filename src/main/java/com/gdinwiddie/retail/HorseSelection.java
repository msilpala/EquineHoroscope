package com.gdinwiddie.retail;

public class HorseSelection {

	private final String horseName;
	private final String effectiveDate;

	public HorseSelection(String horseName, String effectiveDate) {
		this.horseName = horseName;
		this.effectiveDate = effectiveDate;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public String getHorseName() {
		return horseName;
	}

}
