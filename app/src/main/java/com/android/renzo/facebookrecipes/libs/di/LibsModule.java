package com.android.renzo.facebookrecipes.libs.di;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.android.renzo.facebookrecipes.libs.GlideImageLoader;
import com.android.renzo.facebookrecipes.libs.GreenRobotEventBus;
import com.android.renzo.facebookrecipes.libs.base.EventBus;
import com.android.renzo.facebookrecipes.libs.base.ImageLoader;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HOME on 26/06/2016.
 */
@Module
public class LibsModule {
    private Activity activity;

    public LibsModule(Fragment fragment) {
        this.activity = activity;
    }

    @Provides
    @Singleton
    ImageLoader providesImageLoader(RequestManager requestManager){
        return new GlideImageLoader(requestManager);
    }

    @Provides
    @Singleton
    RequestManager providesRequestManager(Fragment fragment){
        return  Glide.with(fragment);
    }

    @Provides
    @Singleton
    Activity providesActivity(){
        return this.activity;
    }

    @Provides
    @Singleton
    EventBus providesEventBus(org.greenrobot.eventbus.EventBus eventBus){
        return new GreenRobotEventBus(eventBus);
    }

    @Provides
    @Singleton
    org.greenrobot.eventbus.EventBus providesLibraryEventBus(){
        return org.greenrobot.eventbus.EventBus.getDefault();
    }
}
