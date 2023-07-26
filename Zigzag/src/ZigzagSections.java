import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZigzagSections extends JFrame {

	// declaring the objects i want on my JFrame
	private JButton ok;
	private JButton cancel;
	private JTextField inputArea;
	private JLabel label;
	private JLabel imgContainer;
	public int zigzagSections;

	//I will be using GridBagLayout for this frame, so I need to have constraints too.
	GridBagConstraints constraints= new GridBagConstraints();

	//declaring the class variables so that all the methods in this class can access this variable
	private int zigzagSectionLength;
	private int modulor;
	private String message;
	private String restrictionMsg;
	private String imgSrc;

	// THE CONSTRUCTOR
	// so every-time an instance of this class is created the constructor is invoked.
	public ZigzagSections( int sectionLength, int mod) {
		super("Zigzag Sections");//super keyword invokes the parent class (JFrame in this instance)
		setLayout(new GridBagLayout());//Layout i want for this frame

		TheHandler actionHandler = new TheHandler();	// instantiating actionHandler object to handle the events for this JFrame

		morphingIntoCorrectMode(mod);// this method makes the JFrame morphs into the selected mode DURING RUNTIME

		// JLabel is created and position of the JLabel is set.
		// This label acts as container for the images
		imgContainer = new JLabel();
		Image img1= new ImageIcon(this.getClass().getResource(imgSrc)).getImage(); // image is sourced and added to the label. (During Runtime)
		imgContainer.setIcon(new ImageIcon(img1));
		constraints.gridx=2;
		constraints.gridy=0;
		add(imgContainer,constraints);

		// JLabel is created and position of the JLabel is set.
		label= new JLabel(message);
		label.setToolTipText(restrictionMsg);
		label.setFont(new Font("Calibri", Font.BOLD, 20));// want the message to stand out so added font
		constraints.gridx =2;
		constraints.gridy=1;
		add(label,constraints);

		// JTextField is created and position of the JTextField is set.
		inputArea = new JTextField(20);
		constraints.gridx =2;
		constraints.gridy=2;
		inputArea.addActionListener(actionHandler);// ActionListener is added onto the JButton
		add(inputArea,constraints);

		// JButton is created and position of the JButton is set.
		ok = new JButton("Enter");
		constraints.gridx =0;
		constraints.gridy=4;
		ok.addActionListener(actionHandler);// ActionListener is added onto the JButton
		add(ok,constraints);

		// JButton is created and position of the JButton is set.
		cancel= new JButton("Delete");
		constraints.gridx =3;
		constraints.gridy=4;
		cancel.addActionListener(actionHandler);// ActionListener is added onto the JButton
		add(cancel,constraints);

		// here the variables passed in constructor are made accessible to each methods of this class
		modulor= mod;
		zigzagSectionLength=sectionLength;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(500, 300);
		setResizable(false);
		setLocation(750,250 );
	}

	private class TheHandler implements ActionListener{// Private class within the zigzagSections class that handles the events on this JFrame

		public void actionPerformed(ActionEvent event) {// actionPerformed method is created that tells how to deal with the event
			if (event.getActionCommand().equals("Enter")) {
				ErrorCatching();// users clicks on Enter than the ErrorCatching method is called.
			}
			else if (event.getSource()==inputArea) {
				ErrorCatching();//if the user presses enter key then also the ErrorCatching method is called
			}
			else if (event.getActionCommand().equals("Delete")) {
				inputArea.getText();// user clicks on Delete button and text in inputArea is deleted using getText and setText
				inputArea.setText("");
			}
		}
	}
	private void ErrorCatching(){// this method is used to catch Invalid Inputs by the user.
		
		String congratMsgTitle= "CONGRATULATIONS!! You have entered a valid Input for the Sections";
		String userInput;
		
		// Note Strings means collection of symbols.
		try {// Use to try-catch, to catch the user if the user enters any other collection of symbols than numbers
			
			userInput = inputArea.getText();
			zigzagSections=(Integer.parseInt(userInput));

			//Sections should be 2-12
			//this means section length should be less than 13 and more than 1, therefore, introduced CONSTANTS
			final int lowerLimit=1;
			final int upperLimit=13;

			if ((zigzagSections>lowerLimit)&&(zigzagSections<upperLimit)&&(zigzagSections % modulor==0)) {
				JOptionPane.showMessageDialog(null, congratMsgTitle);
			
				//if the user enters the correct Input,then object speedMode is created
				// speedMode is an Instance of ChooseSpeed class
				ChooseSpeedMode speedMode= new ChooseSpeedMode(zigzagSectionLength, zigzagSections);
				dispose();
			}
			else {
				//if the input outside the limit is entered this is displayed.
				JOptionPane.showMessageDialog(null, restrictionMsg);
			}
		}
		catch(NumberFormatException illegalInput) {
			// if illegalInput is caught this is displayed
			JOptionPane.showMessageDialog(null, restrictionMsg);
		}
	}
	private void morphingIntoCorrectMode(int mod) {
		// this method uses modular to transform this frame into selected mode DURING RUNTIME
		
		if (mod ==2) {// if mod is 2 it becomes regular mode
			imgSrc= "/regular.png";
			message= "Enter an EVEN NUMBER for zig zag section between 2-12";
			restrictionMsg= "Enter an EVEN number between 2-12 cm";
		}
		else {// if the mod is not 2 it becomes freestyle
			imgSrc= "/freestyle.png";
			message= "Enter any NUMBER for zig zag section between 2-12";
			restrictionMsg= "Enter any NUMBER between 2-12 cm";
		}
	}

}

