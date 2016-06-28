package com.android.renzo.facebookrecipes.recipelist;

import com.android.renzo.facebookrecipes.entities.Recipe;

/**
 * Created by HOME on 27/06/2016.
 */
public interface RecipeListRepository {
    void getSavedRecipes();
    void updateRecipe(Recipe recipe);
    void removeRecipe(Recipe recipe);
}
