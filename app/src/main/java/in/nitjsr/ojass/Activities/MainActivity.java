package in.nitjsr.ojass.Activities;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.squareup.picasso.Picasso;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import in.nitjsr.ojass.Adapters.MainActivityAdapter;
import in.nitjsr.ojass.Adapters.NotificationAdapter;
import in.nitjsr.ojass.Fragments.SubscribeFragment;
import in.nitjsr.ojass.Modals.CoordinatorsModel;
import in.nitjsr.ojass.Modals.EventModel;
import in.nitjsr.ojass.Modals.NotificationModal;
import in.nitjsr.ojass.Modals.RulesModel;
import in.nitjsr.ojass.R;
import in.nitjsr.ojass.Utils.Constants;
import in.nitjsr.ojass.Utils.CustomViewPager;
import in.nitjsr.ojass.Utils.SharedPrefManager;

import static in.nitjsr.ojass.Utils.Constants.FIREBASE_REF_NOTIFICATIONS;
import static in.nitjsr.ojass.Utils.Constants.FIREBASE_REF_NOTIFICATIONS_BODY;
import static in.nitjsr.ojass.Utils.Constants.FIREBASE_REF_NOTIFICATIONS_TITLE;
import static in.nitjsr.ojass.Utils.Constants.FIREBASE_REF_OJASS_CHANNEL;
import static in.nitjsr.ojass.Utils.Constants.FIREBASE_REF_OJASS_ID;
import static in.nitjsr.ojass.Utils.Constants.FIREBASE_REF_USERS;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener{

    private ImageButton ibSwipeUp,subscribe;
    private RelativeLayout notifications;
    private boolean isSwipeUpMenuVisible;
    private static CustomViewPager viewPager;
    private BottomNavigationView navigation;
    private FirebaseAuth mAuth;
    private boolean isWarningShown = false;
    public static ArrayList<EventModel> data;
    public ProgressDialog progressDialog;
    private boolean isNotiVisible = false;
    private SharedPrefManager shared;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Events
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Events");
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Initialising App data...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        shared = new SharedPrefManager(this);

        data=new ArrayList<>();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                data.clear();
                progressDialog.dismiss();
                try {
                    for(DataSnapshot ds: dataSnapshot.getChildren()) {
                        String about=ds.child("about").getValue(String.class);
                        String branch=ds.child("branch").getValue(String.class);
                        String details=ds.child("detail").getValue(String.class);
                        String name=ds.child("name").getValue(String.class);
                        Long prize1=ds.child("prize").child("first").getValue(Long.class);
                        Long prize2=ds.child("prize").child("second").getValue(Long.class);
                        Long prize3=ds.child("prize").child("third").getValue(Long.class);
                        Long prizeT=ds.child("prize").child("total").getValue(Long.class);
                        ArrayList<CoordinatorsModel> coordinatorsModelArrayList=new ArrayList<>();
                        coordinatorsModelArrayList.clear();

                        ArrayList<RulesModel> rulesModelArrayList=new ArrayList<>();
                        rulesModelArrayList.clear();

                        for(DataSnapshot d:ds.child("coordinators").getChildren()) {
                            CoordinatorsModel coordinatorsModel=d.getValue(CoordinatorsModel.class);
                            coordinatorsModelArrayList.add(coordinatorsModel);
                        }

                        for(DataSnapshot d:ds.child("rules").getChildren()) {
                            RulesModel rulesModel=d.getValue(RulesModel.class);
                            rulesModelArrayList.add(rulesModel);
                        }
                        data.add(new EventModel(about,branch,details,name,prize1,prize2,prize3,prizeT,coordinatorsModelArrayList,rulesModelArrayList));
                    }
                } catch(Exception e){
                    if (progressDialog.isShowing()) progressDialog.dismiss();
                    Toast.makeText(MainActivity.this, "Something went wrong in Events!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                if (progressDialog.isShowing()) progressDialog.dismiss();
            }
        });


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
        findViewById(R.id.tv_see_all_noti).setOnClickListener(this);

        findViewById(R.id.rl_notification_menu).setOnClickListener(this);
        findViewById(R.id.rl_subscribe).setOnClickListener(this);
        findViewById(R.id.view_noti_blank).setOnClickListener(this);
        //Picasso.with(this).load(R.drawable.star_bg).fit().into(((ImageView)findViewById(R.id.iv_header)));

        getFbHash();
    }

    @Override
    protected void onResume() {
        super.onResume();
        readNotificationCount();
    }

    private void readNotificationCount() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(FIREBASE_REF_NOTIFICATIONS).child(FIREBASE_REF_OJASS_CHANNEL);
        ref.keepSynced(true);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int currIndex = 0;
                if (dataSnapshot.exists()){
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                        if (Long.parseLong(dataSnapshot1.getKey()) > shared.getLastNotiTime()) currIndex++;
                }
                ((TextView)findViewById(R.id.tv_noti_count)).setText(""+currIndex);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
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
        final Dialog QRDialog = new Dialog(this);
        QRDialog.setContentView(R.layout.dialog_qr);
        QRDialog.getWindow().getAttributes().windowAnimations = R.style.pop_up_anim;
        QRDialog.show();
        final TextView tvOjassId = QRDialog.findViewById(R.id.tv_ojass_id);
        final ImageView ivQR = QRDialog.findViewById(R.id.iv_qr_code);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(FIREBASE_REF_USERS).child(mAuth.getCurrentUser().getUid());
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @SuppressLint("NewApi")
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    ivQR.setImageBitmap(getQRCode(mAuth.getCurrentUser().getUid()));
                    if (dataSnapshot.child(FIREBASE_REF_OJASS_ID).exists()){
                        tvOjassId.setText(dataSnapshot.child(FIREBASE_REF_OJASS_ID).getValue().toString());
                        tvOjassId.setTextColor(Color.BLUE);
                    } else {
                        tvOjassId.setText(Constants.PAYMENT_DUE);
                        tvOjassId.setTextColor(Color.RED);
                    }
                } else {
                    //Show Please Register Image
                    ivQR.setImageDrawable(getDrawable(R.drawable.ic_launcher_background));
                    tvOjassId.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
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
            startActivity(new Intent(this, SponsersActivity.class));
        } else if (view.getId() == R.id.ll_app_dev_menu) {
            startActivity(new Intent(this, DevelopersAcitivity.class));
        } else if (view.getId() == R.id.ll_blank) {
            ibSwipeUp.performClick();
        } else if(view.getId()==R.id.rl_subscribe) {
            SubscribeFragment detailsfragment=new SubscribeFragment();
            detailsfragment.show(getSupportFragmentManager(),"Subscribe");
        } else if(view.getId()==R.id.rl_notification_menu) {
            if (isNotiVisible) {
                findViewById(R.id.ll_notification).setVisibility(View.GONE);
                isNotiVisible = false;
            } else {
                findViewById(R.id.ll_notification).setVisibility(View.VISIBLE);
                queryNotifications();
                isNotiVisible = true;
            }
        } else if (view.getId() == R.id.tv_see_all_noti){
            startActivity(new Intent(this, FeedActivity.class));
            findViewById(R.id.ll_notification).setVisibility(View.GONE);
            isNotiVisible = false;
        } else if (view.getId() == R.id.view_noti_blank){
            findViewById(R.id.ll_notification).setVisibility(View.GONE);
            isNotiVisible = false;
        }

    }

    public void getFbHash(){
        PackageInfo info;
        try {
            info = getPackageManager().getPackageInfo("in.nitjsr.ojass", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                //String something = new String(Base64.encodeBytes(md.digest()));
                Log.e("Facebook", something);
            }
        } catch (Exception e) {
            Log.e("Facebook", e.toString());
        }
    }

    private void queryNotifications() {
       Query ref = FirebaseDatabase.getInstance().getReference(FIREBASE_REF_NOTIFICATIONS).child(FIREBASE_REF_OJASS_CHANNEL).orderByKey().limitToLast(25);
        ref.keepSynced(true);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    prepareNotificationRecyclerView(dataSnapshot);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void prepareNotificationRecyclerView(DataSnapshot dataSnapshot) {
        RecyclerView rv = findViewById(R.id.rv_notification);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
        ArrayList<NotificationModal> noti = new ArrayList<>();
        int currIndex = 0;
        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
            Log.d("TAG", dataSnapshot1.getKey() + ' ' +shared.getLastNotiTime());
            if (Long.parseLong(dataSnapshot1.getKey()) > shared.getLastNotiTime()){
                noti.add(new NotificationModal(
                        dataSnapshot1.child(FIREBASE_REF_NOTIFICATIONS_TITLE).getValue().toString(),
                        dataSnapshot1.child(FIREBASE_REF_NOTIFICATIONS_BODY).getValue().toString()));
                currIndex++;
            }
        }
        ((TextView)findViewById(R.id.tv_noti_count)).setText(""+currIndex);
        rv.setAdapter(new NotificationAdapter(this, noti));
        shared.setNotiTime(System.currentTimeMillis()/1000);
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
