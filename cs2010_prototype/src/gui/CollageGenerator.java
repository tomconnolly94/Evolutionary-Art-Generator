package gui;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import biomorphHandling.BiomorphManager;
public class CollageGenerator
{
	private BiomorphManager bm;
	private int size = 10;
	public CollageGenerator(BiomorphManager bm)
	{
		this.bm = bm;
	}
	public void generateDefault()
	{
		int length = (int) Math.sqrt(bm.getSize());
		if (length > 10) length = 10;
		JFrame frame = new JFrame();
		Image image;
		try
		{
			image = ImageIO.read(new File("src/biomorphdownload.jpg"));
			frame.setIconImage(image);
		}
		catch (IOException e1){}
		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(length, length);
		panel.setLayout(layout);
		int biomorphCount = 0;
		for (int j = 0; j < length; j++)
		{
			for (int i = 0; i < length; i++)
			{
				if (!(biomorphCount > bm.getSize() - 1))
				{
					panel.add(new OpenGLCanvas(bm.getSpecific(biomorphCount), (size * size)).getCanvas());
					biomorphCount++;
				}
				else panel.add(new OpenGLCanvas(null, (size * size)).getCanvas());
			}
		}
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	public void generateCustom(int x, int y, boolean autoFill)
	{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(y, x);
		panel.setLayout(layout);
		if (autoFill)
		{
			int limit = bm.getSize();
			for (int i = 0; i < ((x * y) - limit); i++) bm.createAndAdd();
		}
		int biomorphCount = 0;
		for (int j = 0; j < y; j++)
		{
			for (int i = 0; i < x; i++)
			{
				if (!(biomorphCount > bm.getSize() - 1))
				{
					panel.add(new OpenGLCanvas(bm.getSpecific(biomorphCount), (10 * 10)).getCanvas());
					biomorphCount++;
				}
				else panel.add(new OpenGLCanvas(null, (10 * 10)).getCanvas());
			}
		}
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args)
	{
		BiomorphManager bm = new BiomorphManager();
		CollageGenerator cg = new CollageGenerator(bm);
		cg.generateCustom(10, 2, true);
	}
}
