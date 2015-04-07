package com.dngconsulting.demo.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.dngconsulting.demo.client.event.UpdatedCartEvent;
import com.dngconsulting.demo.client.localstorage.LocalStorageUtils;
import com.dngconsulting.demo.client.resources.AppMessage;
import com.dngconsulting.demo.client.view.widgets.WarningPopup;
import com.dngconsulting.demo.shared.Panier;
import com.dngconsulting.demo.shared.PanierItem;
import com.google.gwt.user.client.Timer;
import com.google.web.bindery.event.shared.EventBus;


public class AppContext {
	
	private static Panier panier = LocalStorageUtils.getInitialPanier();

	private static GATracker tracker = getTrackerInstance();

	private static EventBus eventBus;
	
	public static void clearPanier(){
		Panier old = LocalStorageUtils.getClonedPanier();
		LocalStorageUtils.clearStoredPanier();
		panier.getListItems().clear();
		eventBus.fireEvent(new UpdatedCartEvent(old, panier));
		WarningPopup popup = new WarningPopup(AppMessage.MSG.cartClearMessage());
		manageCartMessageDisplay(popup);
	}
	
	public static void addOrUpdateItemPanier(PanierItem item){
		Panier old = LocalStorageUtils.getClonedPanier();
		if(panier.getListItems() != null){
			Iterator<PanierItem> it = panier.getListItems().iterator();
			while(it.hasNext()){
				if(it.next().getRef().equalsIgnoreCase(item.getRef())){
					it.remove();
					break;
				}
			}
			panier.getListItems().add(item);
			WarningPopup popup = new WarningPopup(AppMessage.MSG.cartUpdateMessage());
			manageCartMessageDisplay(popup);
		}
		else{
			ArrayList<PanierItem> list = new  ArrayList<PanierItem>();
			list.add(item);
			panier.setListItems(list);
			WarningPopup popup = new WarningPopup(AppMessage.MSG.cartAddItemMessage());
			manageCartMessageDisplay(popup);
		}
		LocalStorageUtils.storePanier(panier);
		eventBus.fireEvent(new UpdatedCartEvent(old, panier));
	}
	public static void removeItemPanier(String ref){
		removeItemPanier(ref, false);
	}
	
	public static void removeItemPanier(String ref, boolean isSilent){
		Panier old = LocalStorageUtils.getClonedPanier();
		Iterator<PanierItem> it = panier.getListItems().iterator();
		while(it.hasNext()){
			if(it.next().getRef().equalsIgnoreCase(ref)){
				it.remove();
				break;
			}
		}
		LocalStorageUtils.storePanier(panier);
		eventBus.fireEvent(new UpdatedCartEvent(old, panier));
		if(!isSilent){
			WarningPopup popup = new WarningPopup(AppMessage.MSG.cartUpdateMessage());
			manageCartMessageDisplay(popup);
		}
	}
	
	public static Collection<PanierItem> getPanierItems(){
		if(panier==null || panier.getListItems() == null) return new ArrayList<PanierItem>();
		return panier.getListItems();
	}
	
	public static GATracker getGa() {
		return tracker;
	}
//
//	public native static void setUniversalAccount(GATracker tracker, String accountId)/*-{
//		tracker.universalAccount(accountId);
//	}-*/;
//
//	public native static void trackUniversalPageview(GATracker tracker, String page,String title)/*-{
//		tracker.trackUniversalPageview(page,title);
//	}-*/;

	public native static GATracker getTrackerInstance() /*-{
		return $wnd.tracker;
	}-*/;

	public static void setEventBus(EventBus bus){
		eventBus = bus;
	}
	
	private static void manageCartMessageDisplay(WarningPopup popup){
		popup.center();
		Timer t = new Timer() {
			
			@Override
			public void run() {
				popup.hide();
			}
		};
		t.schedule(3000);
	}
	
}
