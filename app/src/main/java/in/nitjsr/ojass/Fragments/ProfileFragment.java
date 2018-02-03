package in.nitjsr.ojass.Fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import in.nitjsr.ojass.Adapters.ProfileEventAdapter;
import in.nitjsr.ojass.Adapters.RecyclerViewAdapter;
import in.nitjsr.ojass.Modals.Modal;
import in.nitjsr.ojass.R;
import in.nitjsr.ojass.Utils.Constants;
import in.nitjsr.ojass.Utils.Utilities;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_profile, container, false);

        FirebaseUser mUser = FirebaseAuth.getInstance().getCurrentUser();
        Utilities.setPicassoImage(view.getContext(), mUser.getPhotoUrl().toString(), (ImageView)view.findViewById(R.id.iv_profile_img));
        ((TextView)view.findViewById(R.id.tv_profile_name)).setText(mUser.getDisplayName());
        ((TextView)view.findViewById(R.id.tv_profile_email)).setText(mUser.getEmail());

        DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("Users").child(mUser.getUid());
        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ((TextView)view.findViewById(R.id.tv_profile_number)).setText("+91 "+dataSnapshot.child(Constants.FIREBASE_REF_MOBILE).getValue().toString());
                TextView tvOjassId = view.findViewById(R.id.tv_profile_ojass_id);
                if (dataSnapshot.child(Constants.FIREBASE_REF_OJASS_ID).getValue() != null) {
                    tvOjassId.setText(dataSnapshot.child(Constants.FIREBASE_REF_OJASS_ID).getValue().toString());
                    tvOjassId.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                }
                else {
                    tvOjassId.setText(getString(R.string.not_registered));
                    tvOjassId.setTextColor(Color.RED);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        prepareRecyclerView(view);
        return view;
    }

    private void prepareRecyclerView(View view) {
        RecyclerView rvEvents = view.findViewById(R.id.rv_profile_events);
        LinearLayoutManager ll = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvEvents.setHasFixedSize(true);
        rvEvents.setLayoutManager(ll);
        rvEvents.setAdapter(new ProfileEventAdapter(view.getContext(), prepareDataSet()));
    }

    private ArrayList<Modal> prepareDataSet() {
        ArrayList<Modal> dataSet = new ArrayList<>();
        dataSet.add(new Modal(R.drawable.ic_launcher_background, "Event 1", "Team 1"));
        dataSet.add(new Modal(R.drawable.ic_launcher_background, "Event 2", "Team 2"));
        dataSet.add(new Modal(R.drawable.ic_launcher_background, "Event 3", "Team 3"));
        dataSet.add(new Modal(R.drawable.ic_launcher_background, "Event1", "Event2"));
        dataSet.add(new Modal(R.drawable.ic_launcher_background, "Event1", "Event2"));
        dataSet.add(new Modal(R.drawable.ic_launcher_background, "Event1", "Event2"));
        dataSet.add(new Modal(R.drawable.ic_launcher_background, "Event1", "Event2"));
        return dataSet;
    }

}
