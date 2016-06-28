package com.android.renzo.facebookrecipes.recipelist;

import com.android.renzo.facebookrecipes.entities.Recipe;

/**
 * Created by HOME on 27/06/2016.
 */
public interface StoredRecipesInteractor {
    void executeUpdate(Recipe recipe);
    void executeDelete(Recipe recipe);
}
