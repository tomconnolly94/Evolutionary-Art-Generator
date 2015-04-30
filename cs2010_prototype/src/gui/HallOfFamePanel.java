package gui;
import biomorphHandling.Biomorph;
public class HallOfFamePanel extends LowerBiomorphPanel
{
	private static final long serialVersionUID = -8545611875997727849L;
	/**
	 * Constructor
	 * @param biomorphs The array of biomorphs for initialising the OpenGL canvases.
	 */
	public HallOfFamePanel(Biomorph biomorphs[])
	{
		super(biomorphs);
	}
}