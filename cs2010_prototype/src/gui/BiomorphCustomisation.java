package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BiomorphCustomisation {
	
	private static JPanel modifyPane;
	private static JPanel colourPane;
	
	private static JFrame viewFrame;
	
	private static JSlider green;
	private static JSlider red;
	private static JSlider blue;
	
	final int  blankSpace = 10;
	
	// Sliders used
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
	private static JLabel redLabel;
	private static JLabel greenLabel;
	private static JLabel blueLabel;
	
	public BiomorphCustomisation(){
		initiate();
	}
	
	public void initiate(){
	viewFrame = new JFrame();	
	modifyPane = new JPanel();
	colourPane = new JPanel();
	chainLabel = new JLabel("Chain");
	chain = new JSlider();
	chainLabel.setLabelFor(chain);
	branchLabel = new JLabel("Branch");
	branch = new JSlider();
	branchLabel.setLabelFor(branch);
	lengthLabel = new JLabel("Length");
	length = new JSlider();
	lengthLabel.setLabelFor(length);
	thicknessLabel = new JLabel("Thickness");
	thickness = new JSlider();
	thicknessLabel.setLabelFor(thickness);
	curvatureLabel = new JLabel("Curvature");
	curvature = new JSlider();
	curvatureLabel.setLabelFor(curvature);
	lengthIncLabel = new JLabel("Length Increment");
	lengthIncrement = new JSlider();
	lengthIncLabel.setLabelFor(lengthIncrement);
	thicknessIncLabel = new JLabel("Thickness Increment");
	thicknessIncrement = new JSlider();
	thicknessIncLabel.setLabelFor(thicknessIncrement);

	modifyPane.setLayout(new BoxLayout(modifyPane, BoxLayout.Y_AXIS));
	modifyPane.setBorder(BorderFactory.createLineBorder(Color.black));

	modifyPane.add(chainLabel);
	modifyPane.add(chain);
	modifyPane.add(branchLabel);
	modifyPane.add(branch);
	modifyPane.add(lengthLabel);
	modifyPane.add(length);
	modifyPane.add(thicknessLabel);
	modifyPane.add(thickness);
	modifyPane.add(curvatureLabel);
	modifyPane.add(curvature);
	modifyPane.add(lengthIncLabel);
	modifyPane.add(lengthIncrement);
	modifyPane.add(thicknessIncLabel);
	modifyPane.add(thicknessIncrement);

	red = new JSlider();
	redLabel = new JLabel("Red");
	redLabel.setLabelFor(red);
	
	green = new JSlider();
	greenLabel = new JLabel("Green");
	greenLabel.setLabelFor(green);
	
	blue = new JSlider();
	blueLabel = new JLabel("Blue");
	blueLabel.setLabelFor(blue);


	colourPane.setLayout(new BoxLayout(colourPane, BoxLayout.X_AXIS));
	colourPane.setBorder(BorderFactory.createLineBorder(Color.black));
	colourPane.setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace) );
	
	colourPane.add(red);
	colourPane.add(redLabel);
	colourPane.add(green);
	colourPane.add(blueLabel);
	colourPane.add(blue);
	colourPane.add(greenLabel);
	
	viewFrame.add(colourPane, BorderLayout.SOUTH);
	viewFrame.add(modifyPane, BorderLayout.NORTH);
	
}
	public JPanel getContents()
	{
		return (JPanel)viewFrame.getContentPane();
	}

}



