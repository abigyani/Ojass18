package in.nitjsr.ojass.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.squareup.picasso.Picasso;

import in.nitjsr.ojass.Adapters.MainActivityAdapter;
import in.nitjsr.ojass.R;
import in.nitjsr.ojass.Utils.CustomViewPager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener{

    private ImageButton ibSwipeUp;
    private boolean isSwipeUpMenuVisible;
    private static CustomViewPager viewPager;
    private BottomNavigationView navigation;
    private FirebaseAuth mAuth;
    private boolean isWarningShown = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        isSwipeUpMenuVisible = false;

        navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ibSwipeUp = findViewById(R.id.ib_swipe_up);
        ibSwipeUp.setOnClickListener(this);

        viewPager = findViewById(R.id.view_pager_mainactivity);
        viewPager.setAdapter(new MainActivityAdapter(getSupportFragmentManager()));
        viewPager.setOnPageChangeListener(this);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setPagingEnabled(false);

        findViewById(R.id.ll_team_menu).setOnClickListener(this);
        findViewById(R.id.ll_guru_gyan_menu).setOnClickListener(this);
        findViewById(R.id.ll_faq_menu).setOnClickListener(this);
        findViewById(R.id.ll_about_us_menu).setOnClickListener(this);
        findViewById(R.id.ll_maps_menu).setOnClickListener(this);
        findViewById(R.id.ll_sponsors_menu).setOnClickListener(this);
        findViewById(R.id.ll_blank).setOnClickListener(this);
        findViewById(R.id.ll_app_dev_menu).setOnClickListener(this);

        Picasso.with(this).load(R.drawable.star_bg).fit().into(((ImageView)findViewById(R.id.iv_header)));
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if (isSwipeUpMenuVisible) {
                ibSwipeUp.performClick();
            }
            switch (item.getItemId()) {
                case R.id.bottom_nav_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.bottom_nav_events:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.bottom_nav_qrcode:
                    createQRPopup();
                    return true;
                case R.id.bottom_nav_itinary:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.bottom_nav_profile:
                    viewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        }
    };

    private void createQRPopup() {
        Dialog QRDialog = new Dialog(this);
        QRDialog.setContentView(R.layout.dialog_qr);
        QRDialog.getWindow().getAttributes().windowAnimations = R.style.pop_up_anim;
        ((ImageView)QRDialog.findViewById(R.id.iv_qr_code)).setImageBitmap(getQRCode(mAuth.getCurrentUser().getUid()));
        QRDialog.show();
    }

    private Bitmap getQRCode(String uid) {
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bMatrix = multiFormatWriter.encode(uid, BarcodeFormat.QR_CODE,300,300);
            return new BarcodeEncoder().createBitmap(bMatrix);
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void onClick(View view) {
        isWarningShown = false;
        if (view == ibSwipeUp){
            if (isSwipeUpMenuVisible) {
                ibSwipeUp.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate_down));
                findViewById(R.id.ll_swipe_up).setVisibility(View.GONE);
                findViewById(R.id.ll_blank).setVisibility(View.GONE);
                isSwipeUpMenuVisible = false;
            } else {
                ibSwipeUp.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate_up));
                findViewById(R.id.ll_swipe_up).setVisibility(View.VISIBLE);
                findViewById(R.id.ll_blank).setVisibility(View.VISIBLE);
                isSwipeUpMenuVisible = true;
            }
        } else if (view.getId() == R.id.ll_team_menu) {
            startActivity(new Intent(this, TeamActivity.class));
        } else if (view.getId() == R.id.ll_guru_gyan_menu) {
            startActivity(new Intent(this, GuruGyanActivity.class));
        } else if (view.getId() == R.id.ll_faq_menu) {
            startActivity(new Intent(this,FaqActivity.class));
        } else if (view.getId() == R.id.ll_about_us_menu) {
            startActivity(new Intent(this, AboutUs.class));
        } else if (view.getId() == R.id.ll_maps_menu) {
            startActivity(new Intent(this, MapsActivity.class));
        } else if (view.getId() == R.id.ll_sponsors_menu){
            startActivity(new Intent(this, SponsorsActivity.class));
        } else if (view.getId() == R.id.ll_app_dev_menu) {
            startActivity(new Intent(this, DevelopersAcitivity.class));
        } else if (view.getId() == R.id.ll_blank) {
            ibSwipeUp.performClick();
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                navigation.setSelectedItemId(R.id.bottom_nav_home);
                break;
            case 1:
                navigation.setSelectedItemId(R.id.bottom_nav_events);
                break;
            case 2:
                navigation.setSelectedItemId(R.id.bottom_nav_itinary);
                break;
            case 3:
                navigation.setSelectedItemId(R.id.bottom_nav_profile);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public static void setPager(int position){
        viewPager.setCurrentItem(position);
    }

    @Override
    public void onBackPressed() {
        if (isSwipeUpMenuVisible) ibSwipeUp.performClick();
        else {
            if (viewPager.getCurrentItem() == 0){
                if (!isWarningShown){
                    Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
                    isWarningShown = true;
                }
                else finish();
            } else {
                viewPager.setCurrentItem(0);
            }
        }
    }
}
