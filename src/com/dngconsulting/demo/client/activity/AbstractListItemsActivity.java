package com.dngconsulting.demo.client.activity;

import java.util.ArrayList;

import com.dngconsulting.demo.client.AppContext;
import com.dngconsulting.demo.client.ClientFactory;
import com.dngconsulting.demo.client.localstorage.BeanSerializerUtils;
import com.dngconsulting.demo.client.places.FicheProduitPlace;
import com.dngconsulting.demo.client.services.AbstractAsyncCallback;
import com.dngconsulting.demo.client.services.ServiceLocator;
import com.dngconsulting.demo.client.view.ListItemsView;
import com.dngconsulting.demo.shared.BrandAndCategoryDTO;
import com.dngconsulting.demo.shared.PanierItem;
import com.dngconsulting.demo.shared.ProductDTO;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public abstract class AbstractListItemsActivity extends AbstractActivity  {
	protected ClientFactory clientFactory;
	protected ListItemsView view;
	
	private HandlerRegistration valueChangeHandler;

	public AbstractListItemsActivity(Place place, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		initViewInstance();	
		valueChangeHandler = view.addValueChangeHandler((event) -> {
			clientFactory.getPlaceController().goTo(new FicheProduitPlace(event.getValue()));
		});
		view.addAddCartHandler((addCartEvent)->{
			PanierItem item = BeanSerializerUtils.createPanierItemInstance();
			item.setName(addCartEvent.getName());
			item.setPhotoFile(addCartEvent.getPhotoFile());
			item.setPrice(addCartEvent.getPrice());
			item.setQuantity(addCartEvent.getQuantity());
			item.setRef(addCartEvent.getRefProduct());
			AppContext.addOrUpdateItemPanier(item);
		});
	}

	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		gaTrackLog();
		//		GATracker.trackUniversalPageview("#accueil:","Page d'accueil");
		containerWidget.setWidget(view.asWidget());
		fetchAndSetBrandsAndCategories();
		fetchAndDisplayProducts();
	}
	
	protected abstract void fetchAndDisplayProducts();
	protected abstract void initViewInstance();
	protected abstract void gaTrackLog();

	protected void updateViewWithFetchedData(ArrayList<ProductDTO> list) {
		for (ProductDTO productDTO : list) {
			view.addItem(productDTO.getRef(), productDTO.getName(), productDTO.getPhotoFile(), productDTO.getPrice());
		}
	}
	
	@Override
	public void onStop() {
		super.onStop();
		if(valueChangeHandler!=null) valueChangeHandler.removeHandler();
	}
	
	@Override
	public void onCancel() {
		super.onCancel();
		if(valueChangeHandler!=null) valueChangeHandler.removeHandler();
	}

	private void fetchAndSetBrandsAndCategories() {
		ServiceLocator.getProductService().getBrandsAndCategories(new AbstractAsyncCallback<BrandAndCategoryDTO>() {

			@Override
			public void success(BrandAndCategoryDTO result) {
				view.setListBrands(result.getListBrands());
				view.setListCategories(result.getListCategories());
			}
		});
	}

}
