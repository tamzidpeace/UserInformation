package com.example.arafat.userinformation;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        final UserDatabase db = Room.databaseBuilder(getApplicationContext(), UserDatabase.class,
                "UserDatabase")
                .allowMainThreadQueries()
                .build();

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String catchFirstName = firstName.getText().toString();
                String catchLastName = lastName.getText().toString();
                String catchEmail = mEmail.getText().toString();

                //Log.d(TAG, catchFirstName + " " + catchLastName + " " + catchEmail);

                if (TextUtils.isEmpty(catchFirstName) || TextUtils.isEmpty(catchFirstName) || TextUtils.isEmpty(catchEmail)) {
                    Toast.makeText(getApplicationContext(), "Enter Information", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    db.userDao().insert(new User(catchFirstName, catchLastName, catchEmail));
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }

            }
        });
    }
}
