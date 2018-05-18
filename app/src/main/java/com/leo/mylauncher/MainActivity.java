package com.leo.mylauncher;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button app = findViewById(R.id.apps);
        app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.print("test");
            }
        });

        Toast.makeText(this,"This is Launch",Toast.LENGTH_LONG).show();
        /*new AlertDialog.Builder(this)
                .setTitle("Message").setMessage("This is my Launcher")
                .setPositiveButton("OK",null).show();*/
    }

}

