package in.nitjsr.ojass.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import in.nitjsr.ojass.Fragments.EventsFragmentNew;
import in.nitjsr.ojass.Modals.Modal;
import in.nitjsr.ojass.R;
import in.nitjsr.ojass.Utils.Constants;
import in.nitjsr.ojass.Utils.Utilities;

/**
 * Created by Abhishek on 12-Feb-18.
 */

public class EventAdapterNew extends RecyclerView.Adapter<EventAdapterNew.ViewHolder> {

    private ArrayList<Modal> eventList;
    private Context context;

    public EventAdapterNew(Context context, ArrayList<Modal> eventList){
        this.context = context;
        this.eventList = eventList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_event_new, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        switch (position % 5){
            case 0: holder.rlBg.setBackgroundColor(context.getResources().getColor(R.color.card1));break;
            case 1: holder.rlBg.setBackgroundColor(context.getResources().getColor(R.color.card2));break;
            case 2: holder.rlBg.setBackgroundColor(context.getResources().getColor(R.color.card3));break;
            case 3: holder.rlBg.setBackgroundColor(context.getResources().getColor(R.color.card4));break;
            case 4: holder.rlBg.setBackgroundColor(context.getResources().getColor(R.color.card5));break;
        }
        final Modal event = eventList.get(position);
        Utilities.setPicassoImage(context, event.getImage(), holder.ivEventSrc, Constants.SQUA_PLACEHOLDER);
        holder.tvEventName.setText(event.getEventName());
        holder.tvEventPrize.setText(event.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventsFragmentNew.getEventDetail(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout rlBg;
        TextView tvEventName, tvEventPrize;
        ImageView ivEventSrc;

        public ViewHolder(View itemView) {
            super(itemView);
            rlBg = itemView.findViewById(R.id.rl_event_bg);
            tvEventName = itemView.findViewById(R.id.tv_event_name_new);
            tvEventPrize = itemView.findViewById(R.id.tv_event_prize_new);
            ivEventSrc = itemView.findViewById(R.id.iv_event_img_new);
        }
    }
}
