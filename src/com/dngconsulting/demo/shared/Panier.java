package com.dngconsulting.demo.shared;

import java.util.List;

public interface Panier {

	void setListItems(List<PanierItem> listItems);
	List<PanierItem> getListItems();
}
