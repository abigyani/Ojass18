package in.nitjsr.ojass.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import in.nitjsr.ojass.Activities.FullScreenActivity;
import in.nitjsr.ojass.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItinaryFragment extends Fragment implements View.OnClickListener{

    public static final String INTENT_PARAM_DAY = "intentParamDay";

    public ItinaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_itinary, container, false);
        view.findViewById(R.id.cv_day1).setOnClickListener(this);
        view.findViewById(R.id.cv_day2).setOnClickListener(this);
        view.findViewById(R.id.cv_day3).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getContext(), FullScreenActivity.class);
        if (view.getId() == R.id.cv_day1) intent.putExtra(INTENT_PARAM_DAY, 0);
        if (view.getId() == R.id.cv_day2) intent.putExtra(INTENT_PARAM_DAY, 1);
        if (view.getId() == R.id.cv_day3) intent.putExtra(INTENT_PARAM_DAY, 2);
        startActivity(intent);
    }
}
