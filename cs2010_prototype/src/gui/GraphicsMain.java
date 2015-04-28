package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.awt.GLJPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import biomorphHandling.*;
import com.jogamp.opengl.util.FPSAnimator;
/**
 * The main window for the Biomorph Simulation.
 * @author Charandeep Rai, Jack Taylor, Tom Connolly
 * @version 28/04/2015
 */
public class GraphicsMain
{
	private static JFrame mainFrame; // The main frame used for the GUI
	private static BiomorphManager bm; // the Biomorph Manager used to arrange and organise Biomorphs
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
		final JLabel tempLeftLabel = new JLabel("Biomorph Window");
		final JLabel tempRightLabel = new JLabel("Right Panel");
		mainFrame = new JFrame("Group 5 Biomorph Simulation");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FileMenu fileMenu = new FileMenu();
		JPanel largeBiomorphWindow = new JPanel();
		JPanel smallBiomorphWindow[] = new JPanel[8];
		for (int i = 0; i < smallBiomorphWindow.length; i++) smallBiomorphWindow[i] = new JPanel();
		RightPanel rp = new RightPanel();
		GLCanvas canvas[] = new GLCanvas[9];
		OpenGLFrame oframe[] = new OpenGLFrame[9];
		FPSAnimator animator[] = new FPSAnimator[9];
		// *2* Set up the biomorph window
		oframe[0] = new OpenGLFrame(bm.getRandomBiomorph());
		canvas[0] = new GLCanvas(new GLCapabilities(GLProfile.getDefault()));
		canvas[0].setSize(largeBiomorphWindowSize, largeBiomorphWindowSize);
		canvas[0].addGLEventListener(oframe[0]);
		canvas[0].addKeyListener(oframe[0]);
		largeBiomorphWindow.add(canvas[0]);
		largeBiomorphWindow.setSize(largeBiomorphWindowSize, largeBiomorphWindowSize);
		largeBiomorphWindow.setVisible(true);
		animator[0] = new FPSAnimator(canvas[0], 60);
		animator[0].start();
		//Smaller biomorphs for mutation
		for (int i = 1; i < canvas.length; i++)
		{
			oframe[i] = new OpenGLFrame(bm.getRandomBiomorph());
			canvas[i] = new GLCanvas(new GLCapabilities(GLProfile.getDefault()));
			canvas[i].setSize(smallBiomorphWindowSize, smallBiomorphWindowSize);
			canvas[i].addGLEventListener(oframe[i]);
			canvas[i].addKeyListener(oframe[i]);
			smallBiomorphWindow[i - 1].add(canvas[i]);
			smallBiomorphWindow[i - 1].setSize(smallBiomorphWindowSize, smallBiomorphWindowSize);
			smallBiomorphWindow[i - 1].setVisible(true);
			animator[i] = new FPSAnimator(canvas[i], 60);
			animator[i].start();
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
		biomorphPanel.add(largeBiomorphWindow, BorderLayout.CENTER);
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
	public int getWidth()
	{
		// TODO Auto-generated method stub
		return 0;
	}
	public void paintAll(Graphics biomorphgraphics)
	{
		// TODO Auto-generated method stub
		
	}
}
