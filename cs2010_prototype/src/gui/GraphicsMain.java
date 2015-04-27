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
		// *0* Set local variables
		int width = 800;
		int height = 800;
		
		// *1* Create components
		final JLabel tempLeftLabel = new JLabel("Biomorph Window");
		final JLabel tempRightLabel = new JLabel("Right Panel");
		final int blankSpace = 1;
		
		mainFrame = new JFrame("Group 5 Biomorph Simulation");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FileMenu filemenu = new FileMenu();
		RightPanel rp = new RightPanel();
		GLCanvas canvas = new GLCanvas(new GLCapabilities(GLProfile.getDefault()));
		OpenGLFrame oframe = new OpenGLFrame();
		JPanel largeBiomorphWindow = new JPanel();
		
		// *2* Set up the biomorph window
		canvas.setSize(new Dimension(width - 110, height - 110));
		largeBiomorphWindow.add(canvas);
		largeBiomorphWindow.setSize(new Dimension(width-200, height-400));
		largeBiomorphWindow.setVisible(true);
		canvas.addGLEventListener(oframe);
		canvas.addKeyListener(oframe);
		FPSAnimator animator = new FPSAnimator(canvas, 120);
		animator.start();
		
		// *3* Create containers
		JPanel contentPanel = new JPanel(new GridBagLayout());
		JPanel biomorphPanel= new JPanel();
		biomorphPanel.setSize(new Dimension(width-200,height-400));
		JPanel hallOfFamePanel = new JPanel();
		
		// *4* Specify layout managers
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setPreferredSize(new Dimension(width, height));
		((JPanel) mainFrame.getContentPane()).setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
				
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		contentPanel.setMinimumSize(new Dimension(width, height));
		
		// *5* Add components to containers
		
		//TODO:add small biomorph windows to hall of fame panel 
		
		biomorphPanel.add(largeBiomorphWindow, BorderLayout.NORTH);
		biomorphPanel.add(hallOfFamePanel, BorderLayout.SOUTH);
		
		contentPanel.add(largeBiomorphWindow, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 0;
		contentPanel.add(rp.getContents(), gbc);
		
		
		mainFrame.add(filemenu.getContents(), BorderLayout.NORTH);
		mainFrame.add(contentPanel, BorderLayout.CENTER);
		
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