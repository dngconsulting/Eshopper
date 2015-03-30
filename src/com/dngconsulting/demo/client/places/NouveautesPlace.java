package com.dngconsulting.demo.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;


public class NouveautesPlace extends Place
{
	@Prefix("!nouveautes")
	public static class Tokenizer implements PlaceTokenizer<NouveautesPlace>
	{
		@Override
		public String getToken(NouveautesPlace place)
		{
			return "";
		}

		@Override
		public NouveautesPlace getPlace(String token)
		{
			return new NouveautesPlace();
		}
	}
	
}
