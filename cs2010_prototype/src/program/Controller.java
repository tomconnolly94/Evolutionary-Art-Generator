package program;
import java.util.ArrayList;
import java.util.Random;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
/**
 * Top-level class for this project
 * @author Tom Connolly, Jack Taylor
 * @version 18/12/2014
 */
public class Controller
{
	private ArrayList<Biomorph> biomorphCollection;	
	public Controller()
	{
		biomorphCollection = new ArrayList();
	}
	/**
	 * Creates a biomorph and adds it to the list of biomorphs.
	 */
	public void createAndAdd()
	{
		BiomorphCreator bc = new BiomorphCreator();
		Biomorph biomorph = bc.createBiomorph();
		biomorphCollection.add(biomorph);
	}
	/**
	 * @return A random biomorph from the list
	 */
	public Biomorph getRandomBiomorph()
	{	
		Random rand = new Random();
		return biomorphCollection.get(rand.nextInt(biomorphCollection.size() - 1));
	}
	/**
	 * Retrieves a specific biomorph by its index number in the list.
	 * @param index The index number
	 * @return The biomorph corresponding to the given index number
	 */
	public Biomorph getSpecific(int index)
	{
		return biomorphCollection.get(index);
	}
	/**
	 * Removes a biomorph corresponding to the given index number.
	 * @param index The index number
	 */
	public void remove(int index)
	{
		biomorphCollection.remove(index);
	}
	/**
	 * The main method for this application.
	 */
	public static void main(String[] args)
	{
		boolean quit = false;
		boolean keystop = false;
		float aspect;
		//Set display to 1024x768, windowed
		DisplayMode mode = new DisplayMode(1024, 768);
		try
		{
			Display.setDisplayMode(mode);
			Display.create();
			Display.setTitle("Biomorph Test");
		}
		catch (Exception e) {}
		//Set the display's aspect ratio (in this case, 4:3)
		aspect = (float)mode.getWidth() / (float)mode.getHeight();
		//Set projection boundaries for OpenGL drawing
		GL11.glOrtho(-50.0f * aspect, 50.0f * aspect, -50.0f, 50.0f, 0.0f, 1.0f);
		Controller c = new Controller();
		c.createAndAdd();
		while (quit == false)
		{
			//Pressing Enter will generate a new biomorph.
			if (Keyboard.isKeyDown(Keyboard.KEY_RETURN))
			{
				if (keystop == false)
				{
					c.remove(0);
					c.createAndAdd();
				}
				keystop = true;
			}
			//This prevents repeated creations of biomorphs while the Enter key is held down.
			if (Keyboard.isKeyDown(Keyboard.KEY_RETURN) == false) keystop = false;
			if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) quit = true;
	        if (Display.isCloseRequested()) quit = true;
	        //Clear screen and draw biomorph
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			c.getSpecific(0).draw();
			Display.update();
			//Limit to 60fps to save CPU usage
			Display.sync(60);
		}
		Display.destroy();
	}
}