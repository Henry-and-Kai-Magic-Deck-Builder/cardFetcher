package com.mtgdevk;

import java.lang.StringBuffer;
import io.magicthegathering.javasdk.resource.Card;


//method for returning the image url for a card
public class cardPrinter {
    public static String printCard(Card card){
        
        //get the image url
        String imageURL;
        imageURL = card.getImageUrl();

        if (imageURL != null){
        StringBuffer link = new StringBuffer(imageURL);

        //magicgatherer gives links beginning with "http" rather than "https" for some reason so this just manually adds the s
        link.insert(4, "s");
        imageURL = link.toString();
        }

        //default image for error handling
        else {
            imageURL = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgHlb8NnIZVSqt8MowKOhVcdOJr_keedz_FZeMdko1xlkM55pkAQII14nMmODw1UkjDmdjFq99QNZbJlRNVpA09MhM-n_E3CHz3cJSB5Y-wceDdtyJ-iKbBqZyqCzXF8H9myWScz5Wk2gNA5FsfOgBEVAQl7IpvAJe43pRmCUx7jp7jiQ1FNk1mpBAM3-fG/s320/no%20image%20found.jpg";
        }
        return imageURL;
    }
}
