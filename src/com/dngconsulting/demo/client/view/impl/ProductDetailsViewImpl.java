package com.dngconsulting.demo.client.view.impl;

import java.util.ArrayList;
import java.util.Arrays;

import com.dngconsulting.demo.client.event.AddCartEvent;
import com.dngconsulting.demo.client.event.AddCartHandlers;
import com.dngconsulting.demo.client.resources.AppMessage;
import com.dngconsulting.demo.client.view.ProductDetailsView;
import com.dngconsulting.demo.client.view.widgets.SideMenuView;
import com.dngconsulting.demo.client.view.widgets.WarningPopup;
import com.dngconsulting.demo.shared.FormatHelper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.dom.client.ParagraphElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ProductDetailsViewImpl extends Composite implements ProductDetailsView {

	private static ProductDetailsViewUiBinder uiBinder = GWT.create(ProductDetailsViewUiBinder.class);

	interface ProductDetailsViewUiBinder extends UiBinder<Widget, ProductDetailsViewImpl> {}

	@UiField Image productImg;
	@UiField Image newImg;
	@UiField HeadingElement name;
	@UiField SpanElement ref;
	@UiField SpanElement price;
	@UiField Button addCartBtn;
	@UiField SpanElement brand;
	@UiField ParagraphElement description;
	@UiField TextBox quantityTB;
	
	@UiField SideMenuView sideMenu;
	
	@UiField AppMessage i18n;
	
	private String reference;
	private String url;
	private String nameProduct;
	private double priceProduct;
	
	public ProductDetailsViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		addCartBtn.addClickHandler((event)->{
			try{
				int q = Integer.valueOf(quantityTB.getText());
				if(q<1) throw new NumberFormatException();
				ProductDetailsViewImpl.this.fireEvent(new AddCartEvent(reference, url, nameProduct, priceProduct, q));
			}catch (NumberFormatException e){
				WarningPopup popup = new WarningPopup(i18n.quantityErrorMessage());
				popup.showRelativeTo(addCartBtn);
				popup.addCloseHandler((closeEvent)->{quantityTB.setText("1");});
			}
		});
	}

	public void setImageUrl(String url){
		this.url = url;
		productImg.setUrl(UriUtils.fromString(url));
	}
	
	public void setRef(String refLabel){
		this.reference = refLabel;
		ref.setInnerSafeHtml(SafeHtmlUtils.fromString(refLabel));
	}

	public void setName(String nameLabel){
		this.nameProduct = nameLabel;
		name.setInnerSafeHtml(SafeHtmlUtils.fromString(nameLabel));
	}

	public void setPrice(double p){
		this.priceProduct = p;
		price.setInnerSafeHtml(SafeHtmlUtils.fromString(FormatHelper.formatPrice(p)));
	}

	public void setBrand(String brandLabel){
		brand.setInnerSafeHtml(SafeHtmlUtils.fromString(brandLabel));
		sideMenu.setListBrands(new ArrayList<String>(Arrays.asList(brandLabel)));
	}

	public void setDescription(String descLabel){
		description.setInnerSafeHtml(SafeHtmlUtils.fromString(descLabel));
	}

	public void setNewProduct(boolean isNew){
		newImg.setVisible(isNew);
	}
	
	public void setCategory(String category){
		sideMenu.setListCategories(new ArrayList<String>(Arrays.asList(category)));
	}

	@Override
	public HandlerRegistration addAddCartHandler(AddCartHandlers handler) {
		return addHandler(handler, AddCartEvent.TYPE);
	}
}
