package com.gdinwiddie.equinehoroscope.acceptance;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

import java.util.HashSet;
import java.util.Set;

import com.gdinwiddie.equinehoroscope.CrystalBall;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CrystalBallStepDefinitions {

	private CrystalBall crystalBall;
	private HoroscopeCollector horoscopes;

	@Before
	public void setup() {
		this.crystalBall = CrystalBall.instance();
		this.horoscopes = HoroscopeCollector.instance();
	}

	@When("^we request an arbitrary horoscope$")
	public void we_request_an_arbitrary_horoscope() {
		String horse = "Horse's Name";
		String effectiveDate = "Next Wednesday";
		horoscopes.add(crystalBall.fetchHoroscope(horse, effectiveDate));
	}

	@Then("^the horoscope should not be empty$")
	public void the_horoscope_should_not_be_empty() {
		assertThat(horoscopes.get(0), not(isEmptyOrNullString()));
	}

	@When("^we request a horoscope for \"([^\"]*)\" for \"([^\"]*)\"$")
	public void we_request_a_horoscope_for_for(String horse, String effectiveDate) {
		horoscopes.add(crystalBall.fetchHoroscope(horse, effectiveDate));
	}

	@Then("^the horoscopes should be different$")
	public void the_horoscopes_should_be_different() {
		Set<String> horoscopeSet = new HashSet<>(horoscopes);
		assertThat(horoscopeSet.size(), equalTo(horoscopes.size()));
	}

	@Then("^the horoscopes should be the same$")
	public void the_horoscopes_should_be_the_same() {
		Set<String> horoscopeSet = new HashSet<>(horoscopes);
		assertThat(horoscopeSet.size(), equalTo(1));
	}

}
