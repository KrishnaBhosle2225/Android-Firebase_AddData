package com.krishna.firebase_add_data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText edtName,edtRoll,edtEmail,edtMobile;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtRoll = findViewById(R.id.edtRoll);
                edtName = findViewById(R.id.edtName);
                edtEmail = findViewById(R.id.edtEmail);
                edtMobile = findViewById(R.id.edtMobile);

                String roll = edtRoll.getText().toString().trim();
                String name = edtName.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();
                String mobile = edtMobile.getText().toString().trim();

                DataHolder obj = new DataHolder(name,email,mobile);
                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference node = db.getReference("student");

                node.child(roll).setValue(obj);
                edtRoll.setText("");
                edtName.setText("");
                edtEmail.setText("");
                edtMobile.setText("");
                Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
            }
        });

    }
}