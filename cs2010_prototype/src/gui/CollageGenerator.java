package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import biomorphHandling.BiomorphManager;

public class CollageGenerator
{
	private BiomorphManager bm;
	private OpenGLCanvas[][] canvasArray;
	
	public CollageGenerator(BiomorphManager bm){
		this.bm=bm;
	}
	
	public void buildCollection(){
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		canvasArray = new OpenGLCanvas[10][10];
		int biomorphCount= 0;
		for (int j = 0; j<canvasArray.length; j++){
		     for (int i = 0; i<canvasArray[i].length; i++){
		    	 canvasArray[i][j] = new OpenGLCanvas(bm.getSpecific(biomorphCount),100);
		    	 biomorphCount++;
		     } 

		}
		
	}
	
	public void generate(){
		
	}
}
