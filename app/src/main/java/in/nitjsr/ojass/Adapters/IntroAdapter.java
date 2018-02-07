package in.nitjsr.ojass.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import in.nitjsr.ojass.Activities.Walkthrough;

/**
 * Created by Abhishek on 26-Jan-18.
 */

public class IntroAdapter extends PagerAdapter {

    private int[] slideLayouts;
    private int[] slideLayoutsImageView;
    private Context context;
    private ImageView iv;

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
        Picasso.with(context).load(Walkthrough.sliderUrl[position]).fit().into(iv);

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
