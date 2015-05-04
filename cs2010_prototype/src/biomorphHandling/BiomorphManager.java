package biomorphHandling;
import java.util.LinkedList;
import java.util.Random;
import evolution.*;
/**
 * Class to handle storing and manipulation of Biomorphs.
 * @author Tom Connolly
 * @version 24/04/2015
 */
public class BiomorphManager
{
	private LinkedList<Biomorph> biomorphCollection;
	// set of perfect values that the Biomorphs will evolve towards.
	private int[] targetValues = {5, 2, 5, 8, 2, 2, 100, 256, 50, 100, 100, 100};
	private EvolutionStats statisticMachine;
	private boolean useEvolveClo;
	// integer to change the name of Biomorphs after they are saved.
	// private int i = 1;
	public BiomorphManager()
	{
		setUp();
		statisticMachine = new EvolutionStats(targetValues);
		useEvolveClo = true;
	}
	public void setUp()
	{
		biomorphCollection = new LinkedList<Biomorph>();
		for(int i=0;i<9;i++){
			createAndAdd();		
		}
	}
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
		// Biomorph biomorph = bc.createBiomorph(4,0,2,100,100,100,0,5,1,1,0);
		Biomorph biomorph = bc.createRandomBiomorph();
		biomorphCollection.addLast(biomorph);
		return biomorph;
	}
	/**
	 * Creates a biomorph and adds it to the end of a list of biomorphs.
	 */

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
	 * Takes two biomorphs and a set of perfect values, uses the EvolveClosest
	 * class to evolve them together. Then it reports the gene values to the
	 * EvolutionStats object and re
	 */
	public Biomorph evolve(Biomorph father, Biomorph mother)
	{
		Biomorph biomorph;
		Evolver ec = new Evolver(father, mother, targetValues);
		if(useEvolveClo){
			biomorph = ec.evolveClo();
			//System.out.println(biomorph.getMother());
			//System.out.println(biomorph.getFather());
		}
		else{
			biomorph = ec.evolveAv();
		}
		statisticMachine.saveGeneValues(ec.getChildGenes());
		
		return biomorph;
	}
	
	public int getSize(){
		return biomorphCollection.size();
	}
	
	public void updateTargetValues(int gene1,int gene2,int gene3,int gene4,int gene5,int gene6,int gene7,int gene8,int gene9,int gene10,int gene11,int gene12){
		int[] newTargetValues = {gene1,gene2,gene3,gene4,gene5,gene6,gene7,gene8,gene9,gene10,gene11,gene12};
		targetValues = newTargetValues;
	}
	
	public void printTargetValues(){
		for(int i=0;i<12;i++){
			System.out.println(targetValues[i]);
		}
	}
	public EvolutionStats getEvolStats(){
		return statisticMachine;
	}
	
	public void setEvolveClo(boolean bool){
		this.useEvolveClo = bool;
	}
	
	public boolean getUseEvolveClo(){
		return useEvolveClo;
	}
	 
	public int[] getTargetValues(){
		return targetValues;
	}
}