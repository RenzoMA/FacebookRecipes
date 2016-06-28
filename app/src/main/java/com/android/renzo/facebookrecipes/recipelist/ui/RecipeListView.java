package com.android.renzo.facebookrecipes.recipelist.ui;

import com.android.renzo.facebookrecipes.entities.Recipe;

import java.util.List;

/**
 * Created by HOME on 27/06/2016.
 */
public interface RecipeListView {
    void setRecipes(List<Recipe> data);
    void recipeUpdated();
    void recipeDeleted(Recipe recipe);
}
