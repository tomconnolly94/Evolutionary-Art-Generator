package evolution;

import java.util.ArrayList;


public class EvolutionStats
{
	private ArrayList<int[]> statsMaster;
	
	public EvolutionStats(){
		statsMaster = new ArrayList<int[]>(50); 
	}
	
	public void saveStats(int[] values){
		int[] savedValues = new int[11];
		for(int i=0; i<11; i++){
			savedValues[i] = values[i];
		}
		statsMaster.add(savedValues);
	}
	
	public void printStats(){
		for(int arrayIndex=0; arrayIndex<statsMaster.size(); arrayIndex++){
			System.out.println("");
			System.out.println("Biomorph " + (arrayIndex+1));
			System.out.println("");
			for(int dataIndex=0; dataIndex<11; dataIndex++){
				System.out.println(statsMaster.get(arrayIndex)[dataIndex]);
			}
		}
	}


	public static void main(String[] args){
		EvolutionStats es = new EvolutionStats();
		int[] array1 = new int[11];
		for(int i=0; i<11; i++){
			array1[i] = i+5;
		}
		es.saveStats(array1);
		for(int i=0; i<11; i++){
			array1[i] = i+10;
		}
		es.saveStats(array1);
		es.printStats();
	}
}