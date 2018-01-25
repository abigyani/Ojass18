package in.nitjsr.ojass.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Abhishek on 26-Jan-18.
 */

public class SharedPrefManager {

    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;

    private static final String SHARED_PREF = "SharedPref";
    private static final String IS_FIRST_OPEN = "isFirstOpen";
    private static final String IS_LOGGED_IN = "isLoggedIn";

    public SharedPrefManager(Context context){
        sharedPref = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
        editor = sharedPref.edit();
    }

    public void setIsFirstOpen(boolean isFirstOpen){
        editor.putBoolean(IS_FIRST_OPEN, isFirstOpen).apply();
    }

    public boolean isFirstOpen(){
        return sharedPref.getBoolean(IS_FIRST_OPEN, true);
    }

    public boolean isLoggedIn() {
        return sharedPref.getBoolean(IS_LOGGED_IN, false);
    }

    public void setIsLoggedIn(boolean isLoggedIn){
        editor.putBoolean(IS_LOGGED_IN, isLoggedIn).apply();
    }
}
