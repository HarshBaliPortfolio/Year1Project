import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.Font;

public class ChooseSectionsMode extends JFrame{// extends JFrame because it inherits the JFrame class, no need of instantiating JFrame

	//declaring the objects, that I want on my JFrame
	private JComboBox<String> dropDown;
	private JLabel label;
	private JButton ok;

	// declaring the private class variable so that all the methods in this class can access this variable
	int zigzagSectionLength;


	//THE CONSTRUCTOR
	//so every-time an instance of this class is created the constructor is invoked.
	public ChooseSectionsMode(int SectionLength) {

		super("Select Mode");//super keyword invokes the parent class (JFrame in this instance)
		setLayout(new FlowLayout());//Layout i want for this frame

		//Instantiating actionHandler object to handle the events for this JFrame
		TheHandler actionHandler = new TheHandler();

		// String array: modes is created and populated
		String[] modes= {"--Select Mode--","Regular Zigzag", "Freestyle Zigzag"};

		//JLabel is created and added first because of the FlowLayout first thing on left
		label= new JLabel("Please select a mode");
		label.setFont(new Font("Calibri", Font.BOLD, 20));
		add(label);

		//JComboBox is created and added second, because I want this to be after the label.
		dropDown =new JComboBox<String>(modes); //adds mode (String array) to JComboBox
		dropDown.setSelectedIndex(0);			// Displays the item at 0 index at run-time
		add(dropDown);

		// JButton is created 
		ok = new JButton("OK");
		ok.addActionListener(actionHandler);// ActionListener is added onto the JButton
		add(ok);

		// sectionlength is set equal to zigzagSectionLength, so, that all methods in this class can access it, not only constructor.
		zigzagSectionLength =SectionLength;	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(500, 100);
		setResizable(false);
		setLocation(750,250 );
	}

	private class TheHandler implements ActionListener{ // Private class within the Choose Mode class that handles the events on JFrame

		public void actionPerformed(ActionEvent event) {// actionPerformed method is created that tells how to deal with the event

			// User selects an option from dropdown list and presses ok 
			// the ok button gets the index of selected option and chooses the case suitable for that option

			if (event.getActionCommand().equals("OK")) {

				// position of index is stored in the integer choice no.
				int choiceNo =  dropDown.getSelectedIndex(); 
				int modulor;

				switch (choiceNo){
				// if case 1: regular mode is selected, 2 is assigned to modulor
				
				case 1:
					modulor=2;
					creatingSuitableObject(modulor);
					break;

					// if case 2: free style mode is selected, 1 is assigned to modulor 
				case 2: 
					modulor=1;
					creatingSuitableObject(modulor);
					break;

				default:
					JOptionPane.showMessageDialog(null, "Select a mode");
				}
			}
		}
	}
	private void creatingSuitableObject( int modulor) {// this method creates helps to create suitable object depending on the selected mode

		//instead of creating two different objects of RegularZigZagSections this method helps to create a SUITABLE ONE which depends on the selected mode
		ZigzagSections sectionsFrame = new ZigzagSections( zigzagSectionLength, modulor);
		sectionsFrame.setVisible(true);
		sectionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sectionsFrame.setSize(700, 250);
		sectionsFrame.setLocation(750, 250);
		dispose();
	}
}


