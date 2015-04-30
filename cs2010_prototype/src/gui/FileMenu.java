package gui;
import input_output.Load;
import input_output.Save;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import biomorphHandling.Biomorph;
import biomorphHandling.BiomorphManager;
/**
 * The File Menu element of the program
 * @author Charandeep Rai
 */
public class FileMenu extends JComponent implements MenuListener, ActionListener {

	private JFrame frame;
	private Biomorph biomorph;
	private BiomorphManager bm;
	private GraphicsMain gm;
	
	public FileMenu(BiomorphManager bm, GraphicsMain gm)
	{
		this.gm = gm;
		this.bm = bm;
		initialise();
	}
	public JPanel getContents()
	{
		return (JPanel)frame.getContentPane();
	}
	private JMenuBar createMenuBar(String name, int depth)
	{
		JMenuBar menubar = new JMenuBar();
		menubar.add(createNewMenu("New", 4));
		menubar.add(createSaveMenu("Save", 1));
		menubar.add(createPrintMenu("Print", 3));
		menubar.add(createOpenMenu("Open", 2));
		
		return menubar;
	}
	
	public void updateBiomorph(Biomorph biomorph){
		this.biomorph = biomorph;
	}
	
	private JMenu createSaveMenu(String savename, int menudepth)
	{
		JMenu savemenu = new JMenu("Save");
		JMenuItem Textfilesave = new JMenuItem("Save to Text File");
		
		
		for (int i = 0; i < 1; i++)
		{
			savemenu.add(Textfilesave(Textfilesave));
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
		final JMenuItem jMenuItem = new JMenuItem(name);
		jMenuItem.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
					String response = JOptionPane.showInputDialog(frame, "Please enter a file name:", null);
				
					Load load;
					try
					{
						load = new Load(response);
						Biomorph loadedBiomorph = load.load();
						bm.addSpecific(loadedBiomorph);
						gm.refreshMainPanel();
					}
					catch (IOException ea)
					{
						ea.printStackTrace();
					}				
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
//				JOptionPane.showMessageDialog(jMenuItem, "Saved!");
//				BufferedImage biomorphImage = new BufferedImage(this.getSize().width, this.getSize().height, BufferedImage.TYPE_INT_ARGB); 
//				Graphics g = biomorphImage.createGraphics();
//				this.paint(g);  //this == JComponent
//				g.dispose();
//				try{ImageIO.write(biomorphImage,"png",new File("test.png"));}catch (Exception e) {}
			}	
//
//			private Object getSize()
//			{
//				return BiomorphWindows.frame ;
//			}
//
//			private void paint(Graphics g)
//			{
//				
//			}
		});
		return jMenuItem;
		
	}
	
	private JMenuItem Textfilesave(JMenuItem Textfilesave){
		
		Textfilesave.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				String response = JOptionPane.showInputDialog(frame, "Please enter a file name:", null);
				
				Save save = new Save(biomorph.getGenes(), response);
			}
		});
		return Textfilesave;
	}
	
	private JMenuItem loadBiomorph(JMenuItem loadItem){
		
		loadItem.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				
		}});
		return loadItem;
	}
	
	private JMenuItem Bioserialise(JMenuItem Bioserialise){
		
		Bioserialise.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				
			}
			
		});
		return Bioserialise;
	}
	
	
	
		
	//}
	private JMenuItem createNewMenuItem(String newbutton)
	{
		final JMenuItem jMenuItem = new JMenuItem(newbutton);
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
		final JMenuItem jMenuItem = new JMenuItem(printbutton);
		jMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent n)
			{
				JOptionPane.showMessageDialog(jMenuItem, "Printed!");
			}
		});
		return jMenuItem;
	}
	protected void initialise()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(createMenuBar("Save", 1));
		frame.pack();
	}
	
	 
	
	public static void main(String[] args)
	{
		GraphicsMain gm = new GraphicsMain();
		BiomorphManager bm = new BiomorphManager();
		new FileMenu(bm, gm).initialise();
	}
	
	public void updateBM(BiomorphManager bm){
		this.bm = bm;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void menuCanceled(MenuEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void menuDeselected(MenuEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void menuSelected(MenuEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}