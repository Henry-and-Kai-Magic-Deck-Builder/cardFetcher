package com.mtgdevk;
import io.magicthegathering.javasdk.resource.Card;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import io.magicthegathering.javasdk.api.*;
import javax.swing.JOptionPane;
import javax.swing.JComponent;


public class Main {
    public static void main(String[] args) {
        int counter = 0;
        List<Card> cards = new ArrayList<>();
        List<Card> deck = new ArrayList<>();
        Card chosenCard;
        String input;
        String filter;
        int i = JOptionPane.YES_NO_OPTION;
        String placeHolder;

        int finalChoice;
        cardPrinter printer = new cardPrinter();
        boolean run = true;
        while(run){
                //take user input to get card name
            input = JOptionPane.showInputDialog("Enter a MTG card name: ");
            filter = "name=" + input;
            //fetch all cards with the inputted name from the API, catching for errors in doing so
            //printerLoop(Cards card){}
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
                //placeHolder = placeHolder +"\n"+printer.printCard(c);
                ;
                }
            }
            //JOptionPane.showMessageDialog(null, "Oh Hello.." +name);
            //user choses which of the top 5 to chose from
            finalChoice = Integer.parseInt(JOptionPane.showInputDialog("Which card would you like? [1-5], [0] to exit"));
            //list selects from 0-4, so 1 is subtracted from the variable
            finalChoice--;
            if(finalChoice == -1){
            }
            else{
                //add the chosen card to a list variable called deck
                chosenCard = cards.get(finalChoice);
                deck.add(chosenCard);
                JOptionPane.showMessageDialog(null, deck);            
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