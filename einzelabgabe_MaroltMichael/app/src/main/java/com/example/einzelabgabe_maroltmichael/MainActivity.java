package com.example.einzelabgabe_maroltmichael;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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

        try {
            TCP_Thread t = new TCP_Thread(txt);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                throw e;
            }
            tv.setText(t.getModifiedSentence());

        } catch (Exception e) {
            tv.setText(e.toString());
        }
    }

    public void calculate(View view) {
        EditText editNumber= findViewById(R.id.editNumber);
        String txt = editNumber.getText().toString();
        TextView tv = findViewById(R.id.server_response);

        if (txt.length() == 0) {
            tv.setText("No Number given");
            return;
        }

        char[] charArray = txt.toCharArray();
        List<Character> out = new LinkedList<>();

        try {
            for (int i = 0; i < charArray.length; i++) {
                if (isPrime(charArray[i])) {
                    out.add(charArray[i]);
                }
            }

            tv.setText(out.toString().substring(1, 3 * out.size()-1).replaceAll(", ", ""));
        } catch (Exception e){
            tv.setText(e.toString());
        }
    }

    private boolean isPrime(char c) {
        int val = Integer.parseInt(String.valueOf(c));
        if (val < 1) {
            return false;
        }
        for (int i = 2; i <= val/2; i++) {
            if (val%i == 0) {
                return false;
            }
        }
        return true;
    }
}


