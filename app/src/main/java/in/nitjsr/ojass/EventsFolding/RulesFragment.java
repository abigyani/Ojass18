package in.nitjsr.ojass.EventsFolding;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import in.nitjsr.ojass.Activities.MainActivity;
import in.nitjsr.ojass.R;


public class RulesFragment extends Fragment {

    private Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rules, container, false);
        createUI(view);
        return view;
    }

    private void createUI(View view) {
        TextView t1=(TextView) view.findViewById(R.id.title_rules);
        Typeface customFontBold= Typeface.createFromAsset(getActivity().getAssets(),"Ojass.otf");
        t1.setTypeface(customFontBold);
        TextView t2=(TextView) view.findViewById(R.id.text_rules);
        Typeface typeface= Typeface.createFromAsset(getActivity().getAssets(),"textfont.otf");
        t2.setTypeface(typeface);
        String rules="";

        for(int i = 0; i< MainActivity.data.get(SubEventsActivity.position).getRulesModels().size(); i++)
        {
            rules=rules+"<br>"+(i+1)+". "+MainActivity.data.get(SubEventsActivity.position).getRulesModels().get(i).getText();
        }

        t2.setText(Html.fromHtml(rules));
       // t2.setText("Rules");
    }
}
