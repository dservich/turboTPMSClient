/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbotpmsclient;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Dan
 */
public class TransactionManager implements Runnable {

    String transaction;
    Socket serverConnection;
    @Override
    public void run() {
        serverConnection = ServerConnection.getConnection();
        completeTransaction(transaction);
    }

    public TransactionManager(String transaction) {
        this.transaction = transaction;
    }

    public void completeTransaction(String transaction) {
        
        try {
            System.out.println("Transaction to be sent: " + transaction);
            OutputStream outToServer = serverConnection.getOutputStream();
            DataOutputStream dataOut = new DataOutputStream(outToServer);

            dataOut.writeUTF(transaction);
            //dataOut.close();
        } catch (IOException e) {
            System.out.println("IOException in TransactionManager completeTransaction()");
        }
        
    }
}
