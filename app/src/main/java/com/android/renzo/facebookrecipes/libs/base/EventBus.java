package com.android.renzo.facebookrecipes.libs.base;

/**
 * Created by HOME on 26/06/2016.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
