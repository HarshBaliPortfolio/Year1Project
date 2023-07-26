import java.io.IOException;
import javax.swing.JOptionPane;

public class ZigzagMovement {
	// this class is responsible for zigzag movement of the finch and retracing of the finch 

	int timeInMilliSeconds;
	int speedInMMPerSecond;
	Calculations timeForTurn = new Calculations();
	private int turnTime;
	private int zigzagLength;
	private double speedInCMPerSeconds;
	private double timeInSeconds;


	public ZigzagMovement(int zLength, int zigzagSection, double speedInCMPerS, double timeInS) {// this method takes parameters from other class and converts them into class variables

		timeInMilliSeconds= (int) (timeInS *1000);// time is converted into milliseconds

		speedInMMPerSecond = (int) (speedInCMPerS *10);// speed is converted into Millimetres per seconds.

		timeForTurn.setTimeForTurn(speedInCMPerS);// time for turn is called 
		turnTime = timeForTurn.getTimeForTurn();

		// some variables are converted into class variabel
		zigzagLength =zLength;
		speedInCMPerSeconds=  speedInCMPerS;
		timeInSeconds=  timeInS;

		frontZigzag(zigzagSection);	
	}

	private void frontZigzag(int zigzagSection) {
		// this method makes the finch move forward in zigzag manner using zigzagSections
		
		FinchMovement.levelFinch(); //calls a static method from movement class to check whether the finch is placed level or not
		JOptionPane.showMessageDialog(null, "zig zag will commence now");
		FinchMovement.saySomething("starting zigzag");
		for (int initialZigzagSection =1; initialZigzagSection<=zigzagSection;) {

			if (initialZigzagSection % 2 ==0 ) {
				FinchMovement.finchBlueMove(speedInMMPerSecond, timeInMilliSeconds); // methods from movement is called statically 
				FinchMovement.finchTurnLeft(speedInMMPerSecond, turnTime);
				System.out.println("Blue Movement section number: " + initialZigzagSection);
				++initialZigzagSection;
			}
			else {
				FinchMovement.finchGreenMove(speedInMMPerSecond, timeInMilliSeconds);// methods from movement is called statically 
				FinchMovement.finchTurnRight(speedInMMPerSecond, turnTime);
				System.out.println("Green Movement section number: " + initialZigzagSection);
				++initialZigzagSection;			
			}
		}
		System.out.println("Starting the retrace");
		FinchMovement.saySomething("starting retrace");
		JOptionPane.showMessageDialog(null, "Starting retrace");
		//when the intialzigzagSection is equal to zigzagSections, finch exits the loop and finchOrthogonal method is called
		finchOrthogonalMovement(zigzagSection);
	}

	private void finchOrthogonalMovement(int zigzagSection) {
		//this method takes last section into account and sees whether finch is going to turn left or right 90* 
		// due to this method finch turns accordingly to start retracing
		if (zigzagSection % 2 ==0 ) {
			FinchMovement.finchTurnLeft(speedInMMPerSecond, turnTime);
		}
		else
		{
			FinchMovement.finchTurnRight(speedInMMPerSecond, turnTime);
		}	
		//when the finch turns back 180* retraceZigzag method is called
		retraceZigzag(zigzagSection);
	}

	private void retraceZigzag(int zigzagSection) {// this method makes the 
		//NOTE: in this method the backwardsZigzagSection equals to zigzagSection
		for ( int backwardsZigZagSection = zigzagSection; backwardsZigZagSection >=1;) {
			if (backwardsZigZagSection % 2 ==0 ) {
				FinchMovement.finchBlueMove(speedInMMPerSecond, timeInMilliSeconds);
				FinchMovement.finchTurnLeft(speedInMMPerSecond, turnTime);
				--backwardsZigZagSection;
			}
			else {
				FinchMovement.finchGreenMove(speedInMMPerSecond, timeInMilliSeconds);
				FinchMovement.finchTurnRight(speedInMMPerSecond, turnTime);
				--backwardsZigZagSection;
			}
		}
		//when the backwardsZigzagSection equals to 1, finch exits the loop 
		System.out.println("Stopping retrace");
		// after the retrace all the values are assigned to report
		AssigningValuesToReport(zigzagSection);
	}

	private void AssigningValuesToReport(int zigzagSections) {
		// this method uses try and catch because if there is no temp folder in C drive the report cant be created and program will crash.		
		try {
			// linking all the data to report
			CreatingReport report = new CreatingReport();
			report.creatingReport(zigzagLength,zigzagSections, speedInCMPerSeconds , timeInSeconds);

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error occurred while creating file");
			e.printStackTrace();
		}
	}
}