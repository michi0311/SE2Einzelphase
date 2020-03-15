package com.example.einzelabgabe_maroltmichael;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //new Thread(new TCP_connection()).start();


    }


    public void sendMessage(View view) {

        EditText editNumber= findViewById(R.id.editNumber);
        String txt = editNumber.getText().toString();
        TextView tv = findViewById(R.id.server_response);

        try {
            //String message = TCP_connection.getMessage(txt);
            //tv.setText(message);

            TCP_Thread t = new TCP_Thread(txt);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                //TODO do sth
            }
            tv.setText(t.getModifiedSentence());

        } catch (Exception e) {
            tv.setText(e.toString());
        }


    }
}
