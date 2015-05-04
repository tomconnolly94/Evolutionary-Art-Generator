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
		modifyButton = new JButton("Modify");
		// Add components to panels
		buttonPanel.add(modifyButton);
		add(buttonPanel);
		modifyButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (biomorph != null)
				{
					remove(buttonPanel);
					bc = new BiomorphCustomisation(biomorph, buttonPanel);
					add(bc);
					revalidate();
				}
				else
				{
					JOptionPane.showMessageDialog(buttonPanel, "There is no biomorph to modify.");
				}
			}
		});
	}
	public void reset()
	{
		remove(bc);
		add(buttonPanel);
		revalidate();
	}
	public void update(Biomorph biomorph)
	{
		this.biomorph = biomorph;
		bc.setBiomorph(biomorph);
		revalidate();
	}
	public void resize(int size)
	{
		setSize(size, 600);
		buttonPanel.setSize(size, 100);
		bc.resize(size);
	}
	public static void main(String[] args)
	{
		Biomorph biomorph = new Biomorph(null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		new RightPanel(biomorph);
	}
}