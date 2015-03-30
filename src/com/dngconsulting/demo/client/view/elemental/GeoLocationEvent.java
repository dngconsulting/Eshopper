package com.dngconsulting.demo.client.view.elemental;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

@JsType
public interface GeoLocationEvent extends Event {

	@Override
	@JsProperty
	Detail getDetail();
	
	@JsType
	public interface Detail extends Event.Detail{
		@JsProperty double getLatitude();
		@JsProperty double getLongitude();
	}
}
