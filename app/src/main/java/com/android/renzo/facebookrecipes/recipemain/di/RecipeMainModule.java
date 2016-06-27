package com.android.renzo.facebookrecipes.recipemain.di;

import com.android.renzo.facebookrecipes.api.RecipeClient;
import com.android.renzo.facebookrecipes.api.RecipeService;
import com.android.renzo.facebookrecipes.libs.base.EventBus;
import com.android.renzo.facebookrecipes.recipemain.GetNextRecipeInteractor;
import com.android.renzo.facebookrecipes.recipemain.GetNextRecipeInteractorImpl;
import com.android.renzo.facebookrecipes.recipemain.RecipeMainPresenter;
import com.android.renzo.facebookrecipes.recipemain.RecipeMainPresenterImpl;
import com.android.renzo.facebookrecipes.recipemain.RecipeMainRepository;
import com.android.renzo.facebookrecipes.recipemain.RecipeMainRepositoryImpl;
import com.android.renzo.facebookrecipes.recipemain.SaveRecipeInteractor;
import com.android.renzo.facebookrecipes.recipemain.SaveRecipeInteractorImpl;
import com.android.renzo.facebookrecipes.recipemain.ui.RecipeMainView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HOME on 26/06/2016.
 */
@Module
public class RecipeMainModule {
    RecipeMainView view;

    public RecipeMainModule(RecipeMainView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    RecipeMainView providesRecipeMainView(){
        return this.view;
    }

    @Provides
    @Singleton
    RecipeMainPresenter providesRecipeMainPresenter(EventBus eventBus, RecipeMainView view, SaveRecipeInteractor saveInteractor, GetNextRecipeInteractor getNextInteractor){
        return new RecipeMainPresenterImpl(eventBus,view,saveInteractor,getNextInteractor);
    }

    @Provides
    @Singleton
    SaveRecipeInteractor providesSaveRecipeInteractor(RecipeMainRepository repository){
        return new SaveRecipeInteractorImpl(repository);
    }

    @Provides
    @Singleton
    GetNextRecipeInteractor providesGetNextRecipeInteractor(RecipeMainRepository repository){
        return new GetNextRecipeInteractorImpl(repository);
    }

    @Provides
    @Singleton
    RecipeMainRepository providesRecipeMainRepository(EventBus eventBus, RecipeService service){
        return new RecipeMainRepositoryImpl(eventBus,service);
    }

    @Provides
    @Singleton
    RecipeService providesRecipeService(){
        return new RecipeClient().getRecipeService();
    }

}
