package in.nitjsr.ojass.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.List;

import in.nitjsr.ojass.Adapters.RecyclerViewAdapter;
import in.nitjsr.ojass.Adapters.TeamAdapter;
import in.nitjsr.ojass.Modals.Modal;
import in.nitjsr.ojass.Modals.Team;
import in.nitjsr.ojass.R;
import in.nitjsr.ojass.Utils.Constants;
import in.nitjsr.ojass.Utils.Utilities;


public class TeamActivity extends AppCompatActivity implements View.OnClickListener{

    private static ImageView iv;
    private static TextView tvName, tvDesg;
    private static Context context;
    private Spinner sp;
    private ImageButton ibCall, ibWhatsApp;
    private static String userPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        context = this;

        Picasso.with(this).load(R.drawable.ojass_bg).fit().into((ImageView)findViewById(R.id.iv_team_bg));

        iv = findViewById(R.id.iv_team_img);
        tvName = findViewById(R.id.tv_team_name);
        tvDesg = findViewById(R.id.tv_team_desc);

        sp = findViewById(R.id.sp_team);
        ibCall = findViewById(R.id.ib_call);
        ibCall.setOnClickListener(this);
        ibWhatsApp = findViewById(R.id.ib_whats_ap);
        ibWhatsApp.setOnClickListener(this);
        findViewById(R.id.ib_back_btn).setOnClickListener(this);


