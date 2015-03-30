package com.dngconsulting.demo.client.localstorage;

import com.dngconsulting.demo.shared.Panier;
import com.dngconsulting.demo.shared.PanierItem;
import com.google.gwt.core.shared.GWT;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanUtils;

public class BeanSerializerUtils {

	private static AppBeanFactory factory = GWT.create(AppBeanFactory.class);

	public static Panier createPanierInstance(){
		return factory.panier().as();
	}

	public static PanierItem createPanierItemInstance(){
		return factory.item().as();
	}
	
	public static String serializeToJson(Panier panier){
		AutoBean<Panier> bean = AutoBeanUtils.getAutoBean(panier);
		return AutoBeanCodex.encode(bean).getPayload();
	}
	
	public static Panier deserializeFromJson(String json){
		AutoBean<Panier> bean = AutoBeanCodex.decode(factory, Panier.class, json);
		return bean.as();
	}
}
