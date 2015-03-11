package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


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
	
// Creating containers for the components
	fileFrame = new JFrame();
	
	JPanel newPanel = new JPanel();
	JPanel savePanel = new JPanel();
	JPanel openPanel = new JPanel();
	
// Specifying the layout used
	
	fileFrame.setLayout(new BorderLayout());
	((JPanel)fileFrame.getContentPane()).setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
	
	newPanel.setLayout(new BorderLayout());
	newPanel.setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
	
	savePanel.setLayout(new BorderLayout());
	savePanel.setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
	
	openPanel.setLayout(new BorderLayout());
	openPanel.setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));;

// Adding the components to the containers
	
	newPanel.add(newButton, BorderLayout.CENTER);
	savePanel.add(saveButton, BorderLayout.CENTER);
	openPanel.add(openButton, BorderLayout.CENTER);
	
	fileFrame.add(newPanel, BorderLayout.WEST);
	fileFrame.add(savePanel, BorderLayout.WEST);
	fileFrame.add(openPanel, BorderLayout.WEST);
	
// Adding the action listens for the buttons
	
	newButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent n){
			//Needs Completing
		}
	});
	
	saveButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent s){
			//Needs Completing
	}
	});
	
	openButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent o){
			//Needs Completing
	}
	});

// Packing and displaying the GUI
	
	fileFrame.pack();
	fileFrame.setVisible(true);
	
	
	
	
	
	
	
	
}
}