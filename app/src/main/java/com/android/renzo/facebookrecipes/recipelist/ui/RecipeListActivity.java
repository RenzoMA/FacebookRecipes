package com.android.renzo.facebookrecipes.recipelist.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.android.renzo.facebookrecipes.FacebookRecipesApp;
import com.android.renzo.facebookrecipes.R;
import com.android.renzo.facebookrecipes.entities.Recipe;
import com.android.renzo.facebookrecipes.recipelist.RecipeListPresenter;
import com.android.renzo.facebookrecipes.recipelist.adapters.OnItemClickLIstener;
import com.android.renzo.facebookrecipes.recipelist.adapters.RecipesAdapter;
import com.android.renzo.facebookrecipes.recipemain.ui.RecipeMainActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecipeListActivity extends AppCompatActivity implements RecipeListView, OnItemClickLIstener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    RecipesAdapter adapter;
    RecipeListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        ButterKnife.bind(this);
        setupToolbar();
        setupInjection();
        setupRecyclervView();

        presenter.onCreate();
        presenter.getRecipes();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recipes_list, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.action_main){
            navigateMainScreen();
        }else if (id == R.id.action_logout){
            logout();
        }

        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FacebookRecipesApp app = (FacebookRecipesApp)getApplication();
        app.logout();
    }
    private void navigateMainScreen() {
        startActivity(new Intent(this, RecipeMainActivity.class));
    }

    private void setupInjection() {
    }

    private void setupRecyclervView() {
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(adapter);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
    }

    @OnClick(R.id.toolbar)
    public void onToolbarClick(){
        recyclerView.smoothScrollToPosition(0);
    }

    @Override
    public void setRecipes(List<Recipe> data) {
        adapter.setRecipes(data);
    }

    @Override
    public void recipeUpdated() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void recipeDeleted(Recipe recipe) {
        adapter.removeRecipe(recipe);
    }

    @Override
    public void onFavClick(Recipe recipe) {
        presenter.toggleFavorite(recipe);
    }

    @Override
    public void onDeleteClick(Recipe recipe) {
        presenter.removeRecipe(recipe);
    }

    @Override
    public void onItemClick(Recipe recipe) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(recipe.getSourceURL()));
        startActivity(intent);

    }
}
