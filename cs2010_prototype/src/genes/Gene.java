package genes;
/**
 * Abstract class to model a gene. Genes have an integer value and a type to determine what type of gene it is.
 * @author Tom Connolly, Jack Taylor
 * @version 18/12/2014
 */
public abstract class Gene
{
	private int value;
	private String type; //The value of type is never set in any of the gene classes. It would appear it is not actually needed.
	public Gene(int value)
	{
		this.value = value;
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
		return type;
	}
	/**
	 * Edits the Genes value.
	 */
	public void setValue(int i)
	{
		value = i;
	}
}