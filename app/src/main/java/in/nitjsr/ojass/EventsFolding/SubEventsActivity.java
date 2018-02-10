package in.nitjsr.ojass.EventsFolding;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.desarrollodroide.libraryfragmenttransactionextended.FragmentTransactionExtended;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

import org.jetbrains.annotations.NotNull;

import client.yalantis.com.foldingtabbar.FoldingTabBar;
import in.nitjsr.ojass.Activities.MainActivity;
import in.nitjsr.ojass.R;

public class SubEventsActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    TextView toolbar_tv;
    int flag_show = 0;
    public static String actionBarTitle;
    private BoomMenuButton bmb;
    private String[] name = {"Coordinator 1", "Coordinator 2", "Coordinator 3", "Coordinator 4"};
    private String[] ph = {"Phone 1", "Phone 2", "Phone 3", "Phone 4"};


    public static int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_events);
        actionBarTitle = getIntent().getExtras().getString("title");
        getPostion();


        bmb = (BoomMenuButton) findViewById(R.id.bmb);
        bmb.setButtonEnum(ButtonEnum.Ham);


        // set no of  ham buttons
      if (MainActivity.data.get(position).getCoordinatorsModelArrayList().size() == 1) {
            bmb.setPiecePlaceEnum(PiecePlaceEnum.HAM_1);
            bmb.setButtonPlaceEnum(ButtonPlaceEnum.HAM_1);
        } else if (MainActivity.data.get(position).getCoordinatorsModelArrayList().size() == 2) {
            bmb.setPiecePlaceEnum(PiecePlaceEnum.HAM_2);
            bmb.setButtonPlaceEnum(ButtonPlaceEnum.HAM_2);
        } else if (MainActivity.data.get(position).getCoordinatorsModelArrayList().size() == 3) {
            bmb.setPiecePlaceEnum(PiecePlaceEnum.HAM_3);
            bmb.setButtonPlaceEnum(ButtonPlaceEnum.HAM_3);
        } else {
            bmb.setPiecePlaceEnum(PiecePlaceEnum.HAM_4);
            bmb.setButtonPlaceEnum(ButtonPlaceEnum.HAM_4);
        }


        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            HamButton.Builder builder = new HamButton.Builder().listener(new OnBMClickListener() {
                @Override
                public void onBoomButtonClick(int index) {
                    // When the boom-button corresponding this builder is clicked.
                    callPhoneIntent(MainActivity.data.get(position).getCoordinatorsModelArrayList().get(index).getPhone());
                    //Toast.makeText(getApplicationContext(), "Clicked " + index, Toast.LENGTH_SHORT).show();
                }
            })
                    .normalText(MainActivity.data.get(position).getCoordinatorsModelArrayList().get(i).getName())
                    .subNormalText(MainActivity.data.get(position).getCoordinatorsModelArrayList().get(i).getPhone());
            bmb.addBuilder(builder);
        }

        FoldingTabBar tabBar = (FoldingTabBar) findViewById(R.id.folding_tab_bar);
        changeFragment(new AboutFragment());
        actionBarTitle = getIntent().getExtras().getString("title");
        toolbar_tv = (TextView) findViewById(R.id.title_toolbar);
        toolbar_tv.setText(actionBarTitle);
        Typeface customFontBold = Typeface.createFromAsset(getAssets(), "ToolbarText.ttf");
        toolbar_tv.setTypeface(customFontBold);


        tabBar.setOnFoldingItemClickListener(new FoldingTabBar.OnFoldingItemSelectedListener() {
            @Override
            public boolean onFoldingItemSelected(@NotNull MenuItem item) {
                //    bmb.setVisibility(View.GONE);
                if (flag_show == 0)
                    flag_show = 1;
                else
                    flag_show = 0;
                if (flag_show == 0) {
                    bmb.setVisibility(View.VISIBLE);
                } else {
                    bmb.setVisibility(View.GONE);
                }

                switch (item.getItemId()) {
                    case R.id.ftb_menu_about:
                        changeFragment(new AboutFragment());
                        break;
                    case R.id.ftb_menu_details:
                        changeFragment(new DetailsFragment());
                        break;
                    case R.id.ftb_menu_rules:
                        changeFragment(new RulesFragment());
                        break;
                    case R.id.ftb_menu_prize:
                        changeFragment(new PrizeFragment());
                        break;
                }
                return false;
            }
        });
        tabBar.setOnMainButtonClickListener(new FoldingTabBar.OnMainButtonClickedListener() {
            @Override
            public void onMainButtonClicked() {
                if (flag_show == 0)
                    flag_show = 1;
                else
                    flag_show = 0;
                if (flag_show == 0) {
                    bmb.setVisibility(View.VISIBLE);
                } else {
                    bmb.setVisibility(View.GONE);
                }
            }
        });

        findViewById(R.id.ib_back_events).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void getPostion() {

        switch (actionBarTitle) {
            case "High Voltage Concepts (HVC)":
                position = 0;
                break;
            case "Mat Sim":
                position = 1;
                break;
            case "Tame the pyhton":
                position = 2;
                break;
            case "Codiyapa":
                position = 3;
                break;
            case "Game of Troves":
                position = 4;
                break;
            case "Scratch Easy":
                position = 5;
                break;
            case "SimplySql":
                position = 6;
                break;
            case "Counter Strike- Global Offensive":
                position = 7;
                break;
            case "DOTA":
                position = 8;
                break;
            case "FIFA":
                position = 9;
                break;
            case "NFS Most Wanted":
                position = 10;
                break;
            case "Angry Birds":
                position = 11;
                break;
            case "Pratibimb":
                position = 12;
                break;
            case "Elixir of Electricity":
                position = 13;
                break;
            case "Electro-Q":
                position = 14;
                break;
            case "Nexus":
                position = 15;
                break;
            case "Pro-Lo-Co":
                position = 16;
                break;
            case "Who Am I":
                position = 17;
                break;
            case "NSCET":
                position = 18;
                break;
            case "Jagriti":
                position = 19;
                break;
            case "Samvedna":
                position = 20;
                break;
            case "Artifact":
                position = 21;
                break;
            case "Industrial Tycoon":
                position = 22;
                break;
            case "M&I Quiz":
                position = 23;
                break;
            case "MICAV":
                position = 24;
                break;
            case "DronaGyan":
                position = 25;
                break;
            case "Utpreaks":
                position = 26;
                break;
            case "Analog Hunter":
                position = 27;
                break;
            case "Codesense":
                position = 28;
                break;
            case "Digizone":
                position = 29;
                break;
            case "Labyrinth":
                position = 30;
                break;
            case "Embetrix":
                position = 31;
                break;
            case "Web Weaver":
                position = 32;
                break;
            case "Sudo Code":
                position = 33;
                break;
            case "Jigyasa":
                position = 34;
                break;
            case "Algorithma":
                position = 35;
                break;
            case "Ansys":
                position = 36;
                break;
            case "Netkraft":
                position = 37;
                break;
            case "Spectra":
                position = 38;
                break;
            case "Tukvilla":
                position = 39;
                break;
            case "Metal Trivia":
                position = 40;
                break;
            case "K.O.":
                position = 41;
                break;
            case "Exposicion":
                position = 42;
                break;
            case "Code-O-Soccer":
                position = 43;
                break;
            case "Codemania":
                position = 44;
                break;
            case "Autoquiz":
                position = 45;
                break;
            case "Enigma":
                position = 46;
                break;
            case "Junkyard Wars":
                position = 47;
                break;
            case "Teenpreneur":
                position = 48;
                break;
            case "Prakshepan":
                position = 49;
                break;
            case "Samveg":
                position = 50;
                break;
            case "Agnikund":
                position = 51;
                break;
            case "Acumen":
                position = 52;
                break;
            case "Pipe-o-Mania":
                position = 53;
                break;
            case "ABC":
                position = 54;
                break;
            case "Corporate Roadies":
                position = 55;
                break;
            case "Let's Start Up":
                position = 56;
                break;
            case "Neetishastra":
                position = 57;
                break;
            case "TechArt":
                position = 58;
                break;
            case "Accelodrome":
                position = 59;
                break;
            case "Touch Down the plane":
                position = 60;
                break;
            case "Mad Ad":
                position = 61;
                break;
            case "SCI FI":
                position = 62;
                break;
            case "Tech-Know":
                position = 63;
                break;
            case "The Great Ojass Race":
                position = 64;
                break;
            case "App Droid":
                position = 65;
                break;
            case "Director's Cut":
                position = 66;
                break;
            case "LiveCS":
                position = 67;
                break;
            case "Innovision":
                position = 68;
                break;
            case "Wolf of Dalal Street":
                position = 69;
                break;
            case "Kurukshetra":
                position = 70;
                break;
            case "Tachyon":
                position = 71;
                break;
            case "Shapeshifter":
                position = 72;
                break;
            case "360 Mania":
                position = 73;
                break;
            case "MAC FIFA":
                position = 74;
                break;
            case "Battleship":
                position = 75;
                break;
            case "Bizzathlon":
                position = 76;
                break;
            case "Exempler":
                position = 77;
                break;
            case "Metropolis":
                position = 78;
                break;
            case "Archmadeease":
                position = 79;
                break;
            case "Sanrachna":
                position = 80;
                break;
            case "Lens View":
                position = 81;
                break;

        }

    }

    private void changeFragment(Fragment fragment) {
        //    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        //    fragmentTransaction.replace(R.id.container,fragment).commit();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        FragmentTransactionExtended fragmentTransactionExtended = new FragmentTransactionExtended(this, fragmentTransaction,
                new AboutFragment(), fragment, R.id.container);
        fragmentTransactionExtended.addTransition(FragmentTransactionExtended.GLIDE);
        fragmentTransactionExtended.commit();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public void callPhoneIntent(String number) {
        number = number.trim();
        try {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.e("CALL_INTENT", "CALL FAILED", e);
        }
    }
}
