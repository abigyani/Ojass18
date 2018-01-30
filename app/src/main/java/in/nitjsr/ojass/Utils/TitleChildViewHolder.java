package in.nitjsr.ojass.Utils;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

import in.nitjsr.ojass.R;

/**
 * Created by admin on 19-01-2017.
 */

public class TitleChildViewHolder extends ChildViewHolder {

    public TextView option1;

    public TitleChildViewHolder(View itemView) {
        super(itemView);
        option1=(TextView)itemView.findViewById(R.id.option1);
    }
}
