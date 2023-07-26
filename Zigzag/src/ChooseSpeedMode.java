import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseSpeedMode extends JFrame{//extends JFrame because it inherits the JFrame class, no need of instantiating JFrame

	//declaring the objects, that I want on my JFrame
	private JButton ok;
	private JComboBox<String> dropDown;
	private JLabel label;
	
	//declaring the class variables so that all the methods in this class can access this variable
	private int zigzagSectionLength;
	private int zigzagSections;
	private double  speedInCMPerSecond;
	private double timeInSeconds;
	
	// THE CONSTRUCTOR
	// so every-time an instance of this class is created the constructor is invoked.
	public ChooseSpeedMode(int sectionLength, int sections ) {

		super("Speed Mode");//super keyword invokes the parent class (JFrame in this instance)
		setLayout(new FlowLayout());//Layout i want for this frame
		
		//Instantiating actionHandler object to handle the events for this JFrame
		TheHandler actionHandler = new TheHandler();
		
		// String array: modes is created and populated
		String[] modes= {"--Select Speed--","Random Speed","Custom speed"};
		
		//JLabel is created and added first because of the FlowLayout first thing on left
		label= new JLabel("Please select a speed suitable for you:");
		label.setFont(new Font("Calibri", Font.BOLD, 20));
		add(label);
		
		//JComboBox is created and added second, because I want this to be after the label.
		dropDown =new JComboBox<String>(modes);
		dropDown.addActionListener(actionHandler);
		dropDown.setSelectedIndex(0);
		add(dropDown);
		
		// JButton is created 
		ok = new JButton("OK");
		ok.addActionListener(actionHandler);// ActionListener is added onto the JButton
		add(ok);

		//i want all methods in this class to access the variables that are passed in the constructor, so equating them to class variables
		zigzagSectionLength = sectionLength;
		zigzagSections= sections;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(500, 100);
		setResizable(false);
		setLocation(750,250 );
	}

	
	private class TheHandler implements ActionListener{// Private class within the Choose Mode class that handles the events on JFrame

		public void actionPerformed(ActionEvent event) {// actionPerformed method is created that tells how to deal with the event
			
			// User selects an option from dropdown list and presses ok 
			// the ok button gets the index of selected option and chooses the case suitable for that option
			
			if (event.getActionCommand().equals("OK")) {
				
				// position of index is stored in the integer choiceNo.
				int choiceNo =  dropDown.getSelectedIndex(); // 

				switch (choiceNo){
				case 1:
				// Creation of digitalDashboard, Speed and time calculation
				dispose();
				Calculations digitalDashboard = new Calculations();
				speedInCMPerSecond = (double)(digitalDashboard.randomSpeedGenerator());
				digitalDashboard.setTime(speedInCMPerSecond, zigzagSectionLength);
				timeInSeconds= digitalDashboard.getTime();
				
				//Creation of finchGame  and passing the variables 
				ZigzagMovement finchGame = new ZigzagMovement(zigzagSectionLength,zigzagSections,speedInCMPerSecond, timeInSeconds);
				
			
				
				break;
				
				case 2: 		
				// Object speedFrame is created if the user wants to enter the speed of their choice 
				CustomiseSpeed customSpeedFrame = new CustomiseSpeed(zigzagSectionLength, zigzagSections);
				dispose();
				break;

				default:
					JOptionPane.showMessageDialog(null, "Please Select a Speed mode");

				}
			}
		}
	}
}




