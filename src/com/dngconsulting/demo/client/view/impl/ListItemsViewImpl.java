package com.dngconsulting.demo.client.view.impl;

import java.util.ArrayList;

import com.dngconsulting.demo.client.event.AddCartEvent;
import com.dngconsulting.demo.client.event.AddCartHandlers;
import com.dngconsulting.demo.client.view.ListItemsView;
import com.dngconsulting.demo.client.view.widgets.ProductItemView;
import com.dngconsulting.demo.client.view.widgets.ProductItemView.AddCartHandler;
import com.dngconsulting.demo.client.view.widgets.ProductItemView.SeeDetailsHandler;
import com.dngconsulting.demo.client.view.widgets.SideMenuView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;


public class ListItemsViewImpl extends Composite implements ListItemsView {

	private static ListItemsViewUiBinder uiBinder = GWT.create(ListItemsViewUiBinder.class);

	interface ListItemsViewUiBinder extends UiBinder<Widget, ListItemsViewImpl> {}
	
	@UiField HTMLPanel listProducts;
	@UiField HeadingElement titleLabel;
	
	@UiField SideMenuView sideMenu; 

	public ListItemsViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public ListItemsViewImpl(String title) {
		this();
		titleLabel.setInnerSafeHtml(SafeHtmlUtils.fromString(title));
	}
	
	public void setTitleList(String title){
		titleLabel.setInnerSafeHtml(SafeHtmlUtils.fromString(title));
	}
	
	public void setListBrands(ArrayList<String> brands){
		sideMenu.setListBrands(brands);
	}

	public void setListCategories(ArrayList<String> categories){
		sideMenu.setListCategories(categories);
	}
	
	public void addItem(final String ref, String name, String url, double price){
		AddCartHandler addCart = ()->{ListItemsViewImpl.this.fireEvent(new AddCartEvent(ref, url, name, price, 1));};
		SeeDetailsHandler seeDetails = ()->{ValueChangeEvent.fire(ListItemsViewImpl.this, ref);};
		ProductItemView piv = new ProductItemView(seeDetails,addCart);
		piv.setImageUrl(UriUtils.fromString(url));
		piv.setPrice(price);
		piv.setName(name);
		
		listProducts.add(piv);
	}
	
	public void resetListItems(){
		listProducts.clear();
	}

	@Override
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler) {
		return addHandler(handler, ValueChangeEvent.getType());
	}

	@Override
	public HandlerRegistration addAddCartHandler(AddCartHandlers handler) {
		return addHandler(handler, AddCartEvent.TYPE);
	}

	
}
