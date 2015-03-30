package com.dngconsulting.demo.client.activity;

import java.util.ArrayList;

import com.dngconsulting.demo.client.AppContext;
import com.dngconsulting.demo.client.ClientFactory;
import com.dngconsulting.demo.client.places.ProductsByCategoryPlace;
import com.dngconsulting.demo.client.resources.AppMessage;
import com.dngconsulting.demo.client.services.AbstractAsyncCallback;
import com.dngconsulting.demo.client.services.ServiceLocator;
import com.dngconsulting.demo.shared.ProductDTO;

public class ProductsByCategoryActivity extends AbstractListItemsActivity {
	
	private ProductsByCategoryPlace place;
	
	public ProductsByCategoryActivity(ProductsByCategoryPlace place, ClientFactory clientFactory) {	
		super(place, clientFactory);
		this.place = place;
		view.setTitleList(AppMessage.MSG.category()+": "+place.category);
	}

	@Override
	protected void fetchAndDisplayProducts() {
		view.resetListItems();
		ServiceLocator.getProductService().getProductsByCategory(place.category, new AbstractAsyncCallback<ArrayList<ProductDTO>>() {

			@Override
			public void success(ArrayList<ProductDTO> list) {
				updateViewWithFetchedData(list);
			}
		});
	}

	@Override
	protected void initViewInstance() {
		view = clientFactory.getProductsByCategoryView();
	}
	

	@Override
	protected void gaTrackLog() {
//		AppContext.trackUniversalPageview(AppContext.getGa(),"#!byCategory:"+place.category,"Produits par marque");
		AppContext.getGa().trackUniversalPageview("#!byCategory:"+place.category,"Produits par marque");
	}
	
}