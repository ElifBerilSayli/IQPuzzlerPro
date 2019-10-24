/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ıqpuzzlerpro;


 
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;


public class DataManager {
    
    Gson gson;
    Player p1;
    List<Player> playerL ;
    boolean isFull = false;
    boolean sameName = false;
   
   public DataManager() {
       playerL = new ArrayList<Player>();
       gson = new Gson();
    }
    
    public Player addPlayer( String name, int id )
    {
        isFull = false;
        sameName = false;
        boolean flag2 = false;
        // create player object
        Player player = new Player(name, id);
        List<Player>  temp = getArrayInJSON();
        //System.out.println("Size: " + temp.size());
        if( temp == null  )
        {
            System.out.println("girdi1");
            temp = new ArrayList<Player>();
            temp.add(player);
            flag2 = true;
             
        }
        else if ( temp.size() > 0 && temp.size() < 4 && flag2 == false)
        {
            boolean flag = false;
            for( int i = 0; i < temp.size(); i++ )
            {
                if (temp.get(i).getName().equals(name))
                {
                    System.out.println("This name is already entered, please enter another name");
                    flag = true;
                     
                }
            }
            if( flag == true ) 
            {
                System.out.println("Aynı isim");
                sameName = true;
                flag = false;
            }
                
            else
            {
                System.out.println("girdi2");
                temp.add(player);
            }
        }
        else{ 
            System.out.println("Yer yok");
            isFull = true;
        }
        setArrayInJSON(temp);
      
        return player; 
    }
    public void removePlayer( String name )
    {
        
        List<Player>  temp = getArrayInJSON();
        //System.out.println("Size: " + temp.size());
        if( temp == null  )
        {
            System.out.println("Empty!!!!"); 
        }
        else 
        {
            //boolean flag = false;
            //int index;
            for( int i = 0; i < temp.size(); i++ )
            {
                if (temp.get(i).getName().equals(name))
                {
                    //index = i;
                    System.out.println("REMOVE!!");
                    temp.remove(i);
                    //flag = true;

                }
            }
        }
        if ( temp.size() == 0 )
            temp = null;
        setArrayInJSON(temp);
    }
    public void setArrayInJSON(  List<Player> playerL )
    {
        try (FileWriter file = new FileWriter(".\\json\\file.json")) {
                    
                    //p1 = new Player("Elif", 1);
                    //gson.toJson(playerL, file);
                    String jsonInString = gson.toJson(playerL);
                    file.write(jsonInString);
                    file.close();
              }
        catch ( Exception ex ) {
            System.out.println("Problem!!!");
            throw new RuntimeException(ex);
        }
            
    }
    public  List<Player> getArrayInJSON( )
    {
         //List<Player> playerL = new ArrayList<Player>();
         try (BufferedReader reader = new BufferedReader( new FileReader(".\\json\\file.json"))) {

                // Convert JSON to Java Object
                //Type founderListType = new TypeToken<ArrayList<Player>>(){}.getType();
                String result = reader.readLine();
                if ( result == null )
                    return null;
                else
                {
                    //System.out.println(result);
                    JsonReader reader2 = new JsonReader(new StringReader(result));
                    reader2.setLenient(true);
                    playerL = gson.fromJson(reader2, new TypeToken<List<Player>>(){}.getType());
                    //JsonObject entries = (JsonObject) new JsonParser().parse(result);
                   
                    //JsonArray entries = (JsonArray) new JsonParser().parse(reader2);
                    //JsonObject o1 = (JsonObject)entries.get(0);
                    //playerL = (List<Player>)o1;
                     //System.out.println("Buraya girdi");
                }
          }
            catch (IOException e) {
            e.printStackTrace();
        }
         return playerL;
            
    }
   
    /*public static List<Player> toList(String json) 
    {
    if (null == json) {
        return null;
    }
    Gson gson = new Gson();
    return gson.fromJson(json, new TypeToken<ArrayList<Player>>(){}.getType());
    }*/
}