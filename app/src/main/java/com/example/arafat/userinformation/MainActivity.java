package com.example.arafat.userinformation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    Button addName;
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private List<String> name = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //todo work with adapter
        for (int i = 0; i <10 ; i++) {
            name.add("arafat " + i);
        }
        recyclerView.setAdapter(new NameAdapter(name));

        addName = findViewById(R.id.add_name);

        addName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 11-Dec-18  : use of Log-d
                Log.d(TAG, "clicked");
                startActivity(new  Intent(MainActivity.this, AddName.class));
            }
        });
    }
}
