package com.example.ocsmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText lemail,lpass;
    Button log;
    TextView lbtn;
    ProgressBar progressBar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lemail=findViewById(R.id.lemail);
        lpass=findViewById(R.id.lpassword);
        log=findViewById(R.id.loginbtn);
        progressBar= findViewById(R.id.progressBar2);
        fAuth=FirebaseAuth.getInstance();
        lbtn=findViewById(R.id.createText1);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=lemail.getText().toString().trim();
                String password=lpass.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    lemail.setError("Email is Required.");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    lpass.setError("Password is Required.");
                    return;
                }
                if(password.length()<6){
                    lpass.setError("Password Must be >=6 Characters");
                    return;
                }
                progressBar.setVisibility(view.VISIBLE);


                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                     if (task.isSuccessful()){
                         Toast.makeText(Login.this,"Login Successful !!.",Toast.LENGTH_SHORT).show();
                         startActivity(new Intent(getApplicationContext(),EnterID.class));
                     }else {
                         Toast.makeText(Login.this,"Error !"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                         progressBar.setVisibility(View.GONE);
                     }
                    }
                });

            }
        });
        lbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Register.class));

            }
        });



    }

}
