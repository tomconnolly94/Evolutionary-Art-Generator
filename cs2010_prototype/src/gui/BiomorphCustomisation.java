package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import biomorphHandling.Biomorph;
public class BiomorphCustomisation
{
	private static JPanel modifyPane;
	private static JPanel backPane;
	private static JFrame viewFrame;
	private static JButton back;
	private Biomorph biomorph;
	private JSlider[] sliders;
	private JPanel returnPanel;
	private String[] geneNames = {"Branch", "Chain", "Red Level", "Green Level", "Blue Level", "Length", "Length Increment", "Thickness", "Thickness Increment", "Red Iridescence Level", "Green Iridescence Level", "Blue Iridescence Level"};;
	public BiomorphCustomisation(final Biomorph biomorph, final JPanel returnPanel)
	{
		this.returnPanel = returnPanel;
		this.biomorph = biomorph;
		viewFrame = new JFrame();
		viewFrame.setSize(new Dimension(168, 470));
		modifyPane = new JPanel();
		backPane = new JPanel();
		sliders = new JSlider[12];
		for (int i = 0; i < geneNames.length; i++)
		{
			JLabel label = new JLabel(geneNames[i]);
			JSlider slider = new JSlider();
			label.setLabelFor(slider);
			sliders[i] = slider;
			modifyPane.add(label);
			modifyPane.add(slider);
		}
		sliders[Biomorph.BRANCH].setMinimum(3);
		sliders[Biomorph.BRANCH].setMaximum(10);
		sliders[Biomorph.BRANCH].setValue(biomorph.getGenes()[Biomorph.BRANCH].getValue());
		sliders[Biomorph.CHAIN].setMinimum(1);
		sliders[Biomorph.CHAIN].setMaximum(3);
		sliders[Biomorph.CHAIN].setValue(biomorph.getGenes()[Biomorph.CHAIN].getValue());
		sliders[Biomorph.COLOR_RED].setMinimum(0);
		sliders[Biomorph.COLOR_RED].setMaximum(255);
		sliders[Biomorph.COLOR_RED].setValue(biomorph.getGenes()[Biomorph.COLOR_RED].getValue());
		sliders[Biomorph.COLOR_GREEN].setMinimum(0);
		sliders[Biomorph.COLOR_GREEN].setMaximum(255);
		sliders[Biomorph.COLOR_GREEN].setValue(biomorph.getGenes()[Biomorph.COLOR_GREEN].getValue());
		sliders[Biomorph.COLOR_BLUE].setMinimum(0);
		sliders[Biomorph.COLOR_BLUE].setMaximum(255);
		sliders[Biomorph.COLOR_BLUE].setValue(biomorph.getGenes()[Biomorph.COLOR_BLUE].getValue());
		sliders[Biomorph.LENGTH].setMinimum(1);
		sliders[Biomorph.LENGTH].setMaximum(8);
		sliders[Biomorph.LENGTH].setValue(biomorph.getGenes()[Biomorph.LENGTH].getValue());
		sliders[Biomorph.LENGTH_INCREMENT].setMinimum(-3);
		sliders[Biomorph.LENGTH_INCREMENT].setMaximum(3);
		sliders[Biomorph.LENGTH_INCREMENT].setValue(biomorph.getGenes()[Biomorph.LENGTH_INCREMENT].getValue());
		sliders[Biomorph.THICKNESS].setMinimum(1);
		sliders[Biomorph.THICKNESS].setMaximum(10);
		sliders[Biomorph.THICKNESS].setValue(biomorph.getGenes()[Biomorph.THICKNESS].getValue());
		sliders[Biomorph.THICKNESS_INCREMENT].setMinimum(-3);
		sliders[Biomorph.THICKNESS_INCREMENT].setMaximum(3);
		sliders[Biomorph.THICKNESS_INCREMENT].setValue(biomorph.getGenes()[Biomorph.THICKNESS_INCREMENT].getValue());
		sliders[Biomorph.IRIDESCENCE_RED].setMinimum(-16);
		sliders[Biomorph.IRIDESCENCE_RED].setMaximum(16);
		sliders[Biomorph.IRIDESCENCE_RED].setValue(biomorph.getGenes()[Biomorph.IRIDESCENCE_RED].getValue());
		sliders[Biomorph.IRIDESCENCE_GREEN].setMinimum(-16);
		sliders[Biomorph.IRIDESCENCE_GREEN].setMaximum(16);
		sliders[Biomorph.IRIDESCENCE_GREEN].setValue(biomorph.getGenes()[Biomorph.IRIDESCENCE_GREEN].getValue());
		sliders[Biomorph.IRIDESCENCE_BLUE].setMinimum(-16);
		sliders[Biomorph.IRIDESCENCE_BLUE].setMaximum(16);
		sliders[Biomorph.IRIDESCENCE_BLUE].setValue(biomorph.getGenes()[Biomorph.IRIDESCENCE_BLUE].getValue());
		modifyPane.setLayout(new BoxLayout(modifyPane, BoxLayout.Y_AXIS));
		// modifyPane.setBorder(BorderFactory.createLineBorder(Color.black));
		back = new JButton();
		back.setText("Back");
		backPane.add(back);
		JPanel secondPanel = new JPanel(new BorderLayout());
		secondPanel.setSize(new Dimension(168, 608));
		secondPanel.add(modifyPane, BorderLayout.NORTH);
		secondPanel.add(backPane, BorderLayout.SOUTH);
		viewFrame.add(secondPanel);
		System.out.println(secondPanel.getSize() + "1");
		sliders[Biomorph.BRANCH].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				biomorph.updateGene(((JSlider)c.getSource()).getValue(), "Branch");
				System.out.println("");
				System.out.println("ITERATION NEW");
				System.out.println("");
				for (int i = 0; i < geneNames.length; i++)
				{
					System.out.println(biomorph.getGenes()[i].getGeneType());
					System.out.println(biomorph.getGenes()[i].getValue());
				}
			}
		});
		sliders[Biomorph.CHAIN].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				biomorph.updateGene(((JSlider)c.getSource()).getValue(), "Chain");
			}
		});
		sliders[Biomorph.COLOR_RED].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				biomorph.updateGene(((JSlider)c.getSource()).getValue(), "Color Red");
			}
		});
		sliders[Biomorph.COLOR_GREEN].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				biomorph.updateGene(((JSlider)c.getSource()).getValue(), "Color Green");
			}
		});
		sliders[Biomorph.COLOR_BLUE].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				biomorph.updateGene(((JSlider)c.getSource()).getValue(), "Color Blue");
			}
		});
		sliders[Biomorph.LENGTH].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				biomorph.updateGene(((JSlider)c.getSource()).getValue(), "Length");
			}
		});
		sliders[Biomorph.LENGTH_INCREMENT].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				biomorph.updateGene(((JSlider)c.getSource()).getValue(), "Length Increment");
			}
		});
		sliders[Biomorph.THICKNESS].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				biomorph.updateGene(((JSlider)c.getSource()).getValue(), "Thickness");
			}
		});
		sliders[Biomorph.THICKNESS_INCREMENT].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				biomorph.updateGene(((JSlider)c.getSource()).getValue(), "Thickness Increment");
			}
		});
		sliders[Biomorph.IRIDESCENCE_RED].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				biomorph.updateGene(((JSlider)c.getSource()).getValue(), "Iridescence Red");
			}
		});
		sliders[Biomorph.IRIDESCENCE_GREEN].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				biomorph.updateGene(((JSlider)c.getSource()).getValue(), "Iridescence Green");
			}
		});
		sliders[Biomorph.IRIDESCENCE_BLUE].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				biomorph.updateGene(((JSlider)c.getSource()).getValue(), "Iridescence Blue");
			}
		});
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JPanel secondPanel = (JPanel) viewFrame.getContentPane().getParent();
				secondPanel.remove(viewFrame.getContentPane());
				secondPanel.add(returnPanel);
				secondPanel.revalidate();
			}
		});
		// viewFrame.pack();
		// viewFrame.setVisible(true);
	}
	public JPanel getContents()
	{
		return (JPanel) viewFrame.getContentPane();
	}
	public void updateBiomorph(Biomorph biomorph)
	{
		this.biomorph = biomorph;
	}
	public void resize(int size)
	{
		modifyPane.setSize(size, 600);
		for (int i = 0; i < sliders.length; i++) sliders[i].setPreferredSize(new Dimension(modifyPane.getWidth(), 20));
	}
	public static void main(String[] args)
	{
		Biomorph biomorph = new Biomorph(null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		MainBiomorphPanel mbp = new MainBiomorphPanel(biomorph);
		JPanel panel = new JPanel();
		BiomorphCustomisation bc = new BiomorphCustomisation(biomorph, panel);
	}
}