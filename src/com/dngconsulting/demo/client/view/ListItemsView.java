package com.dngconsulting.demo.client.view;

import java.util.ArrayList;

import com.dngconsulting.demo.client.event.HasAddCartHandlers;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.user.client.ui.IsWidget;

public interface ListItemsView extends IsWidget, HasValueChangeHandlers<String>, HasAddCartHandlers {

	void setTitleList(String title);
	void setListBrands(ArrayList<String> brands);
	void setListCategories(ArrayList<String> categories);
	void addItem(final String ref, String name, String url, double price);
	void resetListItems();
	
	
}
