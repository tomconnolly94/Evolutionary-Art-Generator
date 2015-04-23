package gui;
import java.awt.*;
import javax.swing.*;
public class RightPanel
{
	/**
	 * The right panel of the GUI
	 * @author Charandeep Rai
	 */
	// Frames used
	private static JFrame viewFrame;
	// Panels used
	private static JPanel openingPane;
	
	// Buttons used
	private static JButton create;
	private static JButton random;

	public RightPanel()
	{
		initiate();
	}
	public void initiate()
	{
		// Create instance of side container
		viewFrame = new JFrame("Menu");
		openingPane = new JPanel();
		viewFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		// Listeners
		// setTitle
		viewFrame.setTitle("Menu");
		// Create Buttons
		create = new JButton();
		create.setText("Create");
		random = new JButton();
		random.setText("Random");
		// Set Layout
		openingPane.setLayout(new BoxLayout(openingPane, BoxLayout.Y_AXIS));
		openingPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// add components to panel
		openingPane.add(create);
		openingPane.add(random);
		// add panel to frame
		viewFrame.add(openingPane);
		// make visible
		viewFrame.setVisible(true);
		// Create instance of side container
		
}
}