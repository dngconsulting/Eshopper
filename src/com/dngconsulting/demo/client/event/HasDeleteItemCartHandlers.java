package com.dngconsulting.demo.client.event;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasDeleteItemCartHandlers extends HasHandlers {
	
	HandlerRegistration addDeleteItemCartHandler(DeleteItemCartHandlers handler);
}
