package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
public class GraphicsMain
{
	private JFrame mainFrame; // The main frame used for the GUI
	private FileMenu fileMenu;
	private JPanel contentPanel;
	private JPanel biomorphPanel;
	private JPanel mutatePanel;
	private JPanel largeBiomorphWindow;
	private JPanel smallBiomorphWindow[];
	private RightPanel rp;
	private BiomorphManager bm; // The Biomorph Manager used to arrange and organise Biomorphs
	private int largeBiomorphWindowSize;
	private int smallBiomorphWindowSize;
	public GraphicsMain()
	{
		// *0* Initialise variables
		final int blankSpace = 1;
		int width = 800;
		int height = 800;
		largeBiomorphWindowSize = 400;
		smallBiomorphWindowSize = 100;
		bm = new BiomorphManager();
		// *1* Create components
		mainFrame = new JFrame("Group 5 Biomorph Simulation");
		mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		fileMenu = new FileMenu();
		largeBiomorphWindow = new JPanel();
		smallBiomorphWindow = new JPanel[8];
		for (int i = 0; i < smallBiomorphWindow.length; i++) smallBiomorphWindow[i] = new JPanel();
		rp = new RightPanel();
		OpenGLFrame oframe[] = new OpenGLFrame[9];
		// *2* Set up the biomorph windows
		oframe[0] = new OpenGLFrame(bm.getRandomBiomorph(), largeBiomorphWindowSize);
		largeBiomorphWindow.add(oframe[0].getCanvas());
		largeBiomorphWindow.setSize(largeBiomorphWindowSize, largeBiomorphWindowSize);
		largeBiomorphWindow.setVisible(true);
		//Smaller biomorphs for mutation
		for (int i = 1; i < oframe.length; i++)
		{
			oframe[i] = new OpenGLFrame(bm.getSpecific(i), smallBiomorphWindowSize);
			smallBiomorphWindow[i - 1].add(oframe[i].getCanvas());
			smallBiomorphWindow[i - 1].setSize(smallBiomorphWindowSize, smallBiomorphWindowSize);
			smallBiomorphWindow[i - 1].setVisible(true);
		}
		// *3* Create containers
		contentPanel = new JPanel(new GridBagLayout());
		biomorphPanel = new JPanel();
		mutatePanel = new JPanel(new GridBagLayout());
		mutatePanel.setSize(smallBiomorphWindowSize * 4, smallBiomorphWindowSize * 2);
		// *4* Specify layout managers
		mainFrame.setLayout(new BorderLayout()/*new BoxLayout(mainFrame,BoxLayout.Y_AXIS)*/);
		mainFrame.setPreferredSize(new Dimension(width, height));
		((JPanel) mainFrame.getContentPane()).setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		contentPanel.setMinimumSize(new Dimension(width, height));
		GridBagConstraints gbcMutate = new GridBagConstraints();
		GridBagConstraints gbcContent = new GridBagConstraints();
		gbcMutate.fill = GridBagConstraints.HORIZONTAL;
		gbcContent.fill = GridBagConstraints.HORIZONTAL;
		// *5* Add components to containers
		biomorphPanel.add(largeBiomorphWindow, 0);
		for (int i = 0; i < smallBiomorphWindow.length; i++)
		{	
			gbcMutate.gridx = i % 4;
			gbcMutate.gridy = i / 4;
			mutatePanel.add(smallBiomorphWindow[i], gbcMutate);
			smallBiomorphWindow[i].setBorder(new EmptyBorder(-5, -5, -5, -5)); //Remove default padding
		}
		gbcContent.gridx = 0;
		gbcContent.gridy = 0;
		contentPanel.add(biomorphPanel, gbcContent);
		gbcContent.gridx = 0;
		gbcContent.gridy = 1;
		contentPanel.add(mutatePanel, gbcContent);
		gbcContent.gridx = 1;
		gbcContent.gridy = 0;
		contentPanel.add(rp.getContents(), gbcContent);
		mainFrame.add(fileMenu.getContents());
		mainFrame.add(contentPanel);
		// *6* Create action listeners
		mainFrame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				exitApp();
			}
		});
		// *7* Pack and display
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	private void exitApp()
	{
		int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure that you want to quit?", "Quit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
	}
	public static void main(String[] args)
	{
		new GraphicsMain();
	}
}