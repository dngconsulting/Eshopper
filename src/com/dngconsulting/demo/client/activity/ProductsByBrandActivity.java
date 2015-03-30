package com.dngconsulting.demo.client.activity;

import java.util.ArrayList;

import com.dngconsulting.demo.client.AppContext;
import com.dngconsulting.demo.client.ClientFactory;
import com.dngconsulting.demo.client.places.ProductsByBrandPlace;
import com.dngconsulting.demo.client.services.AbstractAsyncCallback;
import com.dngconsulting.demo.client.services.ServiceLocator;
import com.dngconsulting.demo.shared.ProductDTO;

public class ProductsByBrandActivity extends AbstractListItemsActivity {
	
	private ProductsByBrandPlace place;
	
	public ProductsByBrandActivity(ProductsByBrandPlace place, ClientFactory clientFactory) {	
		super(place, clientFactory);
		this.place = place;
		view.setTitleList(place.brand);
	}

	@Override
	protected void fetchAndDisplayProducts() {
		view.resetListItems();
		ServiceLocator.getProductService().getProductsByBrands(place.brand, new AbstractAsyncCallback<ArrayList<ProductDTO>>() {

			@Override
			public void success(ArrayList<ProductDTO> list) {
				updateViewWithFetchedData(list);
			}
		});
	}

	@Override
	protected void initViewInstance() {
		view = clientFactory.getProductsByBrandView();
	}

	@Override
	protected void gaTrackLog() {
//		AppContext.trackUniversalPageview(AppContext.getGa(),"#!byBrand:"+place.brand,"Produits par marque");
		AppContext.getGa().trackUniversalPageview("#!byBrand:"+place.brand,"Produits par marque");
	}
	
}