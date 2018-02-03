package in.nitjsr.ojass.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Field;
import java.util.ArrayList;

import in.nitjsr.ojass.Activities.GuruGyanActivity;
import in.nitjsr.ojass.Activities.MainActivity;
import in.nitjsr.ojass.Activities.SponsersActivity;
import in.nitjsr.ojass.Adapters.RecyclerViewAdapter;
import in.nitjsr.ojass.Adapters.PosterAdapter;
import in.nitjsr.ojass.Modals.Modal;
import in.nitjsr.ojass.R;
import me.relex.circleindicator.CircleIndicator;

import static in.nitjsr.ojass.Utils.Constants.FIREBASE_REF_IMG_CLICK;
import static in.nitjsr.ojass.Utils.Constants.FIREBASE_REF_IMG_SRC;
import static in.nitjsr.ojass.Utils.Constants.FIREBASE_REF_POSTERIMAGES;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements ViewPager.OnPageChangeListener, View.OnClickListener{

    //Poster shit
    private static final int BANNER_DELAY_TIME = 5 * 1000;
    private static final int BANNER_TRANSITION_DELAY = 1200;
    private Runnable runnable;
    private Handler handler;
    private boolean firstScroll = true;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        setSlider(view);
        setEventRv(view);
        setGuruGyanRv(view);
        setSponsorsRv(view);

        view.findViewById(R.id.tv_events_see_all).setOnClickListener(this);
        view.findViewById(R.id.tv_guru_gyan_see_all).setOnClickListener(this);
        view.findViewById(R.id.tv_sponsors_see_all).setOnClickListener(this);

        return view;
    }

    private void setSponsorsRv(View view) {
        RecyclerView rv = view.findViewById(R.id.rv_sponsors);
        LinearLayoutManager ll = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(ll);
        rv.setHasFixedSize(true);
        ArrayList<Modal> sponsorList = prepareSponsorList();
        rv.setAdapter(new RecyclerViewAdapter(sponsorList, view.getContext()));
    }

    private ArrayList<Modal> prepareSponsorList() {
        ArrayList<Modal> models = new ArrayList<>();
        models.add(new Modal(R.drawable.ic_launcher_background, "Codechef", "Coding site"));
        models.add(new Modal(R.drawable.ic_launcher_background, "Hackerrank", "Coding Site"));
        models.add(new Modal(R.drawable.ic_launcher_background, "Radio Mirchi", "Radio Station"));
        models.add(new Modal(R.drawable.ic_launcher_background, "Vimal", "Pan Masala"));
        models.add(new Modal(R.drawable.ic_launcher_background, "MRF", "Tyres"));
        return models;
    }

    private void setGuruGyanRv(View view) {
        RecyclerView rv = view.findViewById(R.id.rv_guru_gyan);
        LinearLayoutManager ll = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(ll);
        rv.setHasFixedSize(true);
        ArrayList<Modal> guruGyanList = prepareGuruGyanList();
        rv.setAdapter(new RecyclerViewAdapter(guruGyanList, view.getContext()));
    }

    private ArrayList<Modal> prepareGuruGyanList() {
        ArrayList<Modal> models = new ArrayList<>();
        models.add(new Modal(R.drawable.ic_launcher_background, "Amitabh Bachan", "Actor"));
        models.add(new Modal(R.drawable.ic_launcher_background, "Zakir Khan", "Comedian"));
        models.add(new Modal(R.drawable.ic_launcher_background, "Arijit Singh", "Singer"));
        models.add(new Modal(R.drawable.ic_launcher_background, "Dhinchak Pooja", "Mental"));
        return models;
    }

    private void setEventRv(View view) {
        RecyclerView rv = view.findViewById(R.id.rv_events);
        LinearLayoutManager ll = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(ll);
        rv.setHasFixedSize(true);
        ArrayList<Modal> eventList = prepareEventList();
        rv.setAdapter(new RecyclerViewAdapter(eventList, view.getContext()));
    }

    private ArrayList<Modal> prepareEventList() {
        ArrayList<Modal> models = new ArrayList<>();
        models.add(new Modal(R.drawable.noground, "No Ground Zone", "Fly planes"));
        models.add(new Modal(R.mipmap.directorscut, "Director's Cut", "Shot Movies"));
        models.add(new Modal(R.mipmap.bizzathalon, "Bizzathalon", "Business"));
        models.add(new Modal(R.drawable.major_codemania, "CodeMania", "Coding"));
        models.add(new Modal(R.drawable.major_capture, "Capture", "MCA Event"));
        models.add(new Modal(R.drawable.major_dota, "Armeggadon", "Gaming"));
        models.add(new Modal(R.drawable.major_robowar, "Robo War", "Robo Fight"));
        models.add(new Modal(R.drawable.major_robowar2, "Robo War 2", "Robo Fight 2"));
        return models;
    }

    public void setSlider(final View view){
        final ViewPager viewPager = view.findViewById(R.id.viewpager_poster);
        final CircleIndicator indicator = view.findViewById(R.id.indicator_slider);
        FirebaseDatabase dataref = FirebaseDatabase.getInstance();
        //dataref.setPersistenceEnabled(false);
        DatabaseReference imageRef = dataref.getReference(FIREBASE_REF_POSTERIMAGES);
        imageRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final int imageCount = (int) dataSnapshot.getChildrenCount();
                String[] imageUrls = new String[imageCount];
                String[] clickUrls = new String[imageCount];
                int currIndex = 0;
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    imageUrls[currIndex] = dataSnapshot1.child(FIREBASE_REF_IMG_SRC).getValue().toString();
                    clickUrls[currIndex] = dataSnapshot1.child(FIREBASE_REF_IMG_CLICK).getValue().toString();
                    Log.d("TAG", imageUrls[currIndex]);
                    currIndex++;
                }
                viewPager.setAdapter(new PosterAdapter(view.getContext(), imageUrls, clickUrls));
                indicator.setViewPager(viewPager);
                viewPager.setOnPageChangeListener(HomeFragment.this);

                try{
                    Field mScroller = ViewPager.class.getDeclaredField("mScroller");
                    mScroller.setAccessible(true);
                    mScroller.set(viewPager, new CustomScroller(viewPager.getContext(),BANNER_TRANSITION_DELAY ));
                } catch (Exception e){}

                handler = new Handler(Looper.getMainLooper());
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        int currItem = viewPager.getCurrentItem();
                        if (currItem == imageCount-1){
                            viewPager.setCurrentItem(0);
                        } else {
                            viewPager.setCurrentItem(++currItem);
                        }
                    }
                };
                handler.postDelayed(runnable, BANNER_DELAY_TIME);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (firstScroll){
            firstScroll = false;
        } else {
            handler.removeCallbacks(runnable);
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (state == ViewPager.SCROLL_STATE_IDLE){
            handler.postDelayed(runnable, BANNER_DELAY_TIME);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_events_see_all:
                MainActivity.setPager(1);
                break;
            case R.id.tv_guru_gyan_see_all:
                startActivity(new Intent(getContext(), GuruGyanActivity.class));
                break;
            case R.id.tv_sponsors_see_all:


                startActivity(new Intent(getContext(), SponsersActivity.class));
        }
    }

    private class CustomScroller extends Scroller {

        private int mDuration;

        public CustomScroller(Context context, int mDuration) {
            super(context);
            this.mDuration = mDuration;
        }

        public CustomScroller(Context context, Interpolator interpolator, int mDuration) {
            super(context, interpolator);
            this.mDuration = mDuration;
        }

        public CustomScroller(Context context, Interpolator interpolator, boolean flywheel, int mDuration) {
            super(context, interpolator, flywheel);
            this.mDuration = mDuration;
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy) {
            super.startScroll(startX, startY, dx, dy, mDuration);
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            super.startScroll(startX, startY, dx, dy, mDuration);
        }
    }
}
