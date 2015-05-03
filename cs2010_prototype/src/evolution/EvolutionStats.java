package evolution;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTextArea;
/**
 * Class to take the gene values from a Biomorph and store them to be printed when called.
 * @author Tom Connolly
 * @version 24/04/2015
 */
public class EvolutionStats
{
	// Fields
	private ArrayList<int[]> statsMaster;
	private ArrayList<String> runningStats;
	private int[] targetValues;
	private int numOfGenes = 12;
	/*
	 * Constructor initialises all fields and loads the geneNames so that genes
	 * can be labelled. also fills arrayList with the names of each gene to be
	 * used later.
	 */
	public EvolutionStats(int[] targetValues)
	{
		this.targetValues = targetValues;
		statsMaster = new ArrayList<int[]>(50);
		loadGeneNames();
	}
	/**
	 * Takes an array of integers, and adds its values to the savedValues array.
	 * @param values
	 */
	public void saveGeneValues(int[] values)
	{
		int[] savedValues = new int[numOfGenes];
		for (int i = 0; i < numOfGenes; i++)
		{
			savedValues[i] = values[i];
		}
		statsMaster.add(savedValues);
	}
	/*
	 * Method to concatenate new gene values to a Sting of old values and print them all out.
	 */
	public void printRunningStats()
	{
		for (int arrayIndex = statsMaster.size() - 1; arrayIndex < statsMaster.size(); arrayIndex++)
		{
			System.out.println("");
			System.out.println("~~~~~~~~~~ Iteration " + (arrayIndex + 1) + " ~~~~~~~~~~");
			System.out.println("");
			for (int dataIndex = 0; dataIndex < numOfGenes; dataIndex++)
			{
				String spaces = " ~ ";
				String val = Integer.toString(statsMaster.get(arrayIndex)[dataIndex]);
				runningStats.set(dataIndex, runningStats.get(dataIndex) + val + spaces);
				System.out.println(runningStats.get(dataIndex));
			}
		}
	}
	
	public JTextArea returnStats()
	{
		
		JTextArea textArea = new JTextArea();
		if(statsMaster.size()>=1){
			for (int arrayIndex = 0; arrayIndex < statsMaster.size(); arrayIndex++)
			{
				for (int dataIndex = 0; dataIndex < numOfGenes; dataIndex++)
				{
					String spaces = " ~ ";
					String val = Integer.toString(statsMaster.get(arrayIndex)[dataIndex]);
					runningStats.set(dataIndex, runningStats.get(dataIndex) + val + spaces);

					System.out.println(runningStats.get(dataIndex));
				}
			}
			textArea.append("Gene values for all evolved Biomorphs\n\n");
			for(int i=0;i<12;i++){
				textArea.append(runningStats.get(i) + "\n");
			}
		}
		else{
			textArea.append("No Biomorphs have been created please press 'Evolve'");
		}
		return textArea;
	}
	/**
	 * Method to load all the geneNames into an array ready to be used for printing.
	 */
	private void loadGeneNames()
	{
		String pv = "(PV)~~ ";
		runningStats = new ArrayList<String>(numOfGenes);
		runningStats.add("Branch              " + targetValues[0] + pv);
		runningStats.add("Chain               " + targetValues[1] + pv);
		runningStats.add("Color Red           " + targetValues[2] + pv);
		runningStats.add("Color Green         " + targetValues[3] + pv);
		runningStats.add("Color Blue          " + targetValues[4] + pv);
		runningStats.add("Length              " + targetValues[5] + pv);
		runningStats.add("Length Increment    " + targetValues[6] + pv);
		runningStats.add("Thickness           " + targetValues[7] + pv);
		runningStats.add("Thickness Increment " + targetValues[8] + pv);
		runningStats.add("Iridescence Red     " + targetValues[9] + pv);
		runningStats.add("Iridescence Green   " + targetValues[10] + pv);
		runningStats.add("Iridescence Blue    " + targetValues[11] + pv);
	}
	
	public void clearStats(){
		statsMaster.clear();
		runningStats.clear();
	}
	
	public void updateTargetValues(int[] targetValues){
		this.targetValues = targetValues;
	}
	public ArrayList<String> getRunningStats(){
		return runningStats;
	}
}