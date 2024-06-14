package com.mtgdevk;

import java.lang.StringBuffer;
import io.magicthegathering.javasdk.resource.Card;


//method for returning the image url for a card
public class cardPrinter {
    public static String printCard(Card card){
        
        //get the image url
        String imageURL;
        imageURL = card.getImageUrl();

        //insert an extra s or else link doesn't work
        
        
        if (imageURL != null){
        StringBuffer link = new StringBuffer(imageURL);
        link.insert(4, "s");
        imageURL = link.toString();
        }

        //default image for error handling
        else {
            imageURL = "https://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=461001&type=card";
        }
        return imageURL;
    }
}
