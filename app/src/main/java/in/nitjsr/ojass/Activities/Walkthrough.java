package in.nitjsr.ojass.Activities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import in.nitjsr.ojass.Adapters.IntroAdapter;
import in.nitjsr.ojass.R;
import in.nitjsr.ojass.Utils.Utilities;
import me.relex.circleindicator.CircleIndicator;

public class Walkthrough extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private ViewPager viewPager;
    private IntroAdapter introAdapter;
    private CircleIndicator circleIndicator;
    private int[] introSlides;
    private int[] introSlidesImageView;
    private Button btnNext, btnSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);

        Utilities.changeStatusBarColor(this);

        viewPager = findViewById(R.id.viewpager_slider);
        circleIndicator = findViewById(R.id.circular_indicator);
        btnNext = findViewById(R.id.btn_next);
        btnSkip = findViewById(R.id.btn_skip);

        btnNext.setOnClickListener(this);
        btnSkip.setOnClickListener(this);

        introSlides = new int[]{
                R.layout.intro_slide_1,
                R.layout.intro_slide_2,
                R.layout.intro_slide_3,
                R.layout.intro_slide_4
        };

        introSlidesImageView = new int[] {
                R.id.iv_intro_slide_1,
                R.id.iv_intro_slide_2,
                R.id.iv_intro_slide_3,
                R.id.iv_intro_slide_4
        };

        introAdapter = new IntroAdapter(this, introSlides, introSlidesImageView);
        viewPager.setAdapter(introAdapter);
        viewPager.setOffscreenPageLimit(3);
        circleIndicator.setViewPager(viewPager);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == introSlides.length - 1){
            btnNext.setText(getString(R.string.gotit));
            btnSkip.setVisibility(View.GONE);
        } else {
            btnNext.setText(getString(R.string.next));
            btnSkip.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_next){
            int currItem = viewPager.getCurrentItem();
            if (currItem < introSlides.length - 1) viewPager.setCurrentItem(currItem + 1);
            else startLoginActivity();
        } else if (view.getId() == R.id.btn_skip){
            startLoginActivity();
        }
    }

    private void startLoginActivity() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
