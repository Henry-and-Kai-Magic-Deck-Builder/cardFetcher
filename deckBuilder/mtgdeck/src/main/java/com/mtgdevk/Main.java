package com.mtgdevk;
import io.magicthegathering.javasdk.resource.Card;

import java.util.List;

import io.magicthegathering.javasdk.api.*;

public class Main {
    public static void main(String[] args) {
        int multiverseId = 1;
        Card card = CardAPI.getCard(multiverseId);
        System.out.println(card.getImageUrl());
    
    }
}