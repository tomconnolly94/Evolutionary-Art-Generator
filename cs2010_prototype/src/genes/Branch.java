package genes;
/**
 * Class to model a Branch gene. This determines how many branches will be generated from the centre,
 * then at the end of each branch if the Chain gene permits it.
 * @author Tom Connolly, Jack Taylor
 * @version 18/12/2014
 */
public class Branch extends Gene
{	
	public Branch(int branchNum)
	{
		super(branchNum);
	}
}