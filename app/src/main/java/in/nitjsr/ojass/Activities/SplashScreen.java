package in.nitjsr.ojass.Activities;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import in.nitjsr.ojass.R;
import in.nitjsr.ojass.Utils.SharedPrefManager;
import in.nitjsr.ojass.Utils.Utilities;

public class SplashScreen extends AppCompatActivity {

    private static final int SPLASH_SCREEN_TIMER =  1250;
    private SharedPrefManager sharedPrefManager;
    private ImageView mImageView;
    private ImageView ivSplash;
    private static final String SPLASH_SCREEN_IMAGE = "https://lh3.googleusercontent.com/-OJj_lIygYuw/Wnt49IcYdVI/AAAAAAAABKo/coVAn3ShO6EgEjGjUr3jwtg5KxofE87IgCL0BGAYYCw/h441/23%2B%25282%2529.jpg";
    private static final int WALKTHROUGH = 1;
    private static final int LOGIN = 2;
    private static final int DASHBOARD = 3;
    private int destinationFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Utilities.changeStatusBarColor(this);

        mImageView = findViewById(R.id.iv_splash_logo);

        ivSplash = findViewById(R.id.iv_splashscreen);
        Picasso.with(this).load(R.drawable.menu_bg).fit().into(ivSplash);
        destinationFlag = getDestinationActivity();
        animation();
        doTheDelayStuff();
    }

    private void animation() {

        ObjectAnimator scaleXAnimation = ObjectAnimator.ofFloat(mImageView, "scaleX", 5.0F, 1.0F);
        scaleXAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleXAnimation.setDuration(1200);

        ObjectAnimator scaleYAnimation = ObjectAnimator.ofFloat(mImageView, "scaleY", 5.0F, 1.0F);
        scaleYAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleYAnimation.setDuration(1200);

        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(mImageView, "alpha", 0.0F, 1.0F);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        alphaAnimation.setDuration(1200);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scaleXAnimation).with(scaleYAnimation).with(alphaAnimation);
        animatorSet.start();

    }

    private void doTheDelayStuff() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (destinationFlag){
                    case DASHBOARD:
                        moveToMainActivity();
                        break;
                    case LOGIN:
                        moveToLoginPage();
                        break;
                    case WALKTHROUGH:
                        moveToWalkthrough();
                        break;
                }
            }
        }, SPLASH_SCREEN_TIMER);
    }

    private int getDestinationActivity(){
        sharedPrefManager = new SharedPrefManager(this);
        if (sharedPrefManager.isFirstOpen()){
            sharedPrefManager.setIsFirstOpen(false);
            return WALKTHROUGH;
        } else {
            if (sharedPrefManager.isLoggedIn()){
                return DASHBOARD;
            } else {
                return LOGIN;
            }
        }
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
