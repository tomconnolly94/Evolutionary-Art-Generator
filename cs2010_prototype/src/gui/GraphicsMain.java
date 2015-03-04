package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * The main window for the Biomorph Simulation. 
 * @author Charandeep
 *
 */

public class GraphicsMain
{
	//The main frame used for the GUI
	private static JFrame mainFrame;


public GraphicsMain() {

		//Creating the main container for the GUI
		mainFrame = new JFrame("Group 5 Biomorph Simulation");
		mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		//Listeners
		mainFrame.addWindowListener(new WindowAdapter() {
			public void Closewindow(WindowEvent e) {
				exitApp();
			}
		});
		
		mainFrame.pack();
		mainFrame.setVisible(true);
	}

private void exitApp() {
	int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure that you want to quit?", "Quit?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
	if (response == JOptionPane.YES_OPTION){
		System.exit(0);
	}
}

public static void main(String[] args){
	GraphicsMain gm = new GraphicsMain();
}
}