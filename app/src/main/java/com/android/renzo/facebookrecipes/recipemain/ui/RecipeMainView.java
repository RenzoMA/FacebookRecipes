package com.android.renzo.facebookrecipes.recipemain.ui;

import com.android.renzo.facebookrecipes.entities.Recipe;

/**
 * Created by HOME on 26/06/2016.
 */
public interface RecipeMainView {
    void showProgress();
    void hideProgress();

    void showUIElements();
    void hideUIElements();
    void saveAnimation();
    void dismissAnimation();

    void onRecipeSaved();
    void setRecipe(Recipe recipe);
    void onGetRecipeError(String error);



}
