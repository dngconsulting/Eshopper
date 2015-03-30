package com.dngconsulting.demo.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class ContactPlace extends Place
{
	@Prefix("!contact")
	public static class Tokenizer implements PlaceTokenizer<ContactPlace>
	{
		@Override
		public String getToken(ContactPlace place)
		{
			return "";
		}

		@Override
		public ContactPlace getPlace(String token)
		{
			return new ContactPlace();
		}
	}
}
