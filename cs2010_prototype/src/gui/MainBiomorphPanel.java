package gui;
import javax.swing.JPanel;
import biomorphHandling.Biomorph;
/**
 * The large biomorph panel for the GUI.
 * @author Jack Taylor
 * @version 30/04/2015
 */
public class MainBiomorphPanel extends JPanel
{
	private static final long serialVersionUID = 9104451169664277399L;
	private OpenGLFrame oframe;
	private int size;
	/**
	 * Constructor
	 * @param biomorph The biomorph used to initialise the OpenGL window
	 */
	public MainBiomorphPanel(Biomorph biomorph)
	{
		super();
		size = 400;
		oframe = new OpenGLFrame(biomorph, size);
		add(oframe.getCanvas());
		setVisible(true);
	}
	/**
	 * Changes the size of this panel. The length and width will always be the same.
	 * @param size The new size for the panel
	 */
	public void resize(int newSize)
	{
		this.size = newSize;
		setSize(size, size);
		oframe.getCanvas().setSize(size, size);
	}
	/**
	 * Changes the biomorph to be displayed on the canvas.
	 * @param biomorph The new biomorph to display
	 */
	public void setBiomorph(Biomorph biomorph)
	{
		oframe.setBiomorph(biomorph);
	}
}