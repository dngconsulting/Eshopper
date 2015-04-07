package com.dngconsulting.demo.client.localstorage;

import com.dngconsulting.demo.shared.Panier;
import com.google.gwt.storage.client.Storage;

public class LocalStorageUtils {

	private static final String PANIER_KEY = "PANIER";
	
	private static Storage store = Storage.getLocalStorageIfSupported();
	
	public static Panier getInitialPanier(){
		if (store != null){
//			StorageMap storeMap = new StorageMap(store);
//			if (storeMap.containsValue(PANIER_KEY)!= true){
//				Panier panier = BeanSerializerUtils.createPanierInstance();
//				return panier;
//			}
//			else{
//				String json = store.getItem(PANIER_KEY);
//				return BeanSerializerUtils.deserializeFromJson(json);
//			}

			String json = store.getItem(PANIER_KEY);
			if(json == null || json.isEmpty()){
				Panier panier = BeanSerializerUtils.createPanierInstance();
				return panier;
			}
			else{
				return BeanSerializerUtils.deserializeFromJson(json);
			}
		}
		else{
			Panier panier = BeanSerializerUtils.createPanierInstance();
			return panier;
		}
	}
	
	public static Panier getClonedPanier(){
		return getInitialPanier();
	}
	
	public static void storePanier(Panier panier){
		if (store != null){
			store.setItem(PANIER_KEY, BeanSerializerUtils.serializeToJson(panier));
		}
	}
	
	public static void clearStoredPanier(){
		if (store != null){
			store.removeItem(PANIER_KEY);
		}
	}
}
