package com.android.renzo.facebookrecipes.recipelist.di;

import com.android.renzo.facebookrecipes.libs.base.ImageLoader;
import com.android.renzo.facebookrecipes.libs.di.LibsModule;
import com.android.renzo.facebookrecipes.recipelist.RecipeListPresenter;
import com.android.renzo.facebookrecipes.recipelist.adapters.RecipesAdapter;
import com.android.renzo.facebookrecipes.recipemain.RecipeMainPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by HOME on 26/06/2016.
 */
@Singleton
@Component(modules = {RecipeListModule.class, LibsModule.class})
public interface RecipeListComponent {
    RecipesAdapter getAdapter();
    RecipeListPresenter getPresenter();

}
