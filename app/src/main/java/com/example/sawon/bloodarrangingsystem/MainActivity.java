package com.example.sawon.bloodarrangingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    Button bLogin,bSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bLogin= (Button) findViewById(R.id.bLogin);
        bSignUp=(Button) findViewById(R.id.bSignup);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(MainActivity.this,GetAmbulance.class);
                startActivity(intent);

            }
        });
        bSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent=new Intent(MainActivity.this,Registration.class);
                intent=new Intent(MainActivity.this,GetBloodbank.class);
                startActivity(intent);
            }
        });

    }
}
