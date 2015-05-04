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
		sliders[Biomorph.BRANCH].setValue((biomorph.getGenes()[Biomorph.BRANCH].getValue() - 3) * 100 / 7);
		sliders[Biomorph.CHAIN].setValue((biomorph.getGenes()[Biomorph.CHAIN].getValue() - 1) * 50);
		sliders[Biomorph.COLOR_RED].setValue((int) (biomorph.getGenes()[Biomorph.COLOR_RED].getValue() / 2.55));
		sliders[Biomorph.COLOR_GREEN].setValue((int) (biomorph.getGenes()[Biomorph.COLOR_GREEN].getValue() / 2.55));
		sliders[Biomorph.COLOR_BLUE].setValue((int) (biomorph.getGenes()[Biomorph.COLOR_BLUE].getValue() / 2.55));
		sliders[Biomorph.LENGTH].setValue((biomorph.getGenes()[Biomorph.LENGTH].getValue() - 1) * 100 / 7);
		sliders[Biomorph.LENGTH_INCREMENT].setValue((biomorph.getGenes()[Biomorph.LENGTH_INCREMENT].getValue() + 3) * 100 / 6);
		sliders[Biomorph.THICKNESS].setValue((biomorph.getGenes()[Biomorph.THICKNESS].getValue() - 1) * 100 / 9);
		sliders[Biomorph.THICKNESS_INCREMENT].setValue((biomorph.getGenes()[Biomorph.THICKNESS_INCREMENT].getValue() + 3) * 100 / 6);
		sliders[Biomorph.IRIDESCENCE_RED].setValue((biomorph.getGenes()[Biomorph.IRIDESCENCE_RED].getValue() - 16) * 100 / 32);
		sliders[Biomorph.IRIDESCENCE_GREEN].setValue((biomorph.getGenes()[Biomorph.IRIDESCENCE_GREEN].getValue() - 16) * 100 / 32);
		sliders[Biomorph.IRIDESCENCE_BLUE].setValue((biomorph.getGenes()[Biomorph.IRIDESCENCE_BLUE].getValue() - 16) * 100 / 32);
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
				int max = (int) ((((JSlider) c.getSource()).getValue()) * 0.07 + 3);
				biomorph.updateGene(max, "Branch");
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
				int max = (int) ((((JSlider) c.getSource()).getValue()) * 0.02 + 1);
				biomorph.updateGene(max, "Chain");
			}
		});
		sliders[Biomorph.COLOR_RED].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue()) * 2.55);
				biomorph.updateGene(max, "Color Red");
			}
		});
		sliders[Biomorph.COLOR_GREEN].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue()) * 2.55);
				biomorph.updateGene(max, "Color Green");
			}
		});
		sliders[Biomorph.COLOR_BLUE].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue()) * 2.55);
				biomorph.updateGene(max, "Color Blue");
			}
		});
		sliders[Biomorph.LENGTH].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue()) * 0.07 + 1);
				biomorph.updateGene(max, "Length");
			}
		});
		sliders[Biomorph.LENGTH_INCREMENT].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue()) * 0.06 - 3);
				biomorph.updateGene(max, "Length Increment");
			}
		});
		sliders[Biomorph.THICKNESS].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue()) * 0.09 + 1);
				biomorph.updateGene(max, "Thickness");
			}
		});
		sliders[Biomorph.THICKNESS_INCREMENT].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue()) * 0.06 - 3);
				biomorph.updateGene(max, "Thickness Increment");
			}
		});
		sliders[Biomorph.IRIDESCENCE_RED].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue()) * 0.32 - 16);
				biomorph.updateGene(max, "Iridescence Red");
			}
		});
		sliders[Biomorph.IRIDESCENCE_GREEN].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue()) * 0.32 - 16);
				biomorph.updateGene(max, "Iridescence Green");
			}
		});
		sliders[Biomorph.IRIDESCENCE_BLUE].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue()) * 0.32 - 16);
				biomorph.updateGene(max, "Iridescence Blue");
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
		for (int i = 0; i < sliders.length; i++) sliders[i].setPreferredSize(new Dimension(size, 20));
	}
	public static void main(String[] args)
	{
		Biomorph biomorph = new Biomorph(null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		MainBiomorphPanel mbp = new MainBiomorphPanel(biomorph);
		JPanel panel = new JPanel();
		BiomorphCustomisation bc = new BiomorphCustomisation(biomorph, panel);
	}
}