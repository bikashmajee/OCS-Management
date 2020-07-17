package com.example.ocsmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegData extends AppCompatActivity {
    EditText dorg,d1,d2,d3,d4,d5;
    Button sub;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_data);
        dorg=findViewById(R.id.oname);
        d1=findViewById(R.id.dno);
        d2=findViewById(R.id.ds);
        d3=findViewById(R.id.dt);
        d4=findViewById(R.id.dm);
        d5=findViewById(R.id.da);
        sub=findViewById(R.id.submit);
       // Firebase.setAndroidContext(getApplicationContext());
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode=FirebaseDatabase.getInstance();
                String OrganisationID=d1.getText().toString();

                //reference.setValue(OrganisationID);
                reference=rootNode.getReference(OrganisationID);
                //getall tha value
                String OrganisationName=dorg.getText().toString();
                 String StudentID=d2.getText().toString();
                String TeacherID=d3.getText().toString();
                String ManagementID=d4.getText().toString();
                String AppSettingID=d5.getText().toString();


                detailneed hrlperclass=new detailneed(OrganisationName,OrganisationID,StudentID,TeacherID,ManagementID,AppSettingID);
                reference.setValue(hrlperclass);


            }
        });


    }
  /*  public void click(View view){
        String OrganisationID=d1.toString();
        String StudentID=d1.toString();
        String TeacherID=d1.toString();
        String ManagementID=d1.toString();
        String AppSettingID=d1.toString();
        if(OrganisationID.equals("")|StudentID.equals("")|TeacherID.equals("")|ManagementID.equals("")|AppSettingID.equals("")){
            Toast.makeText(this,"Plz fill all the Filds",Toast.LENGTH_SHORT).show();
        }
        else{
            detailneed user=new detailneed();
            user.setOrganisationID(OrganisationID);
            user.setStudentID(StudentID);
            user.setTeacherID(TeacherID);
            user.setManagementID(ManagementID);
            user.setAppSettingID(AppSettingID);
           // Firebase firebase=new Firebase(Config.url);
          //  firebase.child("OrganisationID").set


        }

    }*/
}
