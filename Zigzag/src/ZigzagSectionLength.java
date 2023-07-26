import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class ZigzagSectionLength extends JFrame {// extends JFrame because it inherits the JFrame class, no need of instantiating JFrame

	//declaring the objects, that I want on my JFrame
	private JButton ok;
	private JButton cancel;
	private JTextField inputArea;
	private JLabel label;

	//I will be using GridBagLayout for this frame, so I need to have constraints too.
	GridBagConstraints gbc= new GridBagConstraints(); 

	//declaring the class variable so that all the methods in this class can access this variable
	private int zigzagSectionLength;

	//THE CONSTRUCTOR
	//So every-time an instance of this class is created the constructor is invoked.
	public ZigzagSectionLength() {

		super("INPUT"); //super keyword invokes the parent class (JFrame in this instance)
		setLayout(new GridBagLayout());//Layout i want for this frame

		//instantiating actionHandler object to handle the events for this JFrame
		TheHandler actionHandler = new TheHandler();

		//JLabel is created and position of the JLabel is set.
		label= new JLabel("Enter a valid Input between \"15-85\" (cm)");
		label.setToolTipText("Between \\\"15-85\\\" (cm)"); // when the mouse hovers over the label it shows extra information
		label.setFont(new Font("Calibri", Font.BOLD, 20));
		gbc.gridx =2;
		gbc.gridy=0;
		add(label,gbc);

		//JTextField is created and position of the JTextField is set.
		inputArea = new JTextField(20);
		gbc.gridx =2;
		gbc.gridy=1;
		inputArea.addActionListener(actionHandler);// ActionListener is added onto the JTextfield
		add(inputArea,gbc);

		// JButton is created and position of the JButton is set.
		ok = new JButton("Enter");
		gbc.gridx =0;
		gbc.gridy=3;
		ok.addActionListener(actionHandler);// ActionListener is added onto the JButton
		add(ok,gbc);

		//JButton is created and position of the JButton is set.
		cancel= new JButton("Delete");
		gbc.gridx =3;
		gbc.gridy=3;
		cancel.addActionListener(actionHandler);// ActionListener is added onto the JButton
		add(cancel,gbc);	
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(500, 300);
		setResizable(false);
		setLocation(750,250 );
	}

	private class TheHandler implements ActionListener{ // Private class within the Section Length class, that handles the events on the frame
		
		public void actionPerformed(ActionEvent event) {// actionPerformed method is created that tells how to deal with the event

			if (event.getActionCommand().equals("Enter")) { 
				ErrorCatching();// users clicks on Enter than the ErrorCatching method is called.
			}
			else if (event.getSource()==inputArea) {
				ErrorCatching();// if the user presses enter key then also the ErrorCatching method is called
			}
			else if (event.getActionCommand().equals("Delete")) {
				inputArea.getText();// user clicks on Delete button and text in inputArea is deleted using getText and setText
				inputArea.setText("");
			}
		}
	}

	public void ErrorCatching(){// this method is used to catch Invalid Inputs by the user.
		
		String congratMsgTitle= "CONGRATULATIONS!! You have entered a valid Input for the LENGTH";
		String errorMsg= "Enter a value between 15-85 cm";
		String userInput;
		
		// Note Strings means collection of symbols.
		
		try {// Use to try-catch, to catch the user if the user enters any other collection of symbols than numbers
			userInput = inputArea.getText();
			zigzagSectionLength = Integer.parseInt(userInput);

			//Section Length should be 15-85
			//this means section length should be less than 86 and more than 14, therefore, introduced CONSTANTS
			final int upperLimit= 86; 
			final int lowerLimit= 14;
			
			if ((zigzagSectionLength>lowerLimit)&&(zigzagSectionLength<upperLimit)) {
				JOptionPane.showMessageDialog(null, congratMsgTitle);
				System.out.println("Length for one section is: " + zigzagSectionLength);
				dispose();
				
			//if the user enters the input correct Input, (more than 14 and less than 86)then object modes is created
			//modes is instance of ChooseMode class
				ChooseSectionsMode modes = new ChooseSectionsMode(zigzagSectionLength);
			}
			else {
				//if the input outside the limit is entered this is displayed.
				JOptionPane.showMessageDialog(null, errorMsg);
			}
		}
		catch(NumberFormatException illegalInput) {
			// if illegalInput is caught this is displayed
			JOptionPane.showMessageDialog(null, errorMsg);
		}
	}
}