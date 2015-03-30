package com.dngconsulting.demo.client.view;

import com.dngconsulting.demo.client.event.HasAddCartHandlers;
import com.google.gwt.user.client.ui.IsWidget;

public interface ProductDetailsView extends IsWidget, HasAddCartHandlers {

	void setImageUrl(String url);
	void setRef(String refLabel);
	void setName(String nameLabel);
	void setPrice(double p);
	void setBrand(String brandLabel);
	void setDescription(String descLabel);
	void setNewProduct(boolean isNew);
	void setCategory(String category);
	
}
