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

public class Register extends AppCompatActivity {
    EditText  remail,rpassword,rconfpass;
    Button registerbtn;
    TextView rloginbtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

         remail=findViewById(R.id.lemail);
        rloginbtn=findViewById(R.id.createText);
        rpassword=findViewById(R.id.lpassword);
        rconfpass=findViewById(R.id.rconfpassword);
        fAuth= FirebaseAuth.getInstance();
        registerbtn=findViewById(R.id.loginbtn);
        progressBar=findViewById(R.id.progressBar2);

        if(fAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }


        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email=remail.getText().toString().trim();
                String password=rpassword.getText().toString().trim();
                String cpassword=rconfpass.getText().toString().trim();



                if(TextUtils.isEmpty(email)){
                    remail.setError("Email is Required.");
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    rpassword.setError("Password is Required.");
                    return;
                }
                if(password.length()<6){
                    rpassword.setError("Password Must be >=6 Characters");
                    return;
                }
                if(TextUtils.isEmpty(cpassword)){
                    rconfpass.setError("Confirm Password is Required.");
                    return;
                }

                progressBar.setVisibility(view.VISIBLE);
                ///registerrr the user
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Register.this,"User Created.",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),RegData.class));
                        }else{
                            Toast.makeText(Register.this,"Error !"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);

                        }
                    }
                });
            }
        });

        rloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login.class));

            }
        });

    }
}
