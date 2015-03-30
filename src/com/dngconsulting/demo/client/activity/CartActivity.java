package com.dngconsulting.demo.client.activity;

import com.dngconsulting.demo.client.AppContext;
import com.dngconsulting.demo.client.ClientFactory;
import com.dngconsulting.demo.client.places.CartPlace;
import com.dngconsulting.demo.client.view.CartView;
import com.dngconsulting.demo.shared.PanierItem;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class CartActivity extends AbstractActivity {
	
	private ClientFactory clientFactory;

	public CartActivity(CartPlace place,ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}


	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		AppContext.getGa().trackUniversalPageview("#!cart:","Panier");
		CartView view = clientFactory.getCartView();
		panel.setWidget(view.asWidget());
		view.clearCart();
		for (PanierItem item : AppContext.getPanierItems()) {
			view.addItem(item.getPhotoFile(), item.getRef(), item.getName(), item.getPrice(), item.getQuantity());
		}
	}

}
