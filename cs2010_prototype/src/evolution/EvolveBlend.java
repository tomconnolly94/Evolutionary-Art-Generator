package evolution;

import program.Biomorph;
import program.BiomorphCreator;
import genes.*;
/**
 * Class to model a Evolutionary cycle where two parents are given and one child, with gene values 
 * being the average of their parents, is returned.
 * 
 * Doesnt model evolution very well as genes are not spliced together half from your mother and 
 * half from your father, Each person has either one or the other.
 * 
 * @author Tom Connolly
 * @version 24/02/2015
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
