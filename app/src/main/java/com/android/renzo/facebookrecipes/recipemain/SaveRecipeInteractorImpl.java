package com.android.renzo.facebookrecipes.recipemain;

import com.android.renzo.facebookrecipes.entities.Recipe;

/**
 * Created by HOME on 26/06/2016.
 */
public class SaveRecipeInteractorImpl implements SaveRecipeInteractor {

    RecipeMainRepository repository;

    public SaveRecipeInteractorImpl(RecipeMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Recipe recipe) {
        repository.saveRecipe(recipe);
    }
}
