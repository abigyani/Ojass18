package in.nitjsr.ojass.EventsFolding;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ramotion.foldingcell.FoldingCell;

import java.util.HashSet;
import java.util.List;

import in.nitjsr.ojass.R;
import in.nitjsr.ojass.Utils.Constants;
import in.nitjsr.ojass.Utils.Utilities;

/**
 * Simple example of ListAdapter for using with Folding Cell
 * Adapter holds indexes of unfolded elements for correct work with default reusable views behavior
 */
public class FoldingCellListAdapter extends ArrayAdapter<Item> {

    public HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;


    public FoldingCellListAdapter(Context context, List<Item> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get item for selected view
        Item item = getItem(position);
        // if cell is exists - reuse it, if not - create the new one from resource
        FoldingCell cell = (FoldingCell) convertView;
        ViewHolder viewHolder;
        if (cell == null) {
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.cell, parent, false);

            viewHolder.IW1 = (View) cell.findViewById(R.id.v1);
            viewHolder.IW2 = (View) cell.findViewById(R.id.v2);
            viewHolder.IW3 = (View) cell.findViewById(R.id.v3);
            viewHolder.IW4 = (View) cell.findViewById(R.id.v4);
            viewHolder.IW5 = (View) cell.findViewById(R.id.v5);
            viewHolder.IW6 = (View) cell.findViewById(R.id.v6);
            viewHolder.IW7 = (View) cell.findViewById(R.id.v7);
            viewHolder.IW8 = (View) cell.findViewById(R.id.v8);
            viewHolder.IW9 = (View) cell.findViewById(R.id.v9);
            viewHolder.IW10 = (View) cell.findViewById(R.id.v10);
            viewHolder.textView1 = (TextView) cell.findViewById(R.id.textView1);
            viewHolder.textView2 = (TextView) cell.findViewById(R.id.textView2);
            viewHolder.textView3 = (TextView) cell.findViewById(R.id.textView3);
            viewHolder.textView4 = (TextView) cell.findViewById(R.id.textView4);
            viewHolder.textView5 = (TextView) cell.findViewById(R.id.textView5);
            viewHolder.textView6 = (TextView) cell.findViewById(R.id.textView6);
            viewHolder.textView7 = (TextView) cell.findViewById(R.id.textView7);
            viewHolder.textView8 = (TextView) cell.findViewById(R.id.textView8);
            viewHolder.textView9 = (TextView) cell.findViewById(R.id.textView9);
            viewHolder.textView10 = (TextView) cell.findViewById(R.id.textView10);
            viewHolder.textViewHead = (TextView) cell.findViewById(R.id.content_request_btn);
            viewHolder.C1 = (LinearLayout) cell.findViewById(R.id.c1);
            viewHolder.C2 = (LinearLayout) cell.findViewById(R.id.c2);
            viewHolder.C3 = (LinearLayout) cell.findViewById(R.id.c3);
            viewHolder.C4 = (LinearLayout) cell.findViewById(R.id.c4);
            viewHolder.C5 = (LinearLayout) cell.findViewById(R.id.c5);
            viewHolder.C6 = (LinearLayout) cell.findViewById(R.id.c6);
            viewHolder.C7 = (LinearLayout) cell.findViewById(R.id.c7);
            viewHolder.C8 = (LinearLayout) cell.findViewById(R.id.c8);
            viewHolder.C9 = (LinearLayout) cell.findViewById(R.id.c9);
            viewHolder.C10 = (LinearLayout) cell.findViewById(R.id.c10);

            viewHolder.I1 = (ImageView) cell.findViewById((R.id.head_image));
            viewHolder.I2 = (ImageView) cell.findViewById((R.id.head_image1));

            viewHolder.tvEventName = (TextView)cell.findViewById((R.id.head_event_name));
            viewHolder.tvEventName2 = (TextView)cell.findViewById((R.id.head_event_name2));
            viewHolder.tvEventTag = (TextView)cell.findViewById((R.id.head_event_tag));

            viewHolder.pioneerTextView=(TextView) cell.findViewById(R.id.content_request_btn);
            changeFont(viewHolder);
            cell.setTag(viewHolder);
        } else {
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.cell, parent, false);

