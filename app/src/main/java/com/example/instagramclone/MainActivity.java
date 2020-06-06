package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity{
    static EditText email;
    static EditText password;
    Button login;
    TextView forgot,createAccount;
    ConstraintLayout backgroundConstraint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=(EditText)findViewById(R.id.usermail);
        password=(EditText)findViewById(R.id.userpass);
        login=(Button)findViewById(R.id.button);
        forgot=(TextView)findViewById(R.id.forgotpassword);
        createAccount=(TextView)findViewById(R.id.create);
        backgroundConstraint=(ConstraintLayout)findViewById(R.id.backgroundConstraintInsta);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().matches("") ||password.getText().toString().matches(""))
                {
                   email.setError("This field can not be blank");
                    password.setError("This field can not be blank");
                }
                else
                {
                    ParseUser.logInInBackground(email.getText().toString(), password.getText().toString(), new LogInCallback() {
                        @Override
                        public void done(ParseUser user, ParseException e) {
                            if(e==null && user!=null)
                            {
                                Toast.makeText(MainActivity.this, "Successfully log in", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),BottomNavigation.class);
                                startActivity(intent);
                            }
                            else
                            {
                                email.setError("Invalid email!");
                                password.setError("Invalid password");
                            }
                        }
                    });
                }
            }
        });


     createAccount.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent=new Intent(getApplicationContext(),createAccount.class);
             startActivity(intent);
         }
     });

     forgot.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent=new Intent(getApplicationContext(),createAccount.class);
             startActivity(intent);
         }
     });




    backgroundConstraint.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            v=getCurrentFocus();
            InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(),0);
            return true;
        }
    });

    }

}
