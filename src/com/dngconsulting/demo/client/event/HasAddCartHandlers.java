package com.dngconsulting.demo.client.event;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasAddCartHandlers extends HasHandlers {
	
	HandlerRegistration addAddCartHandler(AddCartHandlers handler);
}
