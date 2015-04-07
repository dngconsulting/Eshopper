package com.dngconsulting.demo.client.activity;

import com.dngconsulting.demo.client.AppContext;
import com.dngconsulting.demo.client.ClientFactory;
import com.dngconsulting.demo.client.places.AccueilPlace;
import com.dngconsulting.demo.client.places.CartPlace;
import com.dngconsulting.demo.client.view.CartView;
import com.dngconsulting.demo.shared.PanierItem;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class CartActivity extends AbstractActivity {
	
	private CartView view;

	public CartActivity(CartPlace place,ClientFactory clientFactory) {
		super();
		view = clientFactory.getCartView();
		view.addDeleteItemCartHandler((event)->{
			if(event.isClearAll()){
				AppContext.clearPanier();
				clientFactory.getPlaceController().goTo(new AccueilPlace());
			}
			else{
				AppContext.removeItemPanier(event.getRefProduct(), true);
			}
			
		});
	}


	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		AppContext.getGa().trackUniversalPageview("#!cart:","Panier");
		panel.setWidget(view.asWidget());
		view.clearCart();
		for (PanierItem item : AppContext.getPanierItems()) {
			view.addItem(item.getPhotoFile(), item.getRef(), item.getName(), item.getPrice(), item.getQuantity());
		}
	}

}
