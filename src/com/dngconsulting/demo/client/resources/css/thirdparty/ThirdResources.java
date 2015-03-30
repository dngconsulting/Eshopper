package com.dngconsulting.demo.client.resources.css.thirdparty;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface ThirdResources extends ClientBundle {

	@Source("bootstrap.min.css.txt")
	TextResource bootstrapMinCss();

	@Source("responsive.css.txt")
	TextResource responsiveCss();

	@Source("font-awesome.min.css.txt")
	TextResource fontAwesomeMinCss();

}
