package com.dngconsulting.demo.client.view.elemental;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

@JsType
public interface HTMLElement extends Node {
  
  @JsProperty void setHidden(boolean visible);
  @JsProperty Document getShadowRoot();
}
