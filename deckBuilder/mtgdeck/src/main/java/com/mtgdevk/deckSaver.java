package com.mtgdevk;
import javax.swing.JOptionPane;

import org.json.simple.JSONObject;

import io.magicthegathering.javasdk.resource.Card;

public class deckSaver {
    public static JSONObject saveCard(Card card){
        JSONObject currentCard = new JSONObject();
        
        currentCard.put("MultID", card.getMultiverseid());
        currentCard.put("Name", card.getName());
        currentCard.put("Mana Cost", card.getManaCost());
        currentCard.put("Set", card.getSetName());
                if (card.getToughness() != null){
                    currentCard.put("Power/Toughness", card.getPower() + "/" + card.getToughness());
                }
                if (card.getLoyalty() != null){
                    currentCard.put("Loyalty", card.getLoyalty());
                }
                currentCard.put("Text", card.getText()); 
                return currentCard;           
    }

    }

