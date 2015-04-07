package com.dngconsulting.demo.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class DeleteItemCartEvent extends GwtEvent<DeleteItemCartHandlers> {
	
	public static Type<DeleteItemCartHandlers> TYPE = new Type<DeleteItemCartHandlers>();
	
	private String refProduct = null;
	private boolean clearAll = false;;
	
	public DeleteItemCartEvent() {}
	
	

	public DeleteItemCartEvent(String refProduct) {
		this.refProduct = refProduct;
		this.clearAll = false;
	}



	public DeleteItemCartEvent(boolean clearAll) {
		this.refProduct = null;
		this.clearAll = clearAll;
	}



	@Override
	public Type<DeleteItemCartHandlers> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(DeleteItemCartHandlers handler) {
		handler.onDeleteItemToCart(this);
	}

	public String getRefProduct() {
		return refProduct;
	}

	public void setRefProduct(String refProduct) {
		this.refProduct = refProduct;
	}



	public boolean isClearAll() {
		return clearAll;
	}



	public void setClearAll(boolean clearAll) {
		this.clearAll = clearAll;
	}

}
