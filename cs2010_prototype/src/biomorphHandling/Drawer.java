package biomorphHandling;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
public class Drawer
{
	/**
	 * The main method for this application. Takes care of selecting and drawing
	 * a Biomorph.
	 */
	public static void main(String[] args)
	{
		boolean quit = false;
		boolean keystop = false;
		float aspect;
		// Set display to 1024x768, windowed
		DisplayMode mode = new DisplayMode(1024, 768);
		try
		{
			Display.setDisplayMode(mode);
			Display.create();
			Display.setTitle("Biomorph Test");
		}
		catch (Exception e)
		{
		}
//
//        GLU.gluLookAt(0.0f, 0.0f, 3.0f,   // viewer location        
//        			1.0f, 1.0f, 1.0f,    // view point loc.
//  		      		0.0f, 1.0f, 0.0f);
		// Set the display's aspect ratio (in this case, 4:3)
		aspect = (float) mode.getWidth() / (float) mode.getHeight();
		// Set projection boundaries for OpenGL drawing
		GL11.glOrtho(-50.0f * aspect, 50.0f * aspect, -50.0f, 50.0f, -50.0f, 50.0f);
		BiomorphManager bm = new BiomorphManager();
		/*
		 * A load biomorphs method is called to use EvolveBlend class to evolve
		 * the Biomorph that will be displayed.
		 */
		int i=0;
		while (quit == false)
		{
			// Pressing Enter will generate a new biomorph.
			
			if (/*i<497)*/Keyboard.isKeyDown(Keyboard.KEY_RETURN))
			{
				if (keystop == false)
				{
					//evolves two biomorphs together
					bm.evolveClo(bm.getSpecific(0), bm.getRandomBiomorph());
				}
				keystop = true;
			}
			// This prevents repeated creations of biomorphs while the Enter key
			// is held down.
			if (Keyboard.isKeyDown(Keyboard.KEY_RETURN) == false) keystop = false;
			if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) quit = true;
			if (Display.isCloseRequested()) quit = true;
			// Clear screen and draw biomorph
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			//locates and draws biomorph depending on which is chosen to be drawn by random above
			bm.getSpecific(0).draw();
			Display.update();
			// Limit to 60fps to save CPU usage
			Display.sync(60);
			i++;
		}
		Display.destroy();
	}
}