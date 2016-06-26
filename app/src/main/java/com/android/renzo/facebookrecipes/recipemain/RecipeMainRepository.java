package com.android.renzo.facebookrecipes.recipemain;

import com.android.renzo.facebookrecipes.entities.Recipe;

/**
 * Created by HOME on 26/06/2016.
 */
public interface RecipeMainRepository {

    public final static int COUNT = 1;
    public final static String RECENT_SORT = "r";
    public final static int RECIPE_RANGE = 100000;


    void getNextRecipe();
    void saveRecipe(Recipe recipe);
    void setRecipePage(int recipePage);
}
