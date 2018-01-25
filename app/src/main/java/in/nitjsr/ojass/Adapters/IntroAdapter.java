package in.nitjsr.ojass.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Abhishek on 26-Jan-18.
 */

public class IntroAdapter extends PagerAdapter {

    private int[] slideLayouts;
    private Context context;

    public IntroAdapter(Context context, int[] slideLayouts){
        this.context = context;
        this.slideLayouts = slideLayouts;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(slideLayouts[position], container, false);
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
