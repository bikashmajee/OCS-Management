package com.example.ocsmanagement;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class EnterID extends AppCompatActivity {
    EditText orgid,yourid;
    Button btn;
    TextView tv;
    ProgressBar progressBar;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_i_d);
        orgid = findViewById(R.id.orgID);
        yourid = findViewById(R.id.yourID);
        btn = findViewById(R.id.orglog);
        final int a,b;

        tv=findViewById(R.id.textV);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                reference=FirebaseDatabase.getInstance().getReference().child("jaba") ;
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String org=dataSnapshot.child("organisationID").getValue().toString();
                        String student=dataSnapshot.child("studentID").getValue().toString();
                        String teacher=dataSnapshot.child("teacherID").getValue().toString();
                        String Management=dataSnapshot.child("managementID").getValue().toString();
                        String app=dataSnapshot.child("appSettingID").getValue().toString();
                        String orgg=orgid.getText().toString().trim();
                        String you=yourid.getText().toString().trim();
                        tv.setText(teacher);

                        if(TextUtils.isEmpty(orgg)){
                            orgid.setError("Organisation name is Required.");
                            return;
                        }
                        if(TextUtils.isEmpty(you)){
                            yourid.setError("Organisation name is Required.");
                            return;
                        }






                        if (orgg.equals(org) && you.equals(student) ){
                            Toast.makeText(EnterID.this,"Login Student Successfully.",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Student.class));

                        }else if (orgg.equals(org) && you.equals(teacher)){
                            Toast.makeText(EnterID.this,"Login Teacher Successfully.",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Teacher.class));

                        }
                        else if (orgg.equals(org) && you.equals(Management)){
                            Toast.makeText(EnterID.this,"Login Management Successfully.",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Management.class));

                        }else if (orgg.equals(org) && you.equals(app)){
                            Toast.makeText(EnterID.this,"Login AppSetting Successfully.",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        }

                        else {
                            Toast.makeText(EnterID.this,"Somthing is Wrong!! try again",Toast.LENGTH_SHORT).show();
                         }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

     /*   reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String value = dataSnapshot.getValue(String.c)
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        })

    }*/
        /*fAuth=FirebaseAuth.getInstance();
        DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("OrganisationID").child("studentID")
                .child("teacherID").child("managementID").child("appSettingID");



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String orid=orgid.getText().toString().trim();
                String yoid=yourid.getText().toString().trim();
                if(TextUtils.isEmpty(orid)){
                    orgid.setError("OrganisationID is Required.");
                    return;
                }
                if (TextUtils.isEmpty(yoid)){
                    yourid.setError("YourID is Required.");
                    return;
                }



                DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("jaba").child("studentID")
                         .child("teacherID").child("managementID").child("appSettingID");
                 ref.orderByChild("jaba").equalTo(orid).addListenerForSingleValueEvent(new ValueEventListener() {
                     @Override
                     public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                         if (dataSnapshot.equals(orid)){
                             Toast.makeText(EnterID.this,"User Created.",Toast.LENGTH_SHORT).show();
                             startActivity(new Intent(getApplicationContext(),MainActivity.class));


                         }else {
                             Toast.makeText(EnterID.this,"Error!!.",Toast.LENGTH_SHORT).show();

                         }

                     }

                     @Override
                     public void onCancelled(@NonNull DatabaseError databaseError) {

                     }
                 });





                /*fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Login.this,"Login Successful !!.",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else {
                            Toast.makeText(Login.this,"Error !"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });                        //                }
        });
    }*/

    }

}
