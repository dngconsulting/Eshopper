package com.dngconsulting.demo.client.view.elemental;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

@JsType
public interface GoogleMapDirections extends HTMLElement {
	@JsProperty void setStartAddress(Object add);
	@JsProperty void setEndAddress(Object add);
	@JsProperty void setMap(GoogleMap map);
	@JsProperty Object getStartAddress();
	@JsProperty Object getEndAddress();
	@JsProperty GoogleMap getMap();

}
