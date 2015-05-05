package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import biomorphHandling.Biomorph;
/**
 * A panel containing various sliders to modify a biomorph.
 * @author Jack Taylor, Tom Connolly
 * @version 05/05/2015
 */
public class BiomorphCustomisation extends JPanel
{
	private static final long serialVersionUID = -6272615682510345410L;
	private JPanel modifyPane;
	private JButton back;
	private Biomorph biomorph;
	private JSlider[] sliders;
	private JLabel[] labels;
	private String[] geneNames = {"Branch", "Chain", "Length", "Length Increment", "Thickness", "Thickness Increment", "Red Level", "Green Level", "Blue Level", "Red Iridescence Level", "Green Iridescence Level", "Blue Iridescence Level"};
	/**
	 * Constructor
	 * @param tempBiomorph The biomorph referenced by this panel
	 * @param returnPanel The panel to reactivate when the Back button is pressed
	 * @param size The length of the sliders
	 */
	public BiomorphCustomisation(final Biomorph tempBiomorph, final JPanel returnPanel, int size)
	{
		super(new BorderLayout());
		this.biomorph = tempBiomorph;
		modifyPane = new JPanel();
		sliders = new JSlider[12];
		labels = new JLabel[12];
		for (int i = 0; i < geneNames.length; i++)
		{
			JSlider slider = new JSlider();
			JLabel label = new JLabel(geneNames[i] + ": " + biomorph.getGenes()[i].getValue());
			label.setLabelFor(slider);
			labels[i] = label;
			sliders[i] = slider;
			modifyPane.add(label);
			modifyPane.add(slider);
		}
		modifyPane.setLayout(new BoxLayout(modifyPane, BoxLayout.Y_AXIS));
		back = new JButton();
		back.setText("Back");
		modifyPane.add(back);
		add(modifyPane, BorderLayout.NORTH);
		sliders[Biomorph.BRANCH].setMinimum(3);
		sliders[Biomorph.BRANCH].setMaximum(10);
		sliders[Biomorph.CHAIN].setMinimum(1);
		sliders[Biomorph.CHAIN].setMaximum(3);
		sliders[Biomorph.LENGTH].setMinimum(1);
		sliders[Biomorph.LENGTH].setMaximum(8);
		sliders[Biomorph.LENGTH_INCREMENT].setMinimum(-3);
		sliders[Biomorph.LENGTH_INCREMENT].setMaximum(3);
		sliders[Biomorph.THICKNESS].setMinimum(1);
		sliders[Biomorph.THICKNESS].setMaximum(10);
		sliders[Biomorph.THICKNESS_INCREMENT].setMinimum(-3);
		sliders[Biomorph.THICKNESS_INCREMENT].setMaximum(3);
		sliders[Biomorph.COLOR_RED].setMinimum(0);
		sliders[Biomorph.COLOR_RED].setMaximum(255);
		sliders[Biomorph.COLOR_GREEN].setMinimum(0);
		sliders[Biomorph.COLOR_GREEN].setMaximum(255);
		sliders[Biomorph.COLOR_BLUE].setMinimum(0);
		sliders[Biomorph.COLOR_BLUE].setMaximum(255);
		sliders[Biomorph.IRIDESCENCE_RED].setMinimum(-16);
		sliders[Biomorph.IRIDESCENCE_RED].setMaximum(16);
		sliders[Biomorph.IRIDESCENCE_GREEN].setMinimum(-16);
		sliders[Biomorph.IRIDESCENCE_GREEN].setMaximum(16);
		sliders[Biomorph.IRIDESCENCE_BLUE].setMinimum(-16);
		sliders[Biomorph.IRIDESCENCE_BLUE].setMaximum(16);
		labels[Biomorph.BRANCH].setToolTipText("Number of arms breaking off each arm intersection");
		labels[Biomorph.CHAIN].setToolTipText("Number of arms in the arm chain from the centre of the Biomorph to the edge");
		labels[Biomorph.LENGTH].setToolTipText("Length of each arm in the biomorph");
		labels[Biomorph.LENGTH_INCREMENT].setToolTipText("Difference in length between the first tier of arms and the last");
		labels[Biomorph.THICKNESS].setToolTipText("Thickness of each arm");
		labels[Biomorph.THICKNESS_INCREMENT].setToolTipText("Difference in thickness between the first tier of arms and the last");
		labels[Biomorph.COLOR_RED].setToolTipText("Decimal representation of red colour level");
		labels[Biomorph.COLOR_GREEN].setToolTipText("Decimal representation of green colour level");
		labels[Biomorph.COLOR_BLUE].setToolTipText("Decimal representation of green colour level");
		labels[Biomorph.IRIDESCENCE_RED].setToolTipText("Red value changes across the biomorph");
		labels[Biomorph.IRIDESCENCE_GREEN].setToolTipText("Green value changes across the biomorph");
		labels[Biomorph.IRIDESCENCE_BLUE].setToolTipText("Blue value changes across the biomorph");
		for (int i = 0; i < sliders.length; i++)
		{
			sliders[i].setValue(biomorph.getGenes()[i].getValue());
			sliders[i].setPreferredSize(new Dimension(modifyPane.getWidth() - 10, 20));
		}
		sliders[Biomorph.BRANCH].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				biomorph.updateGene(((JSlider) c.getSource()).getValue(), "Branch");
				labels[Biomorph.BRANCH].setText(geneNames[Biomorph.BRANCH] + ": " + biomorph.getGenes()[Biomorph.BRANCH].getValue());
			}
		});
		sliders[Biomorph.CHAIN].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				biomorph.updateGene(((JSlider) c.getSource()).getValue(), "Chain");
				labels[Biomorph.CHAIN].setText(geneNames[Biomorph.CHAIN] + ": " + biomorph.getGenes()[Biomorph.CHAIN].getValue());
			}
		});
		sliders[Biomorph.LENGTH].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				biomorph.updateGene(((JSlider) c.getSource()).getValue(), "Length");
				labels[Biomorph.LENGTH].setText(geneNames[Biomorph.LENGTH] + ": " + biomorph.getGenes()[Biomorph.LENGTH].getValue());
			}
		});
		sliders[Biomorph.LENGTH_INCREMENT].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				biomorph.updateGene(((JSlider) c.getSource()).getValue(), "Length Increment");
				labels[Biomorph.LENGTH_INCREMENT].setText(geneNames[Biomorph.LENGTH_INCREMENT] + ": " + biomorph.getGenes()[Biomorph.LENGTH_INCREMENT].getValue());
			}
		});
		sliders[Biomorph.THICKNESS].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				biomorph.updateGene(((JSlider) c.getSource()).getValue(), "Thickness");
				labels[Biomorph.THICKNESS].setText(geneNames[Biomorph.THICKNESS] + ": " + biomorph.getGenes()[Biomorph.THICKNESS].getValue());
			}
		});
		sliders[Biomorph.THICKNESS_INCREMENT].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				biomorph.updateGene(((JSlider) c.getSource()).getValue(), "Thickness Increment");
				labels[Biomorph.THICKNESS_INCREMENT].setText(geneNames[Biomorph.THICKNESS_INCREMENT] + ": " + biomorph.getGenes()[Biomorph.THICKNESS_INCREMENT].getValue());
			}
		});
		sliders[Biomorph.COLOR_RED].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				biomorph.updateGene(((JSlider) c.getSource()).getValue(), "Color Red");
				labels[Biomorph.COLOR_RED].setText(geneNames[Biomorph.COLOR_RED] + ": " + biomorph.getGenes()[Biomorph.COLOR_RED].getValue());
			}
		});
		sliders[Biomorph.COLOR_GREEN].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				biomorph.updateGene(((JSlider) c.getSource()).getValue(), "Color Green");
				labels[Biomorph.COLOR_GREEN].setText(geneNames[Biomorph.COLOR_GREEN] + ": " + biomorph.getGenes()[Biomorph.COLOR_GREEN].getValue());
			}
		});
		sliders[Biomorph.COLOR_BLUE].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				biomorph.updateGene(((JSlider) c.getSource()).getValue(), "Color Blue");
				labels[Biomorph.COLOR_BLUE].setText(geneNames[Biomorph.COLOR_BLUE] + ": " + biomorph.getGenes()[Biomorph.COLOR_BLUE].getValue());
			}
		});
		sliders[Biomorph.IRIDESCENCE_RED].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				biomorph.updateGene(((JSlider) c.getSource()).getValue(), "Iridescence Red");
				labels[Biomorph.IRIDESCENCE_RED].setText(geneNames[Biomorph.IRIDESCENCE_RED] + ": " + biomorph.getGenes()[Biomorph.IRIDESCENCE_RED].getValue());
			}
		});
		sliders[Biomorph.IRIDESCENCE_GREEN].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				biomorph.updateGene(((JSlider) c.getSource()).getValue(), "Iridescence Green");
				labels[Biomorph.IRIDESCENCE_GREEN].setText(geneNames[Biomorph.IRIDESCENCE_GREEN] + ": " + biomorph.getGenes()[Biomorph.IRIDESCENCE_GREEN].getValue());
			}
		});
		sliders[Biomorph.IRIDESCENCE_BLUE].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				biomorph.updateGene(((JSlider) c.getSource()).getValue(), "Iridescence Blue");
				labels[Biomorph.IRIDESCENCE_BLUE].setText(geneNames[Biomorph.IRIDESCENCE_BLUE] + ": " + biomorph.getGenes()[Biomorph.IRIDESCENCE_BLUE].getValue());
			}
		});
		final BiomorphCustomisation bc = this;
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JPanel parent = (JPanel) getParent();
				parent.remove(bc);
				parent.add(returnPanel);
				parent.revalidate();
			}
		});
		resize(size);
	}
	/**
	 * Changes the biomorph referenced by this panel.
	 * @param biomorph The new biomorph to reference
	 */
	public void setBiomorph(Biomorph biomorph)
	{
		this.biomorph = biomorph;
		for (int i = 0; i < sliders.length; i++) sliders[i].setValue(biomorph.getGenes()[i].getValue());
	}
	/**
	 * Changes the size of the panel and the length of the sliders.
	 * @param size The new size of the panel
	 */
	public void resize(int size)
	{
		setSize(size, 400);
		modifyPane.setSize(size, 400);
		for (int i = 0; i < sliders.length; i++) sliders[i].setPreferredSize(new Dimension(modifyPane.getWidth() - 10, 20));
		revalidate();
	}
	/**
	 * Main method for testing
	 */
	public static void main(String[] args)
	{
		Biomorph biomorph = new Biomorph(null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		JPanel panel = new JPanel();
		new BiomorphCustomisation(biomorph, panel, 0);
	}
}