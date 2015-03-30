package com.dngconsulting.demo.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;


public class AllProductsPlace extends Place
{
	@Prefix("!all")
	public static class Tokenizer implements PlaceTokenizer<AllProductsPlace>
	{
		@Override
		public String getToken(AllProductsPlace place)
		{
			return "";
		}

		@Override
		public AllProductsPlace getPlace(String token)
		{
			return new AllProductsPlace();
		}
	}
	
}
