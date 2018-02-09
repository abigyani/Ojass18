package in.nitjsr.ojass.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import in.nitjsr.ojass.Activities.Walkthrough;
import in.nitjsr.ojass.R;
import in.nitjsr.ojass.Utils.Constants;
import in.nitjsr.ojass.Utils.Utilities;

/**
 * Created by Abhishek on 26-Jan-18.
 */

public class IntroAdapter extends PagerAdapter {

    private int[] slideLayouts;
    private int[] slideLayoutsImageView;
    private Context context;
    private ImageView iv;
    private static final String sliderUrl[] = {
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/WalkthroughImages%2FQR.png?alt=media&token=c5b68989-2ccf-4fda-a749-89e69ef1542e",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/WalkthroughImages%2FACT%20IND.png?alt=media&token=fff0d0f7-f9ff-437c-b1c3-ea3de32a84be",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/WalkthroughImages%2FApp%20Map.png?alt=media&token=92413930-09e8-49d7-96cb-7a4153795a90",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/WalkthroughImages%2FLOC.png?alt=media&token=e8aaddbc-5c87-40fa-b19b-f12e550e608d"
    };

    public IntroAdapter(Context context, int[] slideLayouts, int[] slideLayoutsImageView){
        this.context = context;
        this.slideLayouts = slideLayouts;
        this.slideLayoutsImageView = slideLayoutsImageView;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(slideLayouts[position], container, false);
        iv = view.findViewById(slideLayoutsImageView[position]);

        if (position == 0) Picasso.with(context).load(R.drawable.intro_qr).placeholder(R.drawable.placeholder_rect).fit().into(iv);
        else if (position == 1) Picasso.with(context).load(R.drawable.intro_event).placeholder(R.drawable.placeholder_rect).fit().into(iv);
        else Utilities.setPicassoImage(context, sliderUrl[position], iv, Constants.RECT_PLACEHOLDER);


        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return slideLayouts.length;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


}
