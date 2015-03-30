package com.dngconsulting.demo.client;

import com.google.gwt.core.client.js.JsType;

@JsType
public interface GATracker {

	void universalAccount(String accountId);
	void trackUniversalPageview(String page,String title);
}
