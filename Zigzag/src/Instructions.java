import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Instructions extends JFrame {// extends JFrame because it inherits the JFrame class, no need of instantiating JFrame

	//declaring the objects, that I want on my JFrame
	JButton startGame;
	JLabel title;
	// the reason why i have label named in numeric order because the instructions are in stepps
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JLabel label5;
	JLabel label6;
	JLabel label7;

	//I will be using GridBagLayout for this frame, so I need to have constraints too.
	GridBagConstraints constraints= new GridBagConstraints();
	public Instructions() {

		super("Instructions");//super keyword invokes the parent class (JFrame in this instance)
		
		setLayout(new GridBagLayout());//Layout i want for this frame
		
		TheHandler actionHandler = new TheHandler();// instantiating actionHandler object to handle the events for this JFrame
		
		// steps to play zigzag 
		String step1= "1. Place the finch on flat surface";
		String step2= "2. Enter the Length for a Zigzag's section (15 - 85cm)";
		String step3= "4. Select a mode: REGULAR mode(You can make a zigzag of EVEN sections) or Freestyle mode(you can make zigzag of EVEN OR ODD section)";
		String step4= "5. Enter the Number of sections you want according to the mode";
		String step5= "6. Select a mode for speed: Random Speed mode (generate speed randomly) or Custom mode(Enter speed of your choice)";
		String step6= "7. Now watch the finch do the magic (zigzag and the retrace)";
		
		title = new JLabel("Follow the steps listed below:");
		constraints.gridx= 0;
		constraints.gridy=0;
		title.setFont(new Font("Calibri", Font.BOLD,20));// want the message to stand out so added font
		add(title, constraints);
		
		label1= new JLabel(step1);
		constraints.gridx= 0;
		constraints.gridy=1;
		label1.setFont(new Font("Calibri", Font.BOLD,15));// want the message to stand out so added font
		add(label1, constraints);

		label2= new JLabel(step2);
		constraints.gridx= 0;
		constraints.gridy=2;
		label2.setFont(new Font("Calibri", Font.BOLD,15));// want the message to stand out so added font
		add(label2,constraints);

		label3= new JLabel(step3);
		constraints.gridx= 0;
		constraints.gridy=3;
		label3.setFont(new Font("Calibri", Font.BOLD,15));// want the message to stand out so added font
		add(label3,constraints);

		label4= new JLabel(step4);
		constraints.gridx= 0;
		constraints.gridy=4;
		label4.setFont(new Font("Calibri", Font.BOLD,15));// want the message to stand out so added font
		add(label4,constraints);

		label5= new JLabel(step5);
		constraints.gridx= 0;
		constraints.gridy=5;
		label5.setFont(new Font("Calibri", Font.BOLD,15));// want the message to stand out so added font
		add(label5,constraints);

		label6= new JLabel(step6);
		constraints.gridx= 0;
		constraints.gridy=6;
		label6.setFont(new Font("Calibri", Font.BOLD,15));// want the message to stand out so added font
		add(label6,constraints);

		startGame= new JButton("Begin Game");
		constraints.gridx= 0;
		constraints.gridy=8;
		startGame.addActionListener(actionHandler);;
		add(startGame, constraints);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(900, 300);
		setResizable(false);
		setLocation(650,350 );
	}
	private class TheHandler implements ActionListener{// when the user clicks on "Begin Game" the object lengthFrame is created.

		public void actionPerformed(ActionEvent event) {// actionPerformed method is created that tells how to deal with the event
			if (event.getActionCommand().equals("Begin Game")) {
				//calls a static method from movement class to check whether the finch is placed level or not
				FinchMovement.levelFinch();
				
				//object called zigzagSectionLength which is an instance of  class SectionLength class
				ZigzagSectionLength zigzagSectionLength = new ZigzagSectionLength();
				dispose();
			}
		}
	}
}
