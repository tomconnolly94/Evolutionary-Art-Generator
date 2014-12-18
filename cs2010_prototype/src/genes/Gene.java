package genes;
/**
 * Abstract class to model a gene. Genes have an integer value and a type to determine what type of gene it is.
 * @author Tom Connolly, Jack Taylor
 * @version 18/12/2014
 */
public abstract class Gene
{
	private int value;
	private String type;
	public Gene(int value)
	{
		this.value = value;
	}
	/**
	 * @return The gene's value
	 */
	public int getValue()
	{
		return value;
	}
	/**
	 * @return The gene's type
	 */
	public String getGeneType()
	{
		return type;
	}
}