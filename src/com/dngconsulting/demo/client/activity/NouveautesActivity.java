package com.dngconsulting.demo.client.activity;

import java.util.ArrayList;

import com.dngconsulting.demo.client.AppContext;
import com.dngconsulting.demo.client.ClientFactory;
import com.dngconsulting.demo.client.places.NouveautesPlace;
import com.dngconsulting.demo.client.services.AbstractAsyncCallback;
import com.dngconsulting.demo.client.services.ServiceLocator;
import com.dngconsulting.demo.shared.ProductDTO;

public class NouveautesActivity extends AbstractListItemsActivity {
	
	public NouveautesActivity(NouveautesPlace place, ClientFactory clientFactory) {	
		super(place, clientFactory);
	}

	@Override
	protected void fetchAndDisplayProducts() {
		view.resetListItems();
		ServiceLocator.getProductService().getProductsNouveaute(new AbstractAsyncCallback<ArrayList<ProductDTO>>() {

			@Override
			public void success(ArrayList<ProductDTO> list) {
				updateViewWithFetchedData(list);
			}
		});
	}

	@Override
	protected void initViewInstance() {
		view = clientFactory.getNouveautesView();
	}

	@Override
	protected void gaTrackLog() {

//		AppContext.trackUniversalPageview(AppContext.getGa(),"#!nouveautes:","Liste nouveaux produits");
		AppContext.getGa().trackUniversalPageview("#!nouveautes:","Liste nouveaux produits");
	}
	
}