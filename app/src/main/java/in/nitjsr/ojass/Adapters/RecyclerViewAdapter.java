package in.nitjsr.ojass.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import in.nitjsr.ojass.Activities.TeamActivity;
import in.nitjsr.ojass.Modals.Modal;
import in.nitjsr.ojass.R;
import in.nitjsr.ojass.Utils.Utilities;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<Modal> dataset;
    private Context context;
    public RecyclerViewAdapter(ArrayList<Modal> dataset, Context context) {
        this.dataset = dataset;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_recyclerview, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Modal current = dataset.get(position);
        if (current.getImage() != null) Utilities.setPicassoImage(context, current.getImage(), holder.eventImg);
        else Picasso.with(context).load(current.getDrawableImage()).fit().into(holder.eventImg);

        holder.evenTitle.setText(current.getEventName());
        holder.eventDesc.setText(current.getDescription());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView evenTitle, eventDesc;
        public ImageView eventImg;
        public ViewHolder(View itemView) {
            super(itemView);
            evenTitle = itemView.findViewById(R.id.event_title);
            eventImg = itemView.findViewById(R.id.eventImg);
            eventDesc = itemView.findViewById(R.id.event_description);
        }
    }
}
