package genes;
/**
 * Abstract class to model a gene. Genes have an integer value and a type to determine what type of gene it is.
 * @author Tom Connolly, Jack Taylor
 * @version 05/05/2015
 */
public abstract class Gene
{
	private int value;
	private String name;
	public Gene(int value, String name)
	{
		this.value = value;
		this.name = name;
	}
	/**
	 * @return The gene's value.
	 */
	public int getValue()
	{
		return value;
	}
	/**
	 * @return The gene's type.
	 */
	public String getGeneType()
	{
		return name;
	}
	/**
	 * Edits the Genes value.
	 */
	public void setValue(int i)
	{
		value = i;
	}
}