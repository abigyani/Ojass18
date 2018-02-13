package in.nitjsr.ojass.Activities;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;

import in.nitjsr.ojass.Adapters.FAQAdapter;
import in.nitjsr.ojass.Fragments.SubscribeFragment;
import in.nitjsr.ojass.Modals.FaqModel;
import in.nitjsr.ojass.Modals.TitleChild;
import in.nitjsr.ojass.Modals.TitleCreater1;
import in.nitjsr.ojass.Modals.TitleParent;
import in.nitjsr.ojass.R;

import static in.nitjsr.ojass.Utils.Constants.FIREBASE_REF_NOTIFICATIONS;


public class FeedActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FAQAdapter adapter;
    DatabaseReference ref;
    public static ArrayList<FaqModel> data;
    ProgressDialog p;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        Picasso.with(this).load(R.drawable.ojass_bg).fit().into((ImageView)findViewById(R.id.iv_feed));

        spinner = findViewById(R.id.spinner_feed);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.events, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner.setAdapter(adapter);

        recyclerView=(RecyclerView)findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        data=new ArrayList<>();

        p=new ProgressDialog(this);
        //onItemSelect();




        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView)adapterView.getChildAt(0)).setTextColor(Color.WHITE);
                onItemSelect();
                //  Toast.makeText(getApplication(),spinner.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        findViewById(R.id.ib_back_feed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        findViewById(R.id.ib_subscribe_feed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SubscribeFragment detailsfragment=new SubscribeFragment();
                detailsfragment.show(getSupportFragmentManager(),"Subscribe");
            }
        });

    }

    public void onItemSelect()
    {

        p.setMessage("Loading Feed....");
        p.setCancelable(true);
        p.show();
        ref= FirebaseDatabase.getInstance().getReference().child(FIREBASE_REF_NOTIFICATIONS).child(spinner.getSelectedItem().toString());
        ref.keepSynced(true);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                p.dismiss();
                data.clear();
                for(DataSnapshot ds: dataSnapshot.getChildren())
                {
                    FaqModel q=ds.getValue(FaqModel.class);
                    data.add(q);
                    // Toast.makeText(FAQActivity.this,"Q"+q.getQuestion()+"\nA:"+q.getAns(),Toast.LENGTH_SHORT).show();

                }

                adapter = new FAQAdapter(FeedActivity.this,initData());
                adapter.setParentClickableViewAnimationDefaultDuration();
                adapter.setParentAndIconExpandOnClick(true);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }



    private List<ParentObject> initData() {
        TitleCreater1 titleCreater= new TitleCreater1(FeedActivity.this);
        //titleCreater= TitleCreater.get(this);
        List<TitleParent> titles= TitleCreater1._titleParents;
        List<ParentObject> parentObject = new ArrayList<>();
        //Toast.makeText(FeedActivity.this,"Title:"+titles.size(),Toast.LENGTH_SHORT).show();
        int i=data.size()-1;
        for(TitleParent title:titles)
        {
            List<Object> childList = new ArrayList<>();
            //childList.add(new TitleChild(("It is LSE web style to title a page of FAQs 'Frequently asked questions (FAQs)'. While the abbreviation is in quite common usage this ensures that there can be no mistaking what they are")));
            childList.add(new TitleChild(data.get(i--).getAns()));
            title.setChildObjectList(childList);
            parentObject.add(title);
        }
        return parentObject;
    }














}