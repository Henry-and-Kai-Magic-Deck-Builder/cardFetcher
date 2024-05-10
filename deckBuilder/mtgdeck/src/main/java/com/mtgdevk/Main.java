package com.mtgdevk;
import io.magicthegathering.javasdk.resource.Card;

import java.util.ArrayList;
import 
java.util.List;
import java.util.Scanner;
import io.magicthegathering.javasdk.api.*;

public class Main {
    public static void main(String[] args) {
        int counter = 0;
        List<Card> cards = new ArrayList<>();
        Scanner userInput = new Scanner(System.in); 
        Scanner cardChoice = new Scanner(System.in);
        cardPrinter printer = new cardPrinter();
        //take user input to get card name
        System.out.println("Enter a MTG card name: ");
        String filter = "name=" + userInput.next();
        //fetch all cards with the inputted name from the API, catching for errors in doing so
        //printerLoop(Cards card){}
        try{
        cards = CardAPI.getAllCards(List.of(filter));
    } 
        catch(Exception e){
        System.out.println("Sorry, something went wrong.");
        }
    if (cards.size() == 0){
        System.out.println("0 results found");
    }
    else{
        counter = 0;
        for(Card c: cards){
            if(counter < 5){
            printer.printCard(c);
            counter++;
            }
        }
    }
    System.out.println("Which card would you like in your deck? (1-5, enter 0 to end)");
    int finalChoice = Integer.valueOf(cardChoice.next());
    finalChoice--;
    if( finalChoice == 0){
    }
    else{
        System.out.println(cards.get(finalChoice));
    }
    }
}
