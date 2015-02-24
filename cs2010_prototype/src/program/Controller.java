package program;
import java.util.ArrayList;
import java.util.Random;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import evolution.*;
/**
 * Top-level class for this project. Manages the collection of biomorphs and handles the drawing of said
 * biomorphs using openGL. 
 * @author Tom Connolly, Jack Taylor
 * @version 24/02/2015
 */
public class Controller
{
	private ArrayList<Biomorph> biomorphCollection;	
	public Controller()
	{
		biomorphCollection = new ArrayList<Biomorph>();
	}
	/**
	 * Creates a biomorph and adds it to the list of biomorphs.
	 */
	public Biomorph createAndAdd()
	{
		BiomorphCreator bc = new BiomorphCreator();
		Biomorph biomorph = bc.createBiomorph();
		biomorphCollection.add(biomorph);
		return biomorph;
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
	/** @return How many biomorphs are currently held in the biomorphCollection*/
	public int getSize(){
		return biomorphCollection.size();
	}
	public void addSpecific(Biomorph b){
		biomorphCollection.add(b);
	}
	/**
	 * The main method for this application.
	 */
	public static void main(String[] args)
	{
		int[] perfectValues = {5,5,5,5,5,5,5,5,5,5,5};
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
		/* Two new biomorphs are created and immediately added to the biomorphCollection, then they are given to the
		 * EvolveBlend object to be evolved using its specific averaging algorithm. The resulting biomorph is then 
		 * added to the array at index 2 so that the code on line 113 will find it. */
		EvolveBlend eb = new EvolveBlend(c.createAndAdd(), c.createAndAdd());
		c.addSpecific(eb.evolve());
		while (quit == false)
		{
			//Pressing Enter will generate a new biomorph.
			if (Keyboard.isKeyDown(Keyboard.KEY_RETURN))
			{
				if (keystop == false)
				{
					//biomorph collection is emptied.
					for(int i=0; i<c.getSize(); i++){
						c.remove(i);
					}
					/*Two new biomorphs are created and immediately added to the biomorphCollection, then they are 
					 * given to the EvolveBlend object to be evolved using its specific 'closest value wins' algorithm. 
					 * The resulting biomorph is then added to the array at index 2 so that the code on line 113 will 
					 * find it. */
					EvolveClosest ec = new EvolveClosest(c.createAndAdd(), c.createAndAdd(), perfectValues);
					c.addSpecific(ec.evolve());
				}
				keystop = true;
			}
			
			//This prevents repeated creations of biomorphs while the Enter key is held down.
			if (Keyboard.isKeyDown(Keyboard.KEY_RETURN) == false) keystop = false;
			if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) quit = true;
	        if (Display.isCloseRequested()) quit = true;
	        //Clear screen and draw biomorph
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			c.getSpecific(2).draw();
			Display.update();
			//Limit to 60fps to save CPU usage
			Display.sync(60);
		}
		Display.destroy();
	}
}