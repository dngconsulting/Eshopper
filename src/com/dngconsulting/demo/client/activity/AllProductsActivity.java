package com.dngconsulting.demo.client.activity;

import java.util.ArrayList;

import com.dngconsulting.demo.client.AppContext;
import com.dngconsulting.demo.client.ClientFactory;
import com.dngconsulting.demo.client.places.AllProductsPlace;
import com.dngconsulting.demo.client.services.AbstractAsyncCallback;
import com.dngconsulting.demo.client.services.ServiceLocator;
import com.dngconsulting.demo.shared.ProductDTO;

public class AllProductsActivity extends AbstractListItemsActivity {
	
	public AllProductsActivity(AllProductsPlace place, ClientFactory clientFactory) {	
		super(place, clientFactory);
	}

	@Override
	protected void fetchAndDisplayProducts() {
		view.resetListItems();
		ServiceLocator.getProductService().getAllProducts(new AbstractAsyncCallback<ArrayList<ProductDTO>>() {

			@Override
			public void success(ArrayList<ProductDTO> list) {
				updateViewWithFetchedData(list);
			}
		});
	}

	@Override
	protected void initViewInstance() {
		view = clientFactory.getAllProductsView();
	}

	@Override
	protected void gaTrackLog() {
//		AppContext.trackUniversalPageview(AppContext.getGa(),"#!all:","Tous les produits");
		AppContext.getGa().trackUniversalPageview("#!all:","Tous les produits");
	}
}
