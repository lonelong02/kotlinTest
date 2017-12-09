package com.wesai.kotlin.mvp;

import org.jetbrains.annotations.NotNull;

/**
 * Created by long on 2017/11/16.
 */

public class BasePresenterFactory<V extends IViewInterface, P extends IPresenterInterface<V>> implements IPresenterFactory{

    private Class<P> pClass;

    private BasePresenterFactory(Class<P> pClass) {
        this.pClass = pClass;

    }

    public static <V extends IViewInterface, P extends IPresenterInterface<V>> BasePresenterFactory<V, P> getFactory(Class<?> mClass) {
        if (mClass != null) {
            CreatePresenter cp = mClass.getAnnotation(CreatePresenter.class);
            if (cp != null) {
                return new BasePresenterFactory(cp.value());
            }
        }
        return null;
    }

    @NotNull
    @Override
    public P createPresenter() {
        try {
            return pClass != null ? pClass.newInstance() : null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
