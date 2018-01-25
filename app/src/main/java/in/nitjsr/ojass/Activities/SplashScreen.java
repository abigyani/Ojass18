package in.nitjsr.ojass.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import in.nitjsr.ojass.R;
import in.nitjsr.ojass.Utils.SharedPrefManager;
import in.nitjsr.ojass.Utils.Utilities;

public class SplashScreen extends AppCompatActivity {

    private static final int SPLASH_SCREEN_TIMER = 2 * 1000;
    private SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Utilities.changeStatusBarColor(this);

        sharedPrefManager = new SharedPrefManager(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!sharedPrefManager.isFirstOpen()){
                    sharedPrefManager.setIsFirstOpen(false);
                    moveToWalkthrough();
                } else {
                    if (sharedPrefManager.isLoggedIn()){
                        moveToMainActivity();
                    } else {
                        moveToLoginPage();
                    }
                }
            }
        }, SPLASH_SCREEN_TIMER);

    }

    private void moveToLoginPage() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    private void moveToMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void moveToWalkthrough() {
        startActivity(new Intent(this, Walkthrough.class));
        finish();
    }
}
