package gui;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 * The help document for the program.
 * @author Tom Connolly
 * @version 07/05/2015
 */
public class HelpDocument
{
	/**
	 * Constructor
	 */
	public HelpDocument()
	{
		// create components
		JFrame frame = new JFrame();
		JTextArea textArea = new JTextArea();
		JScrollPane scroller = new JScrollPane(textArea);
		// set component properties
		frame.setSize(new Dimension(500, 570));
		textArea.setSize(new Dimension(500, 570));
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.setSize(new Dimension(250, 250));
		scroller.getVerticalScrollBar().setValue(1);
		textArea.append("Evolutionary Art Generator Help Document \n\n");
		textArea.append("This document has been designed to aid you in your use of this system. The program is designed to " + ", with user input, create, save and load Evolutionary Art. \n\n");
		textArea.append("\nGetting started: \n\n");
		textArea.append("Click 'Create' on the right hand side to generate 9 random Biomorphs. These are displayed on the Mutation " + "panel and the main window. All visible Biomorphs can be moved and inspected (See 'Window controls'). The " + "Biomorph in the main window can be evolved using the buttons on the right(See 'How the Evolution works'). If " + "there is a Biomorph in the mutation panel that requires further inspection or evolution, it can be loaded " + "into the main window by selecting the corresponding check box and clicking the 'Load to main window' button. " + "The evolutionary parents of the live Biomorph can be loaded into the main window by clicking the 'Load mother/father' " + "Buttons. The original Biomorph can be reloaded by clicking the 'Reset to original Biomorph' button.");
		textArea.append("\n\nWindow controls: \n\n");
		textArea.append("To manipulate any visible Biomorph, click on the window and use the below controls:" + "\n 'Up Arrow' - Rotates the Biomorph upwards about the relative x axis." + "\n 'Down Arrow' - Rotates the Biomorph downwards about the relative x axis." + "\n 'Left Arrow' - Rotates the Biomorph left about the relative y axis." + "\n 'Right Arrow' - Rotates the Biomorph right about the relative y axis." + "\n 'W' - Zooms in on the Biomorphs centre." + "\n 'S' - Zooms out on the Biomorphs centre.");
		textArea.append("\n\nButtons: \n\n");
		textArea.append("To manipulate any visible Biomorph, click on the window and use the below controls:" + "\n 'Modify' - Opens a slider panel through which the live Biomorph's genes can be edited." + "\n 'Create/Evolve' - On first click 8 random Biomorphs are loaded. On subsequent clicks, this button " + "evolves the current Biomorph with whichever other Biomorphs checkboxes are selected (see 'How the evolution works') " + "and loads the result to the main window pushing all old values down one window in the Mutation Panel." + "\n 'Reset' - Discards all created Biomorphs and loads 8 new ones to the program." + "\n 'Load to main window' - Provided one and only one checkbox is selected, the corresponding Biomorph" + "is loaded to the main window." + "\n 'Load mother' - Finds the evolutionary mother of the current biomorph and loads it to the main window for evolution" + "\n 'Load father' - Finds the evolutionary father of the current biomorph and loads it to the main window for evolution" + "\n 'Reset to original Biomorph' - Zooms out on the Biomorphs centre");
		textArea.append("\n\nHow the evolution works: \n\n");
		textArea.append("The evolution in this project is implemented in two ways:" + "\n Average of Parents: This algorithm takes both parents and calculates the average of each of their genes. These are " + "then assigned to the new BiomorphTarget Values: This alogirthm uses a set of 'Target Values' which can be edited in " + "Settings>Edit evolution settings, to evolve. Each gene from each parent is compared to the target value for that gene, " + "whichever (mother or father)is closest to the target value for that gene is assigned to the new Biomorph.");
		textArea.append("\n\nExtra Features: \n\n");
		textArea.append("Display Evolution Statistics: This displays each Biomorph vertically as its gene values, you can trace the path of " + "a genes evolution by looking horizontally across the values displayed next to it.");
		textArea.append("Generate Collage: A collage is a window that is filled with windows displaying biomorphs that have been generated." + "the default option calculates the largest panel that can be built based on how many Biomorphs are available. The custom " + "option allows the dimensions to be selected and any empty space be filled with randomly generated Biomorphs.");
		Image image;
		try
		{
			image = ImageIO.read(new File("src/biomorphdownload.jpg"));
			frame.setIconImage(image);
		}
		catch (IOException e1)
		{
		}
		frame.add(scroller);
		frame.setVisible(true);
	}
	/**
	 * Main method for testing
	 */
	public static void main(String[] args)
	{
		new HelpDocument();
	}
}
