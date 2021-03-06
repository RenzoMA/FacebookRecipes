package com.android.renzo.facebookrecipes.api;

import com.android.renzo.facebookrecipes.entities.Recipe;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by HOME on 26/06/2016.
 */
public class RecipeSearchResponse {

    @SerializedName("page")
    private int count;

    @SerializedName("results")
    private List<Recipe> recipes;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Recipe getFirstRecipe(){
        Recipe first = null;
        if(!recipes.isEmpty()){
            first = recipes.get(0);
        }
        return first;
    }
}
