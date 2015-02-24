package genes;
/**
 * Class to model a gene that holds a value that increments the value of the length gene 
 * so that everytime an arm is drawn down a single chain, the value changes. 
 * @author Tom Connolly
 * @version 24/02/2015
 */
public class LengthIncrement extends Gene
{	
	public LengthIncrement(int lengthIncrement)
	{
		super(lengthIncrement);
	}
}