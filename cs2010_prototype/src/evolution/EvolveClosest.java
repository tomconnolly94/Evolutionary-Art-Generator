package evolution;

import program.Biomorph;
import program.BiomorphCreator;
import genes.*;

public class EvolveClosest{

	private int[] perfectValues;
	private Biomorph father;
	private Biomorph mother;
	
	public EvolveClosest(Biomorph father, Biomorph mother, int[] perfectValues){
		this.perfectValues = perfectValues;
		this.father = father;
		this.mother = mother;
	}

	public Biomorph evolve(){
		
		Gene[] fatherGenes = father.getGenes();
		Gene[] motherGenes = mother.getGenes();
		int[] childGenes = new int[11];

		/*	loop to cycle through all the father genes and for each one choose either the gene
		 *  from the mother of the gene from the father to be assigned to an array called 'childGenes' 
		 *  which holds all the values (in order) of the Genes.
		 */
		for(int i=0; i<fatherGenes.length; i++){
			if((Math.abs(perfectValues[i] - fatherGenes[i].getValue())) < (Math.abs(perfectValues[i] - motherGenes[i].getValue()))){
				childGenes[i] = fatherGenes[i].getValue();
			}
			else{
				childGenes[i] = motherGenes[i].getValue();
			}
		}
		//use biomorph creator to create a new child biomorph with the values held in the array 'childGenes'
		BiomorphCreator bc = new BiomorphCreator();
		Biomorph biomorph = bc.createBiomorph(childGenes[0], childGenes[1], childGenes[2], childGenes[3], childGenes[4], childGenes[5], childGenes[6], childGenes[7], childGenes[8], childGenes[9], childGenes[10]);		
		
		return biomorph;
	}
}