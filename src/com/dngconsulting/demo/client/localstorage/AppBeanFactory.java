package com.dngconsulting.demo.client.localstorage;

import com.dngconsulting.demo.shared.Panier;
import com.dngconsulting.demo.shared.PanierItem;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;

public interface AppBeanFactory extends AutoBeanFactory {

	AutoBean<Panier> panier();
	AutoBean<PanierItem> item();
	
}
