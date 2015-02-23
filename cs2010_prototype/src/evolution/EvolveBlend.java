package evolution;

import program.Biomorph;
import program.BiomorphCreator;

/**
 * Class to take two Biomorphs, take the average of all their gene values and 
 * assign those to a new Biomorph which is returned.
 * @author Tom Connolly, Jack Taylor
 * @version 18/12/2014
 */
public class EvolveBlend {

	
	
	public EvolveBlend(){
		
	}
	
	public Biomorph evolve(Biomorph father, Biomorph mother){
		
		int branchChild = (father.getBranchValue() + mother.getBranchValue())/2;
		int branchIncrementChild = (father.getBranchIncrementValue() + mother.getBranchIncrementValue())/2;
		int chainChild = (father.getChainValue() + mother.getChainValue())/2;
		int colorBChild = (father.getColorBValue() + mother.getColorBValue())/2;
		int colorGChild = (father.getColorGValue() + mother.getColorGValue())/2;
		int colorRChild = (father.getBranchValue() + mother.getBranchValue())/2;
		int curvatureChild = (father.getCurvatureValue() + mother.getCurvatureValue())/2;
		int lengthChild = (father.getLengthValue() + mother.getLengthValue())/2;
		int lengthIncrementChild = (father.getLengthIncrementValue() + mother.getLengthIncrementValue())/2;
		int thicknessChild = (father.getThicknessValue() + mother.getThicknessValue())/2;
		int thicknessIncrementChild = (father.getThicknessIncrementValue() + mother.getThicknessIncrementValue())/2;
		
		
		BiomorphCreator bc = new BiomorphCreator();
		Biomorph biomorph = bc.createBiomorph(branchChild, branchIncrementChild, chainChild, colorBChild, colorGChild, colorRChild, curvatureChild, lengthChild, lengthIncrementChild, thicknessChild, thicknessIncrementChild);		
		
		return biomorph;
	}
}
