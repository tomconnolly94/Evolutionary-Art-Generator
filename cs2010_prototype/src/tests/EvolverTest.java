package tests;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import evolution.Evolver;
import genes.Gene;
import biomorphHandling.Biomorph;

public class EvolverTest
{
	private Evolver e;
	private int[] targetValues = {1,1,1,1,1,1,1,1,1,1,1,1};;
	@Before
	public void setup(){
		Biomorph b1 = new Biomorph(null,null,0,0,0,0,0,0,0,0,0,0,0,0);
		Biomorph b2 = new Biomorph(null,null,10,10,10,10,10,10,10,10,10,10,10,10);
		e = new Evolver(b1,b2,targetValues);
	}
	
	@Test
	public void testEvolveClo(){
		Biomorph b3 = e.evolveClo();
		Gene[] genes = b3.getGenes();
		for(int i=0;i<genes.length;i++){
			assertEquals(genes[i].getValue(),targetValues[i]);
		}
			
	}
}
