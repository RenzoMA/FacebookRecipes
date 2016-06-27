package com.android.renzo.facebookrecipes.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by HOME on 26/06/2016.
 */
public interface RecipeService {
    @GET("popular")
    Call<RecipeSearchResponse> search(//@Query("key") String key,
                                      //@Query("sort") String sort,
                                      //@Query("count") int count,
                                      //@Path("id") int page);
    );
}