package com.dngconsulting.demo.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class ProductsByCategoryPlace extends Place {
	public final String category;

	public ProductsByCategoryPlace(String category) {
		this.category = category;
	}

	@Prefix("!byCategory")
	public static class Tokenizer implements PlaceTokenizer<ProductsByCategoryPlace> {
		@Override
		public String getToken(ProductsByCategoryPlace place) {
			return place.category;
		}

		@Override
		public ProductsByCategoryPlace getPlace(String token) {
			return new ProductsByCategoryPlace(token);
		}
	}

}
