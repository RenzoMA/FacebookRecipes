package com.android.renzo.facebookrecipes.recipelist;

/**
 * Created by HOME on 27/06/2016.
 */
public class RecipeListInteractorImpl implements RecipeListInteractor {
    private RecipeListRepository repository;

    public RecipeListInteractorImpl(RecipeListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getSavedRecipes();
    }
}
