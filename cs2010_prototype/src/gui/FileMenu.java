package gui;

import javax.swing.JButton;
import javax.swing.JFrame;


/**
 * The File Menu element of the program
 * @author Charandeep Rai
 */

public class FileMenu{

//Creation of the frame for the file system.
	private static JFrame fileFrame;
	private static JButton newButton;
	private static JButton saveButton;
	private static JButton openButton;
	

public FileMenu() {

// Padding out the borders with blank spaces	
	final int blankSpace = 1;
	
// Creating components
	
	//Button to create a new Biomorph
	JButton newButton = new JButton();
	JButton saveButton = new JButton();
	JButton openButton = new JButton();
	
	//Set the properties
	newButton.setText("New");
	newButton.setToolTipText("Creates a new Biomorph");
	
	saveButton.setText("Save");
	saveButton.setToolTipText("Saves the created Biomorph");
	
	openButton.setText("Open");
	openButton.setToolTipText("Open up a previously created Biomorph");
	

	
	
	
	
	
}
}