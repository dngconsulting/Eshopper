package com.dngconsulting.demo.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class CartPlace extends Place
{
	@Prefix("!cart")
	public static class Tokenizer implements PlaceTokenizer<CartPlace>
	{
		@Override
		public String getToken(CartPlace place)
		{
			return "";
		}

		@Override
		public CartPlace getPlace(String token)
		{
			return new CartPlace();
		}
	}
}