            viewHolder.textViewHead = (TextView) cell.findViewById(R.id.content_request_btn);
            viewHolder.IW1 = (View) cell.findViewById(R.id.v1);
            viewHolder.IW2 = (View) cell.findViewById(R.id.v2);
            viewHolder.IW3 = (View) cell.findViewById(R.id.v3);
            viewHolder.IW4 = (View) cell.findViewById(R.id.v4);
            viewHolder.IW5 = (View) cell.findViewById(R.id.v5);
            viewHolder.IW6 = (View) cell.findViewById(R.id.v6);
            viewHolder.IW7 = (View) cell.findViewById(R.id.v7);
            viewHolder.IW8 = (View) cell.findViewById(R.id.v8);
            viewHolder.IW9 = (View) cell.findViewById(R.id.v9);
            viewHolder.IW10 = (View) cell.findViewById(R.id.v10);
            viewHolder.textView1 = (TextView) cell.findViewById(R.id.textView1);
            viewHolder.textView2 = (TextView) cell.findViewById(R.id.textView2);
            viewHolder.textView3 = (TextView) cell.findViewById(R.id.textView3);
            viewHolder.textView4 = (TextView) cell.findViewById(R.id.textView4);
            viewHolder.textView5 = (TextView) cell.findViewById(R.id.textView5);
            viewHolder.textView6 = (TextView) cell.findViewById(R.id.textView6);
            viewHolder.textView7 = (TextView) cell.findViewById(R.id.textView7);
            viewHolder.textView8 = (TextView) cell.findViewById(R.id.textView8);
            viewHolder.textView9 = (TextView) cell.findViewById(R.id.textView9);
            viewHolder.textView10 = (TextView) cell.findViewById(R.id.textView10);
            viewHolder.C1 = (LinearLayout) cell.findViewById(R.id.c1);
            viewHolder.C2 = (LinearLayout) cell.findViewById(R.id.c2);
            viewHolder.C3 = (LinearLayout) cell.findViewById(R.id.c3);
            viewHolder.C4 = (LinearLayout) cell.findViewById(R.id.c4);
            viewHolder.C5 = (LinearLayout) cell.findViewById(R.id.c5);
            viewHolder.C6 = (LinearLayout) cell.findViewById(R.id.c6);
            viewHolder.C7 = (LinearLayout) cell.findViewById(R.id.c7);
            viewHolder.C8 = (LinearLayout) cell.findViewById(R.id.c8);
            viewHolder.C9 = (LinearLayout) cell.findViewById(R.id.c9);
            viewHolder.C10 = (LinearLayout) cell.findViewById(R.id.c10);

            viewHolder.I1 = (ImageView) cell.findViewById((R.id.head_image));
            viewHolder.I2 = (ImageView) cell.findViewById((R.id.head_image1));

            viewHolder.tvEventName = (TextView)cell.findViewById((R.id.head_event_name));
            viewHolder.tvEventName2 = (TextView)cell.findViewById((R.id.head_event_name2));
            viewHolder.tvEventTag = (TextView)cell.findViewById((R.id.head_event_tag));