        sp.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ((TextView) sp.getSelectedView()).setTextColor(Color.WHITE);
            }
        });

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(TeamActivity.this, getResources().getStringArray(R.array.team_names)[i], Toast.LENGTH_SHORT).show();
                prepareRecyclerView(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void prepareRecyclerView(int index) {
        RecyclerView rv = findViewById(R.id.rv_team);
        LinearLayoutManager ll = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(ll);
        switch (index){
            case 0 : rv.setAdapter(new TeamAdapter(this, prepareAdministration()));
                break;
            case 1 : rv.setAdapter(new TeamAdapter(this, prepareCore()));
                break;
            case 2 : rv.setAdapter(new TeamAdapter(this, preparePnD()));
                break;
            case 3 : rv.setAdapter(new TeamAdapter(this, teamCoordinator()));
                break;
            case 4 : rv.setAdapter(new TeamAdapter(this, mediaRelation()));
                break;
            case 5 : rv.setAdapter(new TeamAdapter(this, publicRelation()));
                break;
            case 6 : rv.setAdapter(new TeamAdapter(this, eventManage()));
                break;
            case 7 : rv.setAdapter(new TeamAdapter(this, hospitality()));
                break;
            case 8 : rv.setAdapter(new TeamAdapter(this, corporate()));
                break;
            case 9 : rv.setAdapter(new TeamAdapter(this, logistics()));
                break;
            case 10 : rv.setAdapter(new TeamAdapter(this, webteam()));
                break;
            case 11 : rv.setAdapter(new TeamAdapter(this, appteam()));
                break;
            case 12 : rv.setAdapter(new TeamAdapter(this, creativeTeam()));
                break;
            case 13 : rv.setAdapter(new TeamAdapter(this, robotics()));
                break;
            case 14 : rv.setAdapter(new TeamAdapter(this, decorations()));
        }

    }

    private ArrayList<Team> decorations() {
        ArrayList<Team> decors = new ArrayList<>();
        decors.add(new Team("Chinthala S. Krishna", "Decorator", "9471591138", "http://www.ojass.in/app/Images/CoreTeam/saikrishna.png"));
        setResourceOnClick(decors.get(0));
        return decors;
    }

    private ArrayList<Team> robotics() {
        ArrayList<Team> Robotics=new ArrayList<>();
        Robotics.add(new Team("Kaushik Komanduri","Robotics","8008458784","http://www.ojass.in/app/Images/CoreTeam/kaushik.jpg"));
        Robotics.add(new Team("Sammeta Saisaran","Robotics","8434218038","http://www.ojass.in/app/Images/CoreTeam/saiCharan.png"));
        Robotics.add(new Team("Sushil Rajwar","Robotics","9905183679","http://www.ojass.in/app/Images/CoreTeam/sushil.png"));
        Robotics.add(new Team("Mushref Tabrej","Robotics","8409680821","http://www.ojass.in/app/Images/CoreTeam/userdp.png"));
        Robotics.add(new Team("Karthik Raja","Robotics","9703557055","http://www.ojass.in/app/Images/CoreTeam/userdp.png"));
        setResourceOnClick(Robotics.get(0));
        return Robotics;
    }

    private ArrayList<Team> creativeTeam() {
        ArrayList<Team> CreativeTeam=new ArrayList<>();
        CreativeTeam.add(new Team("Tanmesh Singhal","Creative Team","8102629668", "http://www.ojass.in/app/Images/CoreTeam/tanmesh.png"));
        CreativeTeam.add(new Team("R.R.S.S. Sampath","Creative Team","9110460102","http://www.ojass.in/app/Images/CoreTeam/sampath.jpg"));
        CreativeTeam.add(new Team("Chavan Sandeep","Creative Team","9430387956","http://www.ojass.in/app/Images/CoreTeam/sandeep.png"));
        setResourceOnClick(CreativeTeam.get(0));
        return CreativeTeam;
    }

    private ArrayList<Team> appteam() {
        ArrayList<Team> AppTeam=new ArrayList<>();
        AppTeam.add(new Team("Abhishek Kumar","App Team","7858030449","http://www.ojass.in/app/Images/CoreTeam/abhishek.jpg"));
        AppTeam.add(new Team("Shivam Srivastava","App Team","9470918557","http://www.ojass.in/app/Images/CoreTeam/shivam.jpg"));
        AppTeam.add(new Team("Roushan Kumar","App Team","9155956813","http://www.ojass.in/app/Images/CoreTeam/roushan.png"));
        setResourceOnClick(AppTeam.get(0));
        return AppTeam;
    }

    private ArrayList<Team> webteam() {
        ArrayList<Team> WebTeam=new ArrayList<>();
        WebTeam.add(new Team("Akshay Poddar","Web Team","9031000893","http://www.ojass.in/app/Images/CoreTeam/akshay.jpg"));
        WebTeam.add(new Team("Sidhant Ranjan","Web Team","7070474521","http://www.ojass.in/app/Images/CoreTeam/sid.png"));
        setResourceOnClick(WebTeam.get(0));
        return WebTeam;
    }

    private ArrayList<Team> logistics() {
        ArrayList<Team> Logistics=new ArrayList<>();
        Logistics.add(new Team("B. Suprathik Nikhil","Logistics","7032211079","http://www.ojass.in/app/Images/CoreTeam/supratik.png"));
        Logistics.add(new Team("J. Bala Mahesh","Logistics","7842166498","http://www.ojass.in/app/Images/CoreTeam/balaMahesh.png"));
        Logistics.add(new Team("B. Shiva Raj","Logistics","7893160360","http://www.ojass.in/app/Images/CoreTeam/shivraj.png"));
        Logistics.add(new Team("Ram K. Mishra","Logistics","9454818881","http://www.ojass.in/app/Images/CoreTeam/ram.png"));
        setResourceOnClick(Logistics.get(0));
        return Logistics;
    }

    private ArrayList<Team> corporate() {
        ArrayList<Team> CorporateAffairs=new ArrayList<>();
        CorporateAffairs.add(new Team("Pranav Meshram","Corporate Affairs","9471582418","http://www.ojass.in/app/Images/CoreTeam/pranav.png"));
        CorporateAffairs.add(new Team("Anureet K. Sinha","Corporate Affairs","9155677467", "http://www.ojass.in/app/Images/CoreTeam/anurit.jpg"));
        CorporateAffairs.add(new Team("Neetika Sharma","Corporate Affairs","9006991018","http://www.ojass.in/app/Images/CoreTeam/neetika.jpg"));
        CorporateAffairs.add(new Team("Avantika Bharti","Corporate Affairs","8579064858", "http://www.ojass.in/app/Images/CoreTeam/avantika.png"));
        setResourceOnClick(CorporateAffairs.get(0));
        return CorporateAffairs;
    }

    private ArrayList<Team> hospitality() {
        ArrayList<Team> Hospitality=new ArrayList<>();
        Hospitality.add(new Team("Rupal Srivastava","Hospitality","8404804468","http://www.ojass.in/app/Images/CoreTeam/rupal.png"));
        Hospitality.add(new Team("Viraj Kumar","Hospitality","8809400207","http://www.ojass.in/app/Images/CoreTeam/viraj.jpg"));
        Hospitality.add(new Team("Jasbir Singh","Hospitality","7209757673","http://www.ojass.in/app/Images/CoreTeam/Jasbir.jpg"));
        setResourceOnClick(Hospitality.get(0));
        return Hospitality;
    }

    private ArrayList<Team> eventManage() {
        ArrayList<Team> EventManage=new ArrayList<>();
        EventManage.add(new Team("A.N.V. Nagesh K.","Event Management","7075133711", "http://www.ojass.in/app/Images/CoreTeam/userdp.png"));
        EventManage.add(new Team("Gunda Sai Teja","Event Management","9471105585","http://www.ojass.in/app/Images/CoreTeam/saiTeja.png"));
        EventManage.add(new Team("MD Saadique Anwar","Event Management","8521781488","http://www.ojass.in/app/Images/CoreTeam/saadique.png"));
        EventManage.add(new Team("Abhishek Jha","Event Management","9631888674","http://www.ojass.in/app/Images/CoreTeam/abhishekJha.jpg"));
        setResourceOnClick(EventManage.get(0));
        return EventManage;
    }

    private ArrayList<Team> publicRelation() {
        ArrayList<Team> PublicRelation=new ArrayList<>();
        PublicRelation.add(new Team("Aman Gupta","Public Relation","8839059122","http://www.ojass.in/app/Images/CoreTeam/aman.jpg"));
        PublicRelation.add(new Team("Arun Kumar Paswan","Public Relation","7979031324", "http://www.ojass.in/app/Images/CoreTeam/arun.jpg"));
        PublicRelation.add(new Team("S.L.S. Karthik","Public Relation","9430388501","http://www.ojass.in/app/Images/CoreTeam/karthik.jpg"));
        PublicRelation.add(new Team("Kumari Deepshikha","Public Relation","8539023606","http://www.ojass.in/app/Images/CoreTeam/deepshikha.jpg"));
        setResourceOnClick(PublicRelation.get(0));
        return PublicRelation;
    }

    private ArrayList<Team> mediaRelation() {
        ArrayList<Team> MediaRelation =new ArrayList<>();
        MediaRelation.add(new Team("Richa Thacker","Media Relation","8603606099","http://www.ojass.in/app/Images/CoreTeam/richa.png"));
        setResourceOnClick(MediaRelation.get(0));
        return MediaRelation;
    }

    private ArrayList<Team> teamCoordinator() {
        ArrayList<Team> TeamCoordinator=new ArrayList<>();
        TeamCoordinator.add(new Team("Patthi Mahesh","Team Coordinator","7842255976","http://www.ojass.in/app/Images/CoreTeam/maheshPatti.jpg"));
        TeamCoordinator.add(new Team("Akhilesh K. Jain","Team Coordinator","9509164568","http://www.ojass.in/app/Images/CoreTeam/akhilesh.jpg"));
        setResourceOnClick(TeamCoordinator.get(0));
        return TeamCoordinator;
    }

    private ArrayList<Team> preparePnD() {
        ArrayList<Team> PlanningAndDevelopment=new ArrayList<>();
        PlanningAndDevelopment.add(new Team("Raj Ranjan","Planning and Development","8507118002","http://www.ojass.in/app/Images/CoreTeam/raj.png"));
        PlanningAndDevelopment.add(new Team("Aditya Kumar","Planning and Development","7870517024","http://www.ojass.in/app/Images/CoreTeam/aditya.jpg"));
        PlanningAndDevelopment.add(new Team("Kumar Ankur","Planning and Development","8406028040","http://www.ojass.in/app/Images/CoreTeam/ankur.jpg"));
        setResourceOnClick(PlanningAndDevelopment.get(0));
        return PlanningAndDevelopment;
    }

    private ArrayList<Team> prepareCore() {
        ArrayList<Team> coreTeam=new ArrayList<>();
        coreTeam.add(new Team("Shubham K. Singh","Technical Secretary","8404879565","http://www.ojass.in/app/Images/CoreTeam/techie.jpg"));
        coreTeam.add(new Team("Anjali Thakur","Joint Technical Secretary","7258885571","http://www.ojass.in/app/Images/CoreTeam/anjali.jpg"));
        coreTeam.add(new Team("Shubham Kumar","Joint Secretary","8051115377","http://www.ojass.in/app/Images/CoreTeam/shubham.jpg"));
        coreTeam.add(new Team("Prahaas Boppudi","External General Secretary","7070449936","http://www.ojass.in/app/Images/CoreTeam/prahaas.png"));
        coreTeam.add(new Team("Bikrant Amrit","Internal General Secretary","7856046490","http://www.ojass.in/app/Images/CoreTeam/bikrant.jpg"));
        coreTeam.add(new Team("Chandralok Kumar","Treasurer","7870480126","http://www.ojass.in/app/Images/CoreTeam/chandralok.jpg"));
        coreTeam.add(new Team("Akula Sreekar Roy","Spokesperson","8500435856","http://www.ojass.in/app/Images/CoreTeam/AsreekarRoy.jpg"));
        setResourceOnClick(coreTeam.get(0));
        return coreTeam;
    }

    private ArrayList<Team> prepareAdministration() {
        ArrayList<Team> adminTeam = new ArrayList<>();
        adminTeam.add(new Team("Prof. Karunesh Shukla", "Director", "06572373407", "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fadmin1.jpeg?alt=media&token=fb96aa93-3428-4979-b59f-e29a375bc377"));
        adminTeam.add(new Team("Dr. Sripati Jha", "Student's Welfare Dean", "9934532473", "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fadmin5.jpeg?alt=media&token=f1645bea-f62d-4844-8294-e6e5a2c4d2b7"));
        adminTeam.add(new Team("Dilip Kumar", "P I Incharge", "9431330646", "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fadmin4.jpeg?alt=media&token=d32fe4d8-46ae-48c8-a3a7-99574d99ae1c"));
        adminTeam.add(new Team("Sonal Kumar", "President", "9504030431", "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fadmin3.jpeg?alt=media&token=4aa6cbc7-39d1-4bd0-b6f0-5e2c8176b95d"));
        adminTeam.add(new Team("Shubham K. Singh","Technical Secretary","8404879565","http://www.ojass.in/app/Images/CoreTeam/techie.jpg"));
        setResourceOnClick(adminTeam.get(0));
        return adminTeam;
    }

    public static void setResourceOnClick(Team team){
        Utilities.setPicassoImage(context, team.getImageSrc(), iv, Constants.SQUA_PLACEHOLDER);
        tvName.setText(team.getName());
        tvDesg.setText(team.getDesg());
        userPhone = team.getPhone();
    }

    @Override
    public void onClick(View view) {
        if (view == ibCall){
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:+91"+userPhone));
            startActivity(intent);
        } else if (view == ibWhatsApp){
            String userName = ""+FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_VIEW);
            String url = "https://api.whatsapp.com/send?phone=91" + userPhone + "&text=Hey! I'm "+userName+".";
            sendIntent.setData(Uri.parse(url));
            startActivity(sendIntent);
        } else if (view.getId() == R.id.ib_back_btn) finish();
    }
}
