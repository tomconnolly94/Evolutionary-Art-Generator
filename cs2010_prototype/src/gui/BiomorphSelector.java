package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * The Hall of Fame element of the program
 * @author Charandeep Rai
 */
public class BiomorphSelector 
{
//Initialising the components	
	private static JFrame mainFrame;
	
	final int blankSpace = 1;
	
	
	
	public BiomorphSelector(){
	
	JPanel grid = new JPanel();	
	mainFrame = new JFrame("Biomorph Selector");
	
	
	
	
	mainFrame.setLayout(new BorderLayout());
	((JPanel)mainFrame.getContentPane()).setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
	
	
	}

	

    
   
}
