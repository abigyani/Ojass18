package in.nitjsr.ojass.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import in.nitjsr.ojass.Adapters.RecyclerViewAdapter;
import in.nitjsr.ojass.Modals.Modal;
import in.nitjsr.ojass.R;

public class TeamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        prepareRecyclerView();
    }

    private void prepareRecyclerView() {
        RecyclerView rv = findViewById(R.id.rv_team);
        LinearLayoutManager ll = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(ll);
        rv.setAdapter(new RecyclerViewAdapter(prepareDataSet(), this));
    }

    private ArrayList<Modal> prepareDataSet() {
        ArrayList<Modal> dataSet = new ArrayList<>();
        dataSet.add(new Modal(R.drawable.ic_launcher_background, "Abhishek", "abc"));
        dataSet.add(new Modal(R.drawable.ic_launcher_background, "Abhishek", "abc"));
        dataSet.add(new Modal(R.drawable.ic_launcher_background, "Abhishek", "abc"));
        dataSet.add(new Modal(R.drawable.ic_launcher_background, "Abhishek", "abc"));
        dataSet.add(new Modal(R.drawable.ic_launcher_background, "Abhishek", "abc"));
        dataSet.add(new Modal(R.drawable.ic_launcher_background, "Abhishek", "abc"));
        return dataSet;
    }
}
