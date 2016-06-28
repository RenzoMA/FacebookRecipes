package com.android.renzo.facebookrecipes.recipelist;

import com.android.renzo.facebookrecipes.entities.Recipe;
import com.android.renzo.facebookrecipes.recipelist.events.RecipeListEvent;
import com.android.renzo.facebookrecipes.recipelist.ui.RecipeListView;

/**
 * Created by HOME on 27/06/2016.
 */
public interface RecipeListPresenter {
    void onCreate();
    void onDestroy();
    void getRecipes();
    void removeRecipe(Recipe recipe);
    void toggleFavorite(Recipe recipe);
    void onEventMainThread(RecipeListEvent event);

    RecipeListView getView();
}
