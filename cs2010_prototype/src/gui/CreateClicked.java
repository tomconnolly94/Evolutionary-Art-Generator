/*package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CreateClicked 
{
	

	private static JFrame viewFrame;
	
	private static JPanel createClicked;
	private static JPanel secondPanel;

	private static JButton modify;
	private static JButton evolve;
	private static JButton random;

	


	public CreateClicked()	{
		
	viewFrame = new JFrame();
	secondPanel = new JPanel();
	createClicked = new JPanel();
		
	modify = new JButton("Modify");
	random = new JButton("Random");
	evolve = new JButton("Evolve");

	
	secondPanel.add(modify);
	secondPanel.add(random);
	secondPanel.add(evolve);
	createClicked.add(secondPanel);
	
	//createClicked.setLayout(new BoxLayout(createClicked, BoxLayout.Y_AXIS));
	//createClicked.setBorder(BorderFactory.createLineBorder(Color.black));
	
	viewFrame.add(createClicked);
	
	

	modify.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
			viewFrame.remove(createClicked);
			BiomorphCustomisation bc = new BiomorphCustomisation();
			viewFrame.add(bc.getContents());
			//viewFrame.setVisible(true);
			
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
	
	
	
}*/