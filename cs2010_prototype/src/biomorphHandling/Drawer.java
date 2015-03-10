package biomorphHandling;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
/**
 * Class to handle the drawing and displaying of Biomorphs.
 * @author Tom Connolly, Jack Taylor, Charandeep Rai.
 * @version 24/02/2015
 */
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
		float aspect = 0;
		float x = 0.0f;
		float z = 0.0f;
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
		GL11.glOrtho(-50.0f * aspect, 50.0f * aspect, -50.0f, 50.0f, -50.0f, 50.0f);
		BiomorphManager bm = new BiomorphManager();
		//Integer to store runCount for auto-run feature.
		int i = 0;
		while (quit == false)
		{
			// Pressing Enter will generate a new biomorph.
			if (/* i<497) */Keyboard.isKeyDown(Keyboard.KEY_RETURN))
			{
				// evolves two biomorphs together
				if (keystop == false) bm.evolveClo(bm.getSpecific(0), bm.getRandomBiomorph());
				keystop = true;
			}
			// This prevents repeated creations of biomorphs while the Enter key
			// is held down.
			if (Keyboard.isKeyDown(Keyboard.KEY_RETURN) == false) keystop = false;
			if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) quit = true;
			if (Keyboard.isKeyDown(Keyboard.KEY_UP)) x += 1.0f;
			if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) x -= 1.0f;
			if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) z -= 1.0f;
			if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) z += 1.0f;
			if (Display.isCloseRequested()) quit = true;
			// Clear screen and draw biomorph
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			// locates and draws biomorph depending on which is chosen to be
			// drawn by random above
			GL11.glPushMatrix();
				GL11.glRotatef(x, 1.0f, 0.0f, 0.0f);
				GL11.glRotatef(z, 0.0f, 0.0f, 1.0f);
				bm.getSpecific(0).draw();
			GL11.glPopMatrix();
			Display.update();
			// Limit to 60fps to save CPU usage
			Display.sync(60);
			i++;
		}
		Display.destroy();
	}
}