import java.awt.*;
import java.awt.event.* ;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener{
  JTextField userGuess; 
  JButton guessButton;
  JButton playAgainButton;
  JLabel jlabPrompt;
  JLabel jlabIndicator; 
  JLabel jlabDisplay;
  Random r = new Random();
  int randomNum = r.nextInt(100)+1;
   
   GuessingGame(){
     JFrame frame = new JFrame("Guessing Game"); 
      // Specify FlowLayout for the layout manager. 
      frame.setLayout(new FlowLayout()); 
      // Give the frame an initial size. 
      frame.setSize(240, 120); 
      // Create a text field. 
      userGuess = new JTextField(10); 
      // Set the action commands for the text field. 
      userGuess.setActionCommand("myTF"); 
      
      // Create the Reverse button. 
      guessButton = new JButton("Guess"); 
      playAgainButton = new JButton("Play Again"); 
     
     
      // Add action listeners. 
      userGuess.addActionListener(this); 
      guessButton.addActionListener(this); 
      playAgainButton.addActionListener(this);

      // Create the labels. 
      jlabPrompt = new JLabel("Enter your guess: "); 
      jlabIndicator = new JLabel(""); 
      jlabDisplay = new JLabel("");
      
      
      // Add the components to the content pane.    
      frame.add(jlabPrompt);
      frame.add(userGuess); 
      frame.add(guessButton); 
      frame.add(jlabIndicator); 
      frame.add(jlabDisplay);
      frame.add(playAgainButton);
      
      // Display the frame. 
      frame.setVisible(true); 
  } 
  public void actionPerformed(ActionEvent ae) { 
    if(ae.getActionCommand().equals("Guess")) { 
      int guess = Integer.parseInt(userGuess.getText());
      if(guess < randomNum){
        jlabIndicator.setText("Too low!");
      } else if(guess>randomNum){
        jlabIndicator.setText("Too high!");
      } else{
        jlabIndicator.setText("You got it!");
      }
      jlabDisplay.setText("Last guess was " + guess);
      userGuess.setText("");
    }
    else if(ae.getActionCommand().equals("Play Again")){
      int randomNum = r.nextInt(100)+1;
      jlabPrompt.setText("Enter your guess: "); 
      jlabIndicator.setText(""); 
      jlabDisplay.setText("");
      userGuess.setText("");
    }
    else {
      jlabIndicator.setText("You pressed Enter. Please press the Guess Button.");
    } 
  }
} 

