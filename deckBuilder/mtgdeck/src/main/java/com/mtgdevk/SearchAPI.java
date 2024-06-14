package com.mtgdevk;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.json.simple.JSONObject;

import io.magicthegathering.javasdk.api.CardAPI;
import io.magicthegathering.javasdk.resource.Card;

public class SearchAPI {
    public static void searchCards(String searchInput) {


        int counter = 0;
        List<Card> cards = new ArrayList<>();
        Card chosenCard;
        String filter;
        int finalChoice;
        cardPrinter printer = new cardPrinter();
        boolean run = true;



        filter = "name=" + searchInput;

            //fetch all cards with the inputted name from the API, catching for errors in doing so
            try{
                cards = CardAPI.getAllCards(List.of(filter));
                } 
            catch(Exception e){
                //program fails to pull from the API somehow
                JOptionPane.showMessageDialog(null, "Sorry, something went wrong");
            }

        //if the name entered doesn't exist
        if (cards.size() == 0){
            JOptionPane.showMessageDialog(null, "0 results found");        
        }
        else{
            counter = 0;

            //print only the top 5 cards found so that the list isn't extremely long
            for(Card c: cards){
                if(counter < 5){
                printer.printCard(c);
                counter++;
                ;
                }
            }
    }
}
}