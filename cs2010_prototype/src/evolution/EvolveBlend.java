package evolution;
import program.Biomorph;
import program.BiomorphCreator;
import genes.*;
/**
 * Class to model a Evolutionary cycle where two parents are given and one
 * child, with gene values being the average of their parents, is returned.
 * Doesnt model evolution very well as genes are not spliced together half from
 * your mother and half from your father, Each person has either one or the
 * other.
 * @author Tom Connolly
 * @version 24/02/2015
 */
public class EvolveBlend
{
	/*
	 * Globally accessible arrays of the father's and mother's genes and a third
	 * array to hold thenumbers which will become the child's gene values.
	 */
	private Gene[] fatherGenes;
	private Gene[] motherGenes;
	private int[] childGenes;
	// Assigns parameters to global variables so they can be accessed further
	// on.
	public EvolveBlend(Biomorph father, Biomorph mother)
	{
		fatherGenes = father.getGenes();
		motherGenes = mother.getGenes();
		childGenes = new int[11];
	}
	/**
	 * This method takes two sets of genes and for each one takes an average of
	 * the mothers gene value and the fathers and adds it to an array of numbers
	 * which are given to a new child biomorph as gene values.
	 * @return A Biomorph with gene values as described above.
	 */
	public Biomorph evolve()
	{
		// Each gene value from the mother and father is pulled out averaged and
		// placed in the childGenes array.
		for (int i = 0; i < fatherGenes.length; i++)
		{
			childGenes[i] = (fatherGenes[i].getValue() + motherGenes[i].getValue()) / 2;
		}
		// A new biomorph is created using the values taken from the parents
		// above.
		BiomorphCreator bc = new BiomorphCreator();
		Biomorph biomorph = bc.createBiomorph(childGenes[0], childGenes[1], childGenes[2], childGenes[3], childGenes[4], childGenes[5], childGenes[6], childGenes[7], childGenes[8], childGenes[9], childGenes[10]);
		return biomorph;
	}
}
