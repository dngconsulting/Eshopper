package com.dngconsulting.demo.client.activity;

import com.dngconsulting.demo.client.AppContext;
import com.dngconsulting.demo.client.ClientFactory;
import com.dngconsulting.demo.client.places.ContactPlace;
import com.dngconsulting.demo.client.view.ContactView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ContactActivity extends AbstractActivity  {
	private ClientFactory clientFactory;

	public ContactActivity(ContactPlace place, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		AppContext.getGa().trackUniversalPageview("#!contact:","Contact");
		ContactView view = clientFactory.getContactView();
		panel.setWidget(view.asWidget());
		
	}

	
}
