package com.dngconsulting.demo.client.activity;

import java.util.ArrayList;

import com.dngconsulting.demo.client.AppContext;
import com.dngconsulting.demo.client.ClientFactory;
import com.dngconsulting.demo.client.places.AccueilPlace;
import com.dngconsulting.demo.client.services.AbstractAsyncCallback;
import com.dngconsulting.demo.client.services.ServiceLocator;
import com.dngconsulting.demo.shared.ProductDTO;

public class AccueilActivity extends AbstractListItemsActivity  {

	public AccueilActivity(AccueilPlace place, ClientFactory clientFactory) {
		super(place, clientFactory);
	}

	@Override
	protected void fetchAndDisplayProducts() {
		view.resetListItems();
		ServiceLocator.getProductService().getProductsALaUne(new AbstractAsyncCallback<ArrayList<ProductDTO>>() {

			@Override
			public void success(ArrayList<ProductDTO> list) {
				updateViewWithFetchedData(list);
			}
		});
	}

	@Override
	protected void initViewInstance() {
		view = clientFactory.getAccueilView();
	}

	@Override
	protected void gaTrackLog() {
//		AppContext.trackUniversalPageview(AppContext.getGa(),"#!accueil:","Page d'accueil");
		AppContext.getGa().trackUniversalPageview("#!accueil:","Page d'accueil");
	}
}
