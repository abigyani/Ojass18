package in.nitjsr.ojass.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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

        Picasso.with(this).load(R.drawable.ojass_bg).fit().into((ImageView)findViewById(R.id.iv_about_us));
        TextView t1 = findViewById(R.id.description);
        Typeface customFontBold = Typeface.createFromAsset(getAssets(),"textfont.otf");
        t1.setTypeface(customFontBold);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Ojassnitjamshedpur/?ref=br_rs"));
                startActivity(intent);
            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/ojass_techfest/"));
                startActivity(intent);
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/ojass_nitjsr?s=08"));
                startActivity(intent);
            }
        });

        webpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ojass.in"));
                startActivity(intent);
            }
        });

    }
}
