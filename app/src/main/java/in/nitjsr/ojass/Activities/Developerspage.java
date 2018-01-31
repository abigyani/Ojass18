package in.nitjsr.ojass.Activities;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developerspage);


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
