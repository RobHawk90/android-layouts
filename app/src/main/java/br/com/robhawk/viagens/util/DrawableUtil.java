package br.com.robhawk.viagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class DrawableUtil {

    private static final String DRAWABLE = "drawable";

    public static Drawable getDrawable(Context context, String drawableName) {
        Resources resources = context.getResources();
        int drawableId = resources.getIdentifier(drawableName, DRAWABLE, context.getPackageName());
        return resources.getDrawable(drawableId);
    }

}
