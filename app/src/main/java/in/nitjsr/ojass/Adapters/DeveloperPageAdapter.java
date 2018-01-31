package in.nitjsr.ojass.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;
import java.util.zip.Inflater;

import in.nitjsr.ojass.Activities.Developerspage;
import in.nitjsr.ojass.Modals.Devpage_modal;
import in.nitjsr.ojass.R;

/**
 * Created by Sanay on 1/31/2018.
 */

public class DeveloperPageAdapter extends RecyclerView.Adapter<Myviewholder> {

    List<Devpage_modal> mdevInfo = Collections.emptyList();
    Context mcontext;

    private LayoutInflater layoutInflater;
    public DeveloperPageAdapter(Context context , List<Devpage_modal> devInfo)
    {
        layoutInflater = LayoutInflater.from(context);
        mdevInfo = devInfo;
        mcontext = context;
    }

    @Override
    public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.devpage_single_element,parent,false);
        Myviewholder holder = new Myviewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Myviewholder holder, int position) {
        final Devpage_modal current = mdevInfo.get(position);
        holder.image.setImageResource(current.getImage());
        holder.name.setText(current.getName());
        holder.name.setText(current.getDescription());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Developerspage.setDeveloperImage(current);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mdevInfo.size();
    }
}

class Myviewholder extends RecyclerView.ViewHolder
{

    ImageView image;
    TextView name;
    TextView desc;

    public Myviewholder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.dev_img);
        name = itemView.findViewById(R.id.dev_name);
        desc = itemView.findViewById(R.id.dev_desc);
    }
}


