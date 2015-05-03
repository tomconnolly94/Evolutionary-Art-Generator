package gui;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import biomorphHandling.Biomorph;
/**
 * The large biomorph panel for the GUI.
 * @author Jack Taylor
 * @version 30/04/2015
 */
public class MainBiomorphPanel extends JPanel
{
	private static final long serialVersionUID = 9104451169664277399L;
	private OpenGLCanvas canvas;
	private int size;
	/**
	 * Constructor
	 * @param biomorph The biomorph used to initialise the OpenGL window
	 */
	public MainBiomorphPanel(Biomorph biomorph)
	{
		super();
		size = 400;
		canvas = new OpenGLCanvas(biomorph, size);
		add(canvas.getCanvas());
		setBorder(new EmptyBorder(-5, -5, -3, -5));
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
		canvas.getCanvas().setSize(size, size);
	}
	/**
	 * Returns the biomorph displayed on the canvas.
	 */
	public Biomorph getBiomorph()
	{
		return canvas.getBiomorph();
	}
	/**
	 * Changes the biomorph to be displayed on the canvas.
	 * @param biomorph The new biomorph to display
	 */
	public void setBiomorph(Biomorph biomorph)
	{
		canvas.setBiomorph(biomorph);
	}
}