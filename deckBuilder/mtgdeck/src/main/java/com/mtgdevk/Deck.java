package com.mtgdevk;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.*;

import io.magicthegathering.javasdk.resource.Card;

import java.nio.file.*;

    public class Deck {
        private JSONArray deck;

        public Deck() {
            deck = new JSONArray();
        }

        public Deck(JSONArray j) {
            deck = j;
        }

        public JSONArray getDeck() {
            return deck;
        }

        public void setDeck(JSONArray a) {
            deck = a;
        }

        //TODO method that returns a card from a deck based on multID
        /*public Card findCard(String b){
                JSONObject obj = new JSONObject();
                for (int i = 0; i < deck.size(); i++)
                {
                JSONObject card = deck.getJsonObject(b);
                }
        }*/

        public void addCard(Card c) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put(c.getMultiverseid(), deckSaver.saveCard(c));
            deck.add(jsonObj);
        }

        public void removeCard(int i) {
            //make it so its 0 based indexing
            i = i - 1;
            if (i <= getDeck().size()|| i < 0) {
                deck.remove(i);
            } else {
                System.out.println("That is out of index! wahhhh *explodes*");
            }
        }

        public void removeCard(String name) {
            //TODO removeCard by name
        }

        public static Deck loadFromFile() {
            Path path = Paths.get("deckBuilder\\foundryDeckData\\deck.json");

            if (Files.exists(path)) {
                JSONParser parser = new JSONParser();
                JSONArray a = new JSONArray();
                try {
                    a = (JSONArray) parser.parse(new FileReader("deckBuilder\\foundryDeckData\\deck.json"));
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
                Deck loadedDeck = new Deck(a);
                return loadedDeck;
            }
            else{
                Deck loadedDeck = new Deck();
                return loadedDeck;
            }
        }
    

    public void writeToFile() {
        JSONArray deck = getDeck();
        //JSONArray jsonDeck = new JSONArray(deck);
            try {
                FileWriter FileWriter = new FileWriter("deckBuilder\\foundryDeckData\\deck.json");
                FileWriter.write(deck.toJSONString());
                FileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
    }
    



    
    
