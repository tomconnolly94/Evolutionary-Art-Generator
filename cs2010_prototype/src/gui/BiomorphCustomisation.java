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
	private String[] geneNames =
		{"Branch", "Chain", "Red Level", "Green Level", "Blue Level", "Length", "Length Increment", "Thickness", "Thickness Increment", "Red Iridescence Level", "Green Iridescence Level", "Blue Iridescence Level"};
;

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
		
		sliders[0].setValue((biomorph.getGenes()[0].getValue()-3)*100/7);
		sliders[1].setValue((biomorph.getGenes()[1].getValue()-1)*50);
		sliders[2].setValue((int) (biomorph.getGenes()[2].getValue()/2.55));
		sliders[3].setValue((int) (biomorph.getGenes()[3].getValue()/2.55));
		sliders[4].setValue((int) (biomorph.getGenes()[4].getValue()/2.55));
		sliders[5].setValue((biomorph.getGenes()[5].getValue()-1)*100/7);
		sliders[6].setValue((biomorph.getGenes()[6].getValue()+3)*100/6);
		sliders[7].setValue((biomorph.getGenes()[7].getValue()-1)*100/9);
		sliders[8].setValue((biomorph.getGenes()[8].getValue()+3)*100/6);
		sliders[9].setValue((biomorph.getGenes()[9].getValue()-16)*100/32);
		sliders[10].setValue((biomorph.getGenes()[10].getValue()-16)*100/32);
		sliders[11].setValue((biomorph.getGenes()[11].getValue()-16)*100/32);
		
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
		
		sliders[0].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue())*0.07+3);
				biomorph.updateGene(max, "Branch");
				System.out.println("");
				System.out.println("ITERATION NEW");
				System.out.println("");
				for(int i=0;i<geneNames.length;i++){
					System.out.println(biomorph.getGenes()[i].getGeneType());
					System.out.println(biomorph.getGenes()[i].getValue());
				}
				
			}
		});
		sliders[1].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue())*0.02+1);
				biomorph.updateGene(max, "Chain");
			}
		});
		sliders[2].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue())*2.55);
				biomorph.updateGene(max, "Color Red");
			}
		});
		sliders[3].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue())*2.55);
				biomorph.updateGene(max, "Color Green");
			}
		});
		sliders[4].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue())*2.55);
				biomorph.updateGene(max, "Color Blue");
			}
		});
		sliders[5].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue())*0.07+1);
				biomorph.updateGene(max, "Length");
			}
		});
		sliders[6].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue())*0.06-3);
				biomorph.updateGene(max, "Length Increment");
			}
		});
		sliders[7].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue())*0.09+1);
				biomorph.updateGene(max, "Thickness");
			}
		});
		sliders[8].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue())*0.06-3);
				biomorph.updateGene(max, "Thickness Increment");
			}
		});
		sliders[9].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue())*0.32-16);
				biomorph.updateGene(max, "Iridescence Red");
			}
		});
		sliders[10].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue())*0.32-16);
				biomorph.updateGene(max, "Iridescence Green");
			}
		});
		sliders[11].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue())*0.32-16);
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
		//viewFrame.setVisible(true);
	}
	public JPanel getContents()
	{
		return (JPanel) viewFrame.getContentPane();
	}
	
	public void updateBiomorph(Biomorph biomorph){
		this.biomorph=biomorph;
	}
	
	public static void main(String[] args)
	{
		Biomorph biomorph = new Biomorph(null, null,0,0,0,0,0,0,0,0,0,0,0,0);
		MainBiomorphPanel mbp = new MainBiomorphPanel(biomorph);
		JPanel panel = new JPanel();
		BiomorphCustomisation bc = new BiomorphCustomisation(biomorph,panel);
	}
}