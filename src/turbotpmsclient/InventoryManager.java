/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbotpmsclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Dan
 */
public class InventoryManager implements Runnable {

    @Override
    public void run() {

        String serverName = "localhost";
        int port = 5001;
        Socket serverConnection = makeConnection(serverName, port);

    }

    public InventoryManager(ServerConnection conn) {

    }

    public static Socket makeConnection(String serverName, int port) {
        Socket serverConnection = null;
        try {
            System.out.println("Connecting to " + serverName + " on port " + port);
            serverConnection = new Socket(serverName, port);
            System.out.println("Just connected to " + serverConnection.getRemoteSocketAddress());
            
            while (true) {
                System.out.println("Waiting for inventory from Server");
                InputStream inFromServer = serverConnection.getInputStream();
                DataInputStream dataIn = new DataInputStream(inFromServer);
                System.out.println("Server says: " + dataIn.readUTF());
                String data = dataIn.readUTF();
                System.out.println("here is the data:::: \n" + data);
                String[] inventory = data.split("#");
                for (int i = 0; i < inventory.length; i++) {
                    String[] inventoryItem = inventory[i].split("|");
                    String name = inventoryItem[0];
                    int quantity = Integer.parseInt(inventoryItem[1]);
                    double price = Double.parseDouble(inventoryItem[2]);
                    InventoryList.add(new InventoryItem(name, quantity, price));
                }
            }
        } catch (IOException e) {
            System.out.println("IOException in InventoryManager makeConnection()");
        }
        return serverConnection;
    }

}
