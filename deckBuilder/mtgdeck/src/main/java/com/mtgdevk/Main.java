package com.mtgdevk;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

import org.json.simple.JSONObject;
import io.magicthegathering.javasdk.api.CardAPI;
import io.magicthegathering.javasdk.resource.Card;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
       
        
        GUI launch = new GUI(1920, 1080);
        launch.setUpGUI();
        launch.setUpButtonListeners();
   
    }
}