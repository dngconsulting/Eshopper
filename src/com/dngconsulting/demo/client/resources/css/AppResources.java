package com.dngconsulting.demo.client.resources.css;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface AppResources extends ClientBundle {

	Appstyle appstyle();

	@Source("../img/searchicon.png")
	ImageResource searchicon();
}
