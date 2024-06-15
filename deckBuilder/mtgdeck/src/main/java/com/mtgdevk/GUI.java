package com.mtgdevk;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.io.*; 
import java.net.URL; 
import javax.imageio.ImageIO;

import io.magicthegathering.javasdk.resource.Card;

import java.awt.FlowLayout;
import java.awt.Container;

public class GUI {
    //cardSearch search = new cardSearch();
    SearchAPI search = new SearchAPI();
    JFrame frame;
    int width;
    int height;
    JButton button1;
    JButton button2;
    JButton choice1Button, choice2Button, choice3Button, choice4Button, choice5Button;
    JLabel label, choice1Label, choice2Label, choice3Label, choice4Label, choice5Label;
    JTextField input;
    //JTextArea ;
    List<Card> cards;
    Deck deck = new Deck();

    Image defaultImage = null;
    Image getImage1 = null;
    Image getImage2 = null;
    Image getImage3 = null;
    Image getImage4 = null;
    Image getImage5 = null;

    
    






    public GUI(int w, int h){
        
        
        frame = new JFrame();
        label = new JLabel("");
        input = new JTextField(10);
        button1 = new JButton("Search");
        button2 = new JButton("Button 2");
        choice1Button = new JButton("1");
        choice1Label = new JLabel(new ImageIcon(""));
        choice2Button = new JButton("2");
        choice2Label = new JLabel(new ImageIcon(""));
        choice3Button = new JButton("3");
        choice3Label = new JLabel(new ImageIcon(""));
        choice4Button = new JButton("4");
        choice4Label = new JLabel(new ImageIcon(""));
        choice5Button = new JButton("5");
        choice5Label = new JLabel(new ImageIcon(""));

        width = w;
        height = h;
    }

    public void setUpGUI(){
        Container cp = frame.getContentPane();
        GridLayout grid = new GridLayout(10, 10);
        FlowLayout flow = new FlowLayout();
        cp.setLayout(flow);

        frame.setSize(width, height);
        frame.setTitle("Foundry");
        cp.add(input);
        cp.add(button1);
        cp.add(choice1Button);
        cp.add(choice1Label);
        cp.add(choice2Button);
        cp.add(choice2Label);
        cp.add(choice3Button);
        cp.add(choice3Label);
        cp.add(choice4Button);
        cp.add(choice4Label);
        cp.add(choice5Button);
        cp.add(choice5Label);
        //cp.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setUpButtonListeners(){
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                Object buttonClicked = ae.getSource();
                
                if (buttonClicked == button1){

                    //innitialize variables
                    List<BufferedImage> images = new ArrayList();
                    List<ImageIcon> imageIcons = new ArrayList();

                    int a = 0;
                    String searchText = input.getText();

                    cards = SearchAPI.searchCards(searchText);
                    label.setText(searchText);

                    //add the image urls to the images list for as long as the program has cards left to add or when it's added 5 cards
                    while((a) < cards.size() && a < 5) {
                        try {
                            URL url1 = new URL(cardPrinter.printCard(cards.get(a)));
                            images.add(ImageIO.read(url1));
                            a++;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    //if the images list has less than 5 images in it, fill the difference with "no result found" messaages
                    while (a < 5){
                        try {
                            URL url1 = new URL("https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEikBmWDCkpy33Qkb-HlcYEtELaLfyqmITdki9-Av0PQArqibdm2UyWX0_3rdI5QAgOBLloClYsqzLkbPLEBFYW-8x2S9f3k-aFIISKd3AsoovciBUT2m7PKCMLVKaVylYStHjtt6mQz_xw0J-mYeeRU9SFtog18a4oHZX2sItYiql4aieWsw6zJSsqAdzVk/s320/no%20result%20found.jpg");
                            images.add(ImageIO.read(url1));
                            a++;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    //turn the images urls into imageicons and add them to the imageicons list
                    a = 0;
                    while(a < images.size()){
                    imageIcons.add(new ImageIcon(images.get(a)));
                    a++;
                    }
                    
                    //set the choice labels to the imagesicons from imageIcons
                        choice1Label.setIcon(imageIcons.get(0));
    
                        choice2Label.setIcon(imageIcons.get(1));

                        choice3Label.setIcon(imageIcons.get(2));

                        choice4Label.setIcon(imageIcons.get(3));

                        choice5Label.setIcon(imageIcons.get(4));

                    


                }else if (buttonClicked == choice1Button){
                    deck = Deck.loadFromFile();
                    deck.addCard(cards.get(0));
                    deck.writeToFile();
                }else if (buttonClicked == choice2Button){
                    deck = Deck.loadFromFile();
                    deck.addCard(cards.get(1));
                    deck.writeToFile();
                }else if (buttonClicked == choice3Button){
                    deck = Deck.loadFromFile();
                    deck.addCard(cards.get(2));
                    deck.writeToFile();
                }
                else if (buttonClicked == choice4Button){
                    deck = Deck.loadFromFile();
                    deck.addCard(cards.get(3));
                    deck.writeToFile();
                }else if (buttonClicked == choice5Button){
                    deck = Deck.loadFromFile();
                    deck.addCard(cards.get(4));
                    deck.writeToFile();
                }
                
            }
            
        };

        button1.addActionListener(buttonListener);
        button2.addActionListener(buttonListener);
        choice1Button.addActionListener(buttonListener);
        choice2Button.addActionListener(buttonListener);
        choice3Button.addActionListener(buttonListener);
        choice4Button.addActionListener(buttonListener);
        choice5Button.addActionListener(buttonListener);
    }
}




    /* 
    class MyActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            System.out.println("The button has been clicked");
            search.search();
        }
    }
        */

