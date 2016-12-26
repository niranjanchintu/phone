package com.example.chintu.myapplication;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


public class Loginativity extends AppCompatActivity implements View.OnClickListener{
    private Button loginbutton;
    private EditText emailtext;
    private EditText passwordtext;
    private ProgressDialog progressdialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginativity);
        loginbutton = (Button) findViewById(R.id.loginbut);
        emailtext = (EditText) findViewById(R.id.emailtext);
        passwordtext = (EditText) findViewById(R.id.passwordtext);
        loginbutton.setOnClickListener(this);

    }
    private void loginuser()
    {
        String email= emailtext.getText().toString().trim();
        String password=passwordtext.getText().toString().trim();
        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(this,"please enter the email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password))
        {
           Toast.makeText(this,"please enter the password",Toast.LENGTH_SHORT).show();
            return;

        }


    }

    @Override
    public void onClick(View view) {
        if(view == loginbutton)
        {
           loginuser();

        }

    }

}
