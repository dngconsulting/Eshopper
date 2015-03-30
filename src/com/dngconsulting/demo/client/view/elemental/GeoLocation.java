package com.dngconsulting.demo.client.view.elemental;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

@JsType
public interface GeoLocation  extends HTMLElement{
	@JsProperty double getLatitude();
	@JsProperty void setLatitude(double lat);
	@JsProperty double getLongitude();
	@JsProperty void setLongitude(double lat);
}
