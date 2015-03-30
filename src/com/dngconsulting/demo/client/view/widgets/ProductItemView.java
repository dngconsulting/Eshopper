package com.dngconsulting.demo.client.view.widgets;

import com.dngconsulting.demo.shared.FormatHelper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.dom.client.ParagraphElement;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class ProductItemView extends Composite {

	private static ProductItemViewUiBinder uiBinder = GWT.create(ProductItemViewUiBinder.class);

	interface ProductItemViewUiBinder extends UiBinder<Widget, ProductItemView> {}
	
	public interface SeeDetailsHandler{
		void onSeeDetails();
	}
	public interface AddCartHandler{
		void onAddCart();
	}

	@UiField Image productImg;
	@UiField HeadingElement priceLabel;
	@UiField ParagraphElement nameLabel;
	@UiField HeadingElement priceOverlay;
	@UiField ParagraphElement nameOverlay;

	@UiField Anchor seeDetailsBtn;
	@UiField Anchor seeDetailsBtnOverlay;
	@UiField Anchor addCartBtn;
	@UiField Anchor addCartBtnOverlay;
	
	
	public ProductItemView(final SeeDetailsHandler seeDetailsHandler, final AddCartHandler addCartHandler) {
		initWidget(uiBinder.createAndBindUi(this));
		
		seeDetailsBtn.addClickHandler((event)->{seeDetailsHandler.onSeeDetails();});
		seeDetailsBtnOverlay.addClickHandler((event)->{seeDetailsHandler.onSeeDetails();});
		addCartBtn.addClickHandler((event)->{addCartHandler.onAddCart();});
		addCartBtnOverlay.addClickHandler((event)->{addCartHandler.onAddCart();});
	}
	
	public void setImageUrl(SafeUri url){
		productImg.setUrl(url);
	}
	
	public void setPrice(double price){
		String priceToDisplay = FormatHelper.formatPrice(price);
		priceLabel.setInnerHTML(priceToDisplay);
		priceOverlay.setInnerHTML(priceToDisplay);
	}

	public void setName(String name){
		SafeHtml htmlName = SafeHtmlUtils.fromString(name);
		nameLabel.setInnerSafeHtml(htmlName);
		nameOverlay.setInnerSafeHtml(htmlName);
	}
	
}
