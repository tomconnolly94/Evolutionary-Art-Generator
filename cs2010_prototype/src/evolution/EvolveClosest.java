package evolution;

import program.Biomorph;
import program.BiomorphCreator;

public class EvolveClosest {

	private int[] perfectValues;
	private Biomorph father;
	private Biomorph mother;
	
	public EvolveClosest(Biomorph father, Biomorph mother, int[] perfectValues){
		this.perfectValues = perfectValues;
		this.father = father;
		this.mother = mother;
	}

	public Biomorph Evolve(){
		
		int branchChild;
		int branchIncrementChild;
		int chainChild;
		int colorBChild;
		int colorGChild;
		int colorRChild;
		int curvatureChild;
		int lengthChild;
		int lengthIncrementChild;
		int thicknessChild;
		int thicknessIncrementChild;
		
		//branch
		if((Math.abs(perfectValues[0] - father.getBranchValue())) < (Math.abs(perfectValues[0] - mother.getBranchValue()))){
			branchChild = father.getBranchValue();
		}
		else{
			branchChild = mother.getBranchValue();
		}
		
		//branchIncrement
		if((Math.abs(perfectValues[1] - father.getBranchIncrementValue())) < (Math.abs(perfectValues[1] - mother.getBranchIncrementValue()))){
			branchIncrementChild = father.getBranchIncrementValue();
		}
		else{
			branchIncrementChild = mother.getBranchIncrementValue();
		}
		
		//chain
		if((Math.abs(perfectValues[2] - father.getChainValue())) < (Math.abs(perfectValues[2] - mother.getChainValue()))){
			chainChild = father.getChainValue();
		}
		else{
			chainChild = mother.getChainValue();
		}
		
		//colorB
		if((Math.abs(perfectValues[3] - father.getColorBValue())) < (Math.abs(perfectValues[3] - mother.getColorBValue()))){
			colorBChild = father.getColorBValue();
		}
		else{
			colorBChild = mother.getColorBValue();
		}
		
		//colorG
		if((Math.abs(perfectValues[4] - father.getColorGValue())) < (Math.abs(perfectValues[4] - mother.getColorGValue()))){
			colorGChild = father.getColorGValue();
		}
		else{
			colorGChild = mother.getColorGValue();
		}
		
		//colorR
		if((Math.abs(perfectValues[5] - father.getColorRValue())) < (Math.abs(perfectValues[5] - mother.getColorRValue()))){
			colorRChild = father.getColorRValue();
		}
		else{
			colorRChild = mother.getColorRValue();
		}
		
		//curvature
		if((Math.abs(perfectValues[6] - father.getCurvatureValue())) < (Math.abs(perfectValues[6] - mother.getCurvatureValue()))){
			curvatureChild = father.getCurvatureValue();
		}
		else{
			curvatureChild = mother.getCurvatureValue();
		}
		
		//length
		if((Math.abs(perfectValues[7] - father.getLengthValue())) < (Math.abs(perfectValues[7] - mother.getLengthValue()))){
			lengthChild = father.getLengthValue();
		}
		else{
			lengthChild = mother.getLengthValue();
		}
		
		//lengthIncrement
		if((Math.abs(perfectValues[8] - father.getLengthIncrementValue())) < (Math.abs(perfectValues[8] - mother.getLengthIncrementValue()))){
			lengthIncrementChild = father.getLengthIncrementValue();
		}
		else{
			lengthIncrementChild = mother.getLengthIncrementValue();
		}
		
		//thickness
		if((Math.abs(perfectValues[9] - father.getThicknessValue())) < (Math.abs(perfectValues[9] - mother.getThicknessValue()))){
			thicknessChild = father.getThicknessValue();
		}
		else{
			thicknessChild = mother.getThicknessValue();
		}
		
		//thicknessIncrement
		if((Math.abs(perfectValues[10] - father.getThicknessIncrementValue())) < (Math.abs(perfectValues[10] - mother.getThicknessIncrementValue()))){
			thicknessIncrementChild = father.getThicknessIncrementValue();
		}
		else{
			thicknessIncrementChild = mother.getThicknessIncrementValue();
		}
		
		BiomorphCreator bc = new BiomorphCreator();
		Biomorph biomorph = bc.createBiomorph(branchChild, branchIncrementChild, chainChild, colorBChild, colorGChild, colorRChild, curvatureChild, lengthChild, lengthIncrementChild, thicknessChild, thicknessIncrementChild);		
		
		return biomorph;
	}
}