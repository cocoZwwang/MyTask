package com.rwby.mytask;

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
