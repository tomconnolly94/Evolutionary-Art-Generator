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
 * The Hall of Fame element of the program
 * @author Charandeep Rai
 */
public class BiomorphSelector 
{
	private static JFrame mainFrame;
	final int blankSpace = 1;

	public BiomorphSelector(){

		// Creating the containers for the components
		mainFrame = new JFrame("Biomorph Selector");
		JPanel grid = new JPanel();	

		JButton button1 = new JButton();
		JButton button2 = new JButton();
		JButton button3 = new JButton();
		JButton button4 = new JButton();
		JButton button5 = new JButton();
		JButton button6 = new JButton();
		JButton button7 = new JButton();
		JButton button8 = new JButton();

		// Setting the properties
		button1.setText("Button 1!"); 
		button2.setText("Button 2!"); 
		button3.setText("Button 3!"); 
		button4.setText("Button 4!"); 
		button5.setText("Button 5!"); 
		button6.setText("Button 6!"); 
		button7.setText("Button 7!"); 
		button8.setText("Button 8!"); 

		// Specifying the layout managers
		mainFrame.setLayout(new BorderLayout());
		((JPanel)mainFrame.getContentPane()).setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));

		grid.setLayout(new GridLayout(2,4));

		// Adding components to containers
		grid.add(button1);
		grid.add(button2);
		grid.add(button3);
		grid.add(button4);
		grid.add(button5);
		grid.add(button6);
		grid.add(button7);
		grid.add(button8);

		mainFrame.add(grid, BorderLayout.CENTER);
		
		//Action Listeners for each button
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
	}

	protected void initialise()
	{
		mainFrame.pack();
		mainFrame.setVisible(true);
	}

	public static void main (String[] args)
	{
		new BiomorphSelector().initialise();
	}




}
