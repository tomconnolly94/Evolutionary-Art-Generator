package gui;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import biomorphHandling.Biomorph;
/**
 * Abstract class for the lower biomorph panel. This can either be the mutation panel or the Hall of Fame panel.
 * @author Jack Taylor
 * @version 30/04/2015
 */
public abstract class LowerBiomorphPanel extends JPanel
{
	private static final long serialVersionUID = -2142660654932148667L;
	protected OpenGLFrame oframe[];
	protected int size;
	/**
	 * Constructor
	 * @param biomorphs The array of biomorphs for initialising the OpenGL canvases.
	 */
	public LowerBiomorphPanel(Biomorph biomorphs[])
	{
		super(new GridBagLayout());
		size = 100;
		oframe = new OpenGLFrame[8];
		for (int i = 0; i < oframe.length; i++) oframe[i] = new OpenGLFrame(biomorphs[i], size);
		setVisible(true);
	}
	/**
	 * Changes the size of each OpenGL canvas. The length and width will always be the same.
	 * @param size The new size for the canvases
	 */
	public void resize(int newSize)
	{
		this.size = newSize;
		setSize(size, size);
		for (int i = 0; i < oframe.length; i++) oframe[i].getCanvas().setSize(size, size);
	}
	/**
	 * Changes the biomorph to be displayed on a specified canvas.
	 * @param index The canvas to change
	 * @param biomorph The new biomorph to display
	 */
	public void setBiomorph(int index, Biomorph biomorph)
	{
		oframe[index].setBiomorph(biomorph);
	}
}