package evolution;

import program.Biomorph;
import program.BiomorphCreator;
import genes.*;

/**
 * Class to take two Biomorphs, take the average of all their gene values and 
 * assign those to a new Biomorph which is returned.
 * @author Tom Connolly, Jack Taylor
 * @version 18/12/2014
 */
public class EvolveBlend {

	private Gene[] fatherGenes;
	private Gene[] motherGenes;
	private int[] childGenes;
	
	public EvolveBlend(Biomorph father, Biomorph mother){
		fatherGenes = father.getGenes();
		motherGenes = mother.getGenes();
		childGenes = new int[11];
	}
	
	public Biomorph evolve(){
		
		for(int i = 0; i<fatherGenes.length; i++){
			childGenes[i] = (fatherGenes[i].getValue() + motherGenes[i].getValue())/2;
		}
		
		BiomorphCreator bc = new BiomorphCreator();
		Biomorph biomorph = bc.createBiomorph(childGenes[0], childGenes[1], childGenes[2], childGenes[3], childGenes[4], childGenes[5], childGenes[6], childGenes[7], childGenes[8], childGenes[9], childGenes[10]);		
		
		return biomorph;
	}
}
