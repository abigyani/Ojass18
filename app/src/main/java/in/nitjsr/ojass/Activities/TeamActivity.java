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
            case 0 : rv.setAdapter(new TeamAdapter(this, prepareCore()));
                break;
            case 1 : rv.setAdapter(new TeamAdapter(this, preparePnD()));
                break;
            case 2 : rv.setAdapter(new TeamAdapter(this, teamCoordinator()));
                break;
            case 3 : rv.setAdapter(new TeamAdapter(this, mediaRelation()));
                break;
            case 4 : rv.setAdapter(new TeamAdapter(this, publicRelation()));
                break;
            case 5 : rv.setAdapter(new TeamAdapter(this, eventManage()));
                break;
            case 6 : rv.setAdapter(new TeamAdapter(this, hospitality()));
                break;
            case 7 : rv.setAdapter(new TeamAdapter(this, corporate()));
                break;
            case 8 : rv.setAdapter(new TeamAdapter(this, logistics()));
                break;
            case 9 : rv.setAdapter(new TeamAdapter(this, webteam()));
                break;
            case 10 : rv.setAdapter(new TeamAdapter(this, appteam()));
                break;
            case 11 : rv.setAdapter(new TeamAdapter(this, creativeTeam()));
                break;
            case 12 : rv.setAdapter(new TeamAdapter(this, robotics()));
                break;
        }

    }

    private ArrayList<Team> robotics() {
        ArrayList<Team> Robotics=new ArrayList<>();
        Robotics.add(new Team("Kaushik Komanduri","Robotics","8008458784","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fkaushik.png?alt=media&token=875bf20b-32d1-4c0d-902a-65f9d5958069"));
        Robotics.add(new Team("Sammeta Saisaran","Robotics","8434218038","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2FsaiCharan.png?alt=media&token=2dd2b8ac-f43b-44e9-ba11-b58483d938d2"));
        Robotics.add(new Team("Sushil Rajwar","Robotics","9905183679","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fsushil.png?alt=media&token=25f4c8eb-5827-48c4-80c4-f237060baf60"));
        Robotics.add(new Team("Mushref Tabrej","Robotics","8409680821","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fuserdp.png?alt=media&token=15f889fa-6f14-4e23-a259-001e3d017b50"));
        Robotics.add(new Team("Karthik Raja","Robotics","9703557055","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fuserdp.png?alt=media&token=15f889fa-6f14-4e23-a259-001e3d017b50"));
        Robotics.add(new Team("Apurava","Robotics","9470171699", "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fuserdp.png?alt=media&token=15f889fa-6f14-4e23-a259-001e3d017b50"));
        setResourceOnClick(Robotics.get(0));
        return Robotics;
    }

    private ArrayList<Team> creativeTeam() {
        ArrayList<Team> CreativeTeam=new ArrayList<>();
        CreativeTeam.add(new Team("Tanmesh Singhal","Creative Team","8102629668", "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fuserdp.png?alt=media&token=15f889fa-6f14-4e23-a259-001e3d017b50"));
        CreativeTeam.add(new Team("Rahul Kumar","Creative Team","8864033868", "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fuserdp.png?alt=media&token=15f889fa-6f14-4e23-a259-001e3d017b50"));
        CreativeTeam.add(new Team("R.R.S.S. Sampath","Creative Team","9110460102","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fsampath.png?alt=media&token=aca5bc45-0244-47f8-ad4d-22e7d872319a"));
        CreativeTeam.add(new Team("Chavan Sandeep","Creative Team","9430387956","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fsandeep.png?alt=media&token=a615c053-adb9-4704-a35e-f3184acf4db8"));
        setResourceOnClick(CreativeTeam.get(0));
        return CreativeTeam;
    }

    private ArrayList<Team> appteam() {
        ArrayList<Team> AppTeam=new ArrayList<>();
        AppTeam.add(new Team("Abhishek Kumar","App Team","7858030449","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fabhishek.png?alt=media&token=c79e98d3-eefd-42d8-a423-6185c7e4a5f6"));
        AppTeam.add(new Team("Shivam Srivastava","App Team","9470918557","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fshivam.png?alt=media&token=ef478d3a-dc56-4f22-9d8d-0a566fc4f9f4"));
        AppTeam.add(new Team("Roushan Kumar","App Team","9155956813","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Froushan.png?alt=media&token=87616192-6c90-47b5-bfb8-b344853a0924"));
        setResourceOnClick(AppTeam.get(0));
        return AppTeam;
    }

    private ArrayList<Team> webteam() {
        ArrayList<Team> WebTeam=new ArrayList<>();
        WebTeam.add(new Team("Akshay Poddar","Web Team","9031000893","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fakshay.png?alt=media&token=032b01ca-1051-4ec6-885d-db8b962e2b33"));
        WebTeam.add(new Team("Sidhant Ranjan","Web Team","7070474521","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fsid.png?alt=media&token=e50ddb5e-4902-4932-9f38-09186092e720"));
        setResourceOnClick(WebTeam.get(0));
        return WebTeam;
    }

    private ArrayList<Team> logistics() {
        ArrayList<Team> Logistics=new ArrayList<>();
        Logistics.add(new Team("B. Suprathik Nikhil","Logistics","7032211079","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fsupratik.png?alt=media&token=600d008e-5624-4036-9dc7-1bb2c77f8b67"));
        Logistics.add(new Team("J. Bala Mahesh","Logistics","7842166498","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2FbalaMahesh.png?alt=media&token=12925b7b-406c-42d5-b2d3-c40a88565baf"));
        Logistics.add(new Team("B. Shiva Raj","Logistics","7893160360","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fshivraj.png?alt=media&token=83c0c773-23c2-4494-8282-6485e1d2603f"));
        Logistics.add(new Team("Ram K. Mishra","Logistics","9454818881","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fram.png?alt=media&token=99b2a1dd-0365-472b-83e5-275c5a4d8839"));
        setResourceOnClick(Logistics.get(0));
        return Logistics;
    }

    private ArrayList<Team> corporate() {
        ArrayList<Team> CorporateAffairs=new ArrayList<>();
        CorporateAffairs.add(new Team("Pranav Meshram","Corporate Affairs","9471582418","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fpranav.png?alt=media&token=1677728b-33bb-4a24-86ed-1d0338c214e3"));
        CorporateAffairs.add(new Team("Anureet K. Sinha","Corporate Affairs","9155677467", "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fanurit.png?alt=media&token=5a486845-5cca-4732-90c2-1e44323dacd0"));
        CorporateAffairs.add(new Team("Neetika Sharma","Corporate Affairs","9006991018","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fneetika.png?alt=media&token=5935efee-c3a5-4116-b451-71117123d23a"));
        CorporateAffairs.add(new Team("Avantika Bharti","Corporate Affairs","8579064858", "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fuserdp.png?alt=media&token=15f889fa-6f14-4e23-a259-001e3d017b50"));
        setResourceOnClick(CorporateAffairs.get(0));
        return CorporateAffairs;
    }

    private ArrayList<Team> hospitality() {
        ArrayList<Team> Hospitality=new ArrayList<>();
        Hospitality.add(new Team("Rupal Srivastava","Hospitality","8404804468","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Frupal.png?alt=media&token=3b2d55c2-a4af-42ae-bafb-9df7af1e930f"));
        Hospitality.add(new Team("Viraj Kumar","Hospitality","8809400207","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fviraj.png?alt=media&token=cd084edb-e206-4818-8f2d-ed5c5e21e28e"));
        Hospitality.add(new Team("Jasbir Singh","Hospitality","7209757673","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2FJasbir.png?alt=media&token=aae6ec82-9e63-47d2-893d-d20c0ed3ebca"));
        setResourceOnClick(Hospitality.get(0));
        return Hospitality;
    }

    private ArrayList<Team> eventManage() {
        ArrayList<Team> EventManage=new ArrayList<>();
        EventManage.add(new Team("Santosh Kumar","Event Management","8092437800","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fsantosh.png?alt=media&token=20f97fde-733a-467d-aebb-13f0218c79ab"));
        EventManage.add(new Team("A.N.V. Nagesh K.","Event Management","7075133711", "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fuserdp.png?alt=media&token=15f889fa-6f14-4e23-a259-001e3d017b50"));
        EventManage.add(new Team("Gunda Sai Teja","Event Management","9471105585","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2FsaiTeja.png?alt=media&token=499c3613-b165-4dd2-bad9-826b2debb51a"));
        EventManage.add(new Team("MD Saadique Anwar","Event Management","8521781488","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fsaadique.png?alt=media&token=a1ebae8f-a74e-4c95-a7e7-eab0c044350a"));
        EventManage.add(new Team("Abhishek Jha","Event Management","9631888674","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2FabhishekJha.png?alt=media&token=baef8692-0860-4839-b34d-6803ea06d665"));
        setResourceOnClick(EventManage.get(0));
        return EventManage;
    }

    private ArrayList<Team> publicRelation() {
        ArrayList<Team> PublicRelation=new ArrayList<>();
        PublicRelation.add(new Team("Aman Gupta","Public Relation","8839059122","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Faman.png?alt=media&token=eb2f4a1e-16f7-4339-9d46-35e00d2a570e"));
        PublicRelation.add(new Team("Arun Kumar Paswan","Public Relation","7979031324", "https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Farun.png?alt=media&token=789ba1e1-110b-4fc1-9c83-05b8252e9dea"));
        PublicRelation.add(new Team("S.L.S. Karthik","Public Relation","9430388501","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fkarthik.png?alt=media&token=cf9376fc-e27d-49ba-8a02-17f951c0c39a"));
        PublicRelation.add(new Team("Kumari Deepshikha","Public Relation","8539023606","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fdeepshikha.png?alt=media&token=5183772b-c1a5-4587-89c5-445df98824a8"));
        setResourceOnClick(PublicRelation.get(0));
        return PublicRelation;
    }

    private ArrayList<Team> mediaRelation() {
        ArrayList<Team> MediaRelation =new ArrayList<>();
        MediaRelation.add(new Team("Richa Thacker","Media Relation","8603606099","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fricha.png?alt=media&token=43dadc98-1b8f-4bbf-a678-85de7b8c5da7"));
        setResourceOnClick(MediaRelation.get(0));
        return MediaRelation;
    }

    private ArrayList<Team> teamCoordinator() {
        ArrayList<Team> TeamCoordinator=new ArrayList<>();
        TeamCoordinator.add(new Team("Patthi Mahesh","Team Coordinator","7842255976","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2FmaheshPatti.png?alt=media&token=85d9f2e7-80e8-469a-a601-221a27cd454d"));
        TeamCoordinator.add(new Team("Akhilesh K. Jain","Team Coordinator","9509164568","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fakhilesh.png?alt=media&token=6333f17d-eda6-4a65-a6c2-3fef23967e26"));
        setResourceOnClick(TeamCoordinator.get(0));
        return TeamCoordinator;
    }

    private ArrayList<Team> preparePnD() {
        ArrayList<Team> PlanningAndDevelopment=new ArrayList<>();
        PlanningAndDevelopment.add(new Team("Raj Ranjan","Planning and Development","8507118002","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fraj.png?alt=media&token=0afbb7a3-8c1e-4f45-9442-aef8f2b260f5"));
        PlanningAndDevelopment.add(new Team("Aditya Kumar","Planning and Development","7870517024","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Faditya.png?alt=media&token=a87a9fb3-6711-45f4-a1eb-92317de53327"));
        PlanningAndDevelopment.add(new Team("Kumar Ankur","Planning and Development","8406028040","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fankur.png?alt=media&token=faf88f0d-422e-468c-99fc-4004f36f64a8"));
        setResourceOnClick(PlanningAndDevelopment.get(0));
        return PlanningAndDevelopment;
    }

    private ArrayList<Team> prepareCore() {
        ArrayList<Team> coreTeam=new ArrayList<>();
        coreTeam.add(new Team("Shubham K. Singh","Technical Secretary","8404879565","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Ftechie.png?alt=media&token=f7487eea-eaf7-4746-a845-c3416cd26bae"));
        coreTeam.add(new Team("Anjali Thakur","Joint Technical Secretary","7258885571","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fanjali.png?alt=media&token=9b649889-41b2-4d22-b7fc-f0a58d1ad616"));
        coreTeam.add(new Team("Shubham Kumar","Joint Secretary","8051115377","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fshubham.png?alt=media&token=f4031a7a-2ade-4b20-960d-bf35e0deaa28"));
        coreTeam.add(new Team("Prahaas Boppudi","External General Secretary","7070449936","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fprahaas.png?alt=media&token=d3f705f4-7fed-44d3-a110-e7c4a8bb407f"));
        coreTeam.add(new Team("Bikrant Amrit","Internal General Secretary","7856046490","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fbikrant.png?alt=media&token=4b02e59c-b15d-4e59-9f06-068a4095b2ff"));
        coreTeam.add(new Team("Chandralok Kumar","Treasurer","7870480126","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2Fchandralok.png?alt=media&token=8f4b6db5-6215-49d7-a602-7fd3435ccd98"));
        coreTeam.add(new Team("Akula Sreekar Roy","Spokesperson","8500435856","https://firebasestorage.googleapis.com/v0/b/ojass18-1cb0d.appspot.com/o/CoreTeamImages%2FAsreekarRoy.png?alt=media&token=30c0cf63-b069-4753-a9aa-a02d2925067b"));
        setResourceOnClick(coreTeam.get(0));
        return coreTeam;
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
