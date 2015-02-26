package program;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
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
		// Set the display's aspect ratio (in this case, 4:3)
		aspect = (float) mode.getWidth() / (float) mode.getHeight();
		// Set projection boundaries for OpenGL drawing
		GL11.glOrtho(-50.0f * aspect, 50.0f * aspect, -50.0f, 50.0f, 0.0f, 1.0f);
		BiomorphManager bm = new BiomorphManager();
		/*
		 * A load biomorphs method is called to use EvolveBlend class to evolve
		 * the Biomorph that will be displayed.
		 */
		bm.loadBiomorphsWithEvBle();
		// bm.createAndAdd();
		while (quit == false)
		{
			// Pressing Enter will generate a new biomorph.
			if (Keyboard.isKeyDown(Keyboard.KEY_RETURN))
			{
				if (keystop == false)
				{
					// biomorph collection is emptied.
					bm.emptyBiomorphCollection();
					/*
					 * A load biomorphs method is called to use EvolveClosest
					 * class to evolve the Biomorph that will be displayed.
					 */
					bm.loadBiomorphsWithEvClo();
					// bm.createAndAdd();
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
			// Biomorph is extracted from array at index 2, this is where the
			// evolved Biomorph was placed earlier.
			bm.getSpecific(0).draw();
			Display.update();
			// Limit to 60fps to save CPU usage
			Display.sync(60);
		}
		Display.destroy();
	}
}