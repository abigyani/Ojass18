package in.nitjsr.ojass.Fragments;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
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
import java.util.concurrent.CopyOnWriteArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import in.nitjsr.ojass.Activities.LoginActivity;
import in.nitjsr.ojass.Activities.RegisterActivity;
import in.nitjsr.ojass.Adapters.ProfileEventAdapter;
import in.nitjsr.ojass.Adapters.RecyclerViewAdapter;
import in.nitjsr.ojass.Modals.Modal;
import in.nitjsr.ojass.R;
import in.nitjsr.ojass.Utils.Constants;
import in.nitjsr.ojass.Utils.SharedPrefManager;
import in.nitjsr.ojass.Utils.Utilities;

import static in.nitjsr.ojass.Utils.Constants.FIREBASE_REF_USERS;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {

    private FirebaseUser mUser;
    private TextView tvUsername, tvUserOjId, tvEmail, tvNum;
    private CircleImageView circleImageView;
    private ImageView ivtShirt, ivKit;
    private ProgressDialog pd;
    private ImageButton ibRefresh;
    private Button ibLogOut, btnClickRegister;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_profile, container, false);
        tvUsername = view.findViewById(R.id.tv_profile_name);
        tvUserOjId = view.findViewById(R.id.tv_profile_ojass_id);
        tvEmail = view.findViewById(R.id.tv_profile_email);
        tvNum = view.findViewById(R.id.tv_profile_number);
        circleImageView = view.findViewById(R.id.iv_profile_img);
        ivtShirt = view.findViewById(R.id.iv_tshirt);
        ivKit = view.findViewById(R.id.iv_kit);
        ibRefresh = view.findViewById(R.id.ib_refresh);
        ibLogOut = view.findViewById(R.id.ib_logOut);
        btnClickRegister = view.findViewById(R.id.btn_click_to_register);

        mUser = FirebaseAuth.getInstance().getCurrentUser();
        Utilities.setPicassoImage(view.getContext(), mUser.getPhotoUrl().toString(), circleImageView, Constants.SQUA_PLACEHOLDER);
        pd = new ProgressDialog(getContext());
        pd.setTitle("Please Wait");
        pd.setMessage("Loading...");
        pd.show();

        tvUsername.setText(mUser.getDisplayName());
        tvEmail.setText(mUser.getEmail());

        prepareRecyclerView(view);
        fetchData(view, 0);

        ibRefresh.setOnClickListener(this);
        ibLogOut.setOnClickListener(this);
        btnClickRegister.setOnClickListener(this);

        return view;
    }

    private void fetchData(final View view, final int flag) {
        DatabaseReference userRef = FirebaseDatabase.getInstance().getReference(FIREBASE_REF_USERS).child(mUser.getUid());
        userRef.keepSynced(true);
        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @SuppressLint("NewApi")
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    try {
                        btnClickRegister.setVisibility(View.GONE);
                        tvNum.setText("+91 "+dataSnapshot.child(Constants.FIREBASE_REF_MOBILE).getValue().toString());
                        if (dataSnapshot.child(Constants.FIREBASE_REF_OJASS_ID).getValue() != null) {
                            tvUserOjId.setText(dataSnapshot.child(Constants.FIREBASE_REF_OJASS_ID).getValue().toString());
                            tvUserOjId.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                        }
                        else {
                            tvUserOjId.setText(Constants.PAYMENT_DUE);
                            tvUserOjId.setTextColor(Color.RED);
                        }
                        if (dataSnapshot.child(Constants.FIREBASE_REF_TSHIRT).exists()){
                            ivtShirt.setImageDrawable(getActivity().getDrawable(android.R.drawable.checkbox_on_background));
                        } else {
                            ivtShirt.setImageDrawable(getActivity().getDrawable(android.R.drawable.checkbox_off_background));
                        }
                        if (dataSnapshot.child(Constants.FIREBASE_REF_KIT).exists()){
                            ivKit.setImageDrawable(getActivity().getDrawable(android.R.drawable.checkbox_on_background));
                        } else {
                            ivKit.setImageDrawable(getActivity().getDrawable(android.R.drawable.checkbox_off_background));
                        }
                        if (pd.isShowing()) pd.dismiss();
                        if (flag == 1){
                            Toast.makeText(getContext(), "Profile updated!", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e){

                    }
                } else {
                    if (pd.isShowing()) pd.dismiss();
                    tvUserOjId.setText(Constants.NOT_REGISTERED);
                    tvUserOjId.setTextColor(Color.RED);
                    Toast.makeText(getContext(), Constants.NOT_REGISTERED, Toast.LENGTH_SHORT).show();
                    btnClickRegister.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
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
        dataSet.add(new Modal("https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages150x150%2Fvishwacodegen.jpg?alt=media&token=2420396e-592c-4c86-beab-9675b7ce5277", "Codemania", "Result Not Declared"));
        dataSet.add(new Modal("https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/EventPageImages150x150%2Fdeusxmachina.jpg?alt=media&token=b70e7814-f03e-47a7-bd6b-6bb964a69324", "Kurukshetra", "Result Not Declared"));
        dataSet.add(new Modal(R.drawable.ic_launcher_background, "Event 3", "Team 3"));
        dataSet.add(new Modal(R.drawable.ic_launcher_background, "Event1", "Event2"));
        dataSet.add(new Modal(R.drawable.ic_launcher_background, "Event1", "Event2"));
        dataSet.add(new Modal(R.drawable.ic_launcher_background, "Event1", "Event2"));
        dataSet.add(new Modal(R.drawable.ic_launcher_background, "Event1", "Event2"));
        return dataSet;
    }

    @Override
    public void onClick(View view) {
        if (view == ibRefresh) {
            pd.show();
            fetchData(view, 1);
        } else if (view == ibLogOut) {
            signOut();
        } else if (view == btnClickRegister){
            startActivity(new Intent(getContext(), RegisterActivity.class));
            getActivity().finish();
        }
    }

    private void signOut() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(getContext(), gso);
        mGoogleSignInClient.signOut();
        FirebaseAuth.getInstance().signOut();
        SharedPrefManager shared = new SharedPrefManager(getContext());
        shared.setIsLoggedIn(false);
        startActivity(new Intent(getActivity(), LoginActivity.class));
        getActivity().finishAffinity();
    }
}
