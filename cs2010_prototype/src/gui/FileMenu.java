package gui;
import input_output.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ToolTipManager;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import evolution.EvolutionStats;
import biomorphHandling.Biomorph;
import biomorphHandling.BiomorphManager;
/**
 * The File Menu element of the program
 * @author Charandeep Rai
 * @version 02/05/2015
 */
public class FileMenu extends JComponent implements MenuListener, ActionListener
{
	private static final long serialVersionUID = -6163251826528350603L;
	private JFrame frame;
	private Biomorph biomorph;
	private BiomorphManager bm;
	private GraphicsMain gm;
	private EvolutionStats es;
	public FileMenu(BiomorphManager bm, GraphicsMain gm, EvolutionStats es)
	{
		//These two methods make the file menu "heavyweight" so it draws on top of the canvas.
		JPopupMenu.setDefaultLightWeightPopupEnabled(false);
		ToolTipManager.sharedInstance().setLightWeightPopupEnabled(false);
		this.gm = gm;
		this.bm = bm;
		this.es = es;
		initialise();
	}
	public JPanel getContents()
	{
		return (JPanel)frame.getContentPane();
	}
	protected void initialise()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(createMenuBar("Save", 1));
		frame.pack();
	} 
	private JMenuBar createMenuBar(String name, int depth)
	{
		JMenuBar menubar = new JMenuBar();
		menubar.add(createFileMenu("Biomorph", 4));
		menubar.add(createSettingsMenu("Settings", 4));
		menubar.add(createHallOfFameMenu("Hall Of Fame", 3));
		menubar.add(createHelpMenu("Help", 4));
		return menubar;
	}
	public void updateBiomorph(Biomorph biomorph)
	{
		this.biomorph = biomorph;
	}
	private JMenu createFileMenu(String name, int depth)
	{
		JMenu biomorphMenu = new JMenu("File");
		biomorphMenu.add(createNewMenuItem("New"));
		biomorphMenu.add(createOpenMenuItem("Open"));
		biomorphMenu.add(createSaveMenuItem("Save"));
		return biomorphMenu;
	}
	private JMenu createSettingsMenu(String name, int depth)
	{
		JMenu biomorphMenu = new JMenu("Settings");
		biomorphMenu.add(createEditEvolSettingsItem("Edit evolution settings"));
		biomorphMenu.add(createDisplayEvolStatsItem("Display evolution stats"));
		biomorphMenu.add(createSaveEvolStatsItem("Save evolution stats"));
		return biomorphMenu;
	}
	private JMenu createHallOfFameMenu(String name, int depth)
	{
		JMenu biomorphMenu = new JMenu("Hall of Fame");
		biomorphMenu.add(createAddToHallOfFameItem("Add to Hall of Fame"));
		biomorphMenu.add(createRemoveSelectedItem("Remove Selected"));
		biomorphMenu.add(createClearHallOfFameItem("Clear Hall of Fame"));
		return biomorphMenu;
	}
	private JMenu createHelpMenu(String name, int depth)
	{
		JMenu biomorphMenu = new JMenu("Help");
		biomorphMenu.add(createViewHelpDocItem("View Help Document"));
		return biomorphMenu;
	}
	private JMenuItem createNewMenuItem(String name)
	{
		final JMenuItem jMenuItem = new JMenuItem(name);
		jMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent n)
			{
				JOptionPane.showMessageDialog(jMenuItem, "New!");
			}
		});
		return jMenuItem;
	}
	private JMenuItem createEditEvolSettingsItem(String name)
	{
		final JMenuItem jMenuItem = new JMenuItem(name);
		jMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent n)
			{
				//create Panels
				JPanel outer = new JPanel(new BorderLayout());
				JPanel radioButtons = new JPanel();
				final JPanel inputPanel = new JPanel();
				inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
				
				//create buttons
				ButtonGroup bg = new ButtonGroup();
				final JRadioButton button1 = new JRadioButton("Use target values to evolve",true);
				final JRadioButton button2 = new JRadioButton("Use avg of parents to evolve", false);
				
				//add buttons to button group
				bg.add(button1);
				bg.add(button2);
				
				String[] geneNames = {"Branch","Chain Gene","Colour Red","Colour Green","Colour Blue","Length","Length Increment","Thickness","Thickness Increment","Iridescence Red","Iridescence Green","Iridescence Blue"};
							     
				JTextField[] tfa = new JTextField[12];
				for(int i=0;i<12;i++){
					JTextField gene = new JTextField(2);
					tfa[i] = gene;
					inputPanel.add(new JLabel(geneNames[i]));
					inputPanel.add(gene);
					inputPanel.add(Box.createHorizontalStrut(15));
				}
				
				button1.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e)
					{
						inputPanel.setVisible(true);
					}
					
				});
				button2.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e)
					{
						inputPanel.setVisible(false);
					}
					
				});

				
				radioButtons.add(button1);
				radioButtons.add(button2);
				
				outer.add(radioButtons, BorderLayout.NORTH);
				outer.add(inputPanel, BorderLayout.SOUTH);
				
				JOptionPane.showConfirmDialog(null, outer, 
			               "Enter Target Gene Values", JOptionPane.OK_CANCEL_OPTION);
				System.out.println(Integer.parseInt(tfa[0].getText()));
				bm.updateTargetValues(Integer.parseInt(tfa[0].getText()), Integer.parseInt(tfa[1].getText()), Integer.parseInt(tfa[2].getText()), Integer.parseInt(tfa[3].getText()), Integer.parseInt(tfa[4].getText()), Integer.parseInt(tfa[5].getText()), Integer.parseInt(tfa[6].getText()), Integer.parseInt(tfa[7].getText()), Integer.parseInt(tfa[8].getText()), Integer.parseInt(tfa[9].getText()), Integer.parseInt(tfa[10].getText()), Integer.parseInt(tfa[11].getText()));
				bm.printTargetValues();
			}
		});
		return jMenuItem;
	}
	private JMenuItem createDisplayEvolStatsItem(String name)
	{
		final JMenuItem jMenuItem = new JMenuItem(name);
		jMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent n)
			{
				JFrame frame = new JFrame();
				JTextArea textArea = es.returnStats();
				textArea.setEditable(false);
				frame.add(textArea);
				frame.pack();
				frame.setVisible(true);
			}
		});
		return jMenuItem;
	}
	private JMenuItem createSaveEvolStatsItem(String name)
	{
		final JMenuItem jMenuItem = new JMenuItem(name);
		jMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent n)
			{
				String response = JOptionPane.showInputDialog(frame, "Please enter a file name:", null);

				new SaveStatsToText(es.getRunningStats(), response);
			}
		});
		return jMenuItem;
	}
	private JMenuItem createViewHelpDocItem(String name)
	{
		final JMenuItem jMenuItem = new JMenuItem(name);
		jMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent n)
			{
				JOptionPane.showMessageDialog(jMenuItem, "Cleared!");
			}
		});
		return jMenuItem;
	}
	private JMenuItem createOpenMenuItem(String name)
	{
		final JMenuItem jMenuItem = new JMenuItem(name);
		jMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String response = JOptionPane.showInputDialog(frame, "Please enter a file name:", null);
				Load load;
				load = new Load(response);
				Biomorph loadedBiomorph = load.load();
				bm.addSpecific(loadedBiomorph);
				gm.refreshMainPanel();				
			}
		});
		return jMenuItem;
	}
	private JMenuItem createSaveMenuItem(String name)
	{	
		JMenuItem jMenuItem = new JMenuItem(name);
		jMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String response = JOptionPane.showInputDialog(frame, "Please enter a file name:", null);
				@SuppressWarnings("unused")
				SaveBiomorphToText save = new SaveBiomorphToText(biomorph.getGenes(), response);
			}
		});
		return jMenuItem;
	}
	private JMenuItem createAddToHallOfFameItem(String name)
	{
		final JMenuItem jMenuItem = new JMenuItem(name);
		jMenuItem.addActionListener(gm);
		return jMenuItem;
	}
	private JMenuItem createRemoveSelectedItem(String name)
	{	
		final JMenuItem jMenuItem = new JMenuItem(name);
		jMenuItem.addActionListener(gm);
		return jMenuItem;
	}
	private JMenuItem createClearHallOfFameItem(String name)
	{
		final JMenuItem jMenuItem = new JMenuItem(name);
		jMenuItem.addActionListener(gm);
		return jMenuItem;
	}
	public void updateBM(BiomorphManager bm)
	{
		this.bm = bm;
	}
	public void updateES(EvolutionStats es)
	{
		this.es = es;
	}
	public void actionPerformed(ActionEvent e)
	{
		
	}
	public void menuSelected(MenuEvent e)
	{
		
	}
	public void menuDeselected(MenuEvent e)
	{
		
	}
	public void menuCanceled(MenuEvent e)
	{
		
	}
}