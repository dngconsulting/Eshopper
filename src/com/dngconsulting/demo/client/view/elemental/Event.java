package com.dngconsulting.demo.client.view.elemental;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

@JsType
public interface Event {
  
  @JsProperty Detail getDetail();

  @JsType
  public interface Detail {
  }
}
