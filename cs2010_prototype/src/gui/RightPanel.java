package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import biomorphHandling.Biomorph;
/**
 * The right panel of the GUI
 * @author Charandeep Rai, Jack Taylor, Tom Connolly
 * @version 04/05/2015
 */
public class RightPanel extends JPanel
{
	private static final long serialVersionUID = -2321973355804771565L;
	// Panels used
	private JPanel buttonPanel;
	private JPanel sliderPanel;
	private JButton modifyButton;
	private Biomorph biomorph;
	private BiomorphCustomisation bc;
	public RightPanel(Biomorph biomorph)
	{
		bc = new BiomorphCustomisation(new Biomorph(null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), buttonPanel);
		this.biomorph = biomorph;
		initiate();
	}
	public void initiate()
	{
		// Initialise panels and button
		buttonPanel = new JPanel();
		sliderPanel = new JPanel();
		modifyButton = new JButton("Modify");
		// Add components to panels
		buttonPanel.add(modifyButton);
		sliderPanel.add(buttonPanel);
		add(sliderPanel);
		modifyButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (biomorph != null)
				{
					sliderPanel.remove(buttonPanel);
					bc = new BiomorphCustomisation(biomorph, buttonPanel);
					sliderPanel.add(bc);
					sliderPanel.revalidate();
					sliderPanel.repaint();
				}
			}
		});
	}
	public void resetRightPanel()
	{
		sliderPanel.remove(sliderPanel.getComponent(0));
		sliderPanel.add(buttonPanel);
		sliderPanel.revalidate();
		sliderPanel.repaint();
	}
	public void update(Biomorph biomorph)
	{
		this.biomorph = biomorph;
	}
	public void resize(int size)
	{
		bc.resize(size);
	}
	public static void main(String[] args)
	{
		Biomorph biomorph = new Biomorph(null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		new RightPanel(biomorph);
	}
}