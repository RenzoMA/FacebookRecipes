package com.android.renzo.facebookrecipes.libs.base;

import android.widget.ImageView;

/**
 * Created by HOME on 26/06/2016.
 */
public interface ImageLoader {
    void load(ImageView imageView, String URL);
    void setOnFinishedImageLoadingListener(Object listener);
}
