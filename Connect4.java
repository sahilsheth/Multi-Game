/*
 * Connect 4 is similar to the Tic Tac Toe Player file, instead now
 * the player must get 4 in a row, col, or diagonal to win. Like 
 * Tic Tac Toe Player, the score is saved
 */

package myfinal_project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class Connect4 extends JPanel{
	//count for each turn
	int counts = 0;
	//counter for how many times the players can play
    int countingGame = 25;
    
    //used to determine how the player can win
    boolean winner = false;
    
    //set size of the panel
    final int WIDTH = 500;
    final int HEIGHT = 650;
    
    //labels for the name of the players
    JLabel xWinner = new JLabel("X Player");
    JLabel oWinner = new JLabel("O Player");
    
    //labels to display score
    JLabel p1Score =  new JLabel(" ");
    JLabel p2Score = new JLabel(" ");
    
    //panel to set up the board
    JPanel board = new JPanel();
    
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
    JButton buttonTen  = new JButton(" ");
    JButton buttonEleven  = new JButton(" ");
    JButton buttonTwelve  = new JButton(" ");
    JButton buttonThirteen  = new JButton(" ");
    JButton buttonFourteen  = new JButton(" ");
    JButton buttonFifteen  = new JButton(" ");
    JButton buttonSixteen  = new JButton(" ");
    JButton buttonSeventeen  = new JButton(" ");
    JButton buttonEighteen  = new JButton(" ");
    JButton buttonNineteen  = new JButton(" ");
    JButton buttonTwenty  = new JButton(" ");
    JButton buttonTwentyOne = new JButton(" ");
    JButton buttonTwentyTwo = new JButton(" ");
    JButton buttonTwentyThree = new JButton(" ");
    JButton buttonTwentyFour = new JButton(" ");
    JButton buttonTwentyFive = new JButton(" ");
    
    //label that is titled score
    JLabel score = new JLabel("Score");
    
    //determine which player won or to display draw
    JLabel wins = new JLabel();
    
    //1D array that has 25 buttons
    JButton array[] = new JButton[25];
    
    //restart the game
    JButton restart;
    
    //score for player 1 and player 2
    int p1Count = 0;
    int p2Count = 0;
    
    //Constructor
    public Connect4()
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
        xWinner.setForeground(Color.GREEN);
        xWinner.setHorizontalAlignment(SwingConstants.CENTER);
        xWinner.setFont(new Font("DialogInput", Font.BOLD, 25));
        
      
        oWinner.setBackground(Color.DARK_GRAY);
        oWinner.setForeground(Color.BLUE);
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
        scoreRow.setBackground(Color.DARK_GRAY);
        scoreRow.setLayout(new GridLayout(1,2));
        
        
        p1Score.setBackground(Color.DARK_GRAY);
        p1Score.setForeground(Color.WHITE);
        p1Score.setHorizontalAlignment(SwingConstants.CENTER);
        p1Score.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        
        
        p2Score.setBackground(Color.DARK_GRAY);
        p2Score.setForeground(Color.WHITE);
        p2Score.setHorizontalAlignment(SwingConstants.CENTER);
        p2Score.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        
       
        scoreRow.add(p1Score);
        scoreRow.add(p2Score);
        
        header.add(scoreRow, BorderLayout.SOUTH);
       
        
        add(header, BorderLayout.NORTH);
        
       //Bottom
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(2,1));
        
        restart = new JButton("Restart"); 
        restart.addActionListener(new Restarting());
        restart.setForeground(Color.GREEN.darker());
        restart.setBorderPainted(false);
        restart.setFocusPainted(false);
        restart.setFont(new Font("Comic Sans", Font.BOLD, 18));
        bottom.add(restart);
        bottom.add(wins);
       
   
        JPanel bottomBar = new JPanel();
        bottomBar.setLayout(new BorderLayout());
        bottomBar.setBackground(Color.DARK_GRAY);
        bottomBar.add(bottom, BorderLayout.CENTER);
      
        
        add(bottomBar, BorderLayout.SOUTH);  
    	
        //set up board to be 5 by 5
        board.setLayout(new GridLayout(5, 5));
        board.setBackground(Color.GREEN.BLUE);
        
        
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
        array[9] = buttonTen;
        array[10] = buttonEleven;
        array[11] = buttonTwelve;
        array[12] = buttonThirteen;
        array[13] = buttonFourteen;
        array[14] = buttonFifteen;
        array[15] = buttonSixteen;
        array[16] = buttonSeventeen;
        array[17] = buttonEighteen;
        array[18] = buttonNineteen;
        array[19] = buttonTwenty;
        array[20] = buttonTwentyOne;
        array[21] = buttonTwentyTwo;
        array[22] = buttonTwentyThree;
        array[23] = buttonTwentyFour;
        array[24] = buttonTwentyFive;
        
        
      //Initialize the action listener and add each button to the main board
        for(JButton button : array)
        {
            button.addActionListener(new Connect4Game());
            button.setBackground(Color.DARK_GRAY);
            board.add(button);
        }
        
        add(board, BorderLayout.CENTER);
    }
    
    //Determines if player 1 goes or player 2  
    public class Connect4Game implements ActionListener
    {
            @Override public void actionPerformed(ActionEvent e)
            {
                
            	//https://stackoverflow.com/questions/7867834/get-button-name-from-actionlistener
                JButton button = new JButton();
                button = (JButton)e.getSource();
                String command = button.getActionCommand();
                

                //player 1 turn
                if (counts%2==0)
                {
                    xPlayer(button, command);
                }

                //player 2 turn
                else
                {
                    oPlayer(button, command);
                }

                if (winnerMoves())
                {
                    
                    //end of game and disable board
                    for (JButton button1: array)
                     {
                         button1.setEnabled(false);
                     }
                }

                counts++;
        }
    }
    
    
    //player one's turn
    public void xPlayer(JButton button, String block)
    {
        if (block.equals(" "))
        {
           button.setText("X");
           button.setForeground(Color.GREEN);
           button.setFont(new Font("SANS_SERIF", Font.BOLD, 60));
           countingGame--;
        }
        
        //allow player one to continue their turn and choose a space that is not occupied by the board 
        else
        {
            counts--;
        }
    }
    
    //player two's turn
    public void oPlayer(JButton button, String block)
    {
        if (block.equals(" "))
        {
            button.setText("O");
            button.setForeground(Color.BLUE);
            button.setFont(new Font("SANS_SERIF", Font.BOLD, 60));
            countingGame--;
        }
        
         //allow player one to continue their turn and choose a space that is not occupied by the board
        else
        {
            counts--;
        }
    }
    
    //Reset game
    public class Restarting implements ActionListener
    {
        @Override public void actionPerformed(ActionEvent e)
        {
            
            for (JButton button : array)
            {
                button.setText(" ");
                button.setEnabled(true);
                button.setBackground(Color.YELLOW.darker());
                wins.setText(" ");
            }
            
            
            countingGame = 25;
            counts = 0;
        }
    }
    
    //checks if there is a winner
    public boolean  winnerMoves()
    {
        
        //Row win
        if (buttonOne.getText().equals(buttonTwo.getText()) && buttonTwo.getText().equals(buttonThree.getText()) 
        		&& buttonThree.getText().equals(buttonFour.getText()) && !buttonOne.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonOne.getText());
           winner = true;
        }
        
        else if (buttonTwo.getText().equals(buttonThree.getText()) && buttonThree.getText().equals(buttonFour.getText()) 
        		&& buttonFour.getText().equals(buttonFive.getText()) && !buttonTwo.getText().equals(" "))
        {
            
            winnerSymbol((String) buttonTwo.getText());
            winner = true;
        }
        
        else if (buttonSix.getText().equals(buttonSeven.getText()) && buttonSeven.getText().equals(buttonEight.getText()) 
        		&& buttonEight.getText().equals(buttonNine.getText()) && !buttonSix.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonSix.getText());
           winner = true;
        }
        
        else if (buttonSeven.getText().equals(buttonEight.getText()) && buttonEight.getText().equals(buttonNine.getText()) 
        		&& buttonNine.getText().equals(buttonTen.getText()) && !buttonSeven.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonSeven.getText());
           winner = true;
        }
        
        
        else if (buttonEleven.getText().equals(buttonTwelve.getText()) && buttonTwelve.getText().equals(buttonThirteen.getText()) 
        		&& buttonThirteen.getText().equals(buttonFourteen.getText()) && !buttonEleven.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonEleven.getText());
           winner = true;
        }
        
        else if (buttonTwelve.getText().equals(buttonThirteen.getText()) && buttonThirteen.getText().equals(buttonFourteen.getText()) 
        		&& buttonFourteen.getText().equals(buttonFifteen.getText()) && !buttonTwelve.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonTwelve.getText());
           winner = true;
        }
        
        else if (buttonSixteen.getText().equals(buttonSeventeen.getText()) && buttonSeventeen.getText().equals(buttonEighteen.getText()) 
        		&& buttonEighteen.getText().equals(buttonNineteen.getText()) && !buttonSixteen.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonSixteen.getText());
           winner = true;
        }
        
        else if (buttonSeventeen.getText().equals(buttonEighteen.getText()) && buttonEighteen.getText().equals(buttonNineteen.getText()) 
        		&& buttonNineteen.getText().equals(buttonTwenty.getText()) && !buttonSeventeen.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonSeventeen.getText());
           winner = true;
        }
        
        
        else if (buttonTwentyOne.getText().equals(buttonTwentyTwo.getText()) && buttonTwentyTwo.getText().equals(buttonTwentyThree.getText()) 
        		&& buttonTwentyThree.getText().equals(buttonTwentyFour.getText()) && !buttonTwentyOne.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonTwentyOne.getText());
           winner = true;
        }
        
        else if (buttonTwentyTwo.getText().equals(buttonTwentyThree.getText()) && buttonTwentyThree.getText().equals(buttonTwentyFour.getText()) 
        		&& buttonTwentyFour.getText().equals(buttonTwentyFive.getText()) && !buttonTwentyTwo.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonTwentyTwo.getText());
           winner = true;
        }
        
       
        //Column win
        
        
        else if (buttonOne.getText().equals(buttonSix.getText()) && buttonSix.getText().equals(buttonEleven.getText()) 
        		&& buttonEleven.getText().equals(buttonSixteen.getText()) && !buttonOne.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonOne.getText());
           winner = true;
        }
        
        else if (buttonTwo.getText().equals(buttonSeven.getText()) && buttonSeven.getText().equals(buttonTwelve.getText()) 
        		&& buttonTwelve.getText().equals(buttonSeventeen.getText()) && !buttonTwo.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonTwo.getText());
           winner = true;
        }
        
        else if (buttonThree.getText().equals(buttonEight.getText()) && buttonEight.getText().equals(buttonThirteen.getText()) 
        		&& buttonThirteen.getText().equals(buttonEighteen.getText()) && !buttonThree.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonThree.getText());
           winner = true;
        }
        
        else if (buttonFour.getText().equals(buttonNine.getText()) && buttonNine.getText().equals(buttonFourteen.getText()) 
        		&& buttonFourteen.getText().equals(buttonNineteen.getText()) && !buttonFour.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonFour.getText());
           winner = true;
        }
        
        else if (buttonFive.getText().equals(buttonTen.getText()) && buttonTen.getText().equals(buttonFifteen.getText()) 
        		&& buttonFifteen.getText().equals(buttonTwenty.getText()) && !buttonFive.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonFive.getText());
           winner = true;
        }
        
        else if (buttonSix.getText().equals(buttonEleven.getText()) && buttonEleven.getText().equals(buttonSixteen.getText()) 
        		&& buttonSixteen.getText().equals(buttonTwentyOne.getText()) && !buttonSix.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonSix.getText());
           winner = true;
        }
        
        else if (buttonSeven.getText().equals(buttonTwelve.getText()) && buttonTwelve.getText().equals(buttonSeventeen.getText()) 
        		&& buttonSeventeen.getText().equals(buttonTwentyTwo.getText()) && !buttonSeven.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonSeven.getText());
           winner = true;
        }
        
        else if (buttonEight.getText().equals(buttonThirteen.getText()) && buttonThirteen.getText().equals(buttonEighteen.getText()) 
        		&& buttonEighteen.getText().equals(buttonTwentyThree.getText()) && !buttonEight.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonEight.getText());
           winner = true;
        }
        
        else if (buttonNine.getText().equals(buttonFourteen.getText()) && buttonFourteen.getText().equals(buttonNineteen.getText()) 
        		&& buttonNineteen.getText().equals(buttonTwentyFour.getText()) && !buttonNine.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonNine.getText());
           winner = true;
        }
        
        else if (buttonTen.getText().equals(buttonFifteen.getText()) && buttonFifteen.getText().equals(buttonTwenty.getText()) 
        		&& buttonTwenty.getText().equals(buttonTwentyFive.getText()) && !buttonTen.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonTen.getText());
           winner = true;
        }
        
      
        //diagonal wins
        else if (buttonSix.getText().equals(buttonTwelve.getText()) && buttonTwelve.getText().equals(buttonEighteen.getText()) 
        		&& buttonEighteen.getText().equals(buttonTwentyFour.getText()) && !buttonSix.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonSix.getText());
           winner = true;
        }
        
        else if (buttonOne.getText().equals(buttonSeven.getText()) && buttonSeven.getText().equals(buttonThirteen.getText()) 
        		&& buttonThirteen.getText().equals(buttonNineteen.getText()) && !buttonOne.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonOne.getText());
           winner = true;
        }
        
        else if (buttonSeven.getText().equals(buttonThirteen.getText()) && buttonThirteen.getText().equals(buttonNineteen.getText()) 
        		&& buttonNineteen.getText().equals(buttonTwentyFive.getText()) && !buttonSeven.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonSeven.getText());
           winner = true;
        }
        
        else if (buttonTwo.getText().equals(buttonEight.getText()) && buttonEight.getText().equals(buttonFourteen.getText()) 
        		&& buttonFourteen.getText().equals(buttonTwenty.getText()) && !buttonTwo.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonTwo.getText());
           winner = true;
        }
        
        else if (buttonFour.getText().equals(buttonEight.getText()) && buttonEight.getText().equals(buttonTwelve.getText()) 
        		&& buttonTwelve.getText().equals(buttonSixteen.getText()) && !buttonFour.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonFour.getText());
           winner = true;
        }
        
        else if (buttonFive.getText().equals(buttonNine.getText()) && buttonNine.getText().equals(buttonThirteen.getText()) 
        		&& buttonThirteen.getText().equals(buttonSeventeen.getText()) && !buttonFive.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonFive.getText());
           winner = true;
        }
        
        else if (buttonNine.getText().equals(buttonThirteen.getText()) && buttonThirteen.getText().equals(buttonSeventeen.getText()) 
        		&& buttonSeventeen.getText().equals(buttonTwentyOne.getText()) && !buttonNine.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonNine.getText());
           winner = true;
        }
        
        else if (buttonTen.getText().equals(buttonFourteen.getText()) && buttonFourteen.getText().equals(buttonEighteen.getText()) 
        		&& buttonEighteen.getText().equals(buttonTwentyTwo.getText()) && !buttonTen.getText().equals(" "))
        {
            
           winnerSymbol((String) buttonTen.getText());
           winner = true;
        }
        
        
     
        //Tie scenario
        else if (countingGame <= 0)
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
            wins.setText("Congratulations X Player won this game");
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
            wins.setText("Congratulation O Player won this game");
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
            wins.setHorizontalAlignment(SwingConstants.CENTER);
            JOptionPane.showMessageDialog(null, "No one wins", "Display Winner", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    

}
