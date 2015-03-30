package com.dngconsulting.demo.client.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface CartView extends IsWidget {

	void clearCart();
	void addItem(String photoFile, String ref, String name, double price, int qty);
	
}
