package in.nitjsr.ojass.EventsFolding;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import in.nitjsr.ojass.Activities.MainActivity;
import in.nitjsr.ojass.R;


/**
 * Created by andrewkhristyan on 12/9/16.
 */

public class PrizeFragment extends Fragment {
    private TextView prize1,prize2,prize3,prizet,f1,f2,ft,t_1,t2,tt,s1,s2,st,more_details,style2_total,more_details3;
    private LinearLayout style1,style2,first,second,third,one,two,three;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_prize, container, false);
        createUI(view);
        return view;
    }

    private void createUI(View view) {
        TextView t1=(TextView) view.findViewById(R.id.title_prize);
        Typeface customFontBold= Typeface.createFromAsset(getActivity().getAssets(),"Ojass.otf");
        t1.setTypeface(customFontBold);
        prize1=(TextView) view.findViewById(R.id.prize1);
        prize2=(TextView) view.findViewById(R.id.prize2);
        prize3=(TextView) view.findViewById(R.id.prize3);
        prizet=(TextView) view.findViewById(R.id.total_prize);
        f1=(TextView) view.findViewById(R.id.f1);
        f2=(TextView) view.findViewById(R.id.f2);
        s1=(TextView) view.findViewById(R.id.s1);
        s2=(TextView) view.findViewById(R.id.s2);
        ft=(TextView) view.findViewById(R.id.ft);
        st=(TextView) view.findViewById(R.id.st);
        tt=(TextView) view.findViewById(R.id.tt);
        t_1=(TextView) view.findViewById(R.id.t1);
        t2=(TextView) view.findViewById(R.id.t2);
        more_details=(TextView) view.findViewById(R.id.more_deatils);
        more_details3=(TextView) view.findViewById(R.id.more_detail3);
        style2_total=(TextView) view.findViewById(R.id.style2_total);
        style1=(LinearLayout) view.findViewById(R.id.style1);
        style2=(LinearLayout) view.findViewById(R.id.style2);
        first=(LinearLayout) view.findViewById(R.id.first);
        second=(LinearLayout) view.findViewById(R.id.second);
        third=(LinearLayout) view.findViewById(R.id.third);
        one=(LinearLayout) view.findViewById(R.id.one);
        two=(LinearLayout) view.findViewById(R.id.two);
        three=(LinearLayout) view.findViewById(R.id.three);

        switch(SubEventsActivity.actionBarTitle)
        {
            case "High Voltage Concepts (HVC)":{
                style1.setVisibility(View.GONE);
                style2.setVisibility(View.VISIBLE);
                f1.setText("3000");
                f2.setText("2000");
                ft.setText("Total : 5000");
                s1.setText("3000");
                s2.setText("2000");
                st.setText("Total : 5000");
                t_1.setText("3000");
                t2.setText("2000");
                tt.setText("Total : 5000");
                more_details.setText("");
                style2_total.setText("15000/-");
                break;
            }
            case "Codemania":
            {
                style1.setVisibility(View.VISIBLE);
                style2.setVisibility(View.GONE);
                prize1.setText("15000");
                prize2.setText("11000");
                prize3.setText("7000");
                more_details3.setText("Next three winners : 3000");
                prizet.setText("36000/-");
                break;
            }
            case "Who Am I":
            {
                style1.setVisibility(View.GONE);
                style2.setVisibility(View.VISIBLE);
                f1.setText("2000");
                f2.setText("1000");
                ft.setText("Total : 3000");
                s1.setText("2000");
                s2.setText("1000");
                st.setText("Total : 3000");
                third.setVisibility(View.VISIBLE);
                t_1.setText("0");
                t2.setText("0");
                tt.setText("0");
                more_details.setText("");
                style2_total.setText("8000/-");
                break;
            }case "Nexus":
        {
            style1.setVisibility(View.GONE);
            style2.setVisibility(View.VISIBLE);
            f1.setText("3000");
            f2.setText("1500");
            ft.setText("");
            s1.setText("3000");
            s2.setText("1500");
            st.setText("");
            t_1.setText("3000");
            t2.setText("");
            tt.setText("");
            first.setVisibility(View.GONE);
            second.setVisibility(View.GONE);
            third.setVisibility(View.GONE);
            more_details.setText("First Year : 3000\n" +
                    "Second Year : 3000\n" +
                    "Third Year : 3000");
            style2_total.setText("9000/-");
            break;
        }
            case "Touch Down the plane":
            {
                style1.setVisibility(View.VISIBLE);
                style2.setVisibility(View.GONE);
                prize1.setText("24000");
                prize2.setText("18000");
                prize3.setText("10000");
                more_details3.setText("Other 6 Best Team:3000 each\nInnovative Design:1500\nBest Design Report:500");
                prizet.setText("72000/-");
                break;
            }
            case "Director's Cut":
            {
                style1.setVisibility(View.VISIBLE);
                style2.setVisibility(View.GONE);
                prize1.setText("12500");
                prize2.setText("8500");
                prize3.setText("6500");
                more_details3.setText("Best Trailer:1500\nBest Actor:1000\nBest Actress:1000\nBest Cinematographer:1000\nBest Story:1000\nBest Editor:1000");
                prizet.setText("34000/-");
                break;
            }
            case "Embetrix":
            {
                style1.setVisibility(View.GONE);
                style2.setVisibility(View.VISIBLE);
                f1.setText("2000");
                f2.setText("1000");
                ft.setText("Total : 3000");
                second.setVisibility(View.GONE);
                third.setVisibility(View.GONE);
                s1.setText("");
                s2.setText("");
                st.setText("");
                t_1.setText("");
                t2.setText("");
                tt.setText("");
                more_details.setText("2nd & 3rd Year :\n" +
                        "1st: 2800\n" +
                        "2nd: 2000\n" +
                        "3rd: 1200");
                style2_total.setText("9000/-");
                break;
            }
            case "Agnikund":
            {
                style1.setVisibility(View.GONE);
                style2.setVisibility(View.VISIBLE);
                f1.setText("");
                f2.setText("");
                ft.setText("Total : 3000");
                s1.setText("");
                s2.setText("");
                st.setText("Total : 3000");
                t_1.setText("");
                t2.setText("");
                tt.setText("Total : 3000");
                first.setVisibility(View.GONE);
                second.setVisibility(View.GONE);
                third.setVisibility(View.GONE);
                more_details.setText("First Year : 3000\n" +
                        "Second Year : 3000\n" +
                        "Third Year : 3000");
                style2_total.setText("9000/-");
                break;
            }
            case "LiveCS":
            {
                style1.setVisibility(View.VISIBLE);
                style2.setVisibility(View.GONE);
                one.setVisibility(View.GONE);
                two.setVisibility(View.GONE);
                three.setVisibility(View.GONE);
                prizet.setText("10000/-");
                break;
            }
            case "Exposicion":
            {
                style1.setVisibility(View.VISIBLE);
                style2.setVisibility(View.GONE);
                one.setVisibility(View.GONE);
                two.setVisibility(View.GONE);
                three.setVisibility(View.GONE);
                prizet.setText("8000/-");
                break;
            }
            case "Tachyon":
            {
                style1.setVisibility(View.VISIBLE);
                style2.setVisibility(View.GONE);
                one.setVisibility(View.GONE);
                two.setVisibility(View.GONE);
                three.setVisibility(View.GONE);
                prizet.setText("43000/-");
                break;
            }
            case "MAC FIFA":
            {
                style1.setVisibility(View.VISIBLE);
                style2.setVisibility(View.GONE);
                one.setVisibility(View.GONE);
                two.setVisibility(View.GONE);
                three.setVisibility(View.GONE);
                prizet.setText("17000/-");
                break;
            }
            case "360 Mania":
            {
                style1.setVisibility(View.VISIBLE);
                style2.setVisibility(View.GONE);
                one.setVisibility(View.GONE);
                two.setVisibility(View.GONE);
                three.setVisibility(View.GONE);
                prizet.setText("15000/-");
                break;
            }
            case "Shapeshifter":
            {
                style1.setVisibility(View.VISIBLE);
                style2.setVisibility(View.GONE);
                one.setVisibility(View.GONE);
                two.setVisibility(View.GONE);
                three.setVisibility(View.GONE);
                prizet.setText("18000/-");
                break;
            }
            case "Kurukshetra":
            {
                style1.setVisibility(View.VISIBLE);
                style2.setVisibility(View.GONE);
                one.setVisibility(View.GONE);
                two.setVisibility(View.GONE);
                three.setVisibility(View.GONE);
                prizet.setText("25000/-");
                break;
            }
            case "Battleship":
            {
                style1.setVisibility(View.VISIBLE);
                style2.setVisibility(View.GONE);
                one.setVisibility(View.GONE);
                two.setVisibility(View.GONE);
                three.setVisibility(View.GONE);
                prizet.setText("18000/-");
                break;
            }
            case "NSCET":
            {
                style1.setVisibility(View.VISIBLE);
                style2.setVisibility(View.GONE);
                one.setVisibility(View.GONE);
                two.setVisibility(View.GONE);
                three.setVisibility(View.GONE);
                prizet.setText("30000/-");
                break;
            }
            case "Exempler":
            {
                style1.setVisibility(View.GONE);
                style2.setVisibility(View.VISIBLE);
                f1.setText("");
                f2.setText("");
                ft.setText("Total : 3000");
                s1.setText("");
                s2.setText("");
                st.setText("Total : 3000");
                t_1.setText("");
                t2.setText("");
                tt.setText("Total : 3000");
                first.setVisibility(View.GONE);
                second.setVisibility(View.GONE);
                third.setVisibility(View.GONE);
                more_details.setText("1st : 5500\n" +
                        "2nd : 4500\n" +
                        "3rd : 3500\n" +
                        "4th : 2500");
                style2_total.setText("16000/-");
                break;
            }
            default: {
                style1.setVisibility(View.VISIBLE);
                style2.setVisibility(View.GONE);
                prize1.setText(MainActivity.data.get(SubEventsActivity.position).getPrize1().toString());
                prize2.setText(MainActivity.data.get(SubEventsActivity.position).getPrize2().toString());
                prize3.setText(MainActivity.data.get(SubEventsActivity.position).getPrize3().toString());
                prizet.setText(MainActivity.data.get(SubEventsActivity.position).getPrizeT().toString()+"/-");

//                prize1.setText("prize 1");
//                    prize2.setText("prize 1");
//                    prize3.setText("prize 1");
//                    prizet.setText("prize 1");

                break;}
        }






    }
}
