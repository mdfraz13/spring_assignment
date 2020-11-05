package com.axiom.assesment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Release {

	private String announceDate;
	private String priceEur;

	public Release() { }

	public Release(String announceDate, String priceEur) {
		this.announceDate = announceDate;
		this.priceEur = priceEur;
	}

	public String getAnnounceDate() {
		return announceDate;
	}

	public void setAnnounceDate(String announceDate) {
		this.announceDate = announceDate;
	}

	public String getPriceEur() {
		return priceEur;
	}

	public void setPriceEur(String priceEur) {
		this.priceEur = priceEur;
	}

	@Override
	public String toString() {
		return "Release{" +
			   "announceDate='" + announceDate + '\'' +
			   ", priceEur='" + priceEur + '\'' +
			   '}';
	}
}
