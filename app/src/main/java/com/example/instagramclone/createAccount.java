package com.example.instagramclone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class createAccount extends AppCompatActivity{
    static EditText createmail,createpassword,createconfirmpassword;
    static Button signupp;
    ConstraintLayout keyBoardhide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        createmail=(EditText)findViewById(R.id.createmail);
        createpassword=(EditText)findViewById(R.id.createpass);
        createconfirmpassword=(EditText)findViewById(R.id.createconfirmpass);
        signupp=(Button)findViewById(R.id.signUp);
        keyBoardhide=(ConstraintLayout)findViewById(R.id.createConstraint);

        signupp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(createmail.getText().toString().matches("") || createpassword.getText().toString().matches("") || createconfirmpassword.getText().toString().matches(""))
                {
                    createmail.setError("This field can not be blank");
                    createpassword.setError("This field can not be blank");
                    createconfirmpassword.setError("This field can not be blank");
                }
                else if(createpassword.getText().toString().matches(createconfirmpassword.getText().toString()))
                {
                    ParseUser user=new ParseUser();
                    user.setUsername(createmail.getText().toString());
                    user.setPassword(createconfirmpassword.getText().toString());
                    user.setEmail(createmail.getText().toString());
                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if(e==null)
                            {
                                Toast.makeText(createAccount.this, "Successfully Sign Up", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(createAccount.this, e.toString(), Toast.LENGTH_SHORT).show();
                                Log.i("problem",e.toString());
                            }
                        }
                    });
                }
                else
                {
                    createconfirmpassword.setError("Confirm password not match!");
                }
            }
        });


        keyBoardhide.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v=getCurrentFocus();
                InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(),0);
                return true;
            }
        });
        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }

}
