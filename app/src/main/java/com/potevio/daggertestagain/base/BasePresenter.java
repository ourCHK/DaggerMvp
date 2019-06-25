package com.potevio.daggertestagain.base;

/**
 * Created by CHK on 19-6-25.
 */
public abstract class BasePresenter<V extends BaseView> {

    protected  V baseView;

    protected void onAttach(V v) {
        this.baseView = v;
    }

    protected void detach() {
        if (baseView != null) {
            baseView = null;
        }
    }

    protected abstract V getView();

}
