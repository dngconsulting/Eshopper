package com.dngconsulting.demo.client.view.widgets;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class SideMenuView extends Composite {

	private static SideMenuViewUiBinder uiBinder = GWT.create(SideMenuViewUiBinder.class);

	interface SideMenuViewUiBinder extends UiBinder<Widget, SideMenuView> {}

	interface SideMenuItemCatTemplate extends SafeHtmlTemplates {
        @Template("<div class=\"panel panel-default\">"
        		+ "<div class=\"panel-heading\">"
        		+ "<h4 class=\"panel-title\">"
        		+ "<a href=\"{0}\">{1}</a>"
        		+ "</h4></div></div>")
        SafeHtml itemCat(String link, String value);
    }

	interface SideMenuItemBrandTemplate extends SafeHtmlTemplates {
        @Template("<li><a href=\"{0}\"> <span class=\"pull-right\"></span>{1}</a></li>")
        SafeHtml itemBrand(String link, String value);
    }
	
	@UiField DivElement listCat;
	@UiField UListElement listBrand;

	private static SideMenuItemCatTemplate templateCat;
	private static SideMenuItemBrandTemplate templateBrand;

	public SideMenuView() {
		initWidget(uiBinder.createAndBindUi(this));
		templateCat = GWT.create(SideMenuItemCatTemplate.class);
		templateBrand = GWT.create(SideMenuItemBrandTemplate.class);
	}


	public void setListBrands(ArrayList<String> brands){
		listBrand.removeAllChildren();
		String contentBrand = "";
		for (String brand : brands) {
			SafeHtml html = templateBrand.itemBrand("#!byBrand:"+brand, brand);
			contentBrand += html.asString();
		}
		listBrand.setInnerHTML(contentBrand);
	}

	public void setListCategories(ArrayList<String> categories){
		listCat.removeAllChildren();
		String contentCat = "";
		for (String cat : categories) {
			SafeHtml html = templateCat.itemCat("#!byCategory:"+cat, cat);
			contentCat += html.asString();
		}
		listCat.setInnerHTML(contentCat);
	}

}
