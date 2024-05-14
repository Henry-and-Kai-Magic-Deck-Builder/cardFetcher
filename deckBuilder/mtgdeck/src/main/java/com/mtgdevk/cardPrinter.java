package com.mtgdevk;
import javax.swing.JOptionPane;
import javax.swing.JComponent;

import io.magicthegathering.javasdk.resource.Card;


//method for printing only relevant info of a card
public class cardPrinter {
    public void printCard(Card card){
        //card = CardAPI.getCard(1);
        //print multiverse ID

        String name, manaCost, setName, powerAndToughness, loyalty, text;
        int id;
        id = card.getMultiverseid();
        name = card.getName();
        manaCost = card.getManaCost();
        setName = card.getSetName();
        powerAndToughness =  card.getPower()!=null?(card.getPower() + "/" + card.getToughness()):"";
        loyalty = card.getLoyalty()!=null?("[" + card.getLoyalty() + "]"):"";
        text = card.getText()!=null?("'" + card.getText() + "'\n-------------------------\n" ):"";

        JOptionPane.showMessageDialog(null, "\nMult ID: " + id+"\n"+ 
        name + " / " + manaCost+"\n"+
        setName+"\n"+
        powerAndToughness + "\n"+
        loyalty +"\n"+
        text);
        //print everything

    }
}
