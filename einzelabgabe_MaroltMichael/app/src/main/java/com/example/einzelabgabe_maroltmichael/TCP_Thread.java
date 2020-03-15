package com.example.einzelabgabe_maroltmichael;

import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCP_Thread extends Thread {
    static Socket clientSocket = null;
    private static final int SERVERPORT = 53212;
    private static final String SERVER = "se2-isys.aau.at";
    private String message;
    private String modifiedSentence;

    TCP_Thread(String message) {
        this.message = message;
    }

    public String getModifiedSentence() {
        return this.modifiedSentence;
    }

    @Override
    public void run() {
        try {
            clientSocket = new Socket(SERVER, SERVERPORT);

            try {
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                outToServer.writeBytes(message + "\n");
                modifiedSentence = inFromServer.readLine();


            } catch (Exception e) {
                Log.e("error",e.toString());
                throw e;
            }  finally {
                if (clientSocket != null) {
                    clientSocket.close();
                }
            }

        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
