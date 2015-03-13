



  package biomorphHandling;

import java.util.LinkedList;
import java.util.Random;
import evolution.*;
/**
 * Class to handle storing and manipulation of Biomorphs.
 * @author Tom Connolly
 * @version 04/03/2015
 */
public class BiomorphManager
{
	private LinkedList<Biomorph> biomorphCollection;
	// set of perfect values that the Biomorphs will evolve towards.
	private int[] perfectValues =
	{5, 5, 4, 100, 256, 50, 5, 8, 2, 2, 5};
	private EvolutionStats statisticMachine = new EvolutionStats(perfectValues);
	//integer to change the name of Biomorphs after they are saved.
	private int i=1;
	public BiomorphManager()
	{
		setUp();
	}
	public void setUp()
	{
		biomorphCollection = new LinkedList<Biomorph>();
		/* create 4 random orginal parent Biomorphs and load them into indexes
		 0-3 in collection*/
		for (int i = 0; i < 4; i++)
		{
			createAndAdd();
		}
		/*
		 * takes parents in indexes 0 and 1, evolves them together and places
		 * the resulting biomorph in index 0.
		 */
		Biomorph biomorph1 = evolveClo(biomorphCollection.get(0), biomorphCollection.get(1));
		biomorphCollection.add(0, biomorph1);
		/*
		 * takes parents in indexes 2 and 3, evolves them together and places
		 * the resulting biomorph in index 1.
		 */
		Biomorph biomorph2 = evolveClo(biomorphCollection.get(0), biomorphCollection.get(1));
		biomorphCollection.add(1, biomorph2);
		/*
		 * takes evolved parents in indexes 0 and 1, evolves them together and places
		 * the resulting biomorph in index 2.
		 */
		Biomorph biomorph3 = evolveClo(biomorphCollection.get(0), biomorphCollection.get(1));
		biomorphCollection.add(2, biomorph3);
		for (int i = 3; i < 7; i++)
		{
			remove(3);
		}
	}
	/**
	 * Creates a biomorph and adds it to the list of biomorphs.
	 */
	public Biomorph createAndAdd()
	{
		BiomorphCreator bc = new BiomorphCreator();
		// Biomorph biomorph = bc.createBiomorph(4,0,2,100,100,100,0,5,1,1,0);
		Biomorph biomorph = bc.createBiomorph();
		biomorphCollection.add(biomorph);
		return biomorph;
	}
	/**
	 * Clones and returns biomorphCollection solely for testing.
	 */
	public LinkedList<Biomorph> cloneCollection()
	{
		LinkedList<Biomorph> clonedCollection = biomorphCollection;
		return clonedCollection;
	}
	/**
	 * @return A random biomorph from the list
	 */
	public Biomorph getRandomBiomorph()
	{
		// if biomorphCollection is empty, create two random biomorphs to act as
		// initial parents
		if (biomorphCollection.size() < 2)
		{
			setUp();
		}
		Random rand = new Random();
		return biomorphCollection.get(rand.nextInt(biomorphCollection.size()));
	}
	/**
	 * Retrieves a specific biomorph by its index number in the list.
	 * @param index The index number
	 * @return The biomorph corresponding to the given index number
	 */
	public Biomorph getSpecific(int index)
	{
		return biomorphCollection.get(index);
	}
	/**
	 * Removes a biomorph corresponding to the given index number.
	 * @param index The index number
	 */
	public void remove(int index)
	{
		biomorphCollection.remove(index);
	}
	/**
	 * Takes two biomorphs and a set of perfect values, uses the EvolveClosest
	 * class to evolve them together. Then it reports the gene values to the
	 * EvolutionStats object and re
	 */
	public Biomorph evolveClo(Biomorph father, Biomorph mother)
	{
		Evolver ec = new Evolver(father, mother, perfectValues);
		Biomorph biomorph = ec.evolve();
		statisticMachine.saveGeneValues(ec.getChildGenes());
		statisticMachine.printRunningStats();
/*		//Code to save Biomorph TODO:
		Save save = new Save();
		String fileName = "Biomorph " + Integer.toString(i);
		i++;
		save.saveGeneValuesToTextFile(biomorph.getGenes(), fileName);*/
		return biomorph;
	}
}