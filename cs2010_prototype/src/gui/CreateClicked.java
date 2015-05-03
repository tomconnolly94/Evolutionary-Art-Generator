package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CreateClicked 
{
	

	private static JFrame viewFrame;
	
	private static JPanel createClicked;
	

	private static JButton modify;
	private static JButton evolve;
	private static JButton random;

	


	public CreateClicked()	{
		
	viewFrame = new JFrame();
	viewFrame.setSize(1024, 728);
	createClicked = new JPanel();
		
	modify = new JButton();
	modify.setText("Modify");
	random = new JButton();
	random.setText("Random");
	evolve = new JButton();
	evolve.setText("Evolve");

	
	createClicked.add(modify);
	createClicked.add(random);
	createClicked.add(evolve);
	
	createClicked.setLayout(new BoxLayout(createClicked, BoxLayout.Y_AXIS));
	createClicked.setBorder(BorderFactory.createLineBorder(Color.black));
	
	viewFrame.add(createClicked);
	
	

	modify.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
			viewFrame.setVisible(false);
			viewFrame.remove(createClicked);
			BiomorphCustomisation bc = new BiomorphCustomisation();
			viewFrame.add(bc.getContents());
			viewFrame.setVisible(true);
			
			//just waiting for functionality
		}
		});
	random.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
		//functionality for the random biomorph
		}
		});
	
	
	}
	
	


	public JPanel getContents()
	{
		return (JPanel)viewFrame.getContentPane();
	}
	
	
	
}