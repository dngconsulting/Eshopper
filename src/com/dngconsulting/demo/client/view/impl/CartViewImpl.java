package com.dngconsulting.demo.client.view.impl;

import com.dngconsulting.demo.client.event.DeleteItemCartEvent;
import com.dngconsulting.demo.client.event.DeleteItemCartHandlers;
import com.dngconsulting.demo.client.resources.AppMessage;
import com.dngconsulting.demo.client.resources.css.AppResources;
import com.dngconsulting.demo.client.view.CartView;
import com.dngconsulting.demo.client.view.widgets.WarningPopup;
import com.dngconsulting.demo.shared.FormatHelper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.ParagraphElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

public class CartViewImpl extends Composite implements CartView {

	private static CartViewImplUiBinder uiBinder = GWT.create(CartViewImplUiBinder.class);

	interface CartViewImplUiBinder extends UiBinder<Widget, CartViewImpl> {}

	@UiField FlexTable cartTable;
	@UiField AppMessage i18n;
	@UiField AppResources style;
	@UiField Button checkoutBtn;
	@UiField SpanElement emptyLbl;
	
	interface DescCellTemplate extends SafeHtmlTemplates{
		@Template("<h4>{1}</h4><p>{2}: {0}</p>")
		SafeHtml descriptionTemplate(String ref, String name, String labelRef);
	}
	
	
	public CartViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		initHeaderTable();
		checkoutBtn.addClickHandler((e)->{
			if(cartTable.getRowCount()<=0){
				WarningPopup popup = new WarningPopup(AppMessage.MSG.emptyCartMessage());
				popup.showRelativeTo(checkoutBtn);
				return;
			}
			WarningPopup popup = new WarningPopup(AppMessage.MSG.cartCheckoutMessage());
			popup.center();
			popup.addCloseHandler((closeEvent)->{
				clearCart();
				CartViewImpl.this.fireEvent(new DeleteItemCartEvent(true));
			});
			Timer t = new Timer() {
				
				@Override
				public void run() {
					popup.hide();
				}
			};
			t.schedule(6000);
		});
	}
	
	public void clearCart(){
		UIObject.setVisible(emptyLbl, true);
		cartTable.removeAllRows();
	}
	
	public void addItem(String photoFile, String ref, String name, double price, int qty){
		if(UIObject.isVisible(emptyLbl)) UIObject.setVisible(emptyLbl, false);
		int row = cartTable.getRowCount();
		Widget itemcell = createItemCell(photoFile);
		SafeHtml desc = createDesc(ref, name);
		ParagraphElement priceP = Document.get().createPElement();
		priceP.setInnerHTML(FormatHelper.formatPrice(price));
		ParagraphElement qtyP = Document.get().createPElement();
		qtyP.setInnerHTML(""+qty);
		ParagraphElement totalP = Document.get().createPElement();
		totalP.setClassName(style.appstyle().cart_total_price());
		totalP.setInnerHTML(FormatHelper.formatPrice(price*qty));
		
		Widget deleteCell = createDeleteCell(ref);
		
		cartTable.setWidget(row, 0, itemcell);
		cartTable.setHTML(row, 1, desc);
		cartTable.setHTML(row, 2, priceP.getString());
		cartTable.setHTML(row, 3, qtyP.getString());
		cartTable.setHTML(row, 4, totalP.getString());
		cartTable.setWidget(row, 5, deleteCell);
		cartTable.getCellFormatter().setStyleName(row, 0, style.appstyle().cart_product());
		cartTable.getCellFormatter().setStyleName(row, 1, style.appstyle().cart_description());
		cartTable.getCellFormatter().setStyleName(row, 2, style.appstyle().cart_price());
		cartTable.getCellFormatter().setStyleName(row, 3, style.appstyle().cart_quantity());
		cartTable.getCellFormatter().setStyleName(row, 5, style.appstyle().cart_delete());
	}
	

	@Override
	public HandlerRegistration addDeleteItemCartHandler(DeleteItemCartHandlers handler) {
		return addHandler(handler, DeleteItemCartEvent.TYPE);
	}

	private void initHeaderTable() {
		Element headNode = Document.get().createTHeadElement();
		Element tr = Document.get().createTRElement();
		tr.setClassName(style.appstyle().cart_menu());
		Element tdImg = Document.get().createTDElement();
		tdImg.setClassName(style.appstyle().img());
		tdImg.setInnerText(i18n.item());
		tr.appendChild(tdImg);
		Element tdDesc = Document.get().createTDElement();
		tr.appendChild(tdDesc);
		Element tdPrice = Document.get().createTDElement();
		tdPrice.setInnerText(i18n.price());
		tr.appendChild(tdPrice);
		Element tdQty = Document.get().createTDElement();
		tdQty.setInnerText(i18n.quantity());
		tr.appendChild(tdQty);
		Element tdTotal = Document.get().createTDElement();
		tdTotal.setInnerText(i18n.total());
		tr.appendChild(tdTotal);
		tr.appendChild(Document.get().createTDElement());
		
		headNode.insertFirst(tr);
		
		cartTable.getElement().insertFirst(headNode);
	}

	private Widget createItemCell(String photoFile){
		Anchor a = new Anchor();
		a.setHTML(SafeHtmlUtils.fromTrustedString("<img src='"+photoFile+"' width='110px'/>"));
//		a.addClickHandler((event)->{});
		return a;
	}

	private Widget createDeleteCell(String ref){
		Anchor a = new Anchor();
		a.setStyleName("cart_quantity_delete");
		a.setHTML(SafeHtmlUtils.fromTrustedString("<i class=\"fa fa-times\"></i>"));
		a.addClickHandler((event)->{
			int rowToRemove = -1;
			for(int i = 0; i< cartTable.getRowCount(); i++){
				String desc = cartTable.getText(i, 1);
				if(desc.contains(ref)){
					rowToRemove = i;
					break;
				}
			}
			if(rowToRemove!=-1) cartTable.removeRow(rowToRemove);
			CartViewImpl.this.fireEvent(new DeleteItemCartEvent(ref));
			if(cartTable.getRowCount()==0) UIObject.setVisible(emptyLbl, true);
		});
		return a;
	}
	
	private SafeHtml createDesc(String ref, String name){
		DescCellTemplate desc = GWT.create(DescCellTemplate.class); 
		return desc.descriptionTemplate(ref, name, i18n.reference());
	}

}
