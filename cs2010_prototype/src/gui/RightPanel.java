package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private JPanel buttonPanel;
	private JPanel secondPanel;
	private  JButton createButton;
	private static JButton modifyButton;

	public RightPanel()
	{
		initiate();		
	}
	public void initiate()
	
	{
		//set frame and panel
		viewFrame = new JFrame("Menu");
		viewFrame.setSize(new Dimension(168,  608));
		buttonPanel = new JPanel();
		secondPanel = new JPanel();
		//set close
		viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		// Create Buttons
		createButton = new JButton("Create");
		modifyButton = new JButton("Modify");
		// Set Layout
		//openingPane.setLayout(new BoxLayout(openingPane, BoxLayout.Y_AXIS));
		//openingPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// add components to panel
		buttonPanel.add(createButton);
		buttonPanel.add(modifyButton);
		secondPanel.add(buttonPanel);
		// add panel to frame
		viewFrame.add(secondPanel);
	
	createButton.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
			secondPanel.remove(buttonPanel);
			BiomorphCustomisation bc = new BiomorphCustomisation();
			
			JPanel bc2 = bc.getContents();
			bc2.setSize(new Dimension(168,608));
			secondPanel = bc.getContents();
			secondPanel.revalidate();
			secondPanel.repaint();
		}
		
	});
	modifyButton.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
			viewFrame.remove(buttonPanel);
			CreateClicked cc = new CreateClicked();
			viewFrame.add(cc.getContents());
		}
		
	});
	//make visible
	//viewFrame.setVisible(true);
	
	}
	public JPanel getContents()
	{
		return (JPanel)viewFrame.getContentPane();
	}
	
	public static void main(String[] args){
		RightPanel rp = new RightPanel();
	}
}