package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import biomorphHandling.Biomorph;
import biomorphHandling.BiomorphManager;
/**
 * The right panel of the GUI
 * @author Charandeep Rai
 */
public class RightPanel extends JPanel
{
	// Panels used
	private JPanel buttonPanel;
	private JPanel secondPanel;
	private JButton modifyButton;
	private Biomorph biomorph;
	private BiomorphCustomisation bc;
	private BiomorphManager bm;
	public RightPanel(BiomorphManager bm, Biomorph biomorph)
	{
		bc = new BiomorphCustomisation(new Biomorph(null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), buttonPanel);
		// this.mainPanel = mainPanel;
		this.biomorph = biomorph;
		this.bm = bm;
		initiate();
	}
	public void initiate()
	{
		buttonPanel = new JPanel();
		modifyButton = new JButton("Modify");
		buttonPanel.add(modifyButton);
		add(buttonPanel);
//		buttonPanel = new JPanel();
//		secondPanel = new JPanel();
//		// add components to panel
//		buttonPanel.add(modifyButton);
//		secondPanel.add(buttonPanel);
//		// add panel to frame
//		add(secondPanel);
		modifyButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (biomorph != null)
				{
					buttonPanel.remove(modifyButton);
					bc = new BiomorphCustomisation(biomorph, buttonPanel);
					JPanel bc2 = bc.getContents();
					buttonPanel.add(bc2);
					revalidate();
					repaint();
				}
			}
		});
	}
	public void resetRightPanel()
	{
		secondPanel.remove(secondPanel.getComponent(0));
		secondPanel.add(buttonPanel);
		secondPanel.revalidate();
		secondPanel.repaint();
	}
	public void update(BiomorphManager bm, Biomorph biomorph)
	{
		this.bm = bm;
		this.biomorph = biomorph;
		bc.updateBiomorph(biomorph);
	}
	public void resize(int size)
	{
		bc.resize(size);
	}
	public static void main(String[] args)
	{
		BiomorphManager bm = new BiomorphManager();
		Biomorph biomorph = new Biomorph(null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		MainBiomorphPanel mbp = new MainBiomorphPanel(biomorph);
		RightPanel rp = new RightPanel(bm, biomorph);
	}
}