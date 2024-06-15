package com.mtgdevk;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import io.magicthegathering.javasdk.api.CardAPI;
import io.magicthegathering.javasdk.resource.Card;

public class SearchAPI {
    public static List<Card> searchCards(String searchInput) {

        List<Card> cards = new ArrayList<>();
        String filter;
        filter = "name=" + searchInput;

            //fetch all cards with the inputted name from the API, catching for errors in doing so
            try{
                cards = CardAPI.getAllCards(List.of(filter));
                } 
            catch(Exception e){
                //program fails to pull from the API somehow
                JOptionPane.showMessageDialog(null, "Sorry, something went wrong");
            }
    return cards;
}
}