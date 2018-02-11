package in.nitjsr.ojass.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.List;

import in.nitjsr.ojass.R;


public class SubscribeFragment extends DialogFragment {

    private ListView mainListView;
    private mItems[] itemss;
    private ArrayAdapter<mItems> listAdapter;
    ArrayList<String> checked = new ArrayList<String>();
    private static final String PREFS_TEXT="SubscribeInfo";
    private static final String ID="Checked";
    private CheckBox cbSubscribe;
    private static final String SUB_ALL = "subAll";
    private SharedPreferences sharedPreferences;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.fragment_subscribe,null);

        mainListView = (ListView)view.findViewById(R.id.mainListView);
        cbSubscribe = view.findViewById(R.id.cb_subscribe_all);

        sharedPreferences=getActivity().getSharedPreferences(PREFS_TEXT,Context.MODE_PRIVATE);
        String Id=sharedPreferences.getString(ID," ");

        if (sharedPreferences.getBoolean(SUB_ALL, false)) cbSubscribe.setChecked(true);
        else cbSubscribe.setChecked(false);

        mainListView
                .setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View item,
                                            int position, long id) {
                        mItems planet = listAdapter.getItem(position);
                        planet.toggleChecked();
                        SelectViewHolder viewHolder = (SelectViewHolder) item
                                .getTag();
                        viewHolder.getCheckBox().setChecked(planet.isChecked());

                    }
                });

        // Create and populate planets.
        itemss = (mItems[])getActivity().getLastNonConfigurationInstance();

        final ArrayList<mItems> planetList = new ArrayList<mItems>();
        final ArrayList<mItems> planetList1 = new ArrayList<mItems>();

        planetList.add(new mItems("Arthashastra"));
        planetList.add(new mItems("Circuit House"));
        planetList.add(new mItems("Vishwa CodeGenesis"));
        planetList.add(new mItems("No Ground Zone"));
        planetList.add(new mItems("Paraphernalia"));
        planetList.add(new mItems("Produs"));
        planetList.add(new mItems("Silicon Valley"));
        planetList.add(new mItems("Rise Of Machines"));
        planetList.add(new mItems("NSCET"));
        planetList.add(new mItems("Neo Drishti"));
        planetList.add(new mItems("Exposicion"));
        planetList.add(new mItems("Deus-X-Machina"));
        planetList.add(new mItems("Avartan"));
        planetList.add(new mItems("Armageddon"));
        planetList.add(new mItems("Aakriti"));
        planetList.add(new mItems("Prayas"));
        planetList.add(new mItems("Live CS"));

        planetList1.add(new mItems("Arthashastra"));
        planetList1.add(new mItems("CircuitHouse"));
        planetList1.add(new mItems("VishwaCodeGenesis"));
        planetList1.add(new mItems("NoGroundZone"));
        planetList1.add(new mItems("Paraphernalia"));
        planetList1.add(new mItems("Produs"));
        planetList1.add(new mItems("SiliconValley"));
        planetList1.add(new mItems("RiseOfMachines"));
        planetList1.add(new mItems("NSCET"));
        planetList1.add(new mItems("NeoDrishti"));
        planetList1.add(new mItems("Exposicion"));
        planetList1.add(new mItems("DeusXMachina"));
        planetList1.add(new mItems("Avartan"));
        planetList1.add(new mItems("Armageddon"));
        planetList1.add(new mItems("Aakriti"));
        planetList1.add(new mItems("Prayas"));
        planetList1.add(new mItems("LiveCS"));


        FirebaseApp.initializeApp(getActivity());

        if(!Id.trim().equals(""))
        {
            String n[]=Id.trim().split(" ");
            for(int i=0;i<n.length;i++)
            {
                planetList.get(Integer.parseInt(n[i])).setChecked(true);
            }

        }



        // Set our custom array adapter as the ListView's adapter.
        listAdapter = new SelectArralAdapter(getActivity(), planetList);
        mainListView.setAdapter(listAdapter);

        cbSubscribe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    for (int i = 0 ; i < 17; i++){
                        //((CheckBox)mainListView.getChildAt(i).findViewById(R.id.CheckBox01)).setChecked(true);
                        planetList.get(i).setChecked(true);
                    }
                } else {
                    for (int i = 0 ; i < 17; i++){
                        //((CheckBox)mainListView.getChildAt(i).findViewById(R.id.CheckBox01)).setChecked(false);
                        planetList.get(i).setChecked(false);
                    }
                }
                listAdapter.notifyDataSetChanged();

            }
        });

        builder.setTitle("Subscribe for Event notifications")
                .setView(view)
                .setPositiveButton("Subscribe", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                        checked.clear();
                        mItems temp;
                        int listSize = planetList.size();
                        int i;
                        String pos="";
                        for(i=0;i<listSize;i++)
                        {
                            FirebaseMessaging.getInstance().unsubscribeFromTopic(planetList1.get(i).getName());
                            if(planetList.get(i).isChecked())
                            {checked.add(planetList1.get(i).getName());
                                pos=pos+" "+i;}
                        }
                        for(i=0;i<checked.size();i++)
                        {
                            FirebaseMessaging.getInstance().subscribeToTopic(checked.get(i));
                            //Toast.makeText(getActivity(),"selected list is : "+checked.get(i),Toast.LENGTH_SHORT).show();
                        }
                        //Toast.makeText(getActivity(),"selected list is : "+checked.size(),Toast.LENGTH_SHORT).show();

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(ID,pos.trim());
                        if (cbSubscribe.isChecked()) editor.putBoolean(SUB_ALL, true);
                        else editor.putBoolean(SUB_ALL, false);
                        //Toast.makeText(getActivity(),"selected list is : "+pos,Toast.LENGTH_SHORT).show();
                        editor.apply();
                        Toast.makeText(getContext(),"Subscriptions Updated!",Toast.LENGTH_SHORT).show();

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();

    }

    private static class mItems {
        private String name = "";
        private boolean checked = false;

        public mItems() {
        }

        public mItems(String name) {
            this.name = name;
        }

        public mItems(String name, boolean checked) {
            this.name = name;
            this.checked = checked;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }

        public String toString() {
            return name;
        }

        public void toggleChecked() {
            checked = !checked;
        }
    }

    /** Holds child views for one row. */
    private static class SelectViewHolder {
        private CheckBox checkBox;
        private TextView textView;

        public SelectViewHolder() {
        }

        public SelectViewHolder(TextView textView, CheckBox checkBox) {
            this.checkBox = checkBox;
            this.textView = textView;
        }

        public CheckBox getCheckBox() {
            return checkBox;
        }

        public void setCheckBox(CheckBox checkBox) {
            this.checkBox = checkBox;
        }

        public TextView getTextView() {
            return textView;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }
    }

    /** Custom adapter for displaying an array of Planet objects. */
    private static class SelectArralAdapter extends ArrayAdapter<mItems> {
        private LayoutInflater inflater;

        public SelectArralAdapter(Context context, List<mItems> planetList) {
            super(context, R.layout.simplerow, R.id.rowTextView, planetList);
            // Cache the LayoutInflate to avoid asking for a new one each time.
            inflater = LayoutInflater.from(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Planet to display
            mItems planet = (mItems) this.getItem(position);

            // The child views in each row.
            CheckBox checkBox;
            TextView textView;

            // Create a new row view
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.simplerow, null);

                // Find the child views.
                textView = (TextView) convertView
                        .findViewById(R.id.rowTextView);
                checkBox = (CheckBox) convertView.findViewById(R.id.CheckBox01);
                // Optimization: Tag the row with it's child views, so we don't
                // have to
                // call findViewById() later when we reuse the row.
                convertView.setTag(new SelectViewHolder(textView, checkBox));
                // If CheckBox is toggled, update the planet it is tagged with.
                checkBox.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v;
                        mItems planet = (mItems) cb.getTag();
                        planet.setChecked(cb.isChecked());
                    }
                });
            }
            // Reuse existing row view
            else {
                // Because we use a ViewHolder, we avoid having to call
                // findViewById().
                SelectViewHolder viewHolder = (SelectViewHolder) convertView
                        .getTag();
                checkBox = viewHolder.getCheckBox();
                textView = viewHolder.getTextView();
            }

            // Tag the CheckBox with the Planet it is displaying, so that we can
            // access the planet in onClick() when the CheckBox is toggled.
            checkBox.setTag(planet);
            // Display planet data
            checkBox.setChecked(planet.isChecked());
            textView.setText(planet.getName());
            return convertView;
        }
    }

    public Object onRetainNonConfigurationInstance() {
        return itemss;
    }


    public SubscribeFragment() {
        // Required empty public constructor
    }
    public static  SubscribeFragment newInstance() {
        SubscribeFragment f = new SubscribeFragment();
        return f;
    }
}

