package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import biomorphHandling.*;
/**
 * The main window for the Biomorph Simulation.
 * @author Charandeep Rai, Jack Taylor, Tom Connolly
 * @version 30/04/2015
 */
public class GraphicsMain implements ActionListener, ItemListener
{
	private JFrame mainFrame; // The main frame used for the GUI
	private FileMenu fileMenu; // The file menu to be displayed at the top of the window
	private JPanel contentPanel; // The content panel, containing the biomorph panel, mutation panel and right panel.
	private MainBiomorphPanel mainPanel; // The main biomorph panel, containing the large biomorph window.
	private LowerBiomorphPanel lowerPanel; // The lower biomorph panel, containing 8 smaller biomorph windows.
	private JPanel evolvePanel;
	private RightPanel rp; // The right panel.
	private BiomorphManager bm; // The Biomorph Manager used to arrange and organise Biomorphs
	private JButton evolveButton;
	private JPanel buttonPanel;
	private JCheckBox[] checkBoxArr;
	private Biomorph[] selectedForEvol;
	/**
	 * Constructor
	 */
	public GraphicsMain()
	{
		// *0* Initialise variables
		final int blankSpace = 3;
		int width = 720;
		int height = 720;
		bm = new BiomorphManager();
		// *1* Create components
		mainFrame = new JFrame("Group 5 Biomorph Simulation");
		mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		fileMenu = new FileMenu();
		evolveButton = new JButton("Evolve");
		evolveButton.setSize(new Dimension(70,20));
		mainPanel = new MainBiomorphPanel(null);
		Biomorph biomorphs[] = new Biomorph[8];
		for (int i = 0; i < biomorphs.length; i++) biomorphs[i] = null;
		lowerPanel = new MutationPanel(biomorphs);
		checkBoxArr = new JCheckBox[8];
		for(int i=0; i<checkBoxArr.length;i++){
			String number = ""+(i+1);
			JCheckBox box = new JCheckBox(number);
			checkBoxArr[i] = box;
		}
		rp = new RightPanel();
		selectedForEvol = new Biomorph[8];
		// *2* Create containers
		contentPanel = new JPanel(new GridBagLayout());
		buttonPanel = new JPanel(new BorderLayout());
		evolvePanel = new JPanel();
		JPanel boxPanel = new JPanel();
		// *3* Specify layout managers
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setMinimumSize(new Dimension(width, height));
		((JPanel) mainFrame.getContentPane()).setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		contentPanel.setMinimumSize(new Dimension(width, height));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		evolveButton.setSize(new Dimension(200,50));
		// *4* Add components to containers
		gbc.gridx = 1;
		gbc.gridy = 0;
		contentPanel.add(mainPanel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		contentPanel.add(lowerPanel, gbc);
		for(JCheckBox box : checkBoxArr){
			boxPanel.add(box);
		}
		evolvePanel.add(evolveButton, BorderLayout.CENTER);
		buttonPanel.add(rp.getContents(), BorderLayout.WEST);
		buttonPanel.add(evolvePanel, BorderLayout.EAST);
		buttonPanel.add(boxPanel, BorderLayout.SOUTH);
		mainFrame.add(fileMenu.getContents(),BorderLayout.NORTH);
		mainFrame.add(contentPanel, BorderLayout.WEST);
		mainFrame.add(buttonPanel, BorderLayout.EAST);
		// *5* Create action listeners
		mainFrame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				exitApp();
			}
		});
		mainFrame.addComponentListener(new ComponentAdapter()
		{
			public void componentResized(ComponentEvent e)
			{
				resize();
			}
		});
		evolveButton.addActionListener(this);
		// *6* Pack and display
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	/**
	 * Evolves the biomorphs when the Evolve button is pressed.
	 */
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("Evolve"))
		{
			for (int i = 7; i >= 0; i--)
			{
				lowerPanel.setBiomorph(i, bm.getSpecific(i));
			}
			Biomorph biomorph = new Biomorph(0,0,0,0,0,0,0,0,0,0,0,0);
			if(selectedForEvol.length>1){
				
				for(int i=0;i<selectedForEvol.length;i++){
					biomorph = bm.evolveClo(selectedForEvol[i], selectedForEvol[i+1]);
				}
			}
			else{
				biomorph = bm.evolveClo(bm.getSpecific(1), bm.getRandomBiomorph());
			}
			bm.addSpecific(biomorph);
			mainPanel.setBiomorph(bm.getSpecific(0));
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e)
	{
		Object source = e.getItemSelectable();
		for(int i=0;i<checkBoxArr.length; i++){
			if(source == checkBoxArr[i]){
				selectedForEvol[i] = bm.getSpecific(i+1);
			}
		}
	}	
	
	/**
	 * Scales the biomorph windows according to the size of the main frame.
	 */
	private void resize()
	{
		mainPanel.resize((int)(mainFrame.getHeight() * 0.55));
		lowerPanel.resize((int)(mainFrame.getHeight() * 0.1375));
	}
	/**
	 * Shows a confirmation dialog to exit the application.
	 */
	private void exitApp()
	{
		int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure that you want to quit?", "Quit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
	}
	/**
	 * Main method
	 */
	public static void main(String[] args)
	{
		new GraphicsMain();
	}

}