package com.dngconsulting.demo.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class ProductsByBrandPlace extends Place {
	public final String brand;

	public ProductsByBrandPlace(String brand) {
		this.brand = brand;
	}

	@Prefix("!byBrand")
	public static class Tokenizer implements PlaceTokenizer<ProductsByBrandPlace> {
		@Override
		public String getToken(ProductsByBrandPlace place) {
			return place.brand;
		}

		@Override
		public ProductsByBrandPlace getPlace(String token) {
			return new ProductsByBrandPlace(token);
		}
	}

}
