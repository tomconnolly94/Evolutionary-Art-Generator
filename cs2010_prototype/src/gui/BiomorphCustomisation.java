package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class BiomorphCustomisation
{
	private static JPanel modifyPane;
	private static JPanel colourPane;
	private static JPanel backPane;
	private static JFrame viewFrame;
	private static JButton back;

	public BiomorphCustomisation()
	{
		viewFrame = new JFrame();
		viewFrame.setSize(new Dimension(168, 470));
		modifyPane = new JPanel();
		colourPane = new JPanel();
		backPane = new JPanel();
		String[] geneNames =
		{"Branch", "Chain", "Red Level", "Green Level", "Blue Level", "Length", "Length Increment", "Thickness", "Thickness Increment", "Red Iridescence Level", "Green Iridescence Level", "Blue Iridescence Level"};
		JSlider[] sliders = new JSlider[12];
		for (int i = 0; i < geneNames.length; i++)
		{
			JLabel label = new JLabel(geneNames[i]);
			JSlider slider = new JSlider();
			label.setLabelFor(slider);
			sliders[i] = slider;
			modifyPane.add(label);
			modifyPane.add(slider);
		}
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
				System.out.println(max);
			}
		});
		sliders[1].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue())*0.02+1);
				System.out.println(max);
			}
		});
		sliders[2].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue())*2.55);
				System.out.println(max);
			}
		});
		sliders[3].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue())*2.55);
				System.out.println(max);
			}
		});
		sliders[4].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue())*2.55);
				System.out.println(max);
			}
		});
		sliders[5].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue())*0.07+1);
				System.out.println(max);
			}
		});
		sliders[6].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue())*0.06-3);
				System.out.println(max);
			}
		});
		sliders[7].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue())*0.09+1);
				System.out.println(max);
			}
		});
		sliders[8].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue())*0.06-3);
				System.out.println(max);
			}
		});
		sliders[9].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue())*0.32-16);
				System.out.println(max);
			}
		});
		sliders[10].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue())*0.32-16);
				System.out.println(max);
			}
		});
		sliders[11].addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent c)
			{
				int max = (int) ((((JSlider) c.getSource()).getValue())*0.32-16);
				System.out.println(max);
			}
		});
		System.out.println(secondPanel.getSize() + "2");
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				viewFrame.setVisible(false);
				viewFrame.remove(backPane);
				viewFrame.remove(colourPane);
				viewFrame.remove(modifyPane);
				CreateClicked cc = new CreateClicked();
				viewFrame.add(cc.getContents());
			}
		});
		System.out.println(secondPanel.getSize() + "3");
		// viewFrame.pack();
		viewFrame.setVisible(true);
	}
	public JPanel getContents()
	{
		return (JPanel) viewFrame.getContentPane();
	}
	public static void main(String[] args)
	{
		BiomorphCustomisation bc = new BiomorphCustomisation();
		bc.getContents();
	}
}