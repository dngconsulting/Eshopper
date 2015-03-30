package com.dngconsulting.demo.client.mappers;

import com.dngconsulting.demo.client.ClientFactory;
import com.dngconsulting.demo.client.activity.AccueilActivity;
import com.dngconsulting.demo.client.activity.AllProductsActivity;
import com.dngconsulting.demo.client.activity.CartActivity;
import com.dngconsulting.demo.client.activity.ContactActivity;
import com.dngconsulting.demo.client.activity.FicheProduitActivity;
import com.dngconsulting.demo.client.activity.NouveautesActivity;
import com.dngconsulting.demo.client.activity.ProductsByBrandActivity;
import com.dngconsulting.demo.client.activity.ProductsByCategoryActivity;
import com.dngconsulting.demo.client.places.AccueilPlace;
import com.dngconsulting.demo.client.places.AllProductsPlace;
import com.dngconsulting.demo.client.places.CartPlace;
import com.dngconsulting.demo.client.places.ContactPlace;
import com.dngconsulting.demo.client.places.FicheProduitPlace;
import com.dngconsulting.demo.client.places.NouveautesPlace;
import com.dngconsulting.demo.client.places.ProductsByBrandPlace;
import com.dngconsulting.demo.client.places.ProductsByCategoryPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;

	public AppActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}
	
	@Override
	public Activity getActivity(Place place) {
		if (place instanceof AccueilPlace)
			return new AccueilActivity((AccueilPlace) place, clientFactory);
		else if (place instanceof NouveautesPlace)
			return new NouveautesActivity((NouveautesPlace) place, clientFactory);
		else if (place instanceof ProductsByCategoryPlace)
			return new ProductsByCategoryActivity((ProductsByCategoryPlace) place, clientFactory);
		else if (place instanceof ProductsByBrandPlace)
			return new ProductsByBrandActivity((ProductsByBrandPlace) place, clientFactory);
		else if (place instanceof AllProductsPlace)
			return new AllProductsActivity((AllProductsPlace) place, clientFactory);
		else if (place instanceof FicheProduitPlace)
			return new FicheProduitActivity((FicheProduitPlace) place, clientFactory);
		else if (place instanceof CartPlace)
			return new CartActivity((CartPlace) place, clientFactory);
		else if (place instanceof ContactPlace)
			return new ContactActivity((ContactPlace) place, clientFactory);
		
		return null;
	}

}
