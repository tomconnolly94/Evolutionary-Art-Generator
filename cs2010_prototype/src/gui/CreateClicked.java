package gui;

import java.awt.*;
import javax.swing.*;

public class CreateClicked 
{
	

	private static JFrame viewFrame;
	
	private static JPanel createClicked;
	

	private static JButton modify;
	private static JButton evolve;
	private static JButton random;

	


	public CreateClicked()	{
	modify = new JButton();
	modify.setText("Modify");
	random = new JButton();
	random.setText("Random");
	evolve = new JButton();
	evolve.setText("Evolve");
	// Set Layout
	
	
	createClicked.add(modify);
	createClicked.add(random);
	createClicked.add(evolve);
	
	createClicked.setLayout(new BoxLayout(createClicked, BoxLayout.Y_AXIS));
	createClicked.setBorder(BorderFactory.createLineBorder(Color.black));

	
	

}

	public JPanel getContents()
	{
		return (JPanel)viewFrame.getContentPane();
	}
}
