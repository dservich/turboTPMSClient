/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbotpmsclient;

import java.util.ArrayList;

/**
 *
 * @author Dan
 */
public class InventoryList {
    private static ArrayList<InventoryItem> list = new ArrayList<>();
    
    public InventoryList(){
        
    }
    
    public static void add(InventoryItem item){
        list.add(item);
    }
    
    public static ArrayList<InventoryItem> getList(){
        return list;
    }
    
}
