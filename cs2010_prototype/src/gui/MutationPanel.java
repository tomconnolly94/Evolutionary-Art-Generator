package gui;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import biomorphHandling.Biomorph;
/**
 * Class for the mutation panel. This contains 8 biomorphs for evolution.
 * @author Jack Taylor
 * @version 04/05/2015
 */
public class MutationPanel extends JPanel
{
	private static final long serialVersionUID = -2142660654932148667L;
	protected JPanel panel[];
	protected OpenGLCanvas canvas[];
	protected int size;
	/**
	 * Constructor
	 * @param biomorphs The array of biomorphs for initialising the OpenGL canvases.
	 */
	public MutationPanel(Biomorph biomorphs[])
	{
		super(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		size = 100;
		panel = new JPanel[8];
		canvas = new OpenGLCanvas[8];
		for (int i = 0; i < panel.length; i++) panel[i] = new JPanel();
		for (int i = 0; i < canvas.length; i++)
		{
			if (i < biomorphs.length && biomorphs[i] != null) canvas[i] = new OpenGLCanvas(biomorphs[i], size);
			else canvas[i] = new OpenGLCanvas(null, size);
			panel[i].add(canvas[i].getCanvas());
		}
		for (int i = 0; i < panel.length; i++)
		{	
			gbc.gridx = i % 4;
			gbc.gridy = i / 4;
			add(panel[i], gbc);
			if (gbc.gridx == 3) panel[i].setBorder(new EmptyBorder(-5, -5, -4, -5));
			else panel[i].setBorder(new EmptyBorder(-5, -5, -4, -4));
		}
		setVisible(true);
	}
	/**
	 * Changes the size of each OpenGL canvas. The length and width will always be the same.
	 * @param size The new size for the canvases
	 */
	public void resize(int newSize)
	{
		this.size = newSize;
		for (int i = 0; i < panel.length; i++) panel[i].setSize(size, size);
		for (int i = 0; i < canvas.length; i++) canvas[i].getCanvas().setSize(size, size);
	}
	/**
	 * Returns the biomorph displayed on a specified canvas.
	 */
	public Biomorph getBiomorph(int index)
	{
		Biomorph biomorph;
		if (index < canvas.length) biomorph = canvas[index].getBiomorph();
		else biomorph = null;
		return biomorph;
	}
	/**
	 * Changes the biomorph to be displayed on a specified canvas.
	 * @param index The canvas to change
	 * @param biomorph The new biomorph to display
	 */
	public void setBiomorph(int index, Biomorph biomorph)
	{
		canvas[index].setBiomorph(biomorph);
	}
}