package gui;

import java.awt.*;
import javax.swing.*;

/**
 * The right panel of the GUI
 * @author Charandeep Rai
 */

public class RightPanel {
	//Frames used
	private static JFrame opening;
	private static JFrame createClicked;
	private static JFrame modifyPane;
	private static  JFrame colour;  
	//Buttons used
	private static JButton create;
	private static JButton modify;
	private static JButton evolve;
	private static JButton random;
	private static JButton green;
	private static JButton red;
	private static JButton blue;
	private static JButton back;
	//Sliders used
	private static JSlider chain;
	private static JSlider branch;
	private static JSlider length;
	private static JSlider thickness;
	private static JSlider curvature;
	private static JSlider lengthIncrement;
	private static JSlider thicknessIncrement;
	
	private static JLabel chainLabel;
	private static JLabel branchLabel;
	private static JLabel lengthLabel;
	private static JLabel thicknessLabel;
	private static JLabel curvatureLabel;
	private static JLabel lengthIncLabel;
	private static JLabel thicknessIncLabel;
	private static JLabel redlabel;
	private static JLabel greenlabel;
	private static JLabel bluelabel;
	
	public RightPanel() {
		initiate();
	}
		
public void initiate(){
	//Create instance of side container
	
	opening = new JFrame ("Menu");
	opening.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
	//Listeners
	
	//setTitle
	opening.setTitle("Menu");
	
	//Create Buttons
	create = new JButton ("Create");
	random = new JButton ("Random");

	
	//Set Layout
	opening.setLayout(new BoxLayout(opening, BoxLayout.Y_AXIS));
	opening.add(Box.createRigidArea(new Dimension(0,5)));
}		

public void createClicked(){
	//Create instance of side container
	createClicked = new JFrame ("Menu");
	createClicked.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
	createClicked.setTitle("Menu");
	
	modify = new JButton ("Modify");
	random = new JButton ("Random");
	evolve = new JButton ("Evolve");
	//Set Layout
	createClicked.setLayout(new BoxLayout(createClicked, BoxLayout.Y_AXIS));
	createClicked.add(Box.createRigidArea(new Dimension(0,5)));
	
	

}

public void modify(){
	modifyPane = new JFrame ("Menu");
	modifyPane.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
	modifyPane.setTitle("Menu");
	
	//initialise the sliders, I need to find out the ranges of the genes.
	chainLabel = new JLabel("Chain");
	chain = new JSlider();
	chainLabel.setLabelFor(chain);
	branchLabel = new JLabel("Branch");
	branch = new JSlider();
	lengthLabel = new JLabel("Length");
	length = new JSlider();
	thicknessLabel = new JLabel("Thickness");
	thickness = new JSlider();
	curvatureLabel = new JLabel("Curvature");
	curvature = new JSlider();
	lengthIncLabel = new JLabel("Length Increment");
	lengthIncrement = new JSlider();
	thicknessIncLabel = new JLabel("Thickness Increment");
	thicknessIncrement = new JSlider();
	
	modify.setLayout(new BoxLayout(opening, BoxLayout.Y_AXIS));
	modify.add(Box.createRigidArea(new Dimension(0,5)));
	
	
	colour = new JFrame ("Colour");
	red = new JButton ("Red");
	green = new JButton ("Green");
	blue = new JButton ("Blue");
	colour.setLayout(new BoxLayout(opening, BoxLayout.X_AXIS));
	colour.add(Box.createRigidArea(new Dimension(0,5)));
	
	
	
}

public static void main(String[] args){
	RightPanel rp = new RightPanel();
}

}


