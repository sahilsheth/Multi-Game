/*
 * This game functions like whack a mole where the player is trying
 * to hit the item and avoid hitting the wrong things. 
 */

package myfinal_project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class CatchGame extends JPanel implements ActionListener{
	
	//intended to be objects that are to block the item to catch
	final String obstacles = "1";
	
	//catch item
    final String catchItem = "O";

    //round increases each time
    int roundCounter = 0;
    
    //max number of rounds before restarting
    final int numofRounds = 10;

    JPanel header = new JPanel();
    
    //Array that has the number of buttons
    JButton[] numofButtons = new JButton[24];
    
    //label that displays which round player is in
    JLabel roundLabel = new JLabel("");
    
    //timer to constantly move the item
    Timer time;
    
    //the time the object stays before moving away
    final int timer = 1000;
    
    
    JPanel play = new JPanel();
    //instruction
    JLabel description = new JLabel("Click the O and avoid the 1's");
    
    //calculating correct item being caught and any possible missses
    double itemHit;
    double misses;
    double numofClicks;
    
    public CatchGame()
    {
      
        play.setLayout(new GridLayout(6, 4));
        header.setLayout(new BorderLayout());
        header.setBackground(Color.GREEN.brighter());
        //https://stackoverflow.com/questions/19854728/java-jpanel-is-only-one-small-pixel-in-the-top-center-of-my-jframe
        play.setPreferredSize(new Dimension(700, 680));
        play.setBackground(Color.GREEN.brighter());
        

        // Create each button.
        for (int i = 0; i < 24; ++i)
        {
            numofButtons[i] = new JButton(obstacles);
            
            //http://www.java2s.com/Code/JavaAPI/javax.swing/JPanelsetOpaquebooleanisOpaque.htm
            numofButtons[i].addActionListener(this);
           numofButtons[i].setOpaque(true);
            
            numofButtons[i].setBackground(Color.WHITE);
            
            numofButtons[i].setBorder(BorderFactory.createEmptyBorder());
            play.add(numofButtons[i]);
        }

        //https://docs.oracle.com/javase/tutorial/uiswing/misc/timer.html
        // Setup timer.
        time = new Timer(timer, this);
        time.setInitialDelay(timer);
        time.start();

        // Add elements.
        header.add(roundLabel, BorderLayout.NORTH);
        header.add(play, BorderLayout.CENTER);
        add(header);
        moveCatchItem();
        instructions();
        setVisible(true);
        
        //footer meant to display the instuction
        JPanel footer = new JPanel();
        footer.setLayout(new GridLayout(1,1));
        footer.setBackground(Color.CYAN);
        description.setFont(new Font("Serif", Font.BOLD, 18));
        
        footer.add(description);
        
        add(footer, BorderLayout.SOUTH); 
    }

    

    //determine which object is to be caught
    public void moveCatchItem()
    {
        time.restart();
        //randomly place the object to catch
        Random rand = new Random();
        int index = rand.nextInt(24);
        for (int i = 0; i < 24; ++i)
        {
            numofButtons[i].setText(obstacles);
            numofButtons[i].setForeground(Color.BLUE);
            numofButtons[i].setFont(new Font("Comic Sans", Font.BOLD, 20));
            if (i == index)
            {
                numofButtons[i].setText(catchItem);
                numofButtons[i].setForeground(Color.RED);
                numofButtons[i].setFont(new Font("Comic Sans", Font.BOLD, 20));
            }
        }
    }

    
    //displays the round the player is in
    private void instructions()
    {
        String getRoundNumber = "Round: " + roundCounter + " of " + numofRounds;
        roundLabel.setText(getRoundNumber);
        roundLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
    }

    
    @Override
    public void actionPerformed(ActionEvent e)
    {
    	
        // move the item after a set amount of time
        if (e.getSource() == time)
        {
            moveCatchItem();
        }

        
        else
        {
        	//https://stackoverflow.com/questions/7867834/get-button-name-from-actionlistener
            JButton button = (JButton)e.getSource();
            
            double percent = 0;
            boolean ifCaught = false;

            // if clicking on the item, round counter goes up and count any hits
            if (button.getText().equals(catchItem))
            {
                ++roundCounter;
                ++itemHit;
                ++numofClicks;
                for (int i = 0; i < 12; ++i)
                {
                    numofButtons[i].setBackground(Color.WHITE);
                    numofButtons[i].setForeground(Color.BLACK);
                }
                ifCaught = true;
            }

            //if clicked on the obstacle objects instead, count any misses
            else
            {
                button.setBackground(Color.RED);
                ++misses;
                ++numofClicks;
            }

            // once the program hits the final round, it will dictate the score 
            //and how many misses the player has gotten
            if (roundCounter > numofRounds)
            {
            	percent = Math.round((itemHit/numofClicks)* 100);
            	JOptionPane.showMessageDialog(null, "You caught the item " + percent + 
                		"% times!\nYou missed: " + misses, "Display hits and misses", 
                		JOptionPane.INFORMATION_MESSAGE);
                moveCatchItem();
                
    	        roundCounter = 0;
    	        
    	        
            }

            // keep moving the item even after being caught
            else if (ifCaught == true)
            {
                button.setBackground(Color.GREEN);
                instructions();
                moveCatchItem();
            }
        }
    }

   

}
