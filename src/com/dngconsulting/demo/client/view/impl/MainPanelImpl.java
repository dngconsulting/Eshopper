package com.dngconsulting.demo.client.view.impl;

import com.dngconsulting.demo.client.view.Footer;
import com.dngconsulting.demo.client.view.Header;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class MainPanelImpl extends Composite {

	private static MainPanelUiBinder uiBinder = GWT.create(MainPanelUiBinder.class);

	interface MainPanelUiBinder extends UiBinder<Widget, MainPanelImpl> {
	}
	
	@UiField(provided=true) Header header;
	@UiField(provided=true) Footer footer;
	@UiField SimplePanel content;

	public MainPanelImpl(Header header, Footer footer) {
		this.header = header;
		this.footer = footer;
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public SimplePanel getMainContent(){
		return content;
	}

}
