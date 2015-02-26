package evolution;

import genes.Gene;
import java.util.ArrayList;


public class EvolutionStats
{
	private ArrayList<int[]> statsMaster;
	private ArrayList<String> names;
	private int numOfGenes = 11;
	private ArrayList<String> run;
	
	public EvolutionStats(){
		statsMaster = new ArrayList<int[]>(50);
		loadGeneNames();

		run = new ArrayList<String>(numOfGenes);
		for(int i=0; i<numOfGenes; i++){
			run.add(names.get(i));
		}
	}
	
	public void saveGeneValues(int[] values){
		int[] savedValues = new int[numOfGenes];
		for(int i=0; i<numOfGenes; i++){
			savedValues[i] = values[i];
		}
		statsMaster.add(savedValues);
	}
	
	public void extractAndSaveValuesFromGenes(Gene[] values){
		int[] savedValues = new int[numOfGenes];
		for(int i=0; i<numOfGenes; i++){
			savedValues[i] = values[i].getValue();
		}
		statsMaster.add(savedValues);
	}
	
	public void printBiomorphStats(){
		for(int arrayIndex=statsMaster.size()-1; arrayIndex<statsMaster.size(); arrayIndex++){
			System.out.println("");
			System.out.println("Biomorph " + (arrayIndex+1));
			System.out.println("");
			for(int dataIndex=0; dataIndex<numOfGenes; dataIndex++){
				System.out.println(names.get(dataIndex)+": " + statsMaster.get(arrayIndex)[dataIndex]);
			}
		}
	}
	
	public void printRunningStats(){
		for(int arrayIndex=statsMaster.size()-1; arrayIndex<statsMaster.size(); arrayIndex++){
			System.out.println("");
			System.out.println("---------- Iteration " + (arrayIndex+1) + " ----------");
			System.out.println("");
			for(int dataIndex=0; dataIndex<numOfGenes; dataIndex++){
				String val = Integer.toString(statsMaster.get(arrayIndex)[dataIndex]);
				run.set(dataIndex, run.get(dataIndex) + " - " + val);
			}
		}
		for(String line : run){
			System.out.println(line);
		}
	}
	
	public void loadGeneNames(){
		names = new ArrayList<String>(numOfGenes);
		names.add("Branch");
		names.add("Branch Increment");
		names.add("Chain");
		names.add("Color Red");
		names.add("Color Green");
		names.add("Color Blue");
		names.add("Curvature");
		names.add("Length");
		names.add("Length Increment");
		names.add("Thickness");
		names.add("Thickness Increment");
	}

/*
	public static void main(String[] args){
		EvolutionStats es = new EvolutionStats();
		int[] array1 = new int[numOfGenes];
		for(int i=0; i<numOfGenes; i++){
			array1[i] = i+5;
		}
		es.saveStats(array1);
		for(int i=0; i<numOfGenes; i++){
			array1[i] = i+10;
		}
		es.saveStats(array1);
		es.printStats();
	}*/
}