package com.dngconsulting.demo.server.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitProductsListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ProductManager.initProductManager();
	}

}
