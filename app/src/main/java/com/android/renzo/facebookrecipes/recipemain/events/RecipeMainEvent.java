package com.android.renzo.facebookrecipes.recipemain.events;

import com.android.renzo.facebookrecipes.entities.Recipe;

import java.util.List;

/**
 * Created by HOME on 26/06/2016.
 */
public class RecipeMainEvent {
    private int type;
    private String error;
    private List<Recipe> recipes;

    public final static int NEXT_EVENT = 0;
    public final static int SAVE_EVENT = 1;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
