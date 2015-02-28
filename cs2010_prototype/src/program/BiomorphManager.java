package program;

import java.util.LinkedList;
import java.util.Random;
import evolution.*;

public class BiomorphManager
{
	private LinkedList<Biomorph> biomorphCollection;
	//set of perfect values that the Biomorphs will evolve towards.
	int[] perfectValues =
	{5, 5, 4, 255, 1, 1, 5, 10, 5, 1, 5};
	EvolutionStats statisticMachine = new EvolutionStats();
	
	public BiomorphManager()
	{
		biomorphCollection = new LinkedList<Biomorph>();
		//create 4 random orginal parent Biomorphs and load them into indexes 1-3 in collection
		for(int i=0; i<4; i++){
		createAndAdd();
		}
		/*takes parents in indexes 0 and 1, evolves them together and places the 
		 *resulting biomorph in index 0.*/
		biomorphCollection.set(0, evolveClo(biomorphCollection.get(0), biomorphCollection.get(1)));
		/*takes parents in indexes 0 and 1, evolves them together and places the 
		 *resulting biomorph in index 0.*/
		biomorphCollection.set(1, evolveClo(biomorphCollection.get(2), biomorphCollection.get(3)));
		/*takes parents in indexes 0 and 1, evolves them together and places the 
		 *resulting biomorph in index 0.*/
		biomorphCollection.set(2, evolveClo(biomorphCollection.get(0), biomorphCollection.get(1)));
		for(int i=0; i<4; i++){
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
	 * @return A random biomorph from the list
	 */
	public Biomorph getRandomBiomorph()
	{
		//if biomorphCollection is empty, create two random biomorphs to act as initial parents
		if(biomorphCollection.size() < 2){
			createAndAdd();
			createAndAdd();
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
	 * Takes two biomorphs and a set of perfect values, uses the EvolveClosest class
	 * to evolve them together. Then it reports the gene values to the EvolutionStats 
	 * object and re
	 */
	public Biomorph evolveClo(Biomorph father, Biomorph mother){
		EvolveClosest ec = new EvolveClosest(father, mother, perfectValues);
		Biomorph biomorph = ec.evolve();
		statisticMachine.saveGeneValues(ec.getChildGenes());
		statisticMachine.printRunningStats();
		biomorphCollection.addFirst(biomorph);
		createAndAdd();
		return biomorph;
	}
}