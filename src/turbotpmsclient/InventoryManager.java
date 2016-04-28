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
import java.util.Arrays;

/**
 *
 * @author Dan
 */
public class InventoryManager implements Runnable {

    Socket serverConnection;

    @Override
    public void run() {
        serverConnection = ServerConnection.getConnection();
        getInventory();
    }

    public InventoryManager(ServerConnection conn) {

    }

    public void getInventory() {

        try {
            System.out.println("Connecting to localhost on port 5001");

            System.out.println("Just connected to " + serverConnection.getRemoteSocketAddress());

            while (true) {
                System.out.println("Waiting for inventory from Server");

                InputStream inFromServer = serverConnection.getInputStream();
                DataInputStream dataIn = new DataInputStream(inFromServer);
                String data = dataIn.readUTF();

                System.out.println("Server says: " + data);

                String[] inventory = data.split("#");

                for (int i = 0; i < inventory.length; i++) {
                    System.out.println(inventory[i]);
                }

                for (int i = 0; i < inventory.length; i++) {
                    System.out.println(inventory[i]);
                    String[] inventoryItem = inventory[i].split(":::");
                    for (int j = 0; j < inventoryItem.length; j++) {
                        System.out.println(inventoryItem[j]);
                    }
                    String name = inventoryItem[0];
                    int quantity = Integer.parseInt(inventoryItem[1]);
                    double price = Double.parseDouble(inventoryItem[2]);
                    InventoryList.add(new InventoryItem(name, quantity, price));
                }
                System.out.println("Here is the Inventory List:::\n" + InventoryList.getList().toString());
            }
        } catch (IOException e) {
            System.out.println("IOException in InventoryManager getInventory()");
        }

    }

}
