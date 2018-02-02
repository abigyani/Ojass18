package in.nitjsr.ojass.EventsFolding;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.nitjsr.ojass.R;


public class ResultsFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_results, container, false);
        createUI(view);
        return view;
    }


    private void createUI(View view) {
        TextView t1=(TextView) view.findViewById(R.id.title_results);
     //   Typeface customFontBold= Typeface.createFromAsset(getActivity().getAssets(),"Ojass.otf");
     //   t1.setTypeface(customFontBold);

        TextView t2=(TextView) view.findViewById(R.id.text_results);
    //    Typeface typeface= Typeface.createFromAsset(getActivity().getAssets(),"textfont.otf");
    //    t2.setTypeface(typeface);
        t2.setText("Results Content");
    }

}
