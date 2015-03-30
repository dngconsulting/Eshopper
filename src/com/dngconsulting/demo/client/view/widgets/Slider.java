package com.dngconsulting.demo.client.view.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Slider extends Composite {

	private static SliderUiBinder uiBinder = GWT.create(SliderUiBinder.class);

	interface SliderUiBinder extends UiBinder<Widget, Slider> {
	}

	public Slider() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
