package com.android.renzo.facebookrecipes.recipelist;

import com.android.renzo.facebookrecipes.entities.Recipe;

/**
 * Created by HOME on 27/06/2016.
 */
public class StoredRecipesInteractorImpl implements StoredRecipesInteractor {

    private RecipeListRepository repository;

    public StoredRecipesInteractorImpl(RecipeListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void executeUpdate(Recipe recipe) {
        repository.updateRecipe(recipe);
    }

    @Override
    public void executeDelete(Recipe recipe) {
        repository.removeRecipe(recipe);
    }
}
