package program;

import java.util.LinkedList;
import java.util.Random;
import evolution.*;

public class BiomorphManager
{
	private LinkedList<Biomorph> biomorphCollection;
	int[] perfectValues =
	{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
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
		remove(3);
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
	/** @return How many biomorphs are currently held in the biomorphCollection */
	public int getSize()
	{
		return biomorphCollection.size();
	}
	public void addSpecific(Biomorph b)
	{
		biomorphCollection.add(b);
	}
	/**
	 * Takes the biomorphCollection and removes every Biomorph from it.
	 */
	public void emptyBiomorphCollection()
	{
		for (int i = 0; i < getSize(); i++)
		{
			remove(i);
		}
	}
/*
	*//**
	 * Two new biomorphs are created and immediately added to the
	 * biomorphCollection, then they are given to the EvolveBlend object to be
	 * evolved using its specific averaging algorithm. The resulting biomorph is
	 * then added to the array at index 2 so that the code on line 113 will find
	 * it.
	 *//*
	public void loadBiomorphsWithEvBle()
	{
		EvolveBlend eb = new EvolveBlend(getRandomBiomorph(), getRandomBiomorph());
		addSpecific(eb.evolve());
	}
	*//**
	 * Two new biomorphs are created and immediately added to the
	 * biomorphCollection, then they are given to the EvolveBlend object to be
	 * evolved using its specific 'closest value wins' algorithm. The resulting
	 * biomorph is then added to the array at index 2 so that the code on line
	 * 113 will find it.
	 *//*
	public void loadBiomorphsWithEvClo()
	{
		EvolveClosest ec = new EvolveClosest(getRandomBiomorph(), getRandomBiomorph(), perfectValues);
		addSpecific(ec.evolve());
		statisticMachine.saveGeneValues(ec.getChildGenes());
		statisticMachine.printRunningStats();
	}
*/
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
		biomorphCollection.add(0,biomorph);
		return biomorph;
	}
}
