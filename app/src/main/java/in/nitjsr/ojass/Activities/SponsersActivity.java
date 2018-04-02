package in.nitjsr.ojass.Activities;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import in.nitjsr.ojass.R;

public class SponsersActivity extends AppCompatActivity {

    TextView i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16,i17,i18,i19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsers);

        Picasso.with(this).load(R.drawable.ojass_bg).fit().into((ImageView)findViewById(R.id.iv_sponsors));

        /*
        * i1 = (TextView) findViewById(R.id.i1);
        i2 = (TextView) findViewById(R.id.i2);
        i3 = (TextView) findViewById(R.id.i3);
        i4 = (TextView) findViewById(R.id.i4);
        i5 = (TextView) findViewById(R.id.i5);
        i6 = (TextView) findViewById(R.id.i6);
        i7 = (TextView) findViewById(R.id.i7);
        i8 = (TextView) findViewById(R.id.i8);
        i9 = (TextView) findViewById(R.id.i9);
        i10 = (TextView) findViewById(R.id.i10);
        i11 = (TextView) findViewById(R.id.i11);
        i12 = (TextView) findViewById(R.id.i12);
        i13 = (TextView) findViewById(R.id.i13);
        i14 = (TextView) findViewById(R.id.i14);
        i15 = (TextView) findViewById(R.id.i15);
        i16 = (TextView) findViewById(R.id.i16);
        i17 = (TextView) findViewById(R.id.i17);
        i17.setPaintFlags(i17.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i18 = (TextView) findViewById(R.id.i18);
        i18.setPaintFlags(i18.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i19 = (TextView) findViewById(R.id.i19);
        i19.setPaintFlags(i19.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i16.setPaintFlags(i16.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);

        i1.setPaintFlags(i1.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i2.setPaintFlags(i2.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i3.setPaintFlags(i3.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i4.setPaintFlags(i4.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i5.setPaintFlags(i5.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i6.setPaintFlags(i6.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i7.setPaintFlags(i7.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i8.setPaintFlags(i8.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i9.setPaintFlags(i9.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i10.setPaintFlags(i10.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i11.setPaintFlags(i11.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i12.setPaintFlags(i12.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i13.setPaintFlags(i13.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i14.setPaintFlags(i14.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i15.setPaintFlags(i15.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        * */


        findViewById(R.id.ib_back_sponsors).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
