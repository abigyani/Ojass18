package in.nitjsr.ojass.EventsFolding;


import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import in.nitjsr.ojass.Fragments.EventsFragment;
import in.nitjsr.ojass.R;

public class BranchHeadDialogFragment extends DialogFragment {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    LayoutInflater inflater;
    View v;
    private String[] br_head_name;
    private String[] br_head_phone;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        inflater = getActivity().getLayoutInflater();
        v = inflater.inflate(R.layout.fragment_branch_head_dialog, null);

        recyclerView = (RecyclerView) v.findViewById(R.id.br_head_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        switch(EventsFragment.SE){
            case 0:
                br_head_name = BranchHeadDetails.Riseofmachinename;
                br_head_phone = BranchHeadDetails.Riseofmachinephone;
                break;
            case 1:
                br_head_name = BranchHeadDetails.VishwacodeGenesisname;
                br_head_phone = BranchHeadDetails.VishwacodeGenesisphone;
                break;
            case 2:
                br_head_name = BranchHeadDetails.CircuitHousename;
                br_head_phone = BranchHeadDetails.CircuitHousephone;
                break;
            case 3:
                br_head_name = BranchHeadDetails.SiliconValleyname;
                br_head_phone = BranchHeadDetails.SiliconValleyphone;
                break;
            case 4:
                br_head_name = BranchHeadDetails.Arthashastraname;
                br_head_phone = BranchHeadDetails.Arthashastraaphone;
                break;
            case 5:
                br_head_name = BranchHeadDetails.Aakritiname;
                br_head_phone = BranchHeadDetails.Aakritiphone;
                break;
            case 6:
                br_head_name = BranchHeadDetails.DuesExMachinaname;
                br_head_phone = BranchHeadDetails.DuesExMachinaphone;
                break;
            case 7:
                br_head_name = BranchHeadDetails.Produsname;
                br_head_phone = BranchHeadDetails.Produsphone;
                break;
            case 8:
                br_head_name = BranchHeadDetails.Paraphernalianame;
                br_head_phone = BranchHeadDetails.Paraphernaliaphone;
                break;
            case 9:
                br_head_name = BranchHeadDetails.Neodrishtiname;
                br_head_phone = BranchHeadDetails.Neodrishtiphone;
                break;
            case 10:
                br_head_name = BranchHeadDetails.Avratanname;
                br_head_phone = BranchHeadDetails.Avratanphone;
                break;
            case 11:
                br_head_name = BranchHeadDetails.Armageddonname;
                br_head_phone = BranchHeadDetails.Armageddonphone;
                break;
            case 12:
                br_head_name = BranchHeadDetails.Prayasname;
                br_head_phone = BranchHeadDetails.Prayasphone;
                break;
            case 13:
                br_head_name = BranchHeadDetails.Nogroundzonename;
                br_head_phone = BranchHeadDetails.Nogroundzonephone;
                break;
            case 14:
                br_head_name = BranchHeadDetails.Nscetname;
                br_head_phone = BranchHeadDetails.Nscetphone;
                break;
            case 15:
                br_head_name = BranchHeadDetails.LiveCSname;
                br_head_phone = BranchHeadDetails.LiveCSphone;
                break;
            case 16:
                br_head_name = BranchHeadDetails.Exposicionname;
                br_head_phone = BranchHeadDetails.Exposicionphone;
                break;
        }

        adapter = new BranchHeadRVAdapter(br_head_name, br_head_phone, getActivity().getApplicationContext());
        recyclerView.setAdapter(adapter);

        Dialog dialog = new Dialog(getActivity());
     //   dialog.setTitle("                 Pioneers");
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(v);
        dialog.getWindow().setLayout((int)getScreenWidth(getActivity()),
                WindowManager.LayoutParams.WRAP_CONTENT);
        return dialog;
    }

    public static int getScreenWidth(Activity activity)  {
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(size);
        return size.x;
    }

}
