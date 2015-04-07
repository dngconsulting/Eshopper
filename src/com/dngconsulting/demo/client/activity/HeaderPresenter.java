package com.dngconsulting.demo.client.activity;

import com.dngconsulting.demo.client.ClientFactory;
import com.dngconsulting.demo.client.event.UpdatedCartEvent;
import com.dngconsulting.demo.client.view.Header;

public class HeaderPresenter {
	private ClientFactory clientFactory;

	public HeaderPresenter(ClientFactory clientFactory, int initialCount) {
		this.clientFactory = clientFactory;
		Header view = this.clientFactory.getHeaderView();
		view.setCountItems(initialCount);
		this.clientFactory.getEventBus().addHandler(UpdatedCartEvent.TYPE, (e)->{
			int count = 0;
			if(e.getNewCart() != null && e.getNewCart().getListItems()!=null){
				count  = e.getNewCart().getListItems().size();
			}
			view.setCountItems(count);
		});
	}

	
}
