package com.mtgdevk;
import io.magicthegathering.javasdk.resource.Card;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import io.magicthegathering.javasdk.api.*;

public class Main {
    public static void main(String[] args) {
        int counter = 0;
        List<Card> cards = new ArrayList<>();
        List<Card> deck = new ArrayList<>();
        Card chosenCard;
        Scanner userInput = new Scanner(System.in); 
        Scanner cardChoice = new Scanner(System.in);
        cardPrinter printer = new cardPrinter();
        boolean run = true;
        int i;
        while(run){
                //take user input to get card name
            System.out.println("Enter a MTG card name: ");
            String filter = "name=" + userInput.next();
            //fetch all cards with the inputted name from the API, catching for errors in doing so
            //printerLoop(Cards card){}
            try{
                cards = CardAPI.getAllCards(List.of(filter));
                } 
            catch(Exception e){
                //program fails to pull from the API somehow
                System.out.println("Sorry, something went wrong.");
                }
        //if the name entered doesn't exist
        if (cards.size() == 0){
            System.out.println("0 results found");
        }
        else{
            counter = 0;
            //print only the top 5 cards found so that the list isn't extremely long
            for(Card c: cards){
                if(counter < 5){
                printer.printCard(c);
                counter++;
                }
            }
            //user choses which of the top 5 to chose from
            System.out.println("Which card would you like in your deck? (1-5, enter 0 to end)");
            int finalChoice = cardChoice.nextInt();
            //list selects from 0-4, so 1 is subtracted from the variable
            finalChoice--;
            if( finalChoice == -1){
            }
            else{
                //add the chosen card to a list variable called deck
                chosenCard = cards.get(finalChoice);
                deck.add(chosenCard);
                System.out.println(deck);
            }
            //allows the user to quit
            System.out.print("Would you like to keep adding to your deck? Yes: [1] No: [2]\n");
            i = userInput.nextInt();
            if (i == 2){
                run = false;
            }
        }
    }
    }
}