package com.mtgdevk;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
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
    JLabel label;
    JTextField input;

    public GUI(int w, int h){
        frame = new JFrame();
        label = new JLabel("");
        input = new JTextField(10);
        button1 = new JButton("Search");
        button2 = new JButton("Button 2");
        width = w;
        height = h;
    }

    public void setUpGUI(){
        Container cp = frame.getContentPane();
        FlowLayout flow = new FlowLayout();
        cp.setLayout(flow);
        frame.setSize(width, height);
        frame.setTitle("Foundry");
        cp.add(input);
        cp.add(button1);
        cp.add(button2);
        cp.add(label);


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
                    label.setText(searchText);
                    SearchAPI.searchCards(searchText);
                } else if (buttonClicked == button2){
                    System.out.println("boop haha");
                }
                
            }
            
        };

        button1.addActionListener(buttonListener);
        button2.addActionListener(buttonListener);
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
