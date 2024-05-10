package com.mtgdevk;
import io.magicthegathering.javasdk.resource.Card;


//method for printing only relevant info of a card
public class cardPrinter {
    public void printCard(Card card){
        //card = CardAPI.getCard(1);
        //print multiverse ID
        System.out.println("\nMult ID: " + card.getMultiverseid());
        //print name and mana cost
        System.out.println(card.getName() + " / " + card.getManaCost());
        //print set
        System.out.println(card.getSetName());
        //if it's a creature, print power and toughness
        System.out.println(card.getPower()!=null?(card.getPower() + "/" + card.getToughness()):"");
        //if it's a planeswalker, print loyalty
        System.out.println(card.getLoyalty()!=null?("[" + card.getLoyalty() + "]"):"");
        //print text if it has any
        System.out.print(card.getText()!=null?("'" + card.getText() + "'\n-------------------------\n" ):"");
    }
}
