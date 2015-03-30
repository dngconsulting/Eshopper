package com.dngconsulting.demo.client.services;

import java.util.ArrayList;

import com.dngconsulting.demo.shared.BrandAndCategoryDTO;
import com.dngconsulting.demo.shared.ProductDTO;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("productservice")
public interface ProductService extends RemoteService {
    ProductDTO getProductDetail(String ref);
    ArrayList<ProductDTO> getAllProducts();
    ArrayList<ProductDTO> getProductsALaUne();
    ArrayList<ProductDTO> getProductsNouveaute();
    ArrayList<ProductDTO> getProductsByCategory(String category);
    ArrayList<ProductDTO> getProductsByBrands(String brand);
    BrandAndCategoryDTO getBrandsAndCategories();
	
//	void storePanier(PanierDTO panier);
}
