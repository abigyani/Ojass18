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
import in.nitjsr.ojass.Utils.Constants;
import in.nitjsr.ojass.Utils.Utilities;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItinaryFragment extends Fragment implements View.OnClickListener{

    private ImageView day1, day2, day3;
    private String itinary_images[] = {
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/ItinaryImages%2Fday1.png?alt=media&token=e18fa65d-4076-43f6-a12c-ffe76b68fc11",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/ItinaryImages%2Fday2.png?alt=media&token=1a324345-e864-470d-91cf-e303176770de",
            "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/ItinaryImages%2Fday3.png?alt=media&token=f1cebc84-d061-4120-a59f-3d87eee28c15"
    };

    public static final String INTENT_PARAM_DAY = "intentParamDay";

    public ItinaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_itinary, container, false);

        day1 = view.findViewById(R.id.iv_day1);
        day2 = view.findViewById(R.id.iv_day2);
        day3 = view.findViewById(R.id.iv_day3);

        Utilities.setPicassoImage(getContext(), itinary_images[0], day1, Constants.RECT_PLACEHOLDER);
        Utilities.setPicassoImage(getContext(), itinary_images[1], day2, Constants.RECT_PLACEHOLDER);
        Utilities.setPicassoImage(getContext(), itinary_images[2], day3, Constants.RECT_PLACEHOLDER);

    /*    Picasso.with(getContext()).load(itinary_images[0]).fit().into(day1);
        Picasso.with(getContext()).load(itinary_images[1]).fit().into(day2);
        Picasso.with(getContext()).load(itinary_images[2]).fit().into(day3);  */

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
