package com.dngconsulting.demo.client;

import com.dngconsulting.demo.client.mappers.AppActivityMapper;
import com.dngconsulting.demo.client.mappers.AppPlaceHistoryMapper;
import com.dngconsulting.demo.client.places.AccueilPlace;
import com.dngconsulting.demo.client.resources.css.AppResources;
import com.dngconsulting.demo.client.resources.css.thirdparty.ThirdResources;
import com.dngconsulting.demo.client.view.impl.MainPanelImpl;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Ecom implements EntryPoint {
	private Place defaultPlace = new AccueilPlace();
	private ClientFactory clientFactory = GWT.create(ClientFactory.class);
	
	public void onModuleLoad() {
		AppResources res = GWT.create(AppResources.class);
		ThirdResources third = GWT.create(ThirdResources.class);
		StyleInjector.injectAtStart(third.fontAwesomeMinCss().getText());
		StyleInjector.injectAtStart(third.bootstrapMinCss().getText());
		StyleInjector.injectAtEnd(third.responsiveCss().getText());
		res.appstyle().ensureInjected();
		
//		AppContext.setUniversalAccount(AppContext.getGa(),"UA-54660467-1");
		AppContext.getTrackerInstance().universalAccount("UA-54660467-1");
		
		EventBus eventBus = clientFactory.getEventBus();
		PlaceController placeController = clientFactory.getPlaceController();
		MainPanelImpl mainPanel = new MainPanelImpl(clientFactory.getHeaderView(), clientFactory.getFooterView());

		// Start ActivityManager for the main widget with our ActivityMapper
		ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
		ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
		activityManager.setDisplay(mainPanel.getMainContent());

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		AppPlaceHistoryMapper historyMapper= GWT.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);

		RootPanel.get().add(mainPanel);

		// Goes to place represented on URL or default place
		historyHandler.handleCurrentHistory();
		
	}
}
