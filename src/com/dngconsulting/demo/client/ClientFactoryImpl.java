package com.dngconsulting.demo.client;

import com.dngconsulting.demo.client.places.AccueilPlace;
import com.dngconsulting.demo.client.resources.AppMessage;
import com.dngconsulting.demo.client.view.AccueilView;
import com.dngconsulting.demo.client.view.CartView;
import com.dngconsulting.demo.client.view.ContactView;
import com.dngconsulting.demo.client.view.Footer;
import com.dngconsulting.demo.client.view.Header;
import com.dngconsulting.demo.client.view.ListItemsView;
import com.dngconsulting.demo.client.view.ProductDetailsView;
import com.dngconsulting.demo.client.view.impl.AccueilViewImpl;
import com.dngconsulting.demo.client.view.impl.CartViewImpl;
import com.dngconsulting.demo.client.view.impl.ContactViewImpl;
import com.dngconsulting.demo.client.view.impl.FooterImpl;
import com.dngconsulting.demo.client.view.impl.HeaderImpl;
import com.dngconsulting.demo.client.view.impl.ListItemsViewImpl;
import com.dngconsulting.demo.client.view.impl.ProductDetailsViewImpl;
import com.google.gwt.place.shared.Place;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class ClientFactoryImpl implements ClientFactory
{
	private static Place defaultPlace;
	private static EventBus eventBus;
	private static AppPlaceController placeController;
	private static HeaderImpl header;
	private static FooterImpl footer;
	private static ListItemsViewImpl nouveautesView;
	private static ListItemsViewImpl productsByCategoryView;
	private static ListItemsViewImpl productsByBrandView;
	private static AccueilView accueilView;
	private static ListItemsViewImpl allProductsView;
	private static ProductDetailsViewImpl ficheProduitView;
	private static CartViewImpl cartView;
	private static ContactViewImpl contactView;
	
	@Override
	public Place getDefaultPlace() {
		if(defaultPlace == null) defaultPlace = new AccueilPlace();
		return defaultPlace;
	}

	@Override
	public AccueilView getAccueilView() {
		if(accueilView==null) accueilView = new AccueilViewImpl(AppMessage.MSG.features_items());
		return accueilView;
	}

	@Override
	public ListItemsView getAllProductsView() {
		if(allProductsView==null) allProductsView = new ListItemsViewImpl(AppMessage.MSG.allItems());
		return allProductsView;
	}

	@Override
	public ListItemsView getNouveautesView() {
		if(nouveautesView==null) nouveautesView = new ListItemsViewImpl(AppMessage.MSG.newItems());
		return nouveautesView;
	}

	@Override
	public ListItemsView getProductsByCategoryView() {
		if(productsByCategoryView==null) productsByCategoryView = new ListItemsViewImpl("");
		return productsByCategoryView;
	}

	@Override
	public ListItemsView getProductsByBrandView() {
		if(productsByBrandView==null) productsByBrandView = new ListItemsViewImpl("");
		return productsByBrandView;
	}

	@Override
	public ProductDetailsView getFicheproduitview() {
		if(ficheProduitView==null) ficheProduitView = new ProductDetailsViewImpl();
		return ficheProduitView;
	}

	@Override
	public CartView getCartView() {
		if(cartView==null) cartView = new CartViewImpl();
		return cartView;
	}

	@Override
	public ContactView getContactView() {
		if(contactView==null) contactView = new ContactViewImpl();
		return contactView;
	}
	
	@Override
	public EventBus getEventBus(){
		if(eventBus==null) eventBus = new SimpleEventBus();
		return eventBus;
	}


	@Override
	public AppPlaceController getPlaceController(){
		if(placeController==null) placeController =  new AppPlaceController(eventBus,defaultPlace);
		return placeController;
	}

	
	public Header getHeaderView() {
		if(header==null) header =  new HeaderImpl();
		return header;
	}

	public Footer getFooterView() {
		if(footer==null) footer = new FooterImpl();
		return footer;
	}


}
