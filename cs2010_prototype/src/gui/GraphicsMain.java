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
 * @author Charandeep Rai
 */
public class GraphicsMain
{
	// The main frame used for the GUI
	private static JFrame mainFrame;
	// the Biomorph Manager used to arrange and organise Biomorphs
	private static BiomorphManager bm;
	
	public GraphicsMain()
	{
		// *0* Initialise variables
		final int blankSpace = 1;
		int width = 800;
		int height = 800;
		int largeBiomorphWindowSize = 300;
		bm = new BiomorphManager();
		
		// *1* Create components
		final JLabel tempLeftLabel = new JLabel("Biomorph Window");
		final JLabel tempRightLabel = new JLabel("Right Panel");
		
		mainFrame = new JFrame("Group 5 Biomorph Simulation");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FileMenu fileMenu = new FileMenu();
		RightPanel rp = new RightPanel();
		GLCanvas canvas = new GLCanvas(new GLCapabilities(GLProfile.getDefault()));
		OpenGLFrame oframe = new OpenGLFrame(bm.getRandomBiomorph());
		JPanel largeBiomorphWindow = new JPanel();
		
		// *2* Set up the biomorph window
		canvas.setSize(new Dimension(largeBiomorphWindowSize, largeBiomorphWindowSize));
		largeBiomorphWindow.add(canvas);
		//largeBiomorphWindow.setSize(new Dimension(largeBiomorphWindowSize, largeBiomorphWindowSize));
		largeBiomorphWindow.setVisible(true);
		canvas.addGLEventListener(oframe);
		canvas.addKeyListener(oframe);
		FPSAnimator animator = new FPSAnimator(canvas, 60);
		animator.start();
		
		// second biomorph Window
		GLCanvas canvas2 = new GLCanvas(new GLCapabilities(GLProfile.getDefault()));
		OpenGLFrame oframe2 = new OpenGLFrame(bm.getRandomBiomorph());
		JPanel largeBiomorphWindow2 = new JPanel();
		canvas2.setSize(new Dimension(largeBiomorphWindowSize, largeBiomorphWindowSize));
		largeBiomorphWindow2.add(canvas2);
		//largeBiomorphWindow.setSize(new Dimension(largeBiomorphWindowSize, largeBiomorphWindowSize));
		largeBiomorphWindow2.setVisible(true);
		canvas2.addGLEventListener(oframe2);
		canvas2.addKeyListener(oframe2);
		FPSAnimator animator2 = new FPSAnimator(canvas2, 60);
		animator2.start();
		
		// *3* Create containers
		JPanel contentPanel = new JPanel(new GridBagLayout());
		//contentPanel.setSize(new Dimension(900,900));
		JPanel biomorphPanel= new JPanel();
		JPanel biomorphPanel2= new JPanel();
		biomorphPanel.setSize(new Dimension(largeBiomorphWindowSize,largeBiomorphWindowSize));
		JPanel hallOfFamePanel = new JPanel();
		
		// *4* Specify layout managers
		mainFrame.setLayout(new BorderLayout()/*new BoxLayout(mainFrame,BoxLayout.Y_AXIS)*/);
		mainFrame.setPreferredSize(new Dimension(width, height));
		((JPanel) mainFrame.getContentPane()).setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
				
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		//gbc.gridwidth = 1;
		
		contentPanel.setMinimumSize(new Dimension(width, height));
		
		// *5* Add components to containers
		
		//TODO:add small biomorph windows to hall of fame panel 
		
		biomorphPanel.add(largeBiomorphWindow, BorderLayout.NORTH);
		
		
		
		//biomorphPanel.add(hallOfFamePanel, BorderLayout.SOUTH);
		
		contentPanel.add(largeBiomorphWindow, gbc);
		
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		biomorphPanel2.add(largeBiomorphWindow2, BorderLayout.SOUTH);
		contentPanel.add(largeBiomorphWindow2, gbc);
		
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		contentPanel.add(rp.getContents(), gbc);
		
        //fileMenu.getContents().setAlignmentX(mainFrame.LEFT_ALIGNMENT);
        //contentPanel.setAlignmentX(mainFrame.LEFT_ALIGNMENT);
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
