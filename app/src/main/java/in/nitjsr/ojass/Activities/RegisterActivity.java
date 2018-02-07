package in.nitjsr.ojass.Activities;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.facebook.accountkit.AccountKitLoginResult;
import com.facebook.accountkit.ui.AccountKitActivity;
import com.facebook.accountkit.ui.AccountKitConfiguration;
import com.facebook.accountkit.ui.LoginType;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import in.nitjsr.ojass.R;
import in.nitjsr.ojass.Utils.SharedPrefManager;
import in.nitjsr.ojass.Utils.Utilities;
import in.nitjsr.ojass.Utils.Constants;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView ivBackground, ivOjassIcon;
    private Spinner spinner;
    private Button registerButton, verifyButton, skipButton;
    private EditText inputName,inputEmail,inputMobile,inputCollege,inputRegId,inputBranch;
    private String tshirtSize;
    private FirebaseUser mUser;
    private DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("Users");
    private static final int APP_REQUEST_CODE = 99;
    private boolean mobileVerified = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Utilities.changeStatusBarColor(this);
        mUser = FirebaseAuth.getInstance().getCurrentUser();

        //ivBackground = findViewById(R.id.iv_background);
        ivOjassIcon = findViewById(R.id.iv_ojass_icon);
        skipButton = findViewById(R.id.btn_skip_register);
        inputName = findViewById(R.id.input_name);
        inputEmail = findViewById(R.id.input_email);
        inputMobile = findViewById(R.id.input_mobile);
        inputCollege = findViewById(R.id.input_college);
        inputRegId = findViewById(R.id.input_regid);
        inputBranch = findViewById(R.id.input_branch);
        verifyButton = findViewById(R.id.verify_button);
        registerButton = findViewById(R.id.register_button);
        spinner = findViewById(R.id.spinner);

        skipButton.setOnClickListener(this);

        //Picasso.with(this).load(R.mipmap.ojass_bg).fit().into(ivBackground);
        Picasso.with(this).load(mUser.getPhotoUrl()).fit().into(ivOjassIcon);

        verifyButton.setBackgroundColor(Color.GRAY);
        verifyButton.setOnClickListener(this);

        inputMobile.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().length() == 10){
                    verifyButton.setBackgroundColor(Color.GREEN);
                } else {
                    verifyButton.setBackgroundColor(Color.GRAY);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tshirtSize = parent.getContext().getResources().getStringArray(R.array.tshirt_size)[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()) {
                    registerUser();
                } else if (!mobileVerified){
                    Toast.makeText(RegisterActivity.this, "Verify Mobile Number", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(RegisterActivity.this, "Enter details", Toast.LENGTH_SHORT).show();
                }
            }
        });

        inputName.setText(mUser.getDisplayName());
        inputEmail.setText(mUser.getEmail());
        inputMobile.setText(mUser.getPhoneNumber());
        checkSMSPermission();
    }

    private void checkSMSPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.READ_SMS,
                    Manifest.permission.RECEIVE_SMS
            }, 101);
        }
    }

    private void registerUser() {
        userRef = userRef.child(mUser.getUid());
        userRef.child(Constants.FIREBASE_REF_EMAIL).setValue(mUser.getEmail());
        userRef.child(Constants.FIREBASE_REF_NAME).setValue(mUser.getDisplayName());
        userRef.child(Constants.FIREBASE_REF_PHOTO).setValue(mUser.getPhotoUrl().toString());
        userRef.child(Constants.FIREBASE_REF_MOBILE).setValue(inputMobile.getText().toString());
        userRef.child(Constants.FIREBASE_REF_COLLEGE).setValue(inputCollege.getText().toString());
        userRef.child(Constants.FIREBASE_REF_COLLEGE_REG_ID).setValue(inputRegId.getText().toString());
        userRef.child(Constants.FIREBASE_REF_BRANCH).setValue(inputBranch.getText().toString());
        userRef.child(Constants.FIREBASE_REF_TSHIRT_SIZE).setValue(tshirtSize);
        Toast.makeText(this, "Welcome to Ojass Space Voyage Dashboard!", Toast.LENGTH_LONG).show();
        new SharedPrefManager(this).setIsLoggedIn(true);
        startActivity(new Intent(RegisterActivity.this,MainActivity.class));
        finish();
    }

    public boolean validate(){

        boolean valid=true;
        if(inputEmail.getText().toString().trim().isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(inputEmail.getText().toString().trim()).matches())
        {
            inputEmail.setError("Please Enter Valid Email Address");
            valid=false;
        }
        if(inputMobile.getText().toString().trim().isEmpty()||!Patterns.PHONE.matcher(inputMobile.getText().toString().trim()).matches() )
        {
            inputMobile.setError("Please Enter Valid Mobile Number");
            valid=false;
        }

        if(inputName.getText().toString().trim().isEmpty() )
        {
            inputName.setError("Please Enter Your Name");
            valid=false;
        }

        if(inputCollege.getText().toString().trim().isEmpty() )
        {
            inputCollege.setError("Please Enter Your College");
            valid=false;
        }

        if(inputRegId.getText().toString().trim().isEmpty() )
        {
            inputRegId.setError("Please Enter Your RegId");
            valid=false;
        }

        if(inputBranch.getText().toString().trim().isEmpty() )
        {
            inputBranch.setError("Please Enter Your Branch");
            valid=false;
        }

        return valid && mobileVerified;
    }

    @Override
    public void onClick(View view) {
        if (view == skipButton){
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else if (view == verifyButton){
            if (verifyButton.getText().toString().equals("Edit")) {
              verifyButton.setText("Verify");
              inputMobile.setEnabled(true);
              mobileVerified = false;
            } else phoneLogin();
        }
    }

    public void phoneLogin() {
        final Intent intent = new Intent(this, AccountKitActivity.class);
        AccountKitConfiguration.AccountKitConfigurationBuilder configurationBuilder =
                new AccountKitConfiguration.AccountKitConfigurationBuilder(
                        LoginType.PHONE,
                        AccountKitActivity.ResponseType.CODE);
        intent.putExtra(
                AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION,
                configurationBuilder.build());
        startActivityForResult(intent, APP_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(
            final int requestCode,
            final int resultCode,
            final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == APP_REQUEST_CODE) { // confirm that this response matches your request
            AccountKitLoginResult loginResult = data.getParcelableExtra(AccountKitLoginResult.RESULT_KEY);
            String toastMessage;
            if (loginResult.getError() != null) {
                toastMessage = loginResult.getError().getErrorType().getMessage();
            } else if (loginResult.wasCancelled()) {
                toastMessage = "Login Cancelled";
            } else {
                if (loginResult.getAccessToken() != null) {
                    toastMessage = "Success:" + loginResult.getAccessToken().getAccountId();
                } else {
                    toastMessage = String.format(
                            "Success:%s...",
                            loginResult.getAuthorizationCode().substring(0,10));
                }
                mobileVerified = true;
                inputMobile.setEnabled(false);
                verifyButton.setText("Edit");
            }

        }
    }

}
