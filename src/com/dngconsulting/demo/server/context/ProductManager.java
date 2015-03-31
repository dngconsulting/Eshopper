package com.dngconsulting.demo.server.context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.dngconsulting.demo.server.EcomConfig;
import com.dngconsulting.demo.shared.BrandAndCategoryDTO;
import com.dngconsulting.demo.shared.ProductDTO;

public class ProductManager {

	private final static String SEP_CSV = ";";
	private final static String PHOTO_URL = "images/products/";

	private HashMap<String,ProductDTO> allProducts = new HashMap<String,ProductDTO>();
	private ArrayList<ProductDTO> newProducts = new ArrayList<ProductDTO>();
	private ArrayList<ProductDTO> aLaUneProducts = new ArrayList<ProductDTO>();
	private ArrayList<String> listBrands = new ArrayList<String>();
	private ArrayList<String> listCategories = new ArrayList<String>();
	private BrandAndCategoryDTO brandAndCat = new BrandAndCategoryDTO();

	private static ProductManager instance;

	ProductManager() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			File file = new File(EcomConfig.get().getDatabaseFilePath()+"/database.csv");
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			if(br.readLine()==null){//null means empty file - or skip header line (by reading line not null) ;)
				br.close();
				fr.close();
				return; 
			}
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				String[] data = line.split(SEP_CSV);
				if(data.length>=9){
					String ref = data[0];
					String name = data[1];
					String brand = data[2];
					String category = data[3];
					
					if(!listBrands.contains(brand)) listBrands.add(brand);
					if(!listCategories.contains(category)) listCategories.add(category);
					
					String description = data[4];
					String photoFile = PHOTO_URL+data[5];
					double price = Double.parseDouble(data[6]);
					boolean isALaUne = data[7].equals("1")?true:false;
					boolean isNew = data[8].equals("1")?true:false;
					ProductDTO p = new ProductDTO();
					p.setRef(ref);
					p.setName(name);
					p.setBrand(brand);
					p.setCategory(category);
					p.setDescription(description);
					p.setPhotoFile(photoFile);
					p.setPrice(price);
					p.setNew(isNew);
					allProducts.put(ref,p);
					if(isALaUne) aLaUneProducts.add(p);
					if(isNew) newProducts.add(p);
				}
			}
			
			brandAndCat.setListBrands(listBrands);
			brandAndCat.setListCategories(listCategories);
			
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ProductManager getInstance(){
		if(instance!=null) return instance;
		else throw new NullPointerException("ProductManager non encore initialisé...");
	}

	static void initProductManager(){
		instance = new ProductManager();
	}

	public ArrayList<ProductDTO> getAllProducts() {
		return new ArrayList<ProductDTO>(allProducts.values());
	}

	public ProductDTO getProductByRef(String ref){
		return allProducts.get(ref);
	}

	public ArrayList<ProductDTO> getNewProducts() {
		return newProducts;
	}


	public ArrayList<ProductDTO> getaLaUneProducts() {
		return aLaUneProducts;
	}

	public BrandAndCategoryDTO getBrandAndCategory(){
		return brandAndCat;
	}
	
}
