package com.android.renzo.facebookrecipes;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by HOME on 26/06/2016.
 */
public class FacebookRecipesApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initFacebook();
        initDB();
    }

    private void initDB() {
        FlowManager.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        DBTearDown();
    }

    private void DBTearDown() {
        FlowManager.destroy();
    }

    private void initFacebook() {
        FacebookSdk.sdkInitialize(this);

    }



}
