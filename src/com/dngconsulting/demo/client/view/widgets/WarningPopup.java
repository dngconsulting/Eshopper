package com.dngconsulting.demo.client.view.widgets;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;

public class WarningPopup extends PopupPanel {
	
	public WarningPopup(String message) {
		this.setAutoHideEnabled(true);
		this.setStyleName("popup-warn");
		this.add(new Label(message));
	}

}
