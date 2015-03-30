package com.dngconsulting.demo.client.view.elemental;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

@JsType
public interface LatLng {

	@JsProperty double getLatitude();
	@JsProperty double getLongitude();
	@JsProperty void setLatitude(double lat);
	@JsProperty void setLongitude(double lng);
	
}
