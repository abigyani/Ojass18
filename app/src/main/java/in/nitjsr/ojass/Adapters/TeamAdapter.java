package in.nitjsr.ojass.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import in.nitjsr.ojass.Activities.TeamActivity;
import in.nitjsr.ojass.Modals.Team;
import in.nitjsr.ojass.R;
import in.nitjsr.ojass.Utils.Utilities;

/**
 * Created by Abhishek on 30-Jan-18.
 */

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Team> teamList;

    public TeamAdapter(Context context, ArrayList<Team> teamList){
        this.context = context;
        this.teamList = teamList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_team, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Team team = teamList.get(position);
        Utilities.setPicassoImage(context, team.getImageSrc(), holder.iv);
        holder.tvName.setText(team.getName());
        holder.tvDesg.setText(team.getDesg());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TeamActivity.setResourceOnClick(team);
            }
        });
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tvName, tvDesg;
        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_team_img);
            tvName = itemView.findViewById(R.id.team_name);
            tvDesg = itemView.findViewById(R.id.team_desg);
        }
    }
}
