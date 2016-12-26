package com.example.chintu.myapplication;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signupacticity extends AppCompatActivity implements View.OnClickListener {
    private Button signupbutton;
    private EditText emailtext;
    private EditText passwordtext;

    private ProgressDialog progressdialog;
    private FirebaseAuth firebaseauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupacticity);
        progressdialog = new ProgressDialog(this);
        firebaseauth = FirebaseAuth.getInstance();


        signupbutton = (Button) findViewById(R.id.signupbut);
        emailtext = (EditText) findViewById(R.id.emailtext1);
        passwordtext = (EditText) findViewById(R.id.passwordtext1);

        signupbutton.setOnClickListener(this);

    }

   private void signupuser(){
    String email=emailtext.getText().toString().trim();
    String password =passwordtext.getText().toString().trim();
    if(TextUtils.isEmpty(email)){
        Toast.makeText(this,"emter the emailID",Toast.LENGTH_SHORT).show();

        return;
    }
    if (TextUtils.isEmpty(password)){
        Toast.makeText(this,"enter the password",Toast.LENGTH_SHORT).show();
        return;
    }
    progressdialog.setMessage("registering user........");
    progressdialog.show();
    firebaseauth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                      public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful()){
                        Toast.makeText(Signupacticity.this ,"Rgistered successfully",Toast.LENGTH_SHORT).show();
                    }
                }
            });
                }
    @Override
   public void onClick(View view) {
        if(view == signupbutton){
            signupuser();
        }

    }
}