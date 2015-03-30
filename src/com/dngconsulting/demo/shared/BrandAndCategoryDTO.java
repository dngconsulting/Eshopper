package com.dngconsulting.demo.shared;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class BrandAndCategoryDTO implements Serializable {
	private ArrayList<String> listBrands;
	private ArrayList<String> listCategories;
	
	public ArrayList<String> getListBrands() {
		return listBrands;
	}
	public void setListBrands(ArrayList<String> listBrands) {
		this.listBrands = listBrands;
	}
	public ArrayList<String> getListCategories() {
		return listCategories;
	}
	public void setListCategories(ArrayList<String> listCategories) {
		this.listCategories = listCategories;
	}
	

}
