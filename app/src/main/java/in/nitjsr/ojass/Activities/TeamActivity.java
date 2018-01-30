package in.nitjsr.ojass.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import in.nitjsr.ojass.Adapters.RecyclerViewAdapter;
import in.nitjsr.ojass.Adapters.TeamAdapter;
import in.nitjsr.ojass.Modals.Modal;
import in.nitjsr.ojass.Modals.Team;
import in.nitjsr.ojass.R;

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
        userPhone = "7858030449";

        iv = findViewById(R.id.iv_team_img);
        tvName = findViewById(R.id.tv_team_name);
        tvDesg = findViewById(R.id.tv_team_desc);
        sp = findViewById(R.id.sp_team);
        ibCall = findViewById(R.id.ib_call);
        ibCall.setOnClickListener(this);
        ibWhatsApp = findViewById(R.id.ib_whats_ap);
        ibWhatsApp.setOnClickListener(this);
        findViewById(R.id.ib_back_btn).setOnClickListener(this);

        Picasso.with(context).load(R.drawable.portrait).fit().into(iv);
        tvName.setText("Abhishek");
        tvDesg.setText("BlackOp");
        prepareRecyclerView();

        sp.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ((TextView) sp.getSelectedView()).setTextColor(Color.WHITE);
            }
        });

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(TeamActivity.this, getResources().getStringArray(R.array.team_names)[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void prepareRecyclerView() {
        RecyclerView rv = findViewById(R.id.rv_team);
        LinearLayoutManager ll = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(ll);
        rv.setAdapter(new TeamAdapter(this, prepareDataSet()));
    }

    private ArrayList<Team> prepareDataSet() {
        ArrayList<Team> dataSet = new ArrayList<>();
        dataSet.add(new Team(R.drawable.portrait, "Abhishek", "abc", "7858030449"));
        dataSet.add(new Team(R.drawable.portraitthree, "Ram", "def", "7858030449"));
        dataSet.add(new Team(R.drawable.portraitfour, "Shyam", "ghi", "7858030449"));
        dataSet.add(new Team(R.drawable.portrait, "Ghansyam", "jkl", "7858030449"));
        dataSet.add(new Team(R.drawable.portraitthree, "Vyayam", "mno", "7858030449"));
        dataSet.add(new Team(R.drawable.portraitfour, "Shyayam", "pqr", "7858030449"));
        return dataSet;
    }

    public static void setResourceOnClick(Team team){
        Picasso.with(context).load(team.getImageSrc()).fit().into(iv);
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
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_VIEW);
            String url = "https://api.whatsapp.com/send?phone=91" + userPhone + "&text=Hey!";
            sendIntent.setData(Uri.parse(url));
            startActivity(sendIntent);
        } else if (view.getId() == R.id.ib_back_btn) finish();
    }
}
