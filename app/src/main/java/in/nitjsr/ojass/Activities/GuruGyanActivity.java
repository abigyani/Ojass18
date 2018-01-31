package in.nitjsr.ojass.Activities;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import in.nitjsr.ojass.Adapters.PosterAdapter;
import in.nitjsr.ojass.R;
import in.nitjsr.ojass.Utils.Utilities;
import me.relex.circleindicator.CircleIndicator;

public class GuruGyanActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvShortDesc, tvFullDesc;
    private Handler handler;
    private boolean firstTimeOpen = true;
    private int previousPos = 0;
    private boolean isSmallVisible = true;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            tvShortDesc.performClick();
        }
    };

    private static final String[] images = {
            "http://www.wallpaperawesome.com/wallpapers-awesome/wallpapers-full-hd-1080-x-1920-smatphone-htc-one-lumia-1520-lg-g2-galaxy-s4-s5-awesome/wallpaper-full-hd-1080-x-1920-smartphone-dark-railroad.jpg",
            "http://www.5djpg.com/uploads/allimg/140424/1-140424101922.jpg",
            "https://wallpaperscraft.com/image/mountains_sky_sunset_peaks_97149_1080x1920.jpg",
            "https://wallpaperscraft.com/image/ultron_avengers_age_of_ultron_avengers_102193_1080x1920.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guru_gyan);

        Utilities.changeStatusBarColor(this);

        tvShortDesc = findViewById(R.id.tv_guru_gyan_short_desc);
        tvShortDesc.setOnClickListener(this);
        tvFullDesc = findViewById(R.id.tv_guru_gyan_full_desc);
        tvFullDesc.setOnClickListener(this);

        prepareViewPager();

        tvShortDesc.setText("Short Text 1");
        tvFullDesc.setText("Long Text 1");

        handler = new Handler(getMainLooper());
        handler.postDelayed(runnable, 3000);
    }

    private void prepareViewPager() {
        ViewPager viewPager = findViewById(R.id.vp_guru_gyan);
        viewPager.setAdapter(new PosterAdapter(this, images, null));
        ((CircleIndicator)findViewById(R.id.ci_guru_gyan)).setViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (firstTimeOpen) firstTimeOpen = false;
                else handler.removeCallbacks(runnable);
            }

            @Override
            public void onPageSelected(int position) {

                Animation animLeft = AnimationUtils.loadAnimation(GuruGyanActivity.this, R.anim.slide_in_left);
                Animation animRight = AnimationUtils.loadAnimation(GuruGyanActivity.this, R.anim.slide_in_right);
                if (position > previousPos) {
                    if (tvShortDesc.isActivated()) tvShortDesc.startAnimation(animRight);
                    else tvFullDesc.startAnimation(animRight);
                } else {
                    if (tvShortDesc.isActivated()) tvShortDesc.startAnimation(animLeft);
                    else tvFullDesc.startAnimation(animLeft);
                }
                previousPos = position;

                switch (position){
                    case 0 :
                        tvShortDesc.setText("Short Text 1");
                        tvFullDesc.setText("Long Text 1");
                        return;

                    case 1 :
                        tvShortDesc.setText("Short Text 2");
                        tvFullDesc.setText("Long Text 2");
                        return;

                    case 2 :
                        tvShortDesc.setText("Short Text 3");
                        tvFullDesc.setText("Long Text 3");
                        return;

                    case 3 :
                        tvShortDesc.setText("Short Text 4");
                        tvFullDesc.setText("Long Text 4");
                        return;

                    case 4 :
                        tvShortDesc.setText("Short Text 5");
                        tvFullDesc.setText("Long Text 5");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE){
                    handler.postDelayed(runnable, 3000);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == tvShortDesc) {
            tvShortDesc.setVisibility(View.GONE);
            tvFullDesc.setVisibility(View.VISIBLE);
            isSmallVisible = false;
        } else if (view == tvFullDesc) {
            tvFullDesc.setVisibility(View.GONE);
            tvShortDesc.setVisibility(View.VISIBLE);
            isSmallVisible = true;
        }
        handler.removeCallbacks(runnable);
    }
}
