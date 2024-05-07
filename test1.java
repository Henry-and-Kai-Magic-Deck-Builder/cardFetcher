import java.io.FileReader;
import java.net.HttpURLConnection;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;
public class test1{
    public static void main(String[] args){
        Scanner io = new Scanner(System.in);  
        System.out.println("Enter card name");
        String card = io.nextLine();

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("C:/Users/kglai/OneDrive/Documents/GitHub/cardFetcher/cards.json")); //C:\Users\kglai\OneDrive\Documents\GitHub\cardFetcher\cards.json
            JSONObject jsonObject = (JSONObject)obj;
            String name = (String)jsonObject.get("name");
            //String manaCost = (String)jsonObject.get("manaCost");
            //JSONArray cardType = (JSONArray)jsonObject.get("type");
            System.out.println("Name: " + name);
            //System.out.println("Mana Cost: " + manaCost);
            //System.out.println("Subjects:");
            //Iterator iterator = subjects.iterator();
            //while (iterator.hasNext()) {
            //    System.out.println(iterator.next());
            //}
        } catch(Exception e) {
            e.printStackTrace();
        }

        

    }
}
