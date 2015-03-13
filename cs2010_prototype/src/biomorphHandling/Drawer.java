package biomorphHandling;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
/**
 * Class to handle the drawing and displaying of Biomorphs. Also serves as application's main class.
 * @author Tom Connolly, Jack Taylor, Charandeep Rai.
 * @version 24/02/2015
 */
public class Drawer
{
	private static boolean quit;
	private boolean keystop;
	private float aspect;
	private float lat; //"Latitude", vertical rotation
	private float lon; //"Longitude", horizontal rotation
	private float zoom;
	BiomorphManager bm;
	/**
	 * Constructor
	 */
	public Drawer()
	{
		quit = false;
		keystop = false;
		aspect = 0.0f;
		lat = 0.0f;
		lon = 0.0f;
		zoom = 1.0f;
		bm = new BiomorphManager();
		// Set display to 1024x768, windowed
		DisplayMode mode = new DisplayMode(1024, 768);
		try
		{
			Display.setDisplayMode(mode);
			Display.create();
			Display.setTitle("Biomorph Test");
		}
		catch (Exception e) {}
		// Set the display's aspect ratio (in this case, 4:3)
		aspect = (float) mode.getWidth() / (float) mode.getHeight();
	}
	/**
	 * Checks if relevant keys have been pressed, and performs necessary actions (e.g. rotation).
	 */
	public void checkInput()
	{
		// Pressing Enter will generate a new biomorph.
		if (Keyboard.isKeyDown(Keyboard.KEY_RETURN))
		{
			// evolves two biomorphs together
			if (keystop == false) bm.evolveClo(bm.getSpecific(0), bm.getRandomBiomorph());
			keystop = true;
		}
		// This prevents repeated creations of biomorphs while the Enter key
		// is held down.
		if (Keyboard.isKeyDown(Keyboard.KEY_RETURN) == false) keystop = false;
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) quit = true;
		if (Keyboard.isKeyDown(Keyboard.KEY_UP)) if (lat < 90.0f) lat += 2.0f;
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) if (lat > -90.0f) lat -= 2.0f;
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) lon -= 2.0f;
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) lon += 2.0f;
		if (Keyboard.isKeyDown(Keyboard.KEY_W))if(zoom>0) zoom -= 0.01f;
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) zoom += 0.01f;
		if (Display.isCloseRequested()) quit = true;
	}
	/**
	 * Draws the biomorph to the screen.
	 */
	public void draw()
	{
		// Clear screen and draw biomorph
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		GL11.glPushMatrix();
		{
			//Positions the camera according to latitude and longitude, as if the biomorph is a globe-like object
			GL11.glOrtho(-80.0f * aspect * zoom, 80.0f * aspect * zoom, -80.0f * zoom, 80.0f * zoom, -80.0f * zoom, 80.0f * zoom);
			GLU.gluLookAt((float)Math.cos(Math.toRadians(lat)) * -(float)Math.cos(Math.toRadians(lon)), (float)Math.sin(Math.toRadians(lat)), (float)Math.cos(Math.toRadians(lat)) * (float)Math.sin(Math.toRadians(lon)), 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
			bm.getSpecific(0).draw();
		}
		GL11.glPopMatrix();
		Display.update();
		// Limit to 60fps to save CPU usage
		Display.sync(60);
	}
	/**
	 * The main method for this application. Takes care of selecting and drawing a Biomorph.
	 */
	public static void main(String[] args)
	{
		Drawer d = new Drawer();
		//Integer to store runCount for auto-run feature.
		int i = 0;
		while (quit == false)
		{
			d.checkInput();
			d.draw();
			i++;
		}
		Display.destroy();
	}
}