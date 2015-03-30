package com.dngconsulting.demo.client.view.impl;

import com.dngconsulting.demo.client.view.Footer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class FooterImpl extends Composite implements Footer {

	private static FooterImplUiBinder uiBinder = GWT.create(FooterImplUiBinder.class);

	interface FooterImplUiBinder extends UiBinder<Widget, FooterImpl> {
	}

	public FooterImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
