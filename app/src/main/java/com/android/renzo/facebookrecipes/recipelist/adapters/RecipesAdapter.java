package com.android.renzo.facebookrecipes.recipelist.adapters;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.renzo.facebookrecipes.R;
import com.android.renzo.facebookrecipes.entities.Recipe;
import com.android.renzo.facebookrecipes.libs.base.ImageLoader;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.SendButton;
import com.facebook.share.widget.ShareButton;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by HOME on 27/06/2016.
 */
public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.ViewHolder> {


    private List<Recipe> recipeList;
    private ImageLoader imageLoader;
    private OnItemClickListener onItemClickLIstener;

    public RecipesAdapter(List<Recipe> recipeList, ImageLoader imageLoader, OnItemClickListener onItemClickLIstener) {
        this.recipeList = recipeList;
        this.imageLoader = imageLoader;
        this.onItemClickLIstener = onItemClickLIstener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.element_stored_recipes, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Recipe currentRecipe = recipeList.get(position);

        imageLoader.load(holder.imgRecipe, currentRecipe.getImageURL());
        holder.txtRecipeName.setText(currentRecipe.getTitle());
        holder.imgFav.setTag(currentRecipe.getFavorite());
        if(currentRecipe.getFavorite()){
            holder.imgFav.setImageResource(android.R.drawable.btn_star_big_on);
        }else{
            holder.imgFav.setImageResource(android.R.drawable.btn_star_big_off);
        }
        holder.setOnItemClickListener(currentRecipe, onItemClickLIstener);

    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipeList = recipes;
        notifyDataSetChanged();
    }

    public void removeRecipe(Recipe recipe) {
        recipeList.remove(recipe);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.imgRecipe)
        ImageView imgRecipe;
        @Bind(R.id.txtRecipeName)
        TextView txtRecipeName;
        @Bind(R.id.imgFav)
        ImageButton imgFav;
        @Bind(R.id.imgDelete)
        ImageButton imgDelete;
        @Bind(R.id.layoutButtons)
        LinearLayout layoutButtons;
        @Bind(R.id.fbShare)
        ShareButton fbShare;
        @Bind(R.id.fbSend)
        SendButton fbSend;

        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this,view);
        }

        public void setOnItemClickListener(final Recipe currentRecipe, final OnItemClickListener onItemClickLIstener) {
            view.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickLIstener.onItemClick(currentRecipe);
                }
            });

            imgFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickLIstener.onFavClick(currentRecipe);
                }
            });

            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickLIstener.onDeleteClick(currentRecipe);
                }
            });

            ShareLinkContent content = new ShareLinkContent.Builder()
                    .setContentUrl(Uri.parse(currentRecipe.getImageURL()))
                    .build();

            fbShare.setShareContent(content);
            fbSend.setShareContent(content);

        }
    }
}
