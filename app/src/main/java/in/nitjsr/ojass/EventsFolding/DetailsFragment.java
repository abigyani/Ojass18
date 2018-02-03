package in.nitjsr.ojass.EventsFolding;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.nitjsr.ojass.Activities.MainActivity;
import in.nitjsr.ojass.R;


/**
 * Created by andrewkhristyan on 12/9/16.
 */

public class DetailsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        createUI(view);
        return view;
    }

    private void createUI(View view) {
        TextView t1=(TextView) view.findViewById(R.id.title_details);
    //    Typeface customFontBold= Typeface.createFromAsset(getActivity().getAssets(),"Ojass.otf");
    //    t1.setTypeface(customFontBold);

        TextView t2=(TextView) view.findViewById(R.id.text_details);
    //    Typeface typeface= Typeface.createFromAsset(getActivity().getAssets(), "textfont.otf");
    //    t2.setTypeface(typeface);
        t2.setText(Html.fromHtml(MainActivity.data.get(SubEventsActivity.position).getDetails()));
//        t2.setText("Details fragment");

    }
}
