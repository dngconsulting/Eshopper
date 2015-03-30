package com.dngconsulting.demo.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class AccueilPlace extends Place
{
	@Prefix("!accueil")
	public static class Tokenizer implements PlaceTokenizer<AccueilPlace>
	{
		@Override
		public String getToken(AccueilPlace place)
		{
			return "";
		}

		@Override
		public AccueilPlace getPlace(String token)
		{
			return new AccueilPlace();
		}
	}
}
