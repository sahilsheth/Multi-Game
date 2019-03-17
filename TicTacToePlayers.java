/*
 * Tic Tac Toe game that looks for a player that gets 3
 * in a row, col, or diagonal. Game counts and saves the score
 * for any player who wins. 
 */


package myfinal_project;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class TicTacToePlayers extends JPanel {
	//count for each turn
	int count = 0;
	//counter for how many times the players can play
    int numofMoves = 9;
    
    //used to determine how the player can win
    boolean winner = false;
    
    //set size of panel
    final int WIDTH = 500;
    final int HEIGHT = 650;
    
    //label for each player
    JLabel xWinner = new JLabel("Player X ");
    JLabel oWinner = new JLabel("Player O");
    
    //label for score
    JLabel p1Score = new JLabel(" ");
    JLabel p2Score = new JLabel(" ");
    
    //set up board panel
    JPanel board = new JPanel();
    
    //label titled score
    JLabel score = new JLabel("Score");
    
    //buttons that correspond to each panel
    JButton buttonOne = new JButton(" ");
    JButton buttonTwo = new JButton(" ");
    JButton buttonThree = new JButton(" ");
    JButton buttonFour = new JButton(" ");
    JButton buttonFive = new JButton(" ");
    JButton buttonSix = new JButton(" ");
    JButton buttonSeven = new JButton(" ");
    JButton buttonEight = new JButton(" ");
    JButton buttonNine = new JButton(" ");
    
    //1D array that has 9 buttons
    JButton array[] = new JButton[9];
    
    //restart game
    JButton restart = new JButton("Restart"); 
    
    //score counter
    int p1Count = 0;
    int p2Count = 0;
    private Color color1 = Color.ORANGE;
    
    //display which player won or if draw
    JLabel wins = new JLabel();
    
    //Constructor
    public TicTacToePlayers()
    {
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());
        
        //Header
        JPanel header = new JPanel();
        header.setLayout(new BorderLayout());
        header.setBackground(Color.DARK_GRAY);
        
        JPanel headerRow = new JPanel();
        headerRow.setBackground(Color.ORANGE);
        headerRow.setLayout(new GridLayout(1,3));
        
        
        xWinner.setBackground(Color.DARK_GRAY);
        xWinner.setForeground(Color.GREEN.darker());
        xWinner.setHorizontalAlignment(SwingConstants.CENTER);
        xWinner.setFont(new Font("DialogInput", Font.BOLD, 25));
        
        
        oWinner.setBackground(Color.DARK_GRAY);
        oWinner.setForeground(Color.BLUE.darker());
        oWinner.setHorizontalAlignment(SwingConstants.CENTER);
        oWinner.setFont(new Font("DialogInput", Font.PLAIN, 25));
        
        score.setForeground(Color.RED);
        score.setHorizontalAlignment(SwingConstants.CENTER);
        score.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        
        
        headerRow.add(xWinner);
        headerRow.add(score);
        headerRow.add(oWinner);
        
        header.add(headerRow, BorderLayout.CENTER);
                
        //WINS
        JPanel scoreRow = new JPanel();
        scoreRow.setLayout(new GridLayout(1,2));
        
        p1Score.setForeground(Color.ORANGE.darker());
        p1Score.setHorizontalAlignment(SwingConstants.CENTER);
        p1Score.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        
       
        p2Score.setForeground(Color.RED);
        p2Score.setHorizontalAlignment(SwingConstants.CENTER);
        p2Score.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        
        scoreRow.add(p1Score);
        scoreRow.add(p2Score);
        
        header.add(scoreRow, BorderLayout.SOUTH);
       
        
        add(header, BorderLayout.NORTH);
        
       //Bottom
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(2,1));
        
       
        
        
        restart.addActionListener(new Restart());
        restart.setForeground(Color.YELLOW.darker());
        restart.setBorderPainted(false);
        restart.setFocusPainted(false);
        restart.setFont(new Font("Comic Sans", Font.BOLD, 18));
        bottom.add(restart);
        bottom.add(wins);
        
       
   
        JPanel bottomBar = new JPanel();
        bottomBar.setLayout(new BorderLayout());
        bottomBar.add(bottom, BorderLayout.CENTER);
        
        add(bottomBar, BorderLayout.SOUTH);  
        
        //game board set up 3 by 3
        board.setLayout(new GridLayout(3, 3));
		board.setBackground(color1);
		
		
		//get each element of array to be placed in a button
        array[0] = buttonOne;
        array[1] = buttonTwo;
        array[2] = buttonThree;
        array[3] = buttonFour;
        array[4] = buttonFive;
        array[5] = buttonSix;
        array[6] = buttonSeven;
        array[7] = buttonEight;
        array[8] = buttonNine;
        
        //Initialize the action listener and add each button to the main board
        for(JButton button : array)
        {
            button.addActionListener(new Game());
            button.setBackground(Color.DARK_GRAY);
            board.add(button);
        }
        
        add(board, BorderLayout.CENTER);
    }
    
    //Determines if player 1 goes or player 2  
    public class Game implements ActionListener
    {
            @Override public void actionPerformed(ActionEvent e)
            {
                
            	//https://stackoverflow.com/questions/7867834/get-button-name-from-actionlistener
                JButton button = new JButton();
                button = (JButton)e.getSource();
                String command = button.getActionCommand();
                

                //player 1 turn
                if (count%2==0)
                {
                    playerX(button, command);
                }

                //player 2 turn
                else
                {
                    playerO(button, command);
                }

                if (winnerMoves())
                {
                   
                    //end of game and disable board
                    for (JButton button1: array)
                     {
                         button1.setEnabled(false);
                     }
                }

                count++;
        }
    }
    
    
    //player one's turn
    public void playerX(JButton button, String command)
    {
        if (command.equals(" "))
        {
           button.setText("X");
           button.setForeground(Color.GREEN);
           button.setFont(new Font("SANS_SERIF", Font.BOLD, 60));
           numofMoves--;
        }
        
        //allow player one to continue their turn and choose a space that is not occupied by the board 
        else
        {
            count--;
        }
    }
    
    //player two's turn
    public void playerO(JButton button, String block)
    {
        if (block.equals(" "))
        {
            button.setText("O");
            button.setForeground(Color.BLUE);
            button.setFont(new Font("SANS_SERIF", Font.BOLD, 60));
            numofMoves--;
        }
        
         //allow player one to continue their turn and choose a space that is not occupied by the board 
        else
        {
            count--;
        }
    }
    
  //Reset game
    public class Restart implements ActionListener
    {
        @Override public void actionPerformed(ActionEvent e)
        {
            
            for (JButton button : array)
            {
                button.setText(" ");
                button.setEnabled(true);
                button.setBackground(Color.YELLOW);
                wins.setText(" ");
            }
            
          
            numofMoves = 9;
            count = 0;
        }
    }
    
    //checks if there is a winner
    public boolean  winnerMoves()
    {
        
        //Row win
        if (buttonOne.getText().equals(buttonTwo.getText()) && buttonTwo.getText().equals(buttonThree.getText()) 
        		&& !buttonOne.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonOne.getText());
           winner = true;
        }
        
        //Row win
        else if (buttonFour.getText().equals(buttonFive.getText()) && buttonFive.getText().equals(buttonSix.getText()) 
        		&& !buttonFour.getText().equals(" "))
        {
            
           winnerSymbol((String)  buttonFour.getText());
           winner = true;
        }
        
        //Row win
        else if(buttonSeven.getText().equals(buttonEight.getText()) && buttonEight.getText().equals(buttonNine.getText()) 
        		&& !buttonSeven.getText().equals(" "))
        {
            
            winnerSymbol((String) buttonSeven.getText());
           winner = true;
        }
        
        //Column win
        else if (buttonOne.getText().equals(buttonFour.getText()) && buttonFour.getText().equals(buttonSeven.getText()) 
        		&& !buttonOne.getText().equals(" "))
        {
            
            winnerSymbol((String) buttonOne.getText());
            winner = true;
        }
        
        //Column win
        else if (buttonTwo.getText().equals(buttonFive.getText()) && buttonFive.getText().equals(buttonEight.getText()) 
        		&& !buttonTwo.getText().equals(" "))
        {
            
            winnerSymbol((String) buttonTwo.getText());
            winner = true;
        }
        
        //Column win
        else if (buttonThree.getText().equals(buttonSix.getText()) && buttonSix.getText().equals(buttonNine.getText()) 
        		&& !buttonThree.getText().equals(" "))
        {
           
            winnerSymbol((String) buttonThree.getText());
            winner = true;
        }
        
        //Diagonal win
        else if (buttonSeven.getText().equals(buttonFive.getText()) && buttonFive.getText().equals(buttonThree.getText()) 
        		&& !buttonSeven.getText().equals(" "))
        {
            
            winnerSymbol((String) buttonSeven.getText());
            winner = true;
        }
        
        
        //Diagonal win
        else if (buttonNine.getText().equals(buttonFive.getText()) && buttonFive.getText().equals(buttonOne.getText()) 
        		&& !buttonNine.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonNine.getText());
           winner = true;
        }
        
        //Tie scenario
        else if (numofMoves <= 0)
        {
        	winnerSymbol("");
            winner = true;
        }
        
        else
        {
            winner = false;
        }
        
        return winner;
    }
    
    
    
    //if winner is "X" or "O" then add to scoreboard
    public void  winnerSymbol(String symbol)
    {
        if (symbol.equals("X"))
        {
            p1Count++;
            String xScore = Integer.toString(p1Count);
            p1Score.setText( xScore);
            wins.setText("Congratulations Player X won this game");
            wins.setForeground(Color.GREEN);
            wins.setFont(new Font("Lithos Pro Regular", Font.BOLD, 25));
            wins.setHorizontalAlignment(SwingConstants.CENTER);
            JOptionPane.showMessageDialog(null, "Player X wins", "Display Winner", JOptionPane.INFORMATION_MESSAGE);
        }
        
   
        else if (symbol.equals("O"))
        {
            p2Count++;
            String oScore = Integer.toString(p2Count);
            p2Score.setText( oScore);
            wins.setText("Congratulation Player O won this game");
            wins.setForeground(Color.BLUE);
            wins.setFont(new Font("Lithos Pro Regular", Font.BOLD, 25));
            wins.setHorizontalAlignment(SwingConstants.CENTER);
            JOptionPane.showMessageDialog(null, "Player O wins", "Display Winner", JOptionPane.INFORMATION_MESSAGE);
        }
        
        else
        {
        	wins.setText("DRAW");
        	wins.setHorizontalAlignment(SwingConstants.CENTER);
            wins.setForeground(Color.BLUE);
            wins.setFont(new Font("Lithos Pro Regular", Font.BOLD, 25));
            JOptionPane.showMessageDialog(null, "No one wins", "Display Winner", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
   
    

	
}
