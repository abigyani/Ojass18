package in.nitjsr.ojass.Activities;


import android.content.Intent;
import android.graphics.Color;
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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import in.nitjsr.ojass.R;
import in.nitjsr.ojass.Utils.Utilities;
import in.nitjsr.ojass.Utils.Constants;

public class RegisterActivity extends AppCompatActivity {

    private ImageView ivBackground, ivOjassIcon;
    private Spinner spinner;
    private Button registerButton, verifyButton;
    private EditText inputName,inputEmail,inputMobile,inputCollege,inputRegId,inputBranch;
    private String tshirtSize;
    private FirebaseUser mUser;
    private DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Utilities.changeStatusBarColor(this);
        mUser = FirebaseAuth.getInstance().getCurrentUser();

        ivBackground = findViewById(R.id.iv_background);
        ivOjassIcon = findViewById(R.id.iv_ojass_icon);

        Picasso.with(this).load(R.mipmap.ojass_bg).fit().into(ivBackground);
        Picasso.with(this).load(mUser.getPhotoUrl()).fit().into(ivOjassIcon);

        inputName = findViewById(R.id.input_name);
        inputEmail = findViewById(R.id.input_email);
        inputMobile = findViewById(R.id.input_mobile);
        inputCollege = findViewById(R.id.input_college);
        inputRegId = findViewById(R.id.input_regid);
        inputBranch = findViewById(R.id.input_branch);
        verifyButton = findViewById(R.id.verify_button);
        registerButton = findViewById(R.id.register_button);
        spinner = findViewById(R.id.spinner);

        verifyButton.setBackgroundColor(Color.GRAY);

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
                if(validate()) registerUser();
            }
        });

        inputName.setText(mUser.getDisplayName());
        inputEmail.setText(mUser.getEmail());
        inputMobile.setText(mUser.getPhoneNumber());
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

        return valid;
    }

}
