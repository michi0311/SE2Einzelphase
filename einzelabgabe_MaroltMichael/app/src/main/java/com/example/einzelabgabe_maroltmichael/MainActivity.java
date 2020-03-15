package com.example.einzelabgabe_maroltmichael;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void sendMessage(View view) {
        EditText editNumber= findViewById(R.id.editNumber);
        String txt = editNumber.getText().toString();

        TextView tv = findViewById(R.id.server_response);
        tv.setText(txt);
    }
}
