package in.nitjsr.ojass.Activities;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import in.nitjsr.ojass.Adapters.DeveloperPageAdapter;
import in.nitjsr.ojass.Modals.Devpage_modal;
import in.nitjsr.ojass.R;

public class Developerspage extends AppCompatActivity {


    List<Devpage_modal> personInformation = Collections.emptyList();
    RecyclerView recyclerView;
    DeveloperPageAdapter developerPageAdapter;
    static TextView name;
    static TextView description;
    static ImageView image;
    ImageButton fb;
    ImageButton insta;
    ImageButton twitter;
    ImageButton webpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developerspage);


        fb = findViewById(R.id.dev_fb);
        insta = findViewById(R.id.dev_insta);
        twitter = findViewById(R.id.dev_twitter);
        webpage = findViewById(R.id.dev_web);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Ojassnitjamshedpur"));
                startActivity(intent);
            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/ojass_nitjsr"));
                startActivity(intent);
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/Ojass2k16"));
                startActivity(intent);
            }
        });

        webpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.ojass.in"));
                startActivity(intent);
            }
        });
        name=findViewById(R.id.developers_title);
        description=findViewById(R.id.developers_description);
        image=findViewById(R.id.profile_image);
        personInformation=new ArrayList<Devpage_modal>();
        personInformation.add(new Devpage_modal(R.drawable.ic_launcher_background, "Sanay", "abc"));
        personInformation.add(new Devpage_modal(R.drawable.ic_launcher_background, "Sanay", "abc"));
        personInformation.add(new Devpage_modal(R.drawable.ic_launcher_background, "Sanay", "abc"));
        personInformation.add(new Devpage_modal(R.drawable.ic_launcher_background, "Sanay", "abc"));
        personInformation.add(new Devpage_modal(R.drawable.ic_launcher_background, "Sanay", "abc"));
        personInformation.add(new Devpage_modal(R.drawable.ic_launcher_background, "Sanay", "abc"));
        personInformation.add(new Devpage_modal(R.drawable.ic_launcher_background, "Sanay", "abc"));

        developerPageAdapter = new DeveloperPageAdapter(this, personInformation);
        recyclerView = findViewById(R.id.dev_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(developerPageAdapter);


    }


    public static void setDeveloperImage(Devpage_modal current)
    {
        image.setImageResource(current.getImage());
        name.setText(current.getName());
        description.setText(current.getDescription());
    }
}
