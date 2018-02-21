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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import in.nitjsr.ojass.R;

public class AboutUs extends AppCompatActivity {

    ImageButton fb;
    ImageButton insta;
    ImageButton twitter;
    ImageButton webpage, back;
    ImageButton share, helpdesk_phone, helpdesk_whatsapp, rateUs;

    private static final String AMAN_PHONE = "8839059122";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        fb = (ImageButton) findViewById(R.id.fb);
        insta = (ImageButton) findViewById(R.id.insta);
        twitter = (ImageButton) findViewById(R.id.twitter);
        webpage = (ImageButton) findViewById(R.id.web);
        back = (ImageButton) findViewById(R.id.ib_back_about_us);
        share = (ImageButton) findViewById(R.id.ib_app_share);
        helpdesk_phone = (ImageButton) findViewById(R.id.ib_helpdesk_phone);
        helpdesk_whatsapp = (ImageButton) findViewById(R.id.ib_helpdesk_whatsapp);
        rateUs = (ImageButton) findViewById(R.id.ib_app_rate_us);

        Picasso.with(this).load(R.drawable.ojass_bg).fit().into((ImageView)findViewById(R.id.iv_about_us));
        TextView t1 = (TextView) findViewById(R.id.description);
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

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String playStoreURL = "https://play.google.com/store/apps/details?id=in.nitjsr.ojass";
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Ojass");
                i.putExtra(Intent.EXTRA_TEXT, playStoreURL);
                startActivity(Intent.createChooser(i, ""));
            }
        });

        rateUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String appPackageName = "in.nitjsr.ojass";
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                }
            }
        });

        helpdesk_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+91"+AMAN_PHONE));
                startActivity(intent);
            }
        });

        helpdesk_whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_VIEW);
                String url = "https://api.whatsapp.com/send?phone=91" + AMAN_PHONE + "&text=Hey! I'm "+ FirebaseAuth.getInstance().getCurrentUser().getDisplayName()+".";
                sendIntent.setData(Uri.parse(url));
                startActivity(sendIntent);
            }
        });

    }
}

