package com.dngconsulting.demo.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface AddCartHandlers extends EventHandler {

	void onAddedToCart(AddCartEvent event);
}
