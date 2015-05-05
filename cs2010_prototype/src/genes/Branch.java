package genes;
/**
 * Class to model a Branch gene. This determines how many branches will be generated from the centre, then at the end of each branch if the Chain gene permits it.
 * @author Tom Connolly, Jack Taylor
 * @version 05/05/2015
 */
public class Branch extends Gene
{
	public Branch(int branchNum, String name)
	{
		super(branchNum, name);
	}
}