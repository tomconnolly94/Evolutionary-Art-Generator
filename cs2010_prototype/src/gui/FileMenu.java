package gui;
import inputOutput.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ToolTipManager;
import evolution.EvolutionStats;
import biomorphHandling.Biomorph;
import biomorphHandling.BiomorphManager;
/**
 * The File Menu element of the program
 * @author Charandeep Rai, Jack Taylor, Tom Connolly
 * @version 05/05/2015
 */
public class FileMenu extends JComponent
{
	private static final long serialVersionUID = -6163251826528350603L;
	private JFrame frame;
	private Biomorph biomorph;
	private BiomorphManager bm;
	private GraphicsMain gm;
	private EvolutionStats es;
	/**
	 * Constructor
	 * @param bm The Biomorph Manager
	 * @param gm The GraphicsMain instance
	 * @param es The EvolutionStats instance
	 */
	public FileMenu(BiomorphManager bm, GraphicsMain gm, EvolutionStats es)
	{
		// These two methods make the file menu "heavyweight" so it draws on top of the canvas.
		JPopupMenu.setDefaultLightWeightPopupEnabled(false);
		ToolTipManager.sharedInstance().setLightWeightPopupEnabled(false);
		this.gm = gm;
		this.bm = bm;
		this.es = es;
		initialise();
	}
	/**
	 * @return The contents of the file menu.
	 */
	public JPanel getContents()
	{
		return (JPanel) frame.getContentPane();
	}
	/**
	 * Initialises the file menu.
	 */
	protected void initialise()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(createMenuBar());
		frame.pack();
	}
	/**
	 * Creates the initial menu bar.
	 * @param name The name of the menu bar
	 * @param depth The amount of elements in the menu bar
	 * @return The created menu bar
	 */
	private JMenuBar createMenuBar()
	{
		JMenuBar menubar = new JMenuBar();
		menubar.add(createFileMenu());
		menubar.add(createSettingsMenu());
		menubar.add(createHallOfFameMenu());
		menubar.add(createBiomorphCollageMenu());
		menubar.add(createHelpMenu());
		return menubar;
	}
	/**
	 * Updates the biomorph referenced by this file menu.
	 * @param biomorph The new biomorph
	 */
	public void updateBiomorph(Biomorph biomorph)
	{
		this.biomorph = biomorph;
	}
	/**
	 * Creates the File section of the menu.
	 * @return The created menu
	 */
	private JMenu createFileMenu()
	{
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(createNewMenuItem());
		fileMenu.add(createOpenMenuItem());
		fileMenu.add(createSaveMenuItem());
		fileMenu.add(createClearAllMenuItem());
		return fileMenu;
	}
	/**
	 * Creates the Settings section of the menu.
	 * @return The created menu
	 */
	private JMenu createSettingsMenu()
	{
		JMenu settingsMenu = new JMenu("Evolution");
		settingsMenu.add(createEditEvolSettingsItem());
		settingsMenu.add(createDisplayEvolStatsItem());
		settingsMenu.add(createSaveEvolStatsItem());
		return settingsMenu;
	}
	/**
	 * Creates the Hall of Fame section of the menu.
	 * @return The created menu
	 */
	private JMenu createHallOfFameMenu()
	{
		JMenu hallOfFameMenu = new JMenu("Hall Of Fame");
		hallOfFameMenu.add(createAddToHallOfFameItem());
		hallOfFameMenu.add(createAddToMainWindowItem());
		hallOfFameMenu.add(createRemoveSelectedItem());
		hallOfFameMenu.add(createClearHallOfFameItem());
		return hallOfFameMenu;
	}
	/**
	 * Creates the Biomorph Collaging section of the menu.
	 * @return The created menu
	 */
	private JMenu createBiomorphCollageMenu()
	{
		JMenu biomorphCollageMenu = new JMenu("Biomorph Collaging");
		biomorphCollageMenu.add(createGenerateDefaultCollageItem());
		biomorphCollageMenu.add(createGenerateCustomCollageItem());
		return biomorphCollageMenu;
	}
	/**
	 * Creates the Help section of the menu.
	 * @return The created menu
	 */
	private JMenu createHelpMenu()
	{
		JMenu biomorphMenu = new JMenu("Help");
		biomorphMenu.add(createViewHelpDocItem());
		return biomorphMenu;
	}
	/**
	 * Creates the New item in the File Menu
	 * @return The menu item
	 */
	private JMenuItem createNewMenuItem()
	{
		final JMenuItem jMenuItem = new JMenuItem("New");
		jMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent n)
			{
				gm.resetAction();
			}
		});
		return jMenuItem;
	}
	/**
	 * Creates the Open item in the File Menu
	 * @return The menu item
	 */
	private JMenuItem createOpenMenuItem()
	{
		final JMenuItem jMenuItem = new JMenuItem("Open");
		jMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Load loader = new Load();
				bm.addSpecific(loader.load());
				gm.refreshMainPanel();
			}
		});
		return jMenuItem;
	}
	/**
	 * Creates the Save item in the File Menu
	 * @return The menu item
	 */
	private JMenuItem createSaveMenuItem()
	{
		JMenuItem jMenuItem = new JMenuItem("Save");
		jMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new SaveBiomorphToText(biomorph.getGenes());
			}
		});
		return jMenuItem;
	}
	private JMenuItem createClearAllMenuItem()
	{
		JMenuItem jMenuItem = new JMenuItem("Clear all");
		jMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				gm.clearAll();
			}
		});
		return jMenuItem;
	}
	/**
	 * Creates the Edit Evolution Settings item in the Settings Menu
	 * @return The menu item
	 */
	private JMenuItem createEditEvolSettingsItem()
	{
		final JMenuItem jMenuItem = new JMenuItem("Edit evolution settings");
		jMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent n)
			{
				// create Panels
				JPanel outer = new JPanel(new BorderLayout());
				JPanel radioButtons = new JPanel();
				final JPanel inputPanel = new JPanel();
				inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
				// create buttons
				ButtonGroup bg = new ButtonGroup();
				final JRadioButton button1 = new JRadioButton("Use target values to evolve", bm.getUseEvolveClo());
				final JRadioButton button2 = new JRadioButton("Use avg of parents to evolve", !bm.getUseEvolveClo());
				// add buttons to button group
				bg.add(button1);
				bg.add(button2);
				String[] geneNames =
				{"Branch (Range: 3 - 10)", "Chain Gene (Range: 1 - 3)", "Length (Range: 1 - 8)", "Length Increment (Range: -3 - 3)", "Thickness (Range: 1 - 10)", "Thickness Increment (Range: -3 - 3)", "Colour Red (Range :0 - 255)", "Colour Green (Range: 0 - 255)", "Colour Blue (Range: 0 - 255)", "Iridescence Red (Range: -16 - 16)", "Iridescence Green (Range: -16 - 16)", "Iridescence Blue (Range: -16 - 16)"};
				JTextField[] tfa = new JTextField[12];
				for (int i = 0; i < 12; i++)
				{
					JTextField gene = new JTextField(2);
					tfa[i] = gene;
					inputPanel.add(new JLabel(geneNames[i]));
					inputPanel.add(gene);
					inputPanel.add(Box.createHorizontalStrut(15));
				}
				button1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						inputPanel.setVisible(true);
					}
				});
				button2.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						inputPanel.setVisible(false);
					}
				});
				radioButtons.add(button1);
				radioButtons.add(button2);
				outer.add(radioButtons, BorderLayout.NORTH);
				outer.add(inputPanel, BorderLayout.SOUTH);
				JOptionPane.showConfirmDialog(null, outer, "Enter Target Gene Values", JOptionPane.OK_CANCEL_OPTION);
				if (button1.isSelected())
				{
					bm.setEvolveClo(true);
					for (int i = 0; i < 12; i++)
					{
						if (tfa[i].getText().equals("")) tfa[i].setText(Integer.toString(bm.getTargetValues()[i]));
					}
					bm.updateTargetValues(Integer.parseInt(tfa[0].getText()), Integer.parseInt(tfa[1].getText()), Integer.parseInt(tfa[2].getText()), Integer.parseInt(tfa[3].getText()), Integer.parseInt(tfa[4].getText()), Integer.parseInt(tfa[5].getText()), Integer.parseInt(tfa[6].getText()), Integer.parseInt(tfa[7].getText()), Integer.parseInt(tfa[8].getText()), Integer.parseInt(tfa[9].getText()), Integer.parseInt(tfa[10].getText()), Integer.parseInt(tfa[11].getText()));
					bm.printTargetValues();
				}
				else bm.setEvolveClo(false);
			}
		});
		return jMenuItem;
	}
	/**
	 * Creates the Display Evolution Stats item in the Settings Menu
	 * @return The menu item
	 */
	private JMenuItem createDisplayEvolStatsItem()
	{
		final JMenuItem jMenuItem = new JMenuItem("Display evolution stats");
		jMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent n)
			{
				JFrame frame = new JFrame();
				JTextArea component= es.returnTextAreaStats();
				component.setEditable(false);
				frame.add(component);
				frame.pack();
				frame.setVisible(true);
			}
		});
		return jMenuItem;
	}
	/**
	 * Creates the Save Evolution Stats item in the Settings Menu
	 * @return The menu item
	 */
	private JMenuItem createSaveEvolStatsItem()
	{
		final JMenuItem jMenuItem = new JMenuItem("Save evolution stats");
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
	/**
	 * Creates the Add to Hall of Fame item in the Hall of Fame Menu
	 * @return The menu item
	 */
	private JMenuItem createAddToHallOfFameItem()
	{
		final JMenuItem jMenuItem = new JMenuItem("Add to Hall of Fame");
		jMenuItem.addActionListener(gm);
		return jMenuItem;
	}
	/**
	 * Creates the Add to Main Window item in the Hall of Fame Menu
	 * @return The menu item
	 */
	private JMenuItem createAddToMainWindowItem()
	{
		final JMenuItem jMenuItem = new JMenuItem("Add to Main Window");
		jMenuItem.addActionListener(gm);
		return jMenuItem;
	}
	/**
	 * Creates the Remove Selected item in the Hall of Fame Menu
	 * @return The menu item
	 */
	private JMenuItem createRemoveSelectedItem()
	{
		final JMenuItem jMenuItem = new JMenuItem("Remove Selected");
		jMenuItem.addActionListener(gm);
		return jMenuItem;
	}
	/**
	 * Creates the Clear Hall of Fame item in the Hall of Fame Menu
	 * @return The menu item
	 */
	private JMenuItem createClearHallOfFameItem()
	{
		final JMenuItem jMenuItem = new JMenuItem("Clear Hall of Fame");
		jMenuItem.addActionListener(gm);
		return jMenuItem;
	}
	/**
	 * Creates the Generate Default Collage item in the Biomorph Collaging Menu
	 * @return The menu item
	 */
	private JMenuItem createGenerateDefaultCollageItem()
	{
		JMenuItem jMenuItem = new JMenuItem("Generate default collage");
		jMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				CollageGenerator cg = new CollageGenerator(bm);
				cg.generateDefault();
			}
		});
		return jMenuItem;
	}
	/**
	 * Creates the Generate Custom Collage item in the Biomorph Collaging Menu
	 * @return The menu item
	 */
	private JMenuItem createGenerateCustomCollageItem()
	{
		JMenuItem jMenuItem = new JMenuItem("Generate custom collage");
		jMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JPanel panel = new JPanel(new GridLayout(3, 0));
				panel.setSize(new Dimension(300, 300));
				JTextField xVal = new JTextField(2);
				panel.add(new JLabel("Enter x dimension of Collage"));
				panel.add(xVal);
				JTextField yVal = new JTextField(2);
				panel.add(new JLabel("Enter y dimension of Collage"));
				panel.add(yVal);
				JCheckBox box = new JCheckBox();
				panel.add(new JLabel("Auto-fill empty space with randomly generated Biomorphs."));
				panel.add(box);
				JOptionPane.showConfirmDialog(null, panel, "Enter Target Gene Values", JOptionPane.OK_CANCEL_OPTION);
				if (!xVal.getText().equals("") && !yVal.getText().equals(""))
				{
					CollageGenerator cg = new CollageGenerator(bm);
					cg.generateCustom(Integer.parseInt(xVal.getText()), Integer.parseInt(yVal.getText()), box.isSelected());
				}
			}
		});
		return jMenuItem;
	}
	/**
	 * Creates the View Help Document item in the Help Menu
	 * @return The menu item
	 */
	private JMenuItem createViewHelpDocItem()
	{
		final JMenuItem jMenuItem = new JMenuItem("View Help Document");
		jMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent n)
			{
				new HelpDocument();
			}
		});
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
}