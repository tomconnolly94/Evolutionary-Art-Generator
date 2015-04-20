package gui;
import java.awt.*;
import javax.swing.*;
public class RightPanel
{
	/**
	 * The right panel of the GUI
	 * @author Charandeep Rai
	 */
	// Frames used
	private static JFrame viewFrame;
	// Panels used
	private static JPanel openingPane;
	private static JPanel createClicked;
	private static JPanel modifyPane;
	private static JPanel colourPane;
	// Buttons used
	private static JButton create;
	private static JButton modify;
	private static JButton evolve;
	private static JButton random;
	private static JButton green;
	private static JButton red;
	private static JButton blue;
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
	public RightPanel()
	{
		initiate();
	}
	public void initiate()
	{
		// Create instance of side container
		viewFrame = new JFrame("Menu");
		openingPane = new JPanel();
		viewFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		// Listeners
		// setTitle
		viewFrame.setTitle("Menu");
		// Create Buttons
		create = new JButton();
		create.setText("Create");
		random = new JButton();
		random.setText("Random");
		// Set Layout
		openingPane.setLayout(new BoxLayout(openingPane, BoxLayout.Y_AXIS));
		openingPane.setBorder(BorderFactory.createLineBorder(Color.black));
		// add components to panel
		openingPane.add(create);
		openingPane.add(random);
		// add panel to frame
		viewFrame.add(openingPane);
		// make visible
		viewFrame.setVisible(true);
		// Create instance of side container
		modify = new JButton();
		modify.setText("Modify");
		random = new JButton();
		random.setText("Random");
		evolve = new JButton();
		evolve.setText("Evolve");
		// Set Layout
		createClicked.setLayout(new BoxLayout(createClicked, BoxLayout.Y_AXIS));
		createClicked.setBorder(BorderFactory.createLineBorder(Color.black));
		// add to separate Panel
		createClicked.add(modify);
		createClicked.add(random);
		createClicked.add(evolve);
		// initialise the sliders, I need to find out the ranges of the genes.
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
		red = new JButton();
		red.setText("Red");
		green = new JButton();
		green.setText("Green");
		blue = new JButton();
		blue.setText("Blue");
		colourPane.setLayout(new BoxLayout(colourPane, BoxLayout.X_AXIS));
		colourPane.setBorder(BorderFactory.createLineBorder(Color.black));
		colourPane.add(red);
		colourPane.add(green);
		colourPane.add(blue);
	}
	public void createClicked()
	{
		/**
		 * changes view from first menu to second. Still not sure if this is the
		 * most efficient way to do this or not, could do with some help as this
		 * was where I was going to use the action listeners
		 */
		viewFrame.remove(openingPane);
		viewFrame.add(createClicked);
	}
	public void modify()
	{
		viewFrame.remove(createClicked);
		viewFrame.add(modify);
		viewFrame.add(colourPane);
	}
}