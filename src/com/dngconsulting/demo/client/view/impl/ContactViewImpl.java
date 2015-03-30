package com.dngconsulting.demo.client.view.impl;

import com.dngconsulting.demo.client.view.ContactView;
import com.dngconsulting.demo.client.view.elemental.GeoLocation;
import com.dngconsulting.demo.client.view.elemental.GoogleMap;
import com.dngconsulting.demo.client.view.elemental.GoogleMapDirections;
import com.dngconsulting.demo.client.view.elemental.LatLng;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ContactViewImpl extends Composite implements ContactView {

	private static ContactViewImplUiBinder uiBinder = GWT.create(ContactViewImplUiBinder.class);

	interface ContactViewImplUiBinder extends UiBinder<Widget, ContactViewImpl> {}
	
	@UiField GoogleMap gmap;
	@UiField GeoLocation geoLocation;
	@UiField GoogleMapDirections directions;
	
	private double lat;
	private double lng;
	private boolean isMapReady = false;
	private boolean isGeoResponse = false;

	public ContactViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		gmap.addEventListener("google-map-ready", (e)->{
			directions.setMap(gmap.getMap());
			isMapReady = true;
			manageDirections();
		});
		geoLocation.addEventListener("geo-response", (e)->{
			lat = geoLocation.getLatitude();
			lng = geoLocation.getLongitude();
			isGeoResponse = true;
			manageDirections();
		});
	}

	/*
	 * Create the direction between user position and DNG address
	 * Better to wait both map ready and geo position response events to create it.
	 */
	private void manageDirections() {
		if(isMapReady && isGeoResponse){
			directions.setStartAddress(createLatLng(lat, lng));
			directions.setEndAddress("7 rue de l'industrie, castanet-tolosan");
		}
	}

	private native LatLng createLatLng(double lat, double lng)/*-{
		return new $wnd.google.maps.LatLng(lat,lng);
	}-*/;
}
