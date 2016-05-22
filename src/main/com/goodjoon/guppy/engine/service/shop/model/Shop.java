package com.goodjoon.guppy.engine.service.shop.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.goodjoon.guppy.engine.common.model.BaseModel;

@JsonInclude(Include.NON_NULL)
public class Shop extends BaseModel{
	protected String userId;
	protected String id;
	protected String name;
	protected String[] phones;
	protected String[] phoneNames;
	protected String address;
	protected String[] categoryCodes;
	protected String businessDayComment;
	protected String[] businessHours;
	protected String shortComment;
	protected String[] keywords;
	protected double coordLat;
	protected double coordLong;
	protected boolean hasImages;
	protected String[] images;
	
	public String[] getImages() {
		return images;
	}
	
	public void setImages(String[] images) {
		this.images = images;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getPhones() {
		return phones;
	}
	public void setPhones(String[] phones) {
		this.phones = phones;
	}
	public String[] getPhoneNames() {
		return phoneNames;
	}
	public void setPhoneNames(String[] phoneNames) {
		this.phoneNames = phoneNames;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String[] getCategoryCodes() {
		return categoryCodes;
	}
	public void setCategoryCodes(String[] categoryCodes) {
		this.categoryCodes = categoryCodes;
	}
	public String getBusinessDayComment() {
		return businessDayComment;
	}
	public void setBusinessDayComment(String businessDaycomment) {
		this.businessDayComment = businessDaycomment;
	}
	public String[] getBusinessHours() {
		return businessHours;
	}
	public void setBusinessHours(String[] businessHours) {
		this.businessHours = businessHours;
	}
	public String getShortComment() {
		return shortComment;
	}
	public void setShortComment(String shortComment) {
		this.shortComment = shortComment;
	}
	public String[] getKeywords() {
		return keywords;
	}
	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}
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
	public boolean isHasImages() {
		return hasImages;
	}
	public void setHasImages(boolean hasImages) {
		this.hasImages = hasImages;
	}
	
}
