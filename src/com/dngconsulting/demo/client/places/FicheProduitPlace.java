package com.dngconsulting.demo.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class FicheProduitPlace extends Place {
	public final String id;

	public FicheProduitPlace(String id) {
		this.id = id;
	}

	@Prefix("!ficheproduit")
	public static class Tokenizer implements PlaceTokenizer<FicheProduitPlace> {
		@Override
		public String getToken(FicheProduitPlace place) {
			return place.id;
		}

		@Override
		public FicheProduitPlace getPlace(String token) {
			return new FicheProduitPlace(token);
		}
	}

}
