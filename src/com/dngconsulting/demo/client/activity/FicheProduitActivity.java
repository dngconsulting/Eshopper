package com.dngconsulting.demo.client.activity;

import com.dngconsulting.demo.client.AppContext;
import com.dngconsulting.demo.client.ClientFactory;
import com.dngconsulting.demo.client.localstorage.BeanSerializerUtils;
import com.dngconsulting.demo.client.places.FicheProduitPlace;
import com.dngconsulting.demo.client.services.AbstractAsyncCallback;
import com.dngconsulting.demo.client.services.ServiceLocator;
import com.dngconsulting.demo.client.view.ProductDetailsView;
import com.dngconsulting.demo.shared.PanierItem;
import com.dngconsulting.demo.shared.ProductDTO;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class FicheProduitActivity extends AbstractActivity {
	private ClientFactory clientFactory;
	private FicheProduitPlace place;
	private ProductDetailsView view;
	
	public FicheProduitActivity(FicheProduitPlace place, ClientFactory clientFactory) {	
		this.clientFactory = clientFactory;
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
//		AppContext.trackUniversalPageview(AppContext.getGa(),"#!ficheproduit:" + place.id,"Affichage du produit " + place.id);
		AppContext.getGa().trackUniversalPageview("#!ficheproduit:" + place.id,"Affichage du produit " + place.id);
		Window.scrollTo(0, 0);
		view = clientFactory.getFicheproduitview();		
		containerWidget.setWidget(view.asWidget());
		alimenteProductsByRef();
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
	
	private void alimenteProductsByRef(){
		ServiceLocator.getProductService().getProductDetail(place.id,new AbstractAsyncCallback<ProductDTO>() {
			
			@Override
			public void success(ProductDTO p) {
				view.setRef(p.getRef());
				view.setName(p.getName());
				view.setImageUrl(p.getPhotoFile());
				view.setBrand(p.getBrand());
				view.setCategory(p.getCategory());
				view.setDescription(p.getDescription());
				view.setPrice(p.getPrice());
				view.setNewProduct(p.isNew());
			}
					
		});
	}
	
}