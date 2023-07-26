import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import javax.swing.JOptionPane;

public class FinchMovement {

	//this class is static class
		//uses only static variables and static methods
			//don't have to instantiate an object to use any of its the methods. 
			
	
	//Declaring variables
		//Their scope is restricted to this class.
	private static Finch myFinch = new Finch();
	
	public static void  levelFinch() { //checks if finch is on levelled surface.
		String flatSurfaceDetected ="Flat surface detected";
		String roughSurfaceDetected= "“Put me on flat service!”";
		while (true) {
			if (myFinch.isFinchLevel() == true) {
				JOptionPane.showMessageDialog(null,flatSurfaceDetected);
				break;
			}
			else {
				JOptionPane.showMessageDialog(null,roughSurfaceDetected);// if it is not on levelled surface, User is repeatedly asked to put it on surface
				continue;
			}
		}
	}

	public static void finchBlueMove(int speed, int time) {
		// makes the Finch move for calculated time(at randomspeed) with BLUE color.
		myFinch.setLED(0, 0, 155);
		myFinch.setWheelVelocities(speed, speed, time);
		myFinch.sleep(1000);
	}


	public static void finchGreenMove(int speed, int time) {
		// makes the Finch move for calculated time(at randomspeed) with Green color.
		myFinch.setLED(0, 155, 0);
		myFinch.setWheelVelocities(speed, speed, time);
		myFinch.sleep(1000);

	}

	public static void finchTurnRight(int speed, int timeForTurn) {
		//Turns the finch right on smooth Surface at 90 degrees
		myFinch.setWheelVelocities(speed, -speed, timeForTurn);
	}

	public static void finchTurnLeft(int speed, int timeForTurn) { 
		//Turns the finch left on smooth surface at 90 degrees
		myFinch.setWheelVelocities(-speed, speed,timeForTurn );
	}
	
	public static void saySomething(String command) {
		myFinch.saySomething(command);
	}
}

