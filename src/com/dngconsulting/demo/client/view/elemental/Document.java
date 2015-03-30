package com.dngconsulting.demo.client.view.elemental;

import com.google.gwt.core.client.js.JsType;

@JsType
public interface Document extends Node {

  EventTarget getElementById(String id);
}