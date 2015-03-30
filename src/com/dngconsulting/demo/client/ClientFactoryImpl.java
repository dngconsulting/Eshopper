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
	private static final Place defaultPlace = new AccueilPlace();
	private static final EventBus eventBus = new SimpleEventBus();
	private static final AppPlaceController placeController = new AppPlaceController(eventBus,defaultPlace);
	private static final HeaderImpl header = new HeaderImpl();
	private static final FooterImpl footer = new FooterImpl();
	private static final ListItemsViewImpl nouveautesView = new ListItemsViewImpl(AppMessage.MSG.newItems());
	private static final ListItemsViewImpl productsByCategoryView = new ListItemsViewImpl("");
	private static final ListItemsViewImpl productsByBrandView = new ListItemsViewImpl("");
	private static final AccueilView accueilView = new AccueilViewImpl(AppMessage.MSG.features_items());
	private static final ListItemsViewImpl allProductsView = new ListItemsViewImpl(AppMessage.MSG.allItems());
	private static final ProductDetailsViewImpl ficheProduitView = new ProductDetailsViewImpl();
	private static final CartViewImpl cartView = new CartViewImpl();
	private static final ContactViewImpl contactView = new ContactViewImpl();
	
	@Override
	public Place getDefaultPlace() {
		return defaultPlace;
	}

	@Override
	public AccueilView getAccueilView() {
		return accueilView;
	}

	@Override
	public ListItemsView getAllProductsView() {
		return allProductsView;
	}

	@Override
	public ListItemsView getNouveautesView() {
		return nouveautesView;
	}

	@Override
	public ListItemsView getProductsByCategoryView() {
		return productsByCategoryView;
	}

	@Override
	public ListItemsView getProductsByBrandView() {
		return productsByBrandView;
	}

	@Override
	public ProductDetailsView getFicheproduitview() {
		return ficheProduitView;
	}

	@Override
	public CartView getCartView() {
		return cartView;
	}

	@Override
	public ContactView getContactView() {
		return contactView;
	}
	
	@Override
	public EventBus getEventBus()
	{
		return eventBus;
	}


	@Override
	public AppPlaceController getPlaceController()
	{
		return placeController;
	}

	
	public Header getHeaderView() {
		return header;
	}

	public Footer getFooterView() {
		return footer;
	}


}
