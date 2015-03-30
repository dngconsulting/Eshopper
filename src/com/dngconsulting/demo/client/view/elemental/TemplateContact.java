package com.dngconsulting.demo.client.view.elemental;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

@JsType
public interface TemplateContact extends HTMLElement {

	@JsProperty String getTitle();
	@JsProperty void setTitle(String title);
	
}
