package com.dngconsulting.demo.client.view.impl;

import java.util.ArrayList;

import com.dngconsulting.demo.client.event.AddCartHandlers;
import com.dngconsulting.demo.client.view.AccueilView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class AccueilViewImpl extends Composite implements AccueilView {

	private static AccueilViewImplUiBinder uiBinder = GWT.create(AccueilViewImplUiBinder.class);

	interface AccueilViewImplUiBinder extends UiBinder<Widget, AccueilViewImpl> {}

	@UiField ListItemsViewImpl listItems;
	
	public AccueilViewImpl(String title) {
		initWidget(uiBinder.createAndBindUi(this));
		listItems.setTitleList(title);
	}

	@Override
	public void setTitleList(String title) {
		listItems.setTitleList(title);
	}

	@Override
	public void setListBrands(ArrayList<String> brands) {
		listItems.setListBrands(brands);
	}

	@Override
	public void setListCategories(ArrayList<String> categories) {
		listItems.setListCategories(categories);
	}

	@Override
	public void addItem(String ref, String name, String url, double price) {
		listItems.addItem(ref, name, url, price);
	}

	@Override
	public void resetListItems() {
		listItems.resetListItems();
	}

	@Override
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler) {
		return listItems.addValueChangeHandler(handler);
	}

	@Override
	public HandlerRegistration addAddCartHandler(AddCartHandlers handler) {
		return listItems.addAddCartHandler(handler);
	}

}
