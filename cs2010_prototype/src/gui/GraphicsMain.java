package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
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
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import com.jogamp.opengl.util.FPSAnimator;
/**
 * The main window for the Biomorph Simulation.
 * @author Charandeep Rai
 */
public class GraphicsMain
{
	// The main frame used for the GUI
	private static JFrame mainFrame;
	// private FileMenu fileFrame;
	public GraphicsMain()
	{
		final JLabel tempLeftLabel = new JLabel("Biomorph Window");
		final JLabel tempRightLabel = new JLabel("Right Panel");
		final int blankSpace = 1;
		
		// Creating the main container for the GUI
		mainFrame = new JFrame("Group 5 Biomorph Simulation");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Importing the filemenu element
		FileMenu filemenu = new FileMenu();
		
		// Importing the Biomorph selection element
		// BiomorphSelector selector = new BiomorphSelector();
		
		// Importing the Biomorph display window
		// BiomorphWindows biowindow = new BiomorphWindows();
		
		// Setting up the biomorph window
		GLCanvas canvas = new GLCanvas(new GLCapabilities(GLProfile.getDefault()));
		JPanel bioWindow = new JPanel();
		int width = 800;
		int height = 800;
		canvas.setSize(new Dimension(width - 110, height - 110));
		bioWindow.add(canvas);
		bioWindow.setSize(new Dimension(width, height));
		bioWindow.setVisible(true);
		OpenGLFrame oframe = new OpenGLFrame();
		canvas.addGLEventListener(oframe);
		canvas.addKeyListener(oframe);
		FPSAnimator animator = new FPSAnimator(canvas, 120);
		animator.start();
		
		// Importing the RightPanel
		RightPanel rp = new RightPanel();
		
		// Creating the other containers for the GUI
		JPanel filemenuPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		JPanel bigBiomorphDisplayArea = new JPanel(new GridBagLayout());
		
		// Specifying the layout managers
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setPreferredSize(new Dimension(800, 800));
		((JPanel) mainFrame.getContentPane()).setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		
		filemenuPanel.setLayout(new BorderLayout());
		filemenuPanel.setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		
		rightPanel.setLayout(new BorderLayout());
		rightPanel.setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		// bigBiomorphDisplayArea.setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		bigBiomorphDisplayArea.setMinimumSize(new Dimension(width, height));
		
		// Add components to containers
		filemenuPanel.add(filemenu.getContents(), BorderLayout.CENTER);
		rightPanel.add(rp.getContents(), BorderLayout.CENTER);
		bigBiomorphDisplayArea.add(canvas, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 0;
		bigBiomorphDisplayArea.add(rightPanel, gbc);
		mainFrame.add(filemenuPanel, BorderLayout.NORTH);
		mainFrame.add(bigBiomorphDisplayArea, BorderLayout.CENTER);
		// Action Listeners
		mainFrame.addWindowListener(new WindowAdapter()
		{
			public void Closewindow(WindowEvent e)
			{
				exitApp();
			}
		});
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
}