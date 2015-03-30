package com.dngconsulting.demo.client.view.impl;

import com.dngconsulting.demo.client.resources.AppMessage;
import com.dngconsulting.demo.client.resources.css.AppResources;
import com.dngconsulting.demo.client.view.Header;
import com.dngconsulting.demo.client.view.widgets.WarningPopup;
import com.google.gwt.animation.client.Animation;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

public class HeaderImpl extends Composite implements Header {

	private static HeaderUiBinder uiBinder = GWT.create(HeaderUiBinder.class);

	interface HeaderUiBinder extends UiBinder<Widget, HeaderImpl> {}

	@UiField Button toogleNavigationBtn;
	@UiField UListElement navBarUL;
	@UiField AppMessage i18n;
	@UiField AppResources res;
	
	public HeaderImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		SlideAnimation animation = new SlideAnimation(navBarUL,toogleNavigationBtn.getElement());
		toogleNavigationBtn.addClickHandler((event)->{
			animation.run(300);
		});
	}
	
	@UiHandler({"fb","twitter","linkedin", "dribble","gplus","account","wishlist","checkout","login"})
	public void onClickNotImplemented(ClickEvent event){
		WarningPopup popup = new WarningPopup(i18n.noImplementingFeatureWarnMessage());
		if(event.getSource() instanceof UIObject) popup.showRelativeTo((UIObject) event.getSource());
	}

	public class SlideAnimation extends Animation
	{
	    private final Element elem;
	    private final Element parent;
	    private boolean opening = false;

	    public SlideAnimation(Element widget, Element parent)
	    {
	        this.elem = widget;
	        this.parent = parent;
	    }

	    @Override
	    protected void onComplete()
	    {
	        if(! opening){
				parent.addClassName("collapsed");
				elem.addClassName(res.appstyle().collapse());
				elem.addClassName("collapse");
				elem.removeClassName("collapsing");
				elem.removeClassName("in");
		        elem.getStyle().setHeight(1, Unit.PX);
	        }
	        else{
				elem.removeClassName("collapsing");
				elem.addClassName("in");
		        elem.getStyle().setProperty("height", "auto");

	        }
	    }

	    @Override
	    protected void onStart()
	    {
	        super.onStart();
	        opening = ! opening;

	        if(opening)
	        {
	        	elem.getStyle().setHeight(0, Unit.PX);
				elem.addClassName("collapsing");
				parent.removeClassName("collapsed");
				elem.removeClassName("collapse");
				elem.removeClassName(res.appstyle().collapse());
	        }

	    }

	    @Override
	    protected void onUpdate(double progress)
	    {
	        int scrollHeight = elem.getPropertyInt("scrollHeight");
	        int height = (int) (progress * scrollHeight);
	        if( !opening )
	        {
	            height = scrollHeight - height;
	        }
	        height = Math.max(height, 1);
	        elem.getStyle().setHeight(height, Unit.PX);
	    }
	}
}
