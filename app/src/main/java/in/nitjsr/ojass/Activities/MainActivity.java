package in.nitjsr.ojass.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
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

import com.google.firebase.auth.FirebaseAuth;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.Collections;
import java.util.List;

import in.nitjsr.ojass.Adapters.MainActivityAdapter;
import in.nitjsr.ojass.Modals.Devpage_modal;
import in.nitjsr.ojass.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener{

    private ImageButton ibSwipeUp;
    private boolean isSwipeUpMenuVisible;
    private ViewPager viewPager;
    private BottomNavigationView navigation;
    private FirebaseAuth mAuth;
    private ImageView aboutusclick;
    private ImageView developers;


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

        developers=findViewById(R.id.main_devlopers);
        developers.setOnClickListener(this);

        findViewById(R.id.ll_team_menu).setOnClickListener(this);

        aboutusclick = findViewById(R.id.main_aboutus);
        aboutusclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , AboutUs.class);
                startActivity(intent);
            }
        });

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
            BitMatrix bMatrix=multiFormatWriter.encode(uid, BarcodeFormat.QR_CODE,300,300);
            BarcodeEncoder encoder = new BarcodeEncoder();
            return encoder.createBitmap(bMatrix);
        }
        catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void onClick(View view) {
        if (view == ibSwipeUp){
            if (isSwipeUpMenuVisible) {
                ibSwipeUp.startAnimation(AnimationUtils.loadAnimation(this, R.anim.swipe_down));
                findViewById(R.id.ll_swipe_up).setVisibility(View.GONE);
                isSwipeUpMenuVisible = false;
            } else {
                ibSwipeUp.startAnimation(AnimationUtils.loadAnimation(this, R.anim.swipe_up));
                findViewById(R.id.ll_swipe_up).setVisibility(View.VISIBLE);
                isSwipeUpMenuVisible = true;
            }
        } else if (view.getId() == R.id.ll_team_menu) {
            startActivity(new Intent(this, TeamActivity.class));
        }
        if(view.getId() == R.id.main_devlopers)
        {
            startActivity(new Intent(this,Developerspage.class));
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
}
