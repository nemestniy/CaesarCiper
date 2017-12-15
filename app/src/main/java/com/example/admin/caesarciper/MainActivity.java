package com.example.admin.caesarciper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchEncrypt(View v){
        Intent intent = new Intent(this, encryptActivity.class);
        startActivity(intent);
    }

    public void launchDeciper(View v){
        Intent intent = new Intent(this, decipherActivity.class);
        startActivity(intent);
    }
}
