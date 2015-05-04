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
	private int size;
	/**
	 * Constructor
	 * @param biomorph The biomorph referenced by this panel
	 * @param size The size of the panel
	 */
	public RightPanel(Biomorph biomorph, int size)
	{
		super();
		this.size = size;
		bc = new BiomorphCustomisation(new Biomorph(null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), buttonPanel, size);
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
					bc = new BiomorphCustomisation(biomorph, buttonPanel, size);
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
	/**
	 * Resets the panel to its original state.
	 */
	public void reset()
	{
		remove(bc);
		add(buttonPanel);
		revalidate();
	}
	/**
	 * Changes the biomorph referenced by this panel.
	 * @param biomorph The new biomorph
	 */
	public void update(Biomorph biomorph)
	{
		this.biomorph = biomorph;
		bc.setBiomorph(biomorph);
		revalidate();
	}
	/**
	 * Resizes this panel.
	 * @param newSize The new size of the panel
	 */
	public void resize(int newSize)
	{
		size = newSize;
		setSize(size, 600);
		buttonPanel.setSize(size, 100);
		bc.resize(size);
	}
	/**
	 * Main method for testing
	 */
	public static void main(String[] args)
	{
		Biomorph biomorph = new Biomorph(null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		new RightPanel(biomorph, 100);
	}
}