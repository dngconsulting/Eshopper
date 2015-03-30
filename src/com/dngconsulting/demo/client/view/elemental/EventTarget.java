package com.dngconsulting.demo.client.view.elemental;

import com.google.gwt.core.client.js.JsType;

@JsType
public interface EventTarget {
  void addEventListener(String type, EventListener listener);
}
