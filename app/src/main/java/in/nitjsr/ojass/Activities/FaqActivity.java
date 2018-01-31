package in.nitjsr.ojass.Activities;

import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

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
    public static ArrayList<FaqModel> data;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        recyclerView=(RecyclerView)findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        data=new ArrayList<>();
        data.add(new FaqModel("What is Ojass","Ojass, the annual Techno-Management fest of NIT Jamshedpur is one of the East India's  biggest Collage Festival. It will span for 3 days: March somethig . The spirit of Ojass lies in encouraging sound practice, making precision engineering a way of life,effectively bringing about a paradigm shift from classroom to path-breaking innovation"));
        data.add(new FaqModel("What are the types of events in ojass?","Ojass is a plethara of many events. It includes branch events ,gaming events,formal events,fun events,etc"));
        data.add(new FaqModel("Are there any online events","Yes,there will be online events. For details of the online events stay updated to our facebook page."));
        data.add(new FaqModel("What about the accommodation?","Accomodation will be provided for the students in the collage hostel."));
        data.add(new FaqModel("Will participation certificate be given for events","Yes, we do give participation certificate for the registered candidates"));

        adapter=new FAQAdapter(FaqActivity.this,initData());

        recyclerView.setAdapter(adapter);



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
