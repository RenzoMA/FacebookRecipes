package com.android.renzo.facebookrecipes.recipemain;

import com.android.renzo.facebookrecipes.entities.Recipe;
import com.android.renzo.facebookrecipes.recipemain.events.RecipeMainEvent;
import com.android.renzo.facebookrecipes.recipemain.ui.RecipeMainView;

/**
 * Created by HOME on 26/06/2016.
 */
public interface RecipeMainPresenter {
    void onCreate();
    void onDestroy();

    void dismissRecipe();
    void getNextRecipe();
    void saveRecipe(Recipe recipe);
    void onEventMainThread(RecipeMainEvent event);

    void imageReady();
    void imageError(String error);

    RecipeMainView getView();
}
