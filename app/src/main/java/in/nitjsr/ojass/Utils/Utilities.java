package in.nitjsr.ojass.Utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import in.nitjsr.ojass.R;

/**
 * Created by Abhishek on 26-Jan-18.
 */

public class Utilities {

    public static void changeStatusBarColor(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
    }

    public static void setPicassoImage(final Context context, final String imgSrc, final ImageView iv, final int FLAG){
        if (FLAG == Constants.SQUA_PLACEHOLDER){
            Picasso.with(context).load(imgSrc).placeholder(R.drawable.placeholder_sqaure).fit().networkPolicy(NetworkPolicy.OFFLINE).into(iv, new Callback() {
                @Override
                public void onSuccess() {

                }

                @Override
                public void onError() {
                    Picasso.with(context).load(imgSrc).placeholder(R.drawable.placeholder_sqaure).fit().into(iv);
                }
            });
        } else {
            Picasso.with(context).load(imgSrc).placeholder(R.drawable.placeholder_rect).fit().networkPolicy(NetworkPolicy.OFFLINE).into(iv, new Callback() {
                @Override
                public void onSuccess() {

                }

                @Override
                public void onError() {
                    Picasso.with(context).load(imgSrc).placeholder(R.drawable.placeholder_rect).fit().into(iv);
                }
            });
        }
    }
}
