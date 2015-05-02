package gui;
import input_output.Load;
import input_output.Save;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.ToolTipManager;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import biomorphHandling.Biomorph;
import biomorphHandling.BiomorphManager;
/**
 * The File Menu element of the program
 * @author Charandeep Rai
 */
public class FileMenu extends JComponent implements MenuListener, ActionListener
{
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Biomorph biomorph;
	private BiomorphManager bm;
	private GraphicsMain gm;
	public FileMenu(BiomorphManager bm, GraphicsMain gm)
	{
		//These two methods make the file menu "heavyweight" so it draws on top of the canvas.
		JPopupMenu.setDefaultLightWeightPopupEnabled(false);
		ToolTipManager.sharedInstance().setLightWeightPopupEnabled(false);
		this.gm = gm;
		this.bm = bm;
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
		menubar.add(createBiomorphMenu("Biomorph", 4));
		menubar.add(createHallOfFameMenu("Hall Of Fame", 3));
		return menubar;
	}
	public void updateBiomorph(Biomorph biomorph)
	{
		this.biomorph = biomorph;
	}
	private JMenu createBiomorphMenu(String name, int depth)
	{
		JMenu biomorphMenu = new JMenu("Biomorph");
		biomorphMenu.add(createNewMenuItem("Create New Biomorph"));
		biomorphMenu.add(createOpenMenuItem("Open from Text File"));
		biomorphMenu.add(createSaveMenuItem("Save to Text File"));
		biomorphMenu.add(createPrintMenuItem("Print Biomorph"));
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
				Save save = new Save(biomorph.getGenes(), response);
			}
		});
		return jMenuItem;
	}
	private JMenuItem createPrintMenuItem(String name)
	{
		final JMenuItem jMenuItem = new JMenuItem(name);
		jMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent n)
			{
				JOptionPane.showMessageDialog(jMenuItem, "Printed!");
			}
		});
		return jMenuItem;
	}
	private JMenuItem createAddToHallOfFameItem(String name)
	{
		final JMenuItem jMenuItem = new JMenuItem(name);
		jMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent n)
			{
				JOptionPane.showMessageDialog(jMenuItem, "Added!");
			}
		});
		return jMenuItem;
	}
	private JMenuItem createRemoveSelectedItem(String name)
	{	
		final JMenuItem jMenuItem = new JMenuItem(name);
		jMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent n)
			{
				JOptionPane.showMessageDialog(jMenuItem, "Removed!");
			}
		});
		return jMenuItem;
	}
	private JMenuItem createClearHallOfFameItem(String name)
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
	public void updateBM(BiomorphManager bm)
	{
		this.bm = bm;
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
	public static void main(String[] args)
	{
		GraphicsMain gm = new GraphicsMain();
		BiomorphManager bm = new BiomorphManager();
		new FileMenu(bm, gm).initialise();
	}
//	private JMenu createSaveMenu(String savename, int menudepth)
//	{
//		JMenu savemenu = new JMenu("Save");
//		JMenuItem Textfilesave = new JMenuItem("Save to Text File");
//		for (int i = 0; i < 1; i++)
//		{
//			savemenu.add(Textfilesave(Textfilesave));
//		}
//		return savemenu;
//	}
//	private JMenu createOpenMenu(String name, int menudepth)
//	{
//		JMenu openmenu = new JMenu(name);
//		for (int i = 0; i < 1; i++)
//		{
//			openmenu.add(createOpenMenuItem("Open from TextFile"));
//		}
//		return openmenu;
//	}
//	private JMenu createPrintMenu(String name, int menudepth)
//	{
//		JMenu printmenu = new JMenu(name);
//		for (int i = 0; i < 1; i++)
//		{
//			printmenu.add(createPrintMenuItem("Print Biomorph"));
//		}
//		return printmenu;
//	}
//	private JMenu createNewMenu(String name, int menudepth)
//	{
//		JMenu newmenu = new JMenu(name);
//		for (int i = 0; i < 1; i++)
//		{
//			newmenu.add(createNewMenuItem("Create New Biomorph"));
//		}
//		return newmenu;
//	}
//	private JMenuItem loadBiomorph(JMenuItem loadItem)
//	{
//		loadItem.addActionListener(new ActionListener()
//		{
//			@Override
//			public void actionPerformed(ActionEvent arg0)
//			{
//			}
//		});
//		return loadItem;
//	}
//	private JMenuItem Bioserialise(JMenuItem Bioserialise)
//	{
//		Bioserialise.addActionListener(new ActionListener()
//		{
//			@Override
//			public void actionPerformed(ActionEvent arg0)
//			{
//			}
//		});
//		return Bioserialise;
//	}
}