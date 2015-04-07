package com.dngconsulting.demo.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface UpdatedCartHandlers extends EventHandler {

	void onUpdatedCart(UpdatedCartEvent event);
}
