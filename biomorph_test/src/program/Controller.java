package program;
import java.util.ArrayList;
import java.util.Random;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
public class Controller
{
	private ArrayList<Biomorph> biomorphCollection;	
	public Controller()
	{
		biomorphCollection = new ArrayList<Biomorph>();
	}
	public void createAndAdd()
	{
		BiomorphCreator bc = new BiomorphCreator();
		Biomorph biomorph = bc.createBiomorph();
		biomorphCollection.add(biomorph);
	}
	public Biomorph getRandomBiomorph()
	{	
		Random rand = new Random();
		return biomorphCollection.get(rand.nextInt(biomorphCollection.size() - 1));
	}
	public Biomorph getSpecific(int index)
	{
		return biomorphCollection.get(index);
	}
	public void remove(int index)
	{
		biomorphCollection.remove(index);
	}
	public static void main(String[] args)
	{
		boolean quit = false;
		boolean keystop = false;
		float aspect;
		DisplayMode mode = new DisplayMode(1024, 768);
		try
		{
			Display.setDisplayMode(mode);
			Display.create();
			Display.setTitle("Biomorph Test");
		}
		catch (Exception e) {}
		aspect = (float)mode.getWidth() / (float)mode.getHeight();
		GL11.glOrtho(-50.0f * aspect, 50.0f * aspect, -50.0f, 50.0f, 0.0f, 1.0f);
		Controller c = new Controller();
		c.createAndAdd();
		while (quit == false)
		{
			if (Keyboard.isKeyDown(Keyboard.KEY_RETURN))
			{
				if (keystop == false)
				{
					c.remove(0);
					c.createAndAdd();
				}
				keystop = true;
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_RETURN) == false) keystop = false;
			if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) quit = true;
	        if (Display.isCloseRequested()) quit = true;
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			c.getSpecific(0).draw();
			Display.update();
			try
			{
				Thread.sleep(1000 / 60);
			}
			catch (InterruptedException e) {}
		}
		Display.destroy();
	}
}