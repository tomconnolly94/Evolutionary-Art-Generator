package evolution;
import biomorphHandling.Biomorph;
import biomorphHandling.BiomorphCreator;
import genes.*;
/**
 * Class to model a Evolutionary cycle where an array of 'perfect values' and two parent biomorphs are given, and one child (with gene values being that of whichever
 * parent had the value closest to the value set out in the 'perfect values' array) is returned. Depending on the numbers in the 'target values' array, models
 * evolution quite closely as a child biomorph has for each gene either the mothers gene value or the fathers, not a blend of the values for each gene.
 * @author Tom Connolly
 * @version 05/05/2015
 */
public class Evolver
{
	/**
	 * Globally accessible parent Biomorphs and arrays of the father's and mother's genes and a third array to hold the numbers which will become the child's gene values.
	 */
	private int[] targetValues;
	private int[] childGenes;
	private Gene[] motherGenes;
	private Gene[] fatherGenes;
	private Biomorph mother;
	private Biomorph father;
	/**
	 * Assigns parameters to global variables so they can be accessed further on.
	 */
	public Evolver(Biomorph father, Biomorph mother, int[] targetValues)
	{
		this.father = father;
		this.mother = mother;
		this.targetValues = targetValues;
		fatherGenes = father.getGenes();
		motherGenes = mother.getGenes();
		childGenes = new int[12];
	}
	/**
	 * This method takes two sets of genes and for each one compares it to the number held in the 'target values' array, whichever number is closest
	 * to the perfect value is assigned to an array of numbers which are given to a new child biomorph as gene values.
	 * @return A Biomorph with gene values as described above.
	 */
	public Biomorph evolveClo()
	{
		for (int i = 0; i < childGenes.length; i++)
		{
			if ((Math.abs(targetValues[i] - fatherGenes[i].getValue())) < (Math.abs(targetValues[i] - motherGenes[i].getValue()))) childGenes[i] = fatherGenes[i].getValue();
			else childGenes[i] = motherGenes[i].getValue();
		}
		// BiomorphCreator is used to create a new child biomorph with the values held in the array 'childGenes'.
		BiomorphCreator bc = new BiomorphCreator();
		Biomorph biomorph = bc.createBiomorph(father, mother, childGenes[0], childGenes[1], childGenes[2], childGenes[3], childGenes[4], childGenes[5], childGenes[6], childGenes[7], childGenes[8], childGenes[9], childGenes[10], childGenes[11]);
		return biomorph;
	}
	/**
	 * This method takes two sets of genes and creates a child biomorph with an average of the two sets.
	 * @return A Biomorph with gene values as described above.
	 */
	public Biomorph evolveAv()
	{
		for (int i = 0; i < childGenes.length; i++) childGenes[i] = (fatherGenes[i].getValue() + motherGenes[i].getValue()) / 2;
		BiomorphCreator bc = new BiomorphCreator();
		Biomorph biomorph = bc.createBiomorph(father, mother, childGenes[0], childGenes[1], childGenes[2], childGenes[3], childGenes[4], childGenes[5], childGenes[6], childGenes[7], childGenes[8], childGenes[9], childGenes[10], childGenes[11]);
		return biomorph;
	}
	/**
	 * Method to get the genes of the evolved Biomorph
	 * @return Integer array of gene values from the evolved Biomorph
	 */
	public int[] getChildGenes(){
		return childGenes;
	}
}