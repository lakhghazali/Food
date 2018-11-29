package com.example.lakhder.eatit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lakhder.eatit.common.Common;
import com.example.lakhder.eatit.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import es.dmoral.toasty.Toasty;

public class Singin extends AppCompatActivity {
    EditText editPhone, editPassword;
    Button btnSingIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin);

        //get ID button
        editPhone = findViewById(R.id.edtPhone);
        editPassword = findViewById(R.id.edtPassword);
        btnSingIn = findViewById(R.id.btnSigin);
        Common.PASSWORD = editPassword.getText().toString();


        //Init the Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        final DatabaseReference table_user = database.getReference("User");


        //when click into sing button

        btnSingIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //show dialogue box
                final ProgressDialog mDailog = new ProgressDialog(Singin.this);
                mDailog.setMessage("Waiting for Login");
                mDailog.show();
                //the end dialogue


                table_user.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        mDailog.dismiss();

                        //check if the user exist in databse
                        if (dataSnapshot.child(editPhone.getText().toString()).getChildrenCount() != 0) {

                               //get the user
                            User user = dataSnapshot.child(editPhone.getText().toString()).getValue(User.class);


                            if (user.getPassword().equals(editPassword.getText().toString())) {

                                Toasty.info(getApplicationContext(), "your are seccessfully login", Toast.LENGTH_LONG, true).show();
                                Intent intent = new Intent(Singin.this, Home.class);
                                startActivity(intent);

                            } else {
                                Toasty.warning(getApplicationContext(), "your are wrong", Toast.LENGTH_LONG, true).show();


                            }
                        } else {
                            Toasty.warning(getApplicationContext(), "you have to register first of all", Toast.LENGTH_LONG, true).show();

                        }


                    } //End Function onDataChange

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }  //End Function OnClickBtn
        });

    }
}