            viewHolder.pioneerTextView=(TextView) cell.findViewById(R.id.content_request_btn);
            changeFont(viewHolder);
            cell.setTag(viewHolder);
            // for existing cell set valid valid state(without animation)
            if (unfoldedIndexes.contains(position)) {
                cell.unfold(true);
            } else {
                cell.fold(true);
            }
            viewHolder = (ViewHolder) cell.getTag();
        }


        // bind data from selected element to view through view holder
        // viewHolder.price.setText(item.getPrice());
        // viewHolder.time.setText(item.getTime());
        // viewHolder.date.setText(item.getDate());
        // viewHolder.fromAddress.setText(item.getFromAddress());
        // viewHolder.toAddress.setText(item.getToAddress());
        // viewHolder.requestsCount.setText(String.valueOf(item.getRequestsCount()));
        // viewHolder.pledgePrice.setText(item.getPledgePrice());

        Utilities.setPicassoImage(getContext(), item.getImage(), viewHolder.I2, Constants.SQUA_PLACEHOLDER);
        Utilities.setPicassoImage(getContext(), item.getImage1(), viewHolder.I1, Constants.RECT_PLACEHOLDER);
        viewHolder.tvEventName.setText(item.getHeadEventName());
        viewHolder.tvEventName2.setText(item.getHeadEventName());
        viewHolder.tvEventTag.setText(item.getHeadEventTag());

        if (item.getSub1() != null) {
            viewHolder.C1.setVisibility(View.VISIBLE);
            viewHolder.IW1.setVisibility(View.VISIBLE);
            viewHolder.textView1.setText(item.getSub1());
        } else {
            viewHolder.IW1.setVisibility(View.GONE);
            viewHolder.C1.setVisibility(View.GONE);
        }
        if (item.getSub2() != null) {
            viewHolder.C2.setVisibility(View.VISIBLE);
            viewHolder.IW2.setVisibility(View.VISIBLE);
            viewHolder.textView2.setText(item.getSub2());
        } else {
            viewHolder.IW2.setVisibility(View.GONE);
            viewHolder.C2.setVisibility(View.GONE);
        }
        if (item.getSub3() != null) {
            viewHolder.C3.setVisibility(View.VISIBLE);
            viewHolder.IW3.setVisibility(View.VISIBLE);
            viewHolder.textView3.setText(item.getSub3());
        } else {
            viewHolder.IW3.setVisibility(View.GONE);
            viewHolder.C3.setVisibility(View.GONE);
        }
        if (item.getSub4() != null) {
            viewHolder.C4.setVisibility(View.VISIBLE);
            viewHolder.IW4.setVisibility(View.VISIBLE);
            viewHolder.textView4.setText(item.getSub4());
        } else {
            viewHolder.IW4.setVisibility(View.GONE);
            viewHolder.C4.setVisibility(View.GONE);
        }
        if (item.getSub5() != null) {
            viewHolder.C5.setVisibility(View.VISIBLE);
            viewHolder.IW5.setVisibility(View.VISIBLE);
            viewHolder.textView5.setText(item.getSub5());
        } else {
            viewHolder.IW5.setVisibility(View.GONE);
            viewHolder.C5.setVisibility(View.GONE);
        }
        if (item.getSub6() != null) {
            viewHolder.C6.setVisibility(View.VISIBLE);
            viewHolder.IW6.setVisibility(View.VISIBLE);
            viewHolder.textView6.setText(item.getSub6());
        } else {
            viewHolder.IW6.setVisibility(View.GONE);
            viewHolder.C6.setVisibility(View.GONE);
        }
        if (item.getSub7() != null) {
            viewHolder.C7.setVisibility(View.VISIBLE);
            viewHolder.IW7.setVisibility(View.VISIBLE);
            viewHolder.textView7.setText(item.getSub7());
        } else {
            viewHolder.IW7.setVisibility(View.GONE);
            viewHolder.C7.setVisibility(View.GONE);
        }
        if (item.getSub8() != null) {
            viewHolder.C8.setVisibility(View.VISIBLE);
            viewHolder.IW8.setVisibility(View.VISIBLE);
            viewHolder.textView8.setText(item.getSub8());
        } else {
            viewHolder.IW8.setVisibility(View.GONE);
            viewHolder.C8.setVisibility(View.GONE);
        }
        if (item.getSub9() != null) {
            viewHolder.IW9.setVisibility(View.VISIBLE);
            viewHolder.C9.setVisibility(View.VISIBLE);
            viewHolder.textView9.setText(item.getSub9());
        } else {
            viewHolder.IW9.setVisibility(View.GONE);
            viewHolder.C9.setVisibility(View.GONE);
        }
        if (item.getSub10() != null) {
            viewHolder.IW10.setVisibility(View.VISIBLE);
            viewHolder.C10.setVisibility(View.VISIBLE);
            viewHolder.textView10.setText(item.getSub10());
        } else {
            viewHolder.IW10.setVisibility(View.GONE);
            viewHolder.C10.setVisibility(View.GONE);
        }
        // set custom btn handler for list item from that item
        if (item.getRequestBtnClickListener() != null) {
            viewHolder.textView1.setOnClickListener(item.getRequestBtnClickListener());
        } else {
            // (optionally) add "default" handler if no handler found in item
            viewHolder.textView1.setOnClickListener(defaultRequestBtnClickListener);
        }
        if (item.getRequestBtnClickListener2() != null) {
            viewHolder.textView2.setOnClickListener(item.getRequestBtnClickListener2());
        } else {
            // (optionally) add "default" handler if no handler found in item
            viewHolder.textView2.setOnClickListener(defaultRequestBtnClickListener);
        }
        if (item.getRequestBtnClickListener3() != null) {
            viewHolder.textView3.setOnClickListener(item.getRequestBtnClickListener3());
        } else {
            // (optionally) add "default" handler if no handler found in item
            viewHolder.textView3.setOnClickListener(defaultRequestBtnClickListener);
        }
        if (item.getRequestBtnClickListener4() != null) {
            viewHolder.textView4.setOnClickListener(item.getRequestBtnClickListener4());
        } else {
            // (optionally) add "default" handler if no handler found in item
            viewHolder.textView4.setOnClickListener(defaultRequestBtnClickListener);
        }
        if (item.getRequestBtnClickListener5() != null) {
            viewHolder.textView5.setOnClickListener(item.getRequestBtnClickListener5());
        } else {
            // (optionally) add "default" handler if no handler found in item
            viewHolder.textView5.setOnClickListener(defaultRequestBtnClickListener);
        }
        if (item.getRequestBtnClickListener6() != null) {
            viewHolder.textView6.setOnClickListener(item.getRequestBtnClickListener6());
        } else {
            // (optionally) add "default" handler if no handler found in item
            viewHolder.textView6.setOnClickListener(defaultRequestBtnClickListener);
        }
        if (item.getRequestBtnClickListener7() != null) {
            viewHolder.textView7.setOnClickListener(item.getRequestBtnClickListener7());
        } else {
            // (optionally) add "default" handler if no handler found in item
            viewHolder.textView7.setOnClickListener(defaultRequestBtnClickListener);
        }
        if (item.getRequestBtnClickListener8() != null) {
            viewHolder.textView8.setOnClickListener(item.getRequestBtnClickListener8());
        } else {
            // (optionally) add "default" handler if no handler found in item
            viewHolder.textView8.setOnClickListener(defaultRequestBtnClickListener);
        }
        if (item.getRequestBtnClickListener9() != null) {
            viewHolder.textView9.setOnClickListener(item.getRequestBtnClickListener9());
        } else {
            // (optionally) add "default" handler if no handler found in item
            viewHolder.textView9.setOnClickListener(defaultRequestBtnClickListener);
        }
        if (item.getRequestBtnClickListener10() != null) {
            viewHolder.textView10.setOnClickListener(item.getRequestBtnClickListener10());
        } else {
            // (optionally) add "default" handler if no handler found in item
            viewHolder.textView10.setOnClickListener(defaultRequestBtnClickListener);
        }
        if (item.getRequestBtnClickListener11() != null) {
            viewHolder.pioneerTextView.setOnClickListener(item.getRequestBtnClickListener11());
        } else {
            // (optionally) add "default" handler if no handler found in item
            viewHolder.pioneerTextView.setOnClickListener(defaultRequestBtnClickListener);
        }

        return cell;
    }

    private void changeFont(ViewHolder viewHolder) {

        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "ToolbarText.ttf");
        viewHolder.textView1.setTypeface(typeface);
        viewHolder.textView2.setTypeface(typeface);
        viewHolder.textView3.setTypeface(typeface);
        viewHolder.textView4.setTypeface(typeface);
        viewHolder.textView5.setTypeface(typeface);
        viewHolder.textView6.setTypeface(typeface);
        viewHolder.textView7.setTypeface(typeface);
        viewHolder.textView8.setTypeface(typeface);
        viewHolder.textView9.setTypeface(typeface);
        viewHolder.textView10.setTypeface(typeface);
        viewHolder.pioneerTextView.setTypeface(typeface);
    }

    // simple methods for register cell state changes
    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    public void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }

    public View.OnClickListener getDefaultRequestBtnClickListener() {
        return defaultRequestBtnClickListener;
    }

    public void setDefaultRequestBtnClickListener(View.OnClickListener defaultRequestBtnClickListener) {
        this.defaultRequestBtnClickListener = defaultRequestBtnClickListener;
    }

    // View lookup cache
    private static class ViewHolder {
        TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, tvEventName,
                tvEventName2, tvEventTag, textViewHead,pioneerTextView;
        View IW1, IW2, IW3, IW4, IW5, IW6, IW7, IW8, IW9, IW10;
        LinearLayout C1, C2, C3, C4, C5, C6, C7, C8, C9, C10;
        ImageView I1, I2;
    }
}
