package com.android.renzo.facebookrecipes.recipemain.di;

import com.android.renzo.facebookrecipes.libs.base.ImageLoader;
import com.android.renzo.facebookrecipes.libs.di.LibsModule;
import com.android.renzo.facebookrecipes.recipemain.RecipeMainPresenter;
import com.android.renzo.facebookrecipes.recipemain.ui.RecipeMainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by HOME on 26/06/2016.
 */
@Singleton
@Component(modules = {RecipeMainModule.class, LibsModule.class})
public interface RecipeMainComponent {
    //void inject(RecipeMainActivity activity);
    ImageLoader getImageLoader();
    RecipeMainPresenter getPresenter();

}
