package in.nitjsr.ojass.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;

import in.nitjsr.ojass.Modals.TitleChild;
import in.nitjsr.ojass.Modals.TitleParent;
import in.nitjsr.ojass.R;
import in.nitjsr.ojass.Utils.TitleChildViewHolder;
import in.nitjsr.ojass.Utils.TitleParentViewHolder;

/**
 * Created by admin on 19-01-2017.
 */

public class FAQAdapter extends ExpandableRecyclerAdapter<TitleParentViewHolder,TitleChildViewHolder> {

    LayoutInflater inflater;
    Context context;

    public FAQAdapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public TitleParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view=inflater.inflate(R.layout.faq_parent_layout,viewGroup,false);
        return new TitleParentViewHolder(view);
    }

    @Override
    public TitleChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view=inflater.inflate(R.layout.faq_child_layout,viewGroup,false);
        return new TitleChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(TitleParentViewHolder titleParentViewHolder, int i, Object o) {
        TitleParent title = (TitleParent)o;
        Typeface typeface = Typeface.createFromAsset(context.getAssets(),"opificio_bold.ttf");
        titleParentViewHolder._textView.setText(title.getTitle());
        titleParentViewHolder._textView.setTypeface(typeface);

    }

    @Override
    public void onBindChildViewHolder(TitleChildViewHolder titleChildViewHolder, int i, Object o) {
        TitleChild title=(TitleChild)o;
        Typeface typeface = Typeface.createFromAsset(context.getAssets(),"opificio_regular.ttf");

        titleChildViewHolder.option1.setText(title.getOption1());
        titleChildViewHolder.option1.setTypeface(typeface);

    }
}
