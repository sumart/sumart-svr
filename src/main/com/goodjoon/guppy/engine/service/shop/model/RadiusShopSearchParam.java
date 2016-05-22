package com.goodjoon.guppy.engine.service.shop.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.goodjoon.guppy.engine.common.model.BaseModel;

public class RadiusShopSearchParam extends BaseModel {
	protected double coordLat;
	protected double coordLong;
	
	protected int distance;
	@JsonInclude(Include.NON_NULL)
	protected String[] shopCategories;
	
	public double getCoordLat() {
		return coordLat;
	}
	public void setCoordLat(double coordLat) {
		this.coordLat = coordLat;
	}
	public double getCoordLong() {
		return coordLong;
	}
	public void setCoordLong(double coordLong) {
		this.coordLong = coordLong;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public String[] getShopCategories() {
		return shopCategories;
	}
	public void setShopCategories(String[] shopCategories) {
		this.shopCategories = shopCategories;
	}
}
