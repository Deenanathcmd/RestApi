package com.example.day5.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Hotel")
public class HotelModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int HotelId;
	@Column(name="HotelName")
	private String HotelName;
	private String Address;
	
	public int getHotelId() {
		return HotelId;
	}
	public void setHotelId(int HotelId) {
		this.HotelId=HotelId;
	}
	public String getHotelName() {
		return HotelName;
	}
	public void setHotelName(String HotelName) {
		this.HotelName=HotelName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String Address) {
		this.Address=Address;
	}
}
