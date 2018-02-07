package in.nitjsr.ojass.Activities;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import in.nitjsr.ojass.Adapters.PosterAdapter;
import in.nitjsr.ojass.R;
import in.nitjsr.ojass.Utils.Utilities;
import me.relex.circleindicator.CircleIndicator;

import static in.nitjsr.ojass.Utils.Constants.FIREBASE_REF_GURU_GYAN;
import static in.nitjsr.ojass.Utils.Constants.FIREBASE_REF_GURU_GYAN_DATE;
import static in.nitjsr.ojass.Utils.Constants.FIREBASE_REF_GURU_GYAN_IMAGE;
import static in.nitjsr.ojass.Utils.Constants.FIREBASE_REF_GURU_GYAN_LONG_DESC;
import static in.nitjsr.ojass.Utils.Constants.FIREBASE_REF_GURU_GYAN_SHORT_DESC;
import static in.nitjsr.ojass.Utils.Constants.FIREBASE_REF_GURU_GYAN_TITLE;

public class GuruGyanActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener{

    private TextView tvShortDesc, tvLongDesc, tvTitle, tvDate;
    private CardView card;
    private Handler handler;
    private boolean firstTimeOpen = true;
    private int previousPos = 0;
    private boolean isSmallVisible = true;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (isSmallVisible) card.performClick();
        }
    };

    private String[] images, title, shortDesc, longDesc, dates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guru_gyan);

        Utilities.changeStatusBarColor(this);

        tvShortDesc = findViewById(R.id.tv_guru_gyan_short_desc);
        tvLongDesc = findViewById(R.id.tv_guru_gyan_long_desc);
        tvTitle = findViewById(R.id.tv_guru_gyan_celeb_name);
        tvDate = findViewById(R.id.tv_gg_date);
        card = findViewById(R.id.ll_info);

        card.setOnClickListener(this);

        prepareViewPager();

        handler = new Handler(getMainLooper());
        handler.postDelayed(runnable, 1500);
    }

    private void prepareViewPager() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(FIREBASE_REF_GURU_GYAN);
        ref.keepSynced(true);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    try{
                        int childCount = (int) dataSnapshot.getChildrenCount();
                        images = new String[childCount];
                        title = new String[childCount];
                        shortDesc = new String[childCount];
                        longDesc = new String[childCount];
                        dates = new String[childCount];
                        int currIndex = 0;
                        for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                            images[currIndex] = dataSnapshot1.child(FIREBASE_REF_GURU_GYAN_IMAGE).getValue().toString();
                            title[currIndex] = dataSnapshot1.child(FIREBASE_REF_GURU_GYAN_TITLE).getValue().toString();
                            shortDesc[currIndex] = dataSnapshot1.child(FIREBASE_REF_GURU_GYAN_SHORT_DESC).getValue().toString();
                            longDesc[currIndex] = dataSnapshot1.child(FIREBASE_REF_GURU_GYAN_LONG_DESC).getValue().toString();
                            dates[currIndex] = dataSnapshot1.child(FIREBASE_REF_GURU_GYAN_DATE).getValue().toString();
                            currIndex++;
                        }
                        ViewPager viewPager = findViewById(R.id.vp_guru_gyan);
                        viewPager.setAdapter(new PosterAdapter(GuruGyanActivity.this, images, null));
                        ((CircleIndicator)findViewById(R.id.ci_guru_gyan)).setViewPager(viewPager);
                        viewPager.addOnPageChangeListener(GuruGyanActivity.this);
                        tvDate.setText(dates[0]);
                        tvTitle.setText(title[0]);
                        tvShortDesc.setText(title[0]);
                        tvLongDesc.setText(longDesc[0]);
                    } catch (Exception e){

                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        if (isSmallVisible){
            tvLongDesc.setVisibility(View.VISIBLE);
            isSmallVisible = false;
        } else {
            tvLongDesc.setVisibility(View.GONE);
            isSmallVisible = true;
        }
        handler.removeCallbacks(runnable);
    }

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
            if (!isSmallVisible)
                tvLongDesc.startAnimation(animRight);
            tvShortDesc.startAnimation(animRight);
            tvDate.startAnimation(animRight);
            tvTitle.startAnimation(animRight);
        } else {
            if (!isSmallVisible)
                tvLongDesc.startAnimation(animLeft);
            tvShortDesc.startAnimation(animLeft);
            tvDate.startAnimation(animLeft);
            tvTitle.startAnimation(animLeft);
        }
        previousPos = position;

        tvDate.setText(dates[position]);
        tvTitle.setText(title[position]);
        tvShortDesc.setText(shortDesc[position]);
        tvLongDesc.setText(longDesc[position]);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (state == ViewPager.SCROLL_STATE_IDLE){
            handler.postDelayed(runnable, 1500);
        }
    }
}
