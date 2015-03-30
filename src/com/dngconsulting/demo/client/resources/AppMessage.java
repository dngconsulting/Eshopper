package com.dngconsulting.demo.client.resources;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.i18n.client.Messages;

public interface AppMessage extends Messages {
	
	public static final AppMessage MSG = GWT.create(AppMessage.class);
	

	@Key("account")
	@DefaultMessage("Compte")
	String account();
	
	@Key("wishlist")
	@DefaultMessage("Favoris")
	String wishlist();
	
	@Key("checkout")
	@DefaultMessage("Payer")
	String checkout();
	
	@Key("cart")
	@DefaultMessage("Panier")
	String cart();
	
	@Key("login")
	@DefaultMessage("Connexion")
	String login();
	
	
	@Key("home")
	@DefaultMessage("Accueil")
	String home();
	
	@Key("shop")
	@DefaultMessage("Magasin")
	String shop();
	
	@Key("blog")
	@DefaultMessage("Blog")
	String blog();
	
	@Key("contact")
	@DefaultMessage("Contact")
	String contact();

	@Key("home.slider.title")
	@DefaultMessage("Demonstrateur GWT par DNG Consulting")
	String home_slider_title();
	
	@Key("home.slider.message")
	@DefaultMessage("Cette application est un démonstrateur GWT permettant de mettre en avant certaines possibilités du framework.")
	String home_slider_message();
	
	@Key("all.products")
	@DefaultMessage("Tous les produits")
	String allProducts();
	
	@Key("new.products")
	@DefaultMessage("Nouveautés")
	String newProducts();
	
	@Key("search")
	@DefaultMessage("Recherche")
	String search();
	
	
	@Key("category")
	@DefaultMessage("Categorie")
	String category();
	
	@Key("brands")
	@DefaultMessage("Marques")
	String brands();
	
	@Key("features.items")
	@DefaultMessage("Articles à la une")
	String features_items();
	
	@Key("add.cart")
	@DefaultMessage("Ajouter")
	String addToCart();
	
	@Key("see.details")
	@DefaultMessage("Détails")
	String seeDetails();
	
	@Key("all.items")
	@DefaultMessage("Tous les articles")
	String allItems();
	
	@Key("new.items")
	@DefaultMessage("Nouveautés")
	String newItems();
	
	@Key("reference")
	@DefaultMessage("Référence")
	String reference();

	@Key("availability")
	@DefaultMessage("Disponibilité")
	String availability();

	@Key("instock")
	@DefaultMessage("En stock")
	String instock();
	
	@Key("brand")
	@DefaultMessage("Marque")
	String brand();
	
	@Key("quantity")
	@DefaultMessage("Quantité")
	String quantity();
	
	@Key("details")
	@DefaultMessage("Détails")
	String details();
	
	@Key("item")
	@DefaultMessage("article")
	String item();
	
	@Key("price")
	@DefaultMessage("Prix")
	String price();
	
	@Key("total")
	@DefaultMessage("Total")
	String total();

	@Key("noimplementingfeature.warn.message")
	@DefaultMessage("Le démonstrateur n''implémente pas cette fonction...")
	String noImplementingFeatureWarnMessage();
	

	@Key("quantity.error.message")
	@DefaultMessage("Quantité doit être un entier supérieur à 0")
	String quantityErrorMessage();
	

	@Key("contact.directions.title")
	@DefaultMessage("Trajet pour venir")
	String directionsTitle();
	

	@Key("contact.info.title")
	@DefaultMessage("Information Contact")
	String contactInfoTitle();
	
	
	
}
