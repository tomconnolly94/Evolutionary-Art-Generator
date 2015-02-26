package program;
import java.util.ArrayList;
import java.util.Random;
import evolution.*;
public class BiomorphManager
{
	private ArrayList<Biomorph> biomorphCollection = new ArrayList<Biomorph>();
	int[] perfectValues =
	{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
	EvolutionStats es = new EvolutionStats();
	
	public BiomorphManager()
	{
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
		Random rand = new Random();
		return biomorphCollection.get(rand.nextInt(biomorphCollection.size() - 1));
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
	/**
	 * Two new biomorphs are created and immediately added to the
	 * biomorphCollection, then they are given to the EvolveBlend object to be
	 * evolved using its specific averaging algorithm. The resulting biomorph is
	 * then added to the array at index 2 so that the code on line 113 will find
	 * it.
	 */
	public void loadBiomorphsWithEvBle()
	{
		EvolveBlend eb = new EvolveBlend(createAndAdd(), createAndAdd());
		addSpecific(eb.evolve());
	}
	/**
	 * Two new biomorphs are created and immediately added to the
	 * biomorphCollection, then they are given to the EvolveBlend object to be
	 * evolved using its specific 'closest value wins' algorithm. The resulting
	 * biomorph is then added to the array at index 2 so that the code on line
	 * 113 will find it.
	 */
	public void loadBiomorphsWithEvClo()
	{
		EvolveClosest ec = new EvolveClosest(createAndAdd(), createAndAdd(), perfectValues);
		addSpecific(ec.evolve());
		es.saveGeneValues(ec.getChildGenes());
		es.printStats();
	}
}
