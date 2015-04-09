package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
		
//		BufferedImage button1Icon = ImageIO.read(new File(""));
//		BufferedImage button2Icon = ImageIO.read(new File(""));
//		BufferedImage button3Icon = ImageIO.read(new File(""));
//		BufferedImage button4Icon = ImageIO.read(new File(""));
//		BufferedImage button5Icon = ImageIO.read(new File(""));
//		BufferedImage button6Icon = ImageIO.read(new File(""));
//		BufferedImage button7Icon = ImageIO.read(new File(""));
//		BufferedImage button8Icon = ImageIO.read(new File(""));

		
		
		// Creating new buttons
//		JButton button1 = new JButton(new ImageIcon(button1Icon));
//		JButton button2 = new JButton(new ImageIcon(button2Icon));
//		JButton button3 = new JButton(new ImageIcon(button3Icon));
//		JButton button4 = new JButton(new ImageIcon(button4Icon));
//		JButton button5 = new JButton(new ImageIcon(button5Icon));
//		JButton button6 = new JButton(new ImageIcon(button6Icon));
//		JButton button7 = new JButton(new ImageIcon(button7Icon));
//		JButton button8 = new JButton(new ImageIcon(button8Icon));

		
		JButton button1 = new JButton();
		JButton button2 = new JButton();
		JButton button3 = new JButton();
		JButton button4 = new JButton();
		JButton button5 = new JButton();
		JButton button6 = new JButton();
		JButton button7 = new JButton();
		JButton button8 = new JButton();

		// Setting the properties
		button1.setText("Biomorph Placeholder 1"); 
		button1.setBorder(BorderFactory.createEmptyBorder());
		button1.setContentAreaFilled(false);
	
		button2.setText("Biomorph Placeholder 2"); 
		button2.setBorder(BorderFactory.createEmptyBorder());
		button2.setContentAreaFilled(false);	
		
		button3.setText("Biomorph Placeholder 3"); 
		button3.setBorder(BorderFactory.createEmptyBorder());
		button3.setContentAreaFilled(false);
	
		button4.setText("Biomorph Placeholder 4"); 
		button4.setBorder(BorderFactory.createEmptyBorder());
		button4.setContentAreaFilled(false);
		
		button5.setText("Biomorph Placeholder 5"); 
		button5.setBorder(BorderFactory.createEmptyBorder());
		button5.setContentAreaFilled(false);
	
		button6.setText("Biomorph Placeholder 6"); 
		button6.setBorder(BorderFactory.createEmptyBorder());
		button6.setContentAreaFilled(false);
	
		button7.setText("Biomorph Placeholder 7"); 
		button7.setBorder(BorderFactory.createEmptyBorder());
		button7.setContentAreaFilled(false);
	
		button8.setText("Biomorph Placeholder 8"); 
		button8.setBorder(BorderFactory.createEmptyBorder());
		button8.setContentAreaFilled(false);
	
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
	
	public JPanel getContents()
	{
		return (JPanel)mainFrame.getContentPane();
	}

	public static void main (String[] args)
	{
		new BiomorphSelector().initialise();
	}




}
