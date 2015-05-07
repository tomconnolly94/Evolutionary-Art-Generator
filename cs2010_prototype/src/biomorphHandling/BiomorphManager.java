package biomorphHandling;
import java.util.LinkedList;
import java.util.Random;
import evolution.*;
/**
 * Class to handle storing and manipulation of Biomorphs.
 * @author Tom Connolly
 * @version 05/05/2015
 */
public class BiomorphManager
{
	private LinkedList<Biomorph> biomorphCollection;
	private int[] targetValues = {5, 2, 5, 8, 2, 2, 100, 256, 50, 100, 100, 100}; // Set of target values that the biomorphs will evolve towards.
	private EvolutionStats statisticMachine;
	private boolean useEvolveClo;
	/**
	 * Constructor
	 */
	public BiomorphManager()
	{
		setUp();
		statisticMachine = new EvolutionStats(targetValues);
		useEvolveClo = true;
	}
	/**
	 * Initialises the first set of biomorphs.
	 */
	public void setUp()
	{
		biomorphCollection = new LinkedList<Biomorph>();
		for (int i = 0; i < 9; i++) createAndAdd();
	}
	/**
	 * Adds a specific biomorph to the collection.
	 * @param b The biomorph to add
	 */
	public void addSpecific(Biomorph b)
	{
		biomorphCollection.add(0, b);
	}
	/**
	 * Creates a biomorph and adds it to the start of a list of biomorphs.
	 */
	public Biomorph createAndAdd()
	{
		BiomorphCreator bc = new BiomorphCreator();
		Biomorph biomorph = bc.createRandomBiomorph();
		biomorphCollection.addLast(biomorph);
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
		// If biomorphCollection is empty, create two random biomorphs to act as initial parents
		if (biomorphCollection.size() < 2) setUp();
		Random rand = new Random(10);
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
	 * Takes two biomorphs and a set of perfect values, uses the EvolveClosest class to evolve them together. Then it reports the gene values to the EvolutionStats object and re
	 */
	public Biomorph evolve(Biomorph father, Biomorph mother)
	{
		Biomorph biomorph;
		Evolver ec = new Evolver(father, mother, targetValues);
		if (useEvolveClo)
		{
			biomorph = ec.evolveClo();
		}
		else
		{
			biomorph = ec.evolveAv();
		}
		statisticMachine.saveGeneValues(ec.getChildGenes());
		return biomorph;
	}
	public int getSize()
	{
		return biomorphCollection.size();
	}
	public void updateTargetValues(int gene1, int gene2, int gene3, int gene4, int gene5, int gene6, int gene7, int gene8, int gene9, int gene10, int gene11, int gene12)
	{
		int[] newTargetValues =
		{gene1, gene2, gene3, gene4, gene5, gene6, gene7, gene8, gene9, gene10, gene11, gene12};
		targetValues = newTargetValues;
	}
	public void printTargetValues()
	{
		for (int i = 0; i < 12; i++) System.out.println(targetValues[i]);
	}
	public EvolutionStats getEvolStats()
	{
		return statisticMachine;
	}
	public void setEvolveClo(boolean bool)
	{
		this.useEvolveClo = bool;
	}
	public boolean getUseEvolveClo()
	{
		return useEvolveClo;
	}
	public int[] getTargetValues()
	{
		return targetValues;
	}
}