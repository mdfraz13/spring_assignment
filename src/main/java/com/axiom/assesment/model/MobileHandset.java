package com.axiom.assesment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MobileHandset {

	private long id;
	private String brand;
	private String phone;
	private String picture;
	private Release release;
	private String sim;
	private String resolution;
	private Hardware hardware;

	public MobileHandset() {}

	public MobileHandset(long id,
						 String brand,
						 String phone,
						 String picture,
						 Release release,
						 String sim,
						 String resolution, Hardware hardware) {
		this.id = id;
		this.brand = brand;
		this.phone = phone;
		this.picture = picture;
		this.release = release;
		this.sim = sim;
		this.resolution = resolution;
		this.hardware = hardware;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Release getRelease() {
		return release;
	}

	public void setRelease(Release release) {
		this.release = release;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public Hardware getHardware() {
		return hardware;
	}

	public void setHardware(Hardware hardware) {
		this.hardware = hardware;
	}

	@Override
	public String toString() {
		return "MobileHandset {" +
			   "id=" + id +
			   ", brand='" + brand + '\'' +
			   ", phone='" + phone + '\'' +
			   ", picture='" + picture + '\'' +
			   ", release=" + release +
			   ", sim='" + sim + '\'' +
			   ", resolution='" + resolution + '\'' +
			   ", hardware=" + hardware +
			   '}';
	}
}
