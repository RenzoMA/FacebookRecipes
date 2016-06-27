package com.android.renzo.facebookrecipes.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HOME on 26/06/2016.
 */
public class RecipeClient {

    private Retrofit retrofit;
    private final static String BASE_URL = "http://private-anon-f47dd0e5a-themoviedb.apiary-mock.com/3/movie/";

    public RecipeClient() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public RecipeService getRecipeService(){
        return this.retrofit.create(RecipeService.class);
    }
}
