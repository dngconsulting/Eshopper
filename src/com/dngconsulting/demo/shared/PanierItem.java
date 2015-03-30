package com.dngconsulting.demo.shared;

public interface PanierItem {

	double getPrice();

	void setPrice(double price);

	String getRef();

	void setRef(String ref);

	String getName();

	void setName(String name);

	String getPhotoFile();

	void setPhotoFile(String photoFile);

	int getQuantity();

	void setQuantity(int quantity);

}
