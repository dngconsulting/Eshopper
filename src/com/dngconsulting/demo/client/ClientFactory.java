package com.dngconsulting.demo.client;

import com.dngconsulting.demo.client.view.AccueilView;
import com.dngconsulting.demo.client.view.CartView;
import com.dngconsulting.demo.client.view.ContactView;
import com.dngconsulting.demo.client.view.Footer;
import com.dngconsulting.demo.client.view.Header;
import com.dngconsulting.demo.client.view.ListItemsView;
import com.dngconsulting.demo.client.view.ProductDetailsView;
import com.google.gwt.place.shared.Place;
import com.google.web.bindery.event.shared.EventBus;

public interface ClientFactory
{
	Place getDefaultPlace();
	Header getHeaderView();
	Footer getFooterView();

	AccueilView getAccueilView();
	ListItemsView getNouveautesView();
	ListItemsView getProductsByCategoryView();
	ListItemsView getProductsByBrandView();
	ListItemsView getAllProductsView();
	ProductDetailsView getFicheproduitview();
	CartView getCartView();
	ContactView getContactView();

	EventBus getEventBus();
	AppPlaceController getPlaceController();

}
