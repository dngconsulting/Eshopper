package com.dngconsulting.demo.client.services;

import java.util.ArrayList;

import com.dngconsulting.demo.shared.BrandAndCategoryDTO;
import com.dngconsulting.demo.shared.ProductDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface ProductServiceAsync {
	
	void getProductDetail(String ref,AsyncCallback<ProductDTO> callback);

//	void storePanier(PanierDTO panier, AsyncCallback<Void> callback);
	void getAllProducts(AsyncCallback<ArrayList<ProductDTO>> callback);
	void getProductsALaUne(AsyncCallback<ArrayList<ProductDTO>> callback);
	void getProductsNouveaute(AsyncCallback<ArrayList<ProductDTO>> callback);
	void getBrandsAndCategories(AsyncCallback<BrandAndCategoryDTO> callback);
	void getProductsByCategory(String category, AsyncCallback<ArrayList<ProductDTO>> callback);
	void getProductsByBrands(String brand,AsyncCallback<ArrayList<ProductDTO>> callback);
}
