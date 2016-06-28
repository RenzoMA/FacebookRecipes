package com.android.renzo.facebookrecipes.recipelist.di;

import com.android.renzo.facebookrecipes.entities.Recipe;
import com.android.renzo.facebookrecipes.libs.base.EventBus;
import com.android.renzo.facebookrecipes.libs.base.ImageLoader;
import com.android.renzo.facebookrecipes.recipelist.RecipeListInteractor;
import com.android.renzo.facebookrecipes.recipelist.RecipeListInteractorImpl;
import com.android.renzo.facebookrecipes.recipelist.RecipeListPresenter;
import com.android.renzo.facebookrecipes.recipelist.RecipeListPresenterImpl;
import com.android.renzo.facebookrecipes.recipelist.RecipeListRepository;
import com.android.renzo.facebookrecipes.recipelist.RecipeListRepositoryImpl;
import com.android.renzo.facebookrecipes.recipelist.StoredRecipesInteractor;
import com.android.renzo.facebookrecipes.recipelist.StoredRecipesInteractorImpl;
import com.android.renzo.facebookrecipes.recipelist.adapters.OnItemClickListener;
import com.android.renzo.facebookrecipes.recipelist.adapters.RecipesAdapter;
import com.android.renzo.facebookrecipes.recipelist.ui.RecipeListView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HOME on 26/06/2016.
 */
@Module
public class RecipeListModule {
    RecipeListView view;
    OnItemClickListener onItemClickListener;

    public RecipeListModule(RecipeListView view, OnItemClickListener onItemClickListener) {
        this.view = view;
        this.onItemClickListener = onItemClickListener;
    }

    @Provides @Singleton
    RecipeListView provideRecipeListView() {
        return this.view;
    }

    @Provides @Singleton
    RecipeListPresenter provideRecipeListPresenter(EventBus eventBus, RecipeListView view, RecipeListInteractor listInteractor, StoredRecipesInteractor storedInteractor) {
        return new RecipeListPresenterImpl(eventBus, view, listInteractor, storedInteractor);
    }

    @Provides @Singleton
    RecipeListInteractor provideRecipeListInteractor(RecipeListRepository repository) {
        return new RecipeListInteractorImpl(repository);
    }

    @Provides @Singleton
    StoredRecipesInteractor provideStoredRecipesInteractor(RecipeListRepository repository) {
        return new StoredRecipesInteractorImpl(repository);
    }

    @Provides @Singleton
    RecipeListRepository provideRecipeListRepository(EventBus eventBus) {
        return new RecipeListRepositoryImpl(eventBus);
    }

    @Provides @Singleton
    RecipesAdapter provideRecipesAdapter(List<Recipe> recipes, ImageLoader imageLoader, OnItemClickListener onItemClickListener) {
        return new RecipesAdapter(recipes, imageLoader, onItemClickListener);
    }

    @Provides @Singleton
    OnItemClickListener provideOnItemClickListener() {
        return this.onItemClickListener;
    }

    @Provides @Singleton
    List<Recipe> provideRecipesList() {
        return new ArrayList<Recipe>();
    }


}
