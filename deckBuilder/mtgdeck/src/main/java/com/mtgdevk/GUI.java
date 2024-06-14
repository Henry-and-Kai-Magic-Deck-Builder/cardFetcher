package com.mtgdevk;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.io.*; 
import java.net.MalformedURLException; 
import java.net.URL; 
import javax.imageio.ImageIO;

import io.magicthegathering.javasdk.resource.Card;

import java.awt.FlowLayout;
import java.awt.Container;
//TODO stop program from breaking when API returns less than 5 cards
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
                    String searchText = input.getText();
                    cards = SearchAPI.searchCards(searchText);
                    label.setText(searchText);
                    try {
						URL url1 = new URL(cardPrinter.printCard(cards.get(0)));
                        getImage1 = ImageIO.read(url1);
                    } catch (IOException e) {
        	            e.printStackTrace();
                    }

                    try {
						URL url2 = new URL(cardPrinter.printCard(cards.get(1)));
                        getImage2 = ImageIO.read(url2);
                    } catch (IOException e) {
        	            e.printStackTrace();
                    }
                    try {
						URL url3 = new URL(cardPrinter.printCard(cards.get(2)));
                        getImage3 = ImageIO.read(url3);
                    } catch (IOException e) {
        	            e.printStackTrace();
                    }
                    try {
						URL url4 = new URL(cardPrinter.printCard(cards.get(3)));
                        getImage4 = ImageIO.read(url4);
                    } catch (IOException e) {
        	            e.printStackTrace();
                    }
                    try {
						URL url5 = new URL(cardPrinter.printCard(cards.get(4)));
                        getImage5 = ImageIO.read(url5);
                    } catch (IOException e) {
        	            e.printStackTrace();
                    }
                    System.out.println(cardPrinter.printCard(cards.get(0)));
                    System.out.println(cardPrinter.printCard(cards.get(1)));
                    System.out.println(cardPrinter.printCard(cards.get(2)));
                    System.out.println(cardPrinter.printCard(cards.get(3)));
                    System.out.println(cardPrinter.printCard(cards.get(4)));

                    ImageIcon image1 = new ImageIcon(getImage1);
                    ImageIcon image2 = new ImageIcon(getImage2);
                    ImageIcon image3 = new ImageIcon(getImage3);
                    ImageIcon image4 = new ImageIcon(getImage4);
                    ImageIcon image5 = new ImageIcon(getImage5);



                    choice1Label.setIcon(image1);
                    choice2Label.setIcon(image2);
                    choice3Label.setIcon(image3);
                    choice4Label.setIcon(image4);
                    choice5Label.setIcon(image5);


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





    /* 
    class MyActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            System.out.println("The button has been clicked");
            search.search();
        }
    }
        */
}
