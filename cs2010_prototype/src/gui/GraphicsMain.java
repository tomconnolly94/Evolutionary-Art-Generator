package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import biomorphHandling.*;
/**
 * The main window for the Biomorph Simulation.
 * @author Charandeep Rai, Jack Taylor, Tom Connolly
 * @version 29/04/2015
 */
public class GraphicsMain implements ActionListener
{
	private JFrame mainFrame; // The main frame used for the GUI
	private FileMenu fileMenu; // The file menu to be displayed at the top of the window
	private JPanel contentPanel; // The content panel, containing the biomorph panel, mutation panel and right panel.
	private JPanel biomorphPanel; // The main biomorph panel, containing the large biomorph window.
	private JPanel mutatePanel; // The mutation panel, containing 8 smaller biomorph windows.
	private JPanel largeBiomorphWindow; // The large biomorph window.
	private JPanel smallBiomorphWindow[]; // The array of 8 small biomorph windows.
	private JPanel evolvePanel;
	private RightPanel rp; // The right panel.
	private BiomorphManager bm; // The Biomorph Manager used to arrange and organise Biomorphs
	private OpenGLFrame oframe[];
	private int largeBiomorphWindowSize;
	private int smallBiomorphWindowSize;
	private JButton evolveButton;
	/**
	 * Constructor
	 */
	public GraphicsMain()
	{
		// *0* Initialise variables
		final int blankSpace = 15;
		int width = 720;
		int height = 720;
		largeBiomorphWindowSize = 400;
		smallBiomorphWindowSize = 100;
		bm = new BiomorphManager();
		// *1* Create components
		mainFrame = new JFrame("Group 5 Biomorph Simulation");
		mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		fileMenu = new FileMenu();
		evolveButton = new JButton("Evolve");
		evolvePanel = new JPanel();
		largeBiomorphWindow = new JPanel();
		smallBiomorphWindow = new JPanel[8];
		for (int i = 0; i < smallBiomorphWindow.length; i++) smallBiomorphWindow[i] = new JPanel();
		rp = new RightPanel();
		oframe = new OpenGLFrame[9];
		// *2* Set up the biomorph windows
		oframe[0] = new OpenGLFrame(bm.getSpecific(0), largeBiomorphWindowSize);
		largeBiomorphWindow.add(oframe[0].getCanvas());
		largeBiomorphWindow.setVisible(true);
		//Smaller biomorphs for mutation
		for (int i = 1; i < oframe.length; i++)
		{
			oframe[i] = new OpenGLFrame(bm.getSpecific(i-1), smallBiomorphWindowSize);
			smallBiomorphWindow[i - 1].add(oframe[i].getCanvas());
			smallBiomorphWindow[i - 1].setVisible(true);
		}
		// *3* Create containers
		contentPanel = new JPanel(new GridBagLayout());
		biomorphPanel = new JPanel();
		mutatePanel = new JPanel(new GridBagLayout());
		// *4* Specify layout managers
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setMinimumSize(new Dimension(width, height));
		((JPanel) mainFrame.getContentPane()).setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		contentPanel.setMinimumSize(new Dimension(width, height));
		GridBagConstraints gbcMutate = new GridBagConstraints();
		GridBagConstraints gbcContent = new GridBagConstraints();
		gbcMutate.fill = GridBagConstraints.HORIZONTAL;
		gbcContent.fill = GridBagConstraints.HORIZONTAL;
		evolveButton.setSize(new Dimension(200,50));
		// *5* Add components to containers
		biomorphPanel.add(largeBiomorphWindow, 0);
		for (int i = 0; i < smallBiomorphWindow.length; i++)
		{	
			gbcMutate.gridx = i % 4;
			gbcMutate.gridy = i / 4;
			mutatePanel.add(smallBiomorphWindow[i], gbcMutate);
			smallBiomorphWindow[i].setBorder(new EmptyBorder(-5, -5, -5, -5)); //Remove default padding
		}
		gbcContent.gridx = 1;
		gbcContent.gridy = 0;
		contentPanel.add(biomorphPanel, gbcContent);
		gbcContent.gridx = 1;
		gbcContent.gridy = 1;
		contentPanel.add(mutatePanel, gbcContent);
		gbcContent.gridx = 2;
		gbcContent.gridy = 0;
		contentPanel.add(rp.getContents(), gbcContent);
		gbcContent.gridx = 0;
		gbcContent.gridy = 0;
		contentPanel.add(evolveButton,gbcContent);
		mainFrame.add(fileMenu.getContents());
		mainFrame.add(contentPanel);
		mainFrame.add(evolvePanel, BorderLayout.WEST);
		// *6* Create action listeners
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

		// *7* Pack and display
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	/**
	 * Scales the biomorph windows according to the size of the main frame.
	 */
	private void resize()
	{
		largeBiomorphWindowSize = (int)(mainFrame.getHeight() * 0.6);
		smallBiomorphWindowSize = largeBiomorphWindowSize / 4;
		oframe[0].getCanvas().setSize(largeBiomorphWindowSize, largeBiomorphWindowSize);
		for (int i = 1; i < oframe.length; i++) oframe[i].getCanvas().setSize(smallBiomorphWindowSize, smallBiomorphWindowSize);
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
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("Evolve")){
			for (int i = 8; i > 0; i--){
				oframe[i].setBiomorph(oframe[i-1].getBiomorph());
			}
			bm.addSpecific(bm.evolveClo(bm.getSpecific(1), bm.getSpecific(2)));
			oframe[0].setBiomorph(bm.getSpecific(0));
		}
		
	}
}