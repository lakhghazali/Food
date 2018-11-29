package com.example.lakhder.eatit.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


import com.example.lakhder.eatit.R;
import com.example.lakhder.eatit.Singin;
import com.rengwuxian.materialedittext.MaterialEditText;

public class MainActivity extends AppCompatActivity{
    Button btnSignIn,btnRegister,btnLogin;
    MaterialEditText txt;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         //when click into button sign in
        findViewById(R.id.btn_singin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Singin.class);
                MainActivity.this.startActivity(intent);

            }
        });




    }







}
