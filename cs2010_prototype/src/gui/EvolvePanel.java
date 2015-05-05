package gui;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
public class EvolvePanel extends JPanel
{
	private static final long serialVersionUID = 2448675112978172097L;
	private JButton evolve;
	private JButton reset;
	private JButton loadToMainWindow;
	private JButton loadMother;
	private JButton loadFather;
	private JButton resetToOriginal;
	public EvolvePanel(GraphicsMain gm)
	{
		super(new GridLayout(0, 2));
		evolve = new JButton("Create");
		reset = new JButton("Reset");
		loadToMainWindow = new JButton("Load to main window");
		loadMother = new JButton("Load mother");
		loadFather = new JButton("Load father");
		resetToOriginal = new JButton("Reset to original Biomorph");
		evolve.setToolTipText("This button allows evolution of the live Biomorph and\n whichever Biomorphs are selected below.");
		reset.setToolTipText("This button removes all existing Biomorphs (excluding Hall of Fame) and generates 9 new ones.");
		loadToMainWindow.setToolTipText("This button loads the Biomorph selected using the checkboxes below to the live window");
		loadMother.setToolTipText("This button loads the live Biomorph's data-biological mother");
		loadFather.setToolTipText("This button loads the live Biomorph's data-biological mother");
		resetToOriginal.setToolTipText("This button reloads the originally evolved Biomorph when the parent controls are used.");
		evolve.addActionListener(gm);
		reset.addActionListener(gm);
		loadToMainWindow.addActionListener(gm);
		loadMother.addActionListener(gm);
		loadFather.addActionListener(gm);
		resetToOriginal.addActionListener(gm);
		add(evolve);
		add(reset);
		add(loadToMainWindow);
		add(Box.createRigidArea(new Dimension(0, 5)));
		add(loadMother);
		add(loadFather);
		add(resetToOriginal);
	}
	public void setEvolveText(boolean evolveText)
	{
		if (evolveText == true) evolve.setText("Evolve");
		else evolve.setText("Create");
	}
}