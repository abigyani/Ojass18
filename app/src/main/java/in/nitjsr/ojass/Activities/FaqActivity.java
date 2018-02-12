package in.nitjsr.ojass.Activities;

import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
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
import in.nitjsr.ojass.Modals.FaqModel;
import in.nitjsr.ojass.Modals.TitleChild;
import in.nitjsr.ojass.Modals.TitleCreater;
import in.nitjsr.ojass.Modals.TitleParent;
import in.nitjsr.ojass.R;

public class FaqActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FAQAdapter adapter;
    DatabaseReference ref;
    public static ArrayList<FaqModel> data;
    ProgressDialog p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        Picasso.with(this).load(R.drawable.ojass_bg).fit().into((ImageView)findViewById(R.id.iv_faq));

        recyclerView=(RecyclerView)findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        data=new ArrayList<>();

        ref= FirebaseDatabase.getInstance().getReference().child("Faq");
        ref.keepSynced(true);
        p=new ProgressDialog(this);
        p.setMessage("Loading FAQs....");
        p.setCancelable(false);
        p.show();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Toast.makeText(FAQActivity.this,"fetched"+dataSnapshot.getChildrenCount(),Toast.LENGTH_SHORT).show();
                p.dismiss();
                data.clear();
                if (dataSnapshot.exists()){
                    try {
                        for(DataSnapshot ds: dataSnapshot.getChildren())
                        {
                            FaqModel q=ds.getValue(FaqModel.class);
                            data.add(q);
                            // Toast.makeText(FAQActivity.this,"Q"+q.getQuestion()+"\nA:"+q.getAns(),Toast.LENGTH_SHORT).show();

                        }

                        adapter = new FAQAdapter(FaqActivity.this,initData());
                        adapter.setParentClickableViewAnimationDefaultDuration();
                        adapter.setParentAndIconExpandOnClick(true);
                        recyclerView.setAdapter(adapter);

                     } catch (Exception e){

                    }
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

//        data.add(new FaqModel("What is Ojass","Ojass, the annual Techno-Management fest of NIT Jamshedpur is one of the East India's  biggest Collage Festival. It will span for 3 days: March somethig . The spirit of Ojass lies in encouraging sound practice, making precision engineering a way of life,effectively bringing about a paradigm shift from classroom to path-breaking innovation"));
//        data.add(new FaqModel("What are the types of events in ojass?","Ojass is a plethara of many events. It includes branch events ,gaming events,formal events,fun events,etc"));
//        data.add(new FaqModel("Are there any online events","Yes,there will be online events. For details of the online events stay updated to our facebook page."));
//        data.add(new FaqModel("What about the accommodation?","Accomodation will be provided for the students in the collage hostel."));
//        data.add(new FaqModel("Will participation certificate be given for events","Yes, we do give participation certificate for the registered candidates"));

        adapter=new FAQAdapter(FaqActivity.this,initData());

        recyclerView.setAdapter(adapter);

        findViewById(R.id.ib_back_faq).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private List<ParentObject> initData() {
        TitleCreater titleCreater= new TitleCreater(FaqActivity.this);
        //titleCreater= TitleCreater.get(this);
        List<TitleParent> titles=TitleCreater._titleParents;
        List<ParentObject> parentObject = new ArrayList<>();
        // Toast.makeText(FAQActivity.this,"Title:"+titles.size(),Toast.LENGTH_SHORT).show();
        int i=0;
        for(TitleParent title:titles)
        {
            List<Object> childList = new ArrayList<>();
            //childList.add(new TitleChild(("It is LSE web style to title a page of FAQs 'Frequently asked questions (FAQs)'. While the abbreviation is in quite common usage this ensures that there can be no mistaking what they are")));
            childList.add(new TitleChild(data.get(i++).getAns()));
            title.setChildObjectList(childList);
            parentObject.add(title);
        }
        return parentObject;
    }
}
