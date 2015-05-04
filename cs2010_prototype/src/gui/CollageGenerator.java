package gui;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import biomorphHandling.BiomorphManager;

public class CollageGenerator
{
	private BiomorphManager bm;
	private int length;
	
	public CollageGenerator(BiomorphManager bm){
		this.bm=bm;
		this.length=10;
	}
	
	public void generate(){
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(length,length);
		panel.setLayout(layout);
		
		int biomorphCount= 0;
		for (int j = 0; j<length; j++){
		     for (int i = 0; i<length; i++){
		    	 if(!(biomorphCount>bm.getSize()-1)){
		    		 panel.add(new OpenGLCanvas(bm.getSpecific(biomorphCount),100).getCanvas());
		    		 biomorphCount++;
		    	 }
		    	 else{
		    		 panel.add(new OpenGLCanvas(null,100).getCanvas());
		    	 }
		     } 
		}
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args){
		BiomorphManager bm = new BiomorphManager();
		/*for(int i=0;i<100;i++){
			bm.createAndAdd();
		}*/
		CollageGenerator cg = new CollageGenerator(bm);
		cg.generate();
	}
	
}
