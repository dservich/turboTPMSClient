/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbotpmsclient;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Dan
 */
public class ServerConnection {
    static Socket connection;
    
    public ServerConnection() {
        try{
            connection = new Socket("localhost", 5001);
        }catch(IOException e){
            System.out.println("ERROR: IOException in the ServerConnection");
        }
    }
    
    public static Socket getConnection(){
        return connection;
    }
    
    public static void close() throws IOException{
        connection.close();
    }
}
