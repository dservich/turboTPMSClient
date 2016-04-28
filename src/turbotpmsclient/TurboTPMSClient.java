/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbotpmsclient;

/**
 *
 * @author Dan
 */
public class TurboTPMSClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ServerConnection conn = new ServerConnection();
        InventoryManager inventoryManager = new InventoryManager(conn);
        Thread theInventoryThread = new Thread(inventoryManager);
        theInventoryThread.start();
        
        ClientUI theUI = new ClientUI();
        theUI.setVisible(true);
    }
    
}
