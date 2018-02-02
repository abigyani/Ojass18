package in.nitjsr.ojass.EventsFolding;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.nitjsr.ojass.R;

public class BranchHeadRVAdapter extends RecyclerView.Adapter<BranchHeadRVAdapter.BranchHeadViewHolder> {

    private Context context;
    private String[] br_head_name;
    private String[] br_head_phone;

    public static class BranchHeadViewHolder extends RecyclerView.ViewHolder {

        TextView name, phone;
        CardView cd;

        public BranchHeadViewHolder(View itemView) {
            super(itemView);
            this.cd=(CardView)itemView.findViewById(R.id.cd);
            this.name = (TextView) itemView.findViewById(R.id.br_head_name);
            this.phone = (TextView) itemView.findViewById(R.id.br_head_phone);
        }
    }

    public BranchHeadRVAdapter(String[] br_head_name, String[] br_head_phone, Context context) {
        this.br_head_name = br_head_name;
        this.br_head_phone = br_head_phone;
        this.context = context;
    }

    @Override
    public BranchHeadViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.branch_head_layout, parent, false);
        //    view.setOnClickListener(MainActivity.myOnClickListener);

        BranchHeadViewHolder viewHolder = new BranchHeadViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final BranchHeadViewHolder holder, final int listPosition) {

        holder.name.setText(br_head_name[listPosition]);
        holder.phone.setText(br_head_phone[listPosition]);
        holder.cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = holder.phone.getText().toString();
                if(number.length() > 2)
                    callPhoneIntent(number);
            }
        });

    /*    Typeface tf1 = Typeface.createFromAsset(context.getAssets(), font_name);
        Typeface tf2 = Typeface.createFromAsset(context.getAssets(), font_name);
        holder.name.setTypeface(tf1);
        holder.phone.setTypeface(tf1);    */
    }

    @Override
    public int getItemCount() {
        return br_head_name.length;
    }

    public void callPhoneIntent(String number) {
        number = number.trim();
        try {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.e("CALL_INTENT", "CALL FAILED", e);
        }
    }
}
