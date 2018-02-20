package in.nitjsr.ojass.Fragments;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import in.nitjsr.ojass.Adapters.EventAdapterNew;
import in.nitjsr.ojass.EventsFolding.SubEventsActivity;
import in.nitjsr.ojass.Modals.Modal;
import in.nitjsr.ojass.R;
import in.nitjsr.ojass.Utils.Constants;
import in.nitjsr.ojass.Utils.Utilities;

import static in.nitjsr.ojass.Utils.Constants.eventNames;
import static in.nitjsr.ojass.Utils.Constants.largeEventImage;
import static in.nitjsr.ojass.Utils.Constants.smallEventImage;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragmentNew extends Fragment {

    private static Context context;

    public EventsFragmentNew() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_events_new, container, false);
        RecyclerView rv = view.findViewById(R.id.rv_events_new);
        rv.setHasFixedSize(true);
        GridLayoutManager gm = new GridLayoutManager(getContext(), 2);
        rv.setLayoutManager(gm);
        rv.setAdapter(new EventAdapterNew(getContext(), prepareEventData()));
        context = getContext();
        return view;
    }

    private ArrayList<Modal> prepareEventData() {
        ArrayList<Modal> models = new ArrayList<>();
        models.add(new Modal(smallEventImage[0], eventNames[0], "Prizes worth: \u20B960,000*"));
        models.add(new Modal(smallEventImage[1], eventNames[1], "Prizes worth: \u20B985,000*"));
        models.add(new Modal(smallEventImage[2], eventNames[2], "Prizes worth: \u20B968,500*"));
        models.add(new Modal(smallEventImage[3], eventNames[3], "Prizes worth: \u20B930,000*"));
        models.add(new Modal(smallEventImage[4], eventNames[4], "Prizes worth: \u20B957,000*"));
        models.add(new Modal(smallEventImage[5], eventNames[5], "Prizes worth: \u20B91,19,000*"));
        models.add(new Modal(smallEventImage[6], eventNames[6], "Prizes worth: \u20B964,000*"));
        models.add(new Modal(smallEventImage[7], eventNames[7], "Prizes worth: \u20B945,000*"));
        models.add(new Modal(smallEventImage[8], eventNames[8], "Prizes worth: \u20B977,000*"));
        models.add(new Modal(smallEventImage[9], eventNames[9], "Prizes worth: \u20B933,000*"));
        models.add(new Modal(smallEventImage[10], eventNames[10], "Prizes worth: \u20B933,000*"));
        models.add(new Modal(smallEventImage[11], eventNames[11], "Prizes worth: \u20B950,000*"));
        models.add(new Modal(smallEventImage[12], eventNames[12], "Prizes worth: \u20B920,000*"));
        models.add(new Modal(smallEventImage[13], eventNames[13], "Prizes worth: \u20B965,000*"));
        models.add(new Modal(smallEventImage[14], eventNames[14], "Prizes worth: \u20B930,000*"));
        models.add(new Modal(smallEventImage[15], eventNames[15], "Prizes worth: \u20B910,000*"));
        models.add(new Modal(smallEventImage[16], eventNames[16], "Prizes worth: \u20B912,000*"));
        return models;
    }

    public static void getEventDetail(final int eventPos){
        Dialog dialog = new Dialog(context);
        dialog.getWindow().getAttributes().windowAnimations = R.style.event_zoom;
        dialog.setContentView(R.layout.event_list_new);
        final ListView eventList = dialog.findViewById(R.id.lv_event_list_new);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.tv_lv_event, Constants.EventList[eventPos]);
        eventList.setAdapter(adapter);
        Utilities.setPicassoImage(context, largeEventImage[eventPos], (ImageView)dialog.findViewById(R.id.iv_event_list_new), Constants.RECT_PLACEHOLDER);
        TextView tvName = dialog.findViewById(R.id.tv_event_name_list_new);
        tvName.setText(eventNames[eventPos]);
        final String alpha = "#9a";
        switch (eventPos % 5){
            case 0: tvName.setBackgroundColor(Color.parseColor(alpha+"2C556C"));break;
            case 1: tvName.setBackgroundColor(Color.parseColor(alpha+"207488"));break;
            case 2: tvName.setBackgroundColor(Color.parseColor(alpha+"89196B"));break;
            case 3: tvName.setBackgroundColor(Color.parseColor(alpha+"AD1457"));break;
            case 4: tvName.setBackgroundColor(Color.parseColor(alpha+"9C1825"));break;
        }
        dialog.show();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.findViewById(R.id.tv_dialog_pioneer).setElevation(5);
        }
        dialog.findViewById(R.id.tv_dialog_pioneer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(context, R.layout.tv_list_view_pioneer, Constants.branchHeadName[eventPos]);
                builder.setAdapter(adapter1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:+91"+Constants.branchHeadNum[eventPos][i]));
                        context.startActivity(intent);
                    }
                });
                builder.show();
            }
        });
        eventList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent subEvent =new Intent(context,SubEventsActivity.class);
                subEvent.putExtra("title",""+eventList.getItemAtPosition(i));
                context.startActivity(subEvent);
            }
        });
    }
}
