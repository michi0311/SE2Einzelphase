package com.example.einzelabgabe_maroltmichael;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCP_connection {
    public static String getMessage(String msg) throws Exception {
        String modifiedSentence;
        Socket clientSocket = null;

        try {
            clientSocket = new Socket("se2-isys.aau.at",53212);

            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            outToServer.writeBytes(msg + "\n");

            modifiedSentence = inFromServer.readLine();

            System.out.println("FROM SERVER: " + modifiedSentence);

        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }  finally {
            if (clientSocket != null) {
                clientSocket.close();
            }
        }

        return modifiedSentence;
    }
}
