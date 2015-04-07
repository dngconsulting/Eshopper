package com.dngconsulting.demo.client.event;

import com.dngconsulting.demo.shared.Panier;
import com.google.gwt.event.shared.GwtEvent;

public class UpdatedCartEvent extends GwtEvent<UpdatedCartHandlers> {
	
	public static Type<UpdatedCartHandlers> TYPE = new Type<UpdatedCartHandlers>();
	
	private Panier oldCart;
	private Panier newCart;
	
	
	public UpdatedCartEvent() {}

	public UpdatedCartEvent(Panier oldCart, Panier newCart) {
		this.setOldCart(oldCart);
		this.setNewCart(newCart);
	}

	@Override
	public Type<UpdatedCartHandlers> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(UpdatedCartHandlers handler) {
		handler.onUpdatedCart(this);
	}

	public Panier getOldCart() {
		return oldCart;
	}

	public void setOldCart(Panier oldCart) {
		this.oldCart = oldCart;
	}

	public Panier getNewCart() {
		return newCart;
	}

	public void setNewCart(Panier newCart) {
		this.newCart = newCart;
	}

}
