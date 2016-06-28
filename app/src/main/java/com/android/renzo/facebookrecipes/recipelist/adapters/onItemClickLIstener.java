package com.android.renzo.facebookrecipes.recipelist.adapters;

import com.android.renzo.facebookrecipes.entities.Recipe;

/**
 * Created by HOME on 27/06/2016.
 */
public interface OnItemClickLIstener {
    void onFavClick(Recipe recipe);
    void onDeleteClick(Recipe recipe);
    void onItemClick(Recipe recipe);
}
