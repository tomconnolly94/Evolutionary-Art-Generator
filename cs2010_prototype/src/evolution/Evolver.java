package evolution;
import biomorphHandling.Biomorph;
import biomorphHandling.BiomorphCreator;
import genes.*;
/**
 * Class to model a Evolutionary cycle where an array of 'perfect values' and
 * two parent biomorphs are given and one child, with gene values being that of
 * whichever parent had the value closest to the value set out in the 'perfect
 * values' array, is returned. Depending on the numbers in the 'perfect values'
 * array, models evolution quite closely as a child biomorph has for each gene
 * either the mothers gene value or the fathers, not a combination of both.
 * @author Tom Connolly
 * @version 24/02/2015
 */
public class Evolver
{
	/*
	 * Globally accessible arrays of the father's and mother's genes and a third
	 * array to hold thenumbers which will become the child's gene values.
	 */
	private int[] perfectValues;
	private Biomorph father;
	private Biomorph mother;
	private int[] childGenes;
	private Gene[] motherGenes;
	private Gene[] fatherGenes;
	
	// Assigns parameters to global variables so they can be accessed further
	// on.
	public Evolver(Biomorph father, Biomorph mother, int[] perfectValues)
	{
		this.perfectValues = perfectValues;
		this.father = father;
		this.mother = mother;
	}
	/**
	 * This method takes two sets of genes and for each one compares it to the
	 * number held in the 'perfect values' array, whichever number is closest to
	 * the perfect value is assigned to an array of numbers which are given to a
	 * new child biomorph as gene values.
	 * @return A Biomorph with gene values as described above.
	 */
	public Biomorph evolve()
	{
		/*
		 * The father and mother's genes are extracted from the Biomorph itself
		 * into arrays and the childGenes array is instantiated.
		 */
		fatherGenes = father.getGenes();
		motherGenes = mother.getGenes();
		childGenes = new int[11];
		/*
		 * Each father gene and each mother gene are pulled out and compared to
		 * the 'perfect value', the gene value closest to the perfect number is
		 * added to the child Genes array.
		 */
		for (int i = 0; i < fatherGenes.length; i++)
		{
			if ((Math.abs(perfectValues[i] - fatherGenes[i].getValue())) < (Math.abs(perfectValues[i] - motherGenes[i].getValue())))
			{
				childGenes[i] = fatherGenes[i].getValue();
			}
			else
			{
				childGenes[i] = motherGenes[i].getValue();
			}
		}
		// BiomorphCreator is used to create a new child biomorph with the
		// values held in the array 'childGenes'.
		BiomorphCreator bc = new BiomorphCreator();
		Biomorph biomorph = bc.createBiomorph(childGenes[0], childGenes[1], childGenes[2], childGenes[3], childGenes[4], childGenes[5], childGenes[6], childGenes[7], childGenes[8], childGenes[9], childGenes[10]);

		return biomorph;
	}
	
	public int[] getChildGenes(){
		return childGenes;
	}

}