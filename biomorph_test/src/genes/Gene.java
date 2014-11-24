package genes;
public abstract class Gene
{
	private int value;
	private String type;	
	public Gene(int value)
	{
		this.value = value;
	}
	public int getValue()
	{
		return value;
	}
	public String getGeneType()
	{
		return type;
	}
}