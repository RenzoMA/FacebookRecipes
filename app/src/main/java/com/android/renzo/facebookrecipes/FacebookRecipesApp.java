package com.android.renzo.facebookrecipes;

import android.app.Application;
import android.content.Intent;

import com.android.renzo.facebookrecipes.libs.di.LibsModule;
import com.android.renzo.facebookrecipes.login.ui.LoginActivity;
import com.android.renzo.facebookrecipes.recipelist.adapters.OnItemClickListener;
import com.android.renzo.facebookrecipes.recipelist.di.DaggerRecipeListComponent;
import com.android.renzo.facebookrecipes.recipelist.di.RecipeListComponent;
import com.android.renzo.facebookrecipes.recipelist.di.RecipeListModule;
import com.android.renzo.facebookrecipes.recipelist.ui.RecipeListActivity;
import com.android.renzo.facebookrecipes.recipelist.ui.RecipeListView;
import com.android.renzo.facebookrecipes.recipemain.di.DaggerRecipeMainComponent;
import com.android.renzo.facebookrecipes.recipemain.di.RecipeMainComponent;
import com.android.renzo.facebookrecipes.recipemain.di.RecipeMainModule;
import com.android.renzo.facebookrecipes.recipemain.ui.RecipeMainActivity;
import com.android.renzo.facebookrecipes.recipemain.ui.RecipeMainView;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
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

    public void logout() {
        LoginManager.getInstance().logOut();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public RecipeMainComponent getRecipeMainComponent(RecipeMainActivity activity, RecipeMainView view){
        return DaggerRecipeMainComponent
                .builder()
                .libsModule(new LibsModule(activity))
                .recipeMainModule(new RecipeMainModule(view))
                .build();
    }
    public RecipeListComponent getRecipeListComponent(RecipeListActivity activity, RecipeListView view, OnItemClickListener itemClickListener){
        return DaggerRecipeListComponent
                .builder()
                .libsModule(new LibsModule(activity))
                .recipeListModule(new RecipeListModule(view,itemClickListener))
                .build();
    }
}
