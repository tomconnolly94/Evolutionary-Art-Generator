package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import biomorphHandling.Biomorph;
import biomorphHandling.BiomorphManager;
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
	private Biomorph biomorph;
	private BiomorphCustomisation bc;
	private BiomorphManager bm;
	private MainBiomorphPanel mainPanel;

	public RightPanel(BiomorphManager bm, Biomorph biomorph)
	{
		bc = new BiomorphCustomisation(new Biomorph(null,null,0,0,0,0,0,0,0,0,0,0,0,0),buttonPanel);
		//this.mainPanel = mainPanel;
		this.biomorph=biomorph;
		this.bm = bm;
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
		//buttonPanel.add(createButton);
		buttonPanel.add(modifyButton);
		secondPanel.add(buttonPanel);
		// add panel to frame
		viewFrame.add(secondPanel);
	
	createButton.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
			//imlementation not complete yet
			secondPanel.remove(buttonPanel);
			Biomorph biomorph = new Biomorph(null,null,0,0,0,0,0,0,0,0,0,0,0,0);
			bc = new BiomorphCustomisation(biomorph, buttonPanel);
			bm.addSpecific(biomorph);
			JPanel bc2 = bc.getContents();
			bc2.setSize(new Dimension(168,608));
			secondPanel.add(bc2);
			secondPanel.revalidate();
			secondPanel.repaint();
		}
		
	});
	modifyButton.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
			if(biomorph!=null){
				secondPanel.remove(buttonPanel);
				bc = new BiomorphCustomisation(biomorph, buttonPanel);
				
				JPanel bc2 = bc.getContents();
				bc2.setSize(new Dimension(168,608));
				secondPanel.add(bc2);
				secondPanel.revalidate();
				secondPanel.repaint();
			}
		}
		
	});
	//make visible
	//viewFrame.setVisible(true);
	
	}
	public JPanel getContents()
	{
		return (JPanel)viewFrame.getContentPane();
	}
	
	public void resetRightPanel(){
		secondPanel.remove(secondPanel.getComponent(0));
		secondPanel.add(buttonPanel);
		secondPanel.revalidate();
		secondPanel.repaint();
	}
	
	public void update(BiomorphManager bm, Biomorph biomorph){
		this.bm=bm;
		this.mainPanel = mainPanel;
		this.biomorph = biomorph;
		bc.updateBiomorph(biomorph);
	}
	
	public static void main(String[] args){
		BiomorphManager bm = new BiomorphManager();
		Biomorph biomorph = new Biomorph(null, null,0,0,0,0,0,0,0,0,0,0,0,0);
		MainBiomorphPanel mbp = new MainBiomorphPanel(biomorph);
		RightPanel rp = new RightPanel(bm,biomorph);
	}
}