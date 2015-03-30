package com.dngconsulting.demo.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

public abstract class AbstractAsyncCallback<T> implements AsyncCallback<T> {


    public void failure(Throwable caught) {
    };

    @Override
    public final void onFailure(Throwable caught) {
//        Log.error(caught.getMessage(),caught);
    	failure(caught);
    }

    public final void onSuccess(T result) {
        success(result);
    }

    public abstract void success(T result);
}