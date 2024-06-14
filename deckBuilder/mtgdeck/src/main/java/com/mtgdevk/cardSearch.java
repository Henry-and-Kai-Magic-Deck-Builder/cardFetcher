package com.mtgdevk;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.json.simple.JSONObject;

import io.magicthegathering.javasdk.api.CardAPI;
import io.magicthegathering.javasdk.resource.Card;

public class cardSearch {
    void search() {
        int counter = 0;
        List<Card> cards = new ArrayList<>();
        Card chosenCard;
        String input;
        String filter;
        int i = JOptionPane.YES_NO_OPTION;

        JSONObject jsonDeck = new JSONObject();

        int finalChoice;
        cardPrinter printer = new cardPrinter();
        boolean run = true;
        while(run){

                //take user input to get card name
            input = JOptionPane.showInputDialog("Enter a MTG card name: ");
            filter = "name=" + input;

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

            //user choses which of the top 5 to chose from
            finalChoice = Integer.parseInt(JOptionPane.showInputDialog("Which card would you like? [1-5], [0] for none of them."));

            //list selects from 0-4, so 1 is subtracted from the variable
            finalChoice--;
            if(finalChoice == -1){
                if (JOptionPane.showConfirmDialog(null, "Would you like to keep adding to your deck?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            // yes option
            } else {

            // no option
                run = false;
            }
            }
            else{

                //make the user's choice a variable
                chosenCard = cards.get(finalChoice);

                //write the card data onto a json file in the foundryDeckData folder using the saveCard method
                jsonDeck.put(chosenCard.getMultiverseid(), deckSaver.saveCard(chosenCard));

                //save the JSON file into the foundryDeckData folder
                try {
                    FileWriter FileWriter = new FileWriter("deckBuilder\\foundryDeckData\\deck.json");
                    FileWriter.write(jsonDeck.toJSONString());
                    FileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try{
                    FileReader fileReader = new FileReader("deckBuilder\\foundryDeckData\\deck.json");
                }
            catch (IOException e) {
                e.printStackTrace();
            }

            //allows the user to quit
            if (JOptionPane.showConfirmDialog(null, "Would you like to keep adding to your deck?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            // yes option
            } else {

            // no option
                run = false;
            }
        }
    }
    }
    }
}
