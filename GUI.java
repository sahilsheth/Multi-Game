//Sahil Sheth
//CPSC 223J-01 
//Final Project
/*
 * Program designed to have 3 games to be able to played. The
 * three games are Tic Tac Toe, Connect 4, and a Whack a Mole 
 * type of game. Using the tabbedpane to create tabs where the 
 * user can go any tab to play the game they desired.
 */

package myfinal_project;

import java.awt.*;
import javax.swing.*;



public class GUI extends JFrame {

	static final int WIDTH = 800;
	static final int HEIGHT = 950;
	
	public GUI()
	{
		//title of the tabbed pane
        super("Game");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground(Color.GRAY);
        
        //create the tabbed pane
        JTabbedPane tab = new JTabbedPane();
        tab.setBackground(Color.LIGHT_GRAY);
        tab.setForeground(Color.WHITE);
        
        //new panels that uses cardlayout
        JPanel ticTac = new JPanel();
        ticTac.setLayout(new CardLayout());
        
        JPanel connectFour = new JPanel();
        connectFour.setLayout(new CardLayout());
        
        JPanel catchGame = new JPanel();
        catchGame.setLayout(new CardLayout());
        
        
        //naming each tab
        tab.add("Tic Tac Toe", ticTac);
        tab.addTab("Connect 4", connectFour);
        tab.addTab("Catch", catchGame);
        
        
        //referring to each class file to do its own function when
        //tab is clicked upon
        JPanel three = new TicTacToePlayers();
        ticTac.add(three);
        
        JPanel four = new Connect4();
        connectFour.add(four);
        
        JPanel cat = new CatchGame();
        catchGame.add(cat);
        
        //add the tabbed pane in center
        add(tab, BorderLayout.CENTER);
        
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI game = new GUI();
		game.setVisible(true);
		

	}

}
