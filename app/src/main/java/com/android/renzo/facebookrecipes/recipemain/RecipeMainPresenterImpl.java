package com.android.renzo.facebookrecipes.recipemain;

import com.android.renzo.facebookrecipes.entities.Recipe;
import com.android.renzo.facebookrecipes.libs.base.EventBus;
import com.android.renzo.facebookrecipes.recipemain.events.RecipeMainEvent;
import com.android.renzo.facebookrecipes.recipemain.ui.RecipeMainView;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * Created by HOME on 26/06/2016.
 */
public class RecipeMainPresenterImpl implements RecipeMainPresenter {

    private EventBus eventBus;
    private RecipeMainView view;
    SaveRecipeInteractor saveInteractor;
    GetNextRecipeInteractor getNextInteractor;
    private List<Recipe> recipes;

    public RecipeMainPresenterImpl(EventBus eventBus, RecipeMainView view, SaveRecipeInteractor saveInteractor, GetNextRecipeInteractor getNextInteractor) {
        this.eventBus = eventBus;
        this.view = view;
        this.saveInteractor = saveInteractor;
        this.getNextInteractor = getNextInteractor;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);

    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
        view = null;
    }

    @Override
    public void dismissRecipe() {
        if(this.view != null){
            view.dismissAnimation();
        }
        getNextRecipe();

    }

    @Override
    public void getNextRecipe() {
        if(this.view != null){
            view.hideUIElements();
            view.showProgress();
        }

        if(recipes != null && recipes.size() > 0){
            view.setRecipe(recipes.get(0));
            recipes.remove(0);
        }else {
            getNextInteractor.execute();
        }
    }

    @Override
    public void saveRecipe(Recipe recipe) {
        if(this.view != null){
            view.saveAnimation();
            view.hideUIElements();
            view.showProgress();
        }
        saveInteractor.execute(recipe);
    }

    @Override
    @Subscribe
    public void onEventMainThread(RecipeMainEvent event) {
        if(this.view != null){
            String error = event.getError();
            if(error != null){
                view.hideProgress();
                view.onGetRecipeError(error);
            }else{
                if(event.getType() == RecipeMainEvent.NEXT_EVENT){
                    recipes = event.getRecipes();
                    view.setRecipe(recipes.get(0));
                }else if (event.getType() == RecipeMainEvent.SAVE_EVENT){
                    view.onRecipeSaved();
                    if(recipes != null && recipes.size() > 0){
                        view.setRecipe(recipes.get(0));
                        recipes.remove(0);
                    }else {
                        getNextInteractor.execute();
                    }
                }
            }
        }

    }

    @Override
    public void imageReady() {
        if(this.view != null){
            view.hideProgress();
            view.showUIElements();
        }

    }

    @Override
    public void imageError(String error) {
        if(this.view != null) {
            view.onGetRecipeError(error);
        }
    }

    @Override
    public RecipeMainView getView() {
        return null;
    }
}
