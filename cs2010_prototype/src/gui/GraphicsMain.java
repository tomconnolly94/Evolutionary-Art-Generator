package gui;
import java.awt.BorderLayout;
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
 * @version 28/04/2015
 */
public class GraphicsMain
{
	private static JFrame mainFrame; // The main frame used for the GUI
	private static BiomorphManager bm; // The Biomorph Manager used to arrange and organise Biomorphs
	public GraphicsMain()
	{
		// *0* Initialise variables
		final int blankSpace = 1;
		int width = 800;
		int height = 800;
		int largeBiomorphWindowSize = 400;
		int smallBiomorphWindowSize = 100;
		bm = new BiomorphManager();
		// *1* Create components
		mainFrame = new JFrame("Group 5 Biomorph Simulation");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FileMenu fileMenu = new FileMenu();
		JPanel largeBiomorphWindow = new JPanel();
		JPanel smallBiomorphWindow[] = new JPanel[8];
		for (int i = 0; i < smallBiomorphWindow.length; i++) smallBiomorphWindow[i] = new JPanel();
		RightPanel rp = new RightPanel();
		OpenGLFrame oframe[] = new OpenGLFrame[9];
		// *2* Set up the biomorph window
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
		JPanel contentPanel = new JPanel(new GridBagLayout());
		JPanel biomorphPanel = new JPanel();
		JPanel mutatePanel = new JPanel(new GridBagLayout());
		//mutatePanel.setSize(smallBiomorphWindowSize * 4, smallBiomorphWindowSize * 2);
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
			@SuppressWarnings("unused")
			public void Closewindow(WindowEvent e)
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
		int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure that you want to quit?", "Quit?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
	}
	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		GraphicsMain gm = new GraphicsMain();
	}
}