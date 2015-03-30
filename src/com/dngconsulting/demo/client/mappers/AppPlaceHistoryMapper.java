package com.dngconsulting.demo.client.mappers;

import com.dngconsulting.demo.client.places.AccueilPlace;
import com.dngconsulting.demo.client.places.AllProductsPlace;
import com.dngconsulting.demo.client.places.CartPlace;
import com.dngconsulting.demo.client.places.ContactPlace;
import com.dngconsulting.demo.client.places.FicheProduitPlace;
import com.dngconsulting.demo.client.places.NouveautesPlace;
import com.dngconsulting.demo.client.places.ProductsByBrandPlace;
import com.dngconsulting.demo.client.places.ProductsByCategoryPlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/**
 * PlaceHistoryMapper interface is used to attach all places which the
 * PlaceHistoryHandler should be aware of. This is done via the @WithTokenizers
 * annotation or by extending PlaceHistoryMapperWithFactory and creating a
 * separate TokenizerFactory.
 */
@WithTokenizers({ AccueilPlace.Tokenizer.class,
	NouveautesPlace.Tokenizer.class,
	AllProductsPlace.Tokenizer.class,
	ProductsByBrandPlace.Tokenizer.class,
	ProductsByCategoryPlace.Tokenizer.class, 
	FicheProduitPlace.Tokenizer.class, 
	CartPlace.Tokenizer.class, 
	ContactPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
