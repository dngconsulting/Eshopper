package com.dngconsulting.demo.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.dngconsulting.demo.client.localstorage.LocalStorageUtils;
import com.dngconsulting.demo.shared.Panier;
import com.dngconsulting.demo.shared.PanierItem;


public class AppContext {
	
	private static Panier panier = LocalStorageUtils.getInitialPanier();

	private static GATracker tracker = getTrackerInstance();

	
	public static void clearPanier(){
		LocalStorageUtils.clearStoredPanier();
		panier.getListItems().clear();
	}
	
	public static void addOrUpdateItemPanier(PanierItem item){
		if(panier.getListItems() != null){
			Iterator<PanierItem> it = panier.getListItems().iterator();
			while(it.hasNext()){
				if(it.next().getRef().equalsIgnoreCase(item.getRef())){
					it.remove();
					break;
				}
			}
			panier.getListItems().add(item);
		}
		else{
			ArrayList<PanierItem> list = new  ArrayList<PanierItem>();
			list.add(item);
			panier.setListItems(list);
		}
		LocalStorageUtils.storePanier(panier);
	}
	
	public static void removeItemPanier(PanierItem item){
		panier.getListItems().remove(item);
		LocalStorageUtils.storePanier(panier);
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

}
