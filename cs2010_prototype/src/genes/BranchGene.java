package genes;
/**
 * Class to model a Branch gene. This determines how many branches will be generated from the centre,
 * then at the end of each branch if the Chain gene permits it.
 *
 * @author Tom Connolly
 * @version 22 Nov 2014
 */
 
public class BranchGene extends Gene
{	
	public BranchGene(int branchNum)
	{
		super(branchNum);
	}
}
