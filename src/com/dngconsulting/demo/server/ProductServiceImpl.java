package com.dngconsulting.demo.server;

import java.util.ArrayList;

import com.dngconsulting.demo.client.services.ProductService;
import com.dngconsulting.demo.server.context.ProductManager;
import com.dngconsulting.demo.shared.BrandAndCategoryDTO;
import com.dngconsulting.demo.shared.ProductDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class ProductServiceImpl extends RemoteServiceServlet implements ProductService {

	@Override
	public ProductDTO getProductDetail(String ref) {
		return ProductManager.getInstance().getProductByRef(ref);
	}

	@Override
	public ArrayList<ProductDTO> getProductsALaUne() {
		return ProductManager.getInstance().getaLaUneProducts();
	}

	@Override
	public ArrayList<ProductDTO> getAllProducts() {
		return ProductManager.getInstance().getAllProducts();
	}

	@Override
	public ArrayList<ProductDTO> getProductsNouveaute() {
		return ProductManager.getInstance().getNewProducts();
	}

	@Override
	public BrandAndCategoryDTO getBrandsAndCategories() {
		return ProductManager.getInstance().getBrandAndCategory();
	}

	@Override
	public ArrayList<ProductDTO> getProductsByCategory(String category) {
		ArrayList<ProductDTO> all = ProductManager.getInstance().getAllProducts();
		ArrayList<ProductDTO> result = new ArrayList<ProductDTO>();
		all.forEach(p ->{
			if(p.getCategory().equalsIgnoreCase(category)){
				result.add(p);
			}
		});
		return result;
	}

	@Override
	public ArrayList<ProductDTO> getProductsByBrands(String brand) {
		ArrayList<ProductDTO> all = ProductManager.getInstance().getAllProducts();
		ArrayList<ProductDTO> result = new ArrayList<ProductDTO>();
		all.forEach(p ->{
			if(p.getBrand().equalsIgnoreCase(brand)){
				result.add(p);
			}
		});
		return result;
	}

	
}
