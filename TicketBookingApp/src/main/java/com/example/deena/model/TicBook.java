package com.example.deena.model;

//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TicBook {
	
	@Id
	@Genera
	tedValue(strategy = GenerationType.IDENTITY)
	
	private int ticId;
	public int getTicId() {
		return ticId;
	}
	public void setTicId(int ticId) {
		this.ticId = ticId;
	}
	public int getTicPrice() {
		return ticPrice;
	}
	public void setTicPrice(int ticPrice) {
		this.ticPrice = ticPrice;
	}
	public String getTicName() {
		return ticName;
	}
	public void setTicName(String ticName) {
		this.ticName = ticName;
	}
	public int getTicQty() {
		return ticQty;
	}
	public void setTicQty(int ticQty) {
		this.ticQty = ticQty;
	}
	public String getTicCity() {
		return ticCity;
	}
	public void setTicCity(String ticCity) {
		this.ticCity = ticCity;
	}
	private int ticPrice;
	private String ticName;
	private int ticQty;
	private String ticCity;

	
	
	
	
	
}