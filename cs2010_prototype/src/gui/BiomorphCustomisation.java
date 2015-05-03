package gui;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BiomorphCustomisation {
	
	private static JPanel modifyPane;
	private static JPanel colourPane;
	private static JPanel backPane;
	
	private static JFrame viewFrame;
	
	private static JSlider green;
	private static JSlider red;
	private static JSlider blue;
	
	final int  blankSpace = 10;
	
	// Sliders used
	private static JSlider chainSlider;
	private static JSlider branchSlider;
	private static JSlider lengthSlider;
	private static JSlider thicknessSlider;
	private static JSlider curvatureSlider;
	private static JSlider lengthIncrementSlider;
	private static JSlider thicknessIncrementSlider;

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
	
	private static JButton back;
	
	public BiomorphCustomisation(){
		viewFrame = new JFrame();	
		viewFrame.setSize(1024,  728);
		modifyPane = new JPanel();
		colourPane = new JPanel();
		backPane = new JPanel();
		
		chainLabel = new JLabel("Chain");
		chainSlider = new JSlider();
		chainLabel.setLabelFor(chainSlider);
		
		branchLabel = new JLabel("Branch");
		branchSlider = new JSlider();
		branchLabel.setLabelFor(branchSlider);
		
		lengthLabel = new JLabel("Length");
		lengthSlider= new JSlider();
		lengthLabel.setLabelFor(lengthSlider);
		
		thicknessLabel = new JLabel("Thickness");
		thicknessSlider = new JSlider();
		thicknessLabel.setLabelFor(thicknessSlider);
		
		curvatureLabel = new JLabel("Curvature");
		curvatureSlider = new JSlider();
		curvatureLabel.setLabelFor(curvatureSlider);
		
		lengthIncLabel = new JLabel("Length Increment");
		lengthIncrementSlider = new JSlider();
		lengthIncLabel.setLabelFor(lengthIncrementSlider);
		
		thicknessIncLabel = new JLabel("Thickness Increment");
		thicknessIncrementSlider = new JSlider();
		thicknessIncLabel.setLabelFor(thicknessIncrementSlider);

		modifyPane.setLayout(new BoxLayout(modifyPane, BoxLayout.Y_AXIS));
		modifyPane.setBorder(BorderFactory.createLineBorder(Color.black));

		modifyPane.add(branchLabel);
		modifyPane.add(branchSlider);
		modifyPane.add(chainLabel);
		modifyPane.add(chainSlider);
		modifyPane.add(lengthLabel);
		modifyPane.add(lengthSlider);
		modifyPane.add(thicknessLabel);
		modifyPane.add(thicknessSlider);
		modifyPane.add(curvatureLabel);
		modifyPane.add(curvatureSlider);
		modifyPane.add(lengthIncLabel);
		modifyPane.add(lengthIncrementSlider);
		modifyPane.add(thicknessIncLabel);
		modifyPane.add(thicknessIncrementSlider);

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
		
		back = new JButton();
		back.setText("Back");
		
		backPane.add(back);
		
		viewFrame.add(colourPane, BorderLayout.CENTER);
		viewFrame.add(modifyPane, BorderLayout.NORTH);
		viewFrame.add(backPane, BorderLayout.SOUTH);
	
	
	chainSlider.addChangeListener( new ChangeListener() {
		public void stateChanged(ChangeEvent c)
		{
            System.out.println(((JSlider) c.getSource()).getValue());
		}
	});
	
	branchSlider.addChangeListener( new ChangeListener() {
		public void stateChanged(ChangeEvent b)
		{
            System.out.println(((JSlider) b.getSource()).getValue());
		}
	});
	
	lengthSlider.addChangeListener( new ChangeListener() {
		public void stateChanged(ChangeEvent l)
		{
            System.out.println(((JSlider) l.getSource()).getValue());
		}
	});
	
	thicknessSlider.addChangeListener( new ChangeListener() {
		public void stateChanged(ChangeEvent t)
		{
            System.out.println(((JSlider) t.getSource()).getValue());
		}
	});
	
	
	curvatureSlider.addChangeListener( new ChangeListener() {
		public void stateChanged(ChangeEvent c)
		{
            System.out.println(((JSlider) c.getSource()).getValue());
		}
	});
		
	lengthIncrementSlider.addChangeListener( new ChangeListener() {
		public void stateChanged(ChangeEvent li)
		{
            System.out.println(((JSlider) li.getSource()).getValue());
		}
		});
	
	thicknessIncrementSlider.addChangeListener( new ChangeListener() {
		public void stateChanged(ChangeEvent th)
		{
            System.out.println(((JSlider) th.getSource()).getValue());
		}
	});	
	
	back.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
		viewFrame.setVisible(false);
		viewFrame.remove(backPane);
		viewFrame.remove(colourPane);
		viewFrame.remove(modifyPane);
		CreateClicked cc = new CreateClicked();
		viewFrame.add(cc.getContents());
		viewFrame.pack();
		viewFrame.setVisible(true);
		}
		});
	viewFrame.pack();
	viewFrame.setVisible(true);
	}

	public JPanel getContents()
	{
		return (JPanel)viewFrame.getContentPane();
	}


	public static void main(String[] args){
		BiomorphCustomisation bc = new BiomorphCustomisation();
	}
	
}