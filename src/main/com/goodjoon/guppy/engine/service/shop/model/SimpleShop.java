package com.goodjoon.guppy.engine.service.shop.model;

import com.goodjoon.guppy.engine.common.model.BaseModel;

public class SimpleShop extends BaseModel {
	protected String name;
	protected Double coordLat;
	protected Double coordLong;
	protected String phone;
	protected String category;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getCoordLat() {
		return coordLat;
	}
	public void setCoordLat(Double coordLat) {
		this.coordLat = coordLat;
	}
	public Double getCoordLong() {
		return coordLong;
	}
	public void setCoordLong(Double coordLong) {
		this.coordLong = coordLong;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
