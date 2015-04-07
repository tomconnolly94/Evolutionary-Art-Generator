package gui;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
/**
 * The File Menu element of the program
 * @author Charandeep Rai
 */
public class FileMenu
{
	// public static JFrame fileFrame;
	private JMenuBar createMenuBar(String name, int depth)
	{
		JMenuBar menubar = new JMenuBar();
		menubar.add(createNewMenu("New", 4));
		menubar.add(createSaveMenu("Save", 1));
		menubar.add(createOpenMenu("Open", 2));
		menubar.add(createPrintMenu("Print", 3));
		return menubar;
	}
	private JMenu createSaveMenu(String savename, int menudepth)
	{
		JMenu savemenu = new JMenu(savename);
		for (int i = 0; i < 1; i++)
		{
			savemenu.add(createSaveMenuItem("Save as PDF"));
			savemenu.add(createSaveMenuItem("Save as JPEG"));
			savemenu.add(createSaveMenuItem("Save as TextFile"));
		}
		return savemenu;
	}
	private JMenu createOpenMenu(String name, int menudepth)
	{
		JMenu openmenu = new JMenu(name);
		for (int i = 0; i < 1; i++)
		{
			openmenu.add(createOpenMenuItem("Open from TextFile"));
		}
		return openmenu;
	}
	private JMenu createPrintMenu(String name, int menudepth)
	{
		JMenu printmenu = new JMenu(name);
		for (int i = 0; i < 1; i++)
		{
			printmenu.add(createPrintMenuItem("Print Biomorph"));
		}
		return printmenu;
	}
	private JMenu createNewMenu(String name, int menudepth)
	{
		JMenu newmenu = new JMenu(name);
		for (int i = 0; i < 1; i++)
		{
			newmenu.add(createNewMenuItem("Create New Biomorph"));
		}
		return newmenu;
	}
	private JMenuItem createOpenMenuItem(String name)
	{
		JMenuItem jMenuItem = new JMenuItem(name);
		jMenuItem.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(jMenuItem, "Successfully pressed a menu item");
			}
		});
		return jMenuItem;
	}
	private JMenuItem createSaveMenuItem(String savebutton)
	{
		JMenuItem jMenuItem = new JMenuItem(savebutton);
		jMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent s)
			{
				JOptionPane.showMessageDialog(jMenuItem, "Saved!");
			}
		});
		return jMenuItem;
	}
	private JMenuItem createNewMenuItem(String newbutton)
	{
		JMenuItem jMenuItem = new JMenuItem(newbutton);
		jMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent n)
			{
				JOptionPane.showMessageDialog(jMenuItem, "New!");
			}
		});
		return jMenuItem;
	}
	private JMenuItem createPrintMenuItem(String printbutton)
	{
		JMenuItem jMenuItem = new JMenuItem(printbutton);
		jMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent n)
			{
				JOptionPane.showMessageDialog(jMenuItem, "Printed!");
			}
		});
		return jMenuItem;
	}
	protected void intialise()
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(createMenuBar("Save", 1));
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args)
	{
		new FileMenu().intialise();
	}
}
