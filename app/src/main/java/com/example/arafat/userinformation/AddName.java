package com.example.arafat.userinformation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddName extends AppCompatActivity {

    EditText firstName, lastName, mEmail;
    private Button mSave;
    private static final String TAG = "AddName";
    private static final String TAG1 = "testing error";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_name);

        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        mEmail = findViewById(R.id.email);
        mSave = findViewById(R.id.save);

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String catchFirstName = firstName.getText().toString();
                String catchLastName = lastName.getText().toString();
                String catchEmail = mEmail.getText().toString();

                Log.d(TAG, catchFirstName + " " + catchLastName + " " + catchEmail);
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}
