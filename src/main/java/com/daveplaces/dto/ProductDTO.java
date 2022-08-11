package com.daveplaces.dto;

public class ProductDTO {
	
	private double price;
	private String name;
	private String category;
	private int weight;
	private String note;
	private long barcode;
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getNote() {
		return note;
	}
	
	/**
	 * describe the product
	 * @param note
	 */
	public void setNote(String note) {
		this.note = note;
	}

	public void setProductID(long barcode) {
		this.barcode = barcode;
		
	}
	

}
