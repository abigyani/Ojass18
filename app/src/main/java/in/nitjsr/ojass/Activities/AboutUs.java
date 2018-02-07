package in.nitjsr.ojass.Activities;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import in.nitjsr.ojass.R;

public class AboutUs extends AppCompatActivity {

    ImageButton fb;
    ImageButton insta;
    ImageButton twitter;
    ImageButton webpage, back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        fb = findViewById(R.id.fb);
        insta = findViewById(R.id.insta);
        twitter = findViewById(R.id.twitter);
        webpage = findViewById(R.id.web);
        back = findViewById(R.id.ib_back_about_us);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

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

    }
}
