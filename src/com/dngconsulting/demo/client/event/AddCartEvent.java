package com.dngconsulting.demo.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class AddCartEvent extends GwtEvent<AddCartHandlers> {
	
	public static Type<AddCartHandlers> TYPE = new Type<AddCartHandlers>();
	
	private String refProduct;
	private String photoFile;
	private String name;
	private double price;
	private int quantity;
	
	public AddCartEvent() {}
	
	

	public AddCartEvent(String refProduct, String photoFile, String name,double price, int quantity) {
		this.refProduct = refProduct;
		this.photoFile = photoFile;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}



	@Override
	public Type<AddCartHandlers> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(AddCartHandlers handler) {
		handler.onAddedToCart(this);
	}

	public String getRefProduct() {
		return refProduct;
	}

	public void setRefProduct(String refProduct) {
		this.refProduct = refProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(String photoFile) {
		this.photoFile = photoFile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


}
