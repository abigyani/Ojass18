package in.nitjsr.ojass.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import in.nitjsr.ojass.R;

/**
 * Created by Abhishek on 28-Jan-18.
 */

public class PosterAdapter extends PagerAdapter {

    private Context context;
    private String[] imageUrls, clickUrls;

    public PosterAdapter(Context context, String[] imageUrls, String[] clickUrls){
        this.context = context;
        this.imageUrls = imageUrls;
        this.clickUrls = clickUrls;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        LayoutInflater layoutinflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutinflater.inflate(R.layout.item_poster, container, false);
        final ImageView iv = view.findViewById(R.id.iv_poster);
        Picasso.with(context).load(imageUrls[position]).fit().networkPolicy(NetworkPolicy.OFFLINE).into(iv, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {
                Picasso.with(context).load(imageUrls[position]).fit().into(iv);
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return imageUrls.length;
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
