import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.JOptionPane;

public class Calculations {
	private Random randomNum= new Random();
	private double time; 

	private int timeForTurn;
	DecimalFormat threeDP= new DecimalFormat("0.000");
	
	
	JOptionPane out =new JOptionPane();
	
	public int randomSpeedGenerator (){// This method, generates randomSpeed which is in cm per second 
		int randomSpeed = randomNum.nextInt(15);
		if (randomSpeed<5) {
			randomSpeed=5;
		}
		else {
			randomSpeed = Math.abs(randomSpeed); 
		}
		JOptionPane.showMessageDialog(null,"speed is " +randomSpeed +" cm/s" );
		System.out.println("speed is " +randomSpeed +" cm/s" );//  used for testing 
		return randomSpeed;
	}


	public void setTime(double speed, double distance) {// this method sets time and calculates time using SPEED and DISTANCE.
		time = distance/ speed;
		System.out.println("time is: "+ threeDP.format(time)  +" s");
	}
	
	public double getTime() {// this method gets TIME 
		String message = "The time required for finch to move one section is:"+ threeDP.format(time) +" s";
		JOptionPane.showMessageDialog(null, message);
		return time;
	}

	public void setTimeForTurn(double speedInCMPerSecond) {// this method calculates the time for turn using the speed generated or input by the user.
		final int k=8000;// k is constant
		timeForTurn = (int) Math.round(k/speedInCMPerSecond);
	}
	
	public int getTimeForTurn() {// this method gets the time for the turn calculated
		System.out.println("Time for turn is :" + timeForTurn+"ms");		
		return timeForTurn;
	}

	public int totalDistance(int zigzagSectionLength, int zigzagSections) {
		// Total distance covered by finch is calculated 
		int totalDistance= ( zigzagSectionLength * zigzagSections);
		return totalDistance;
	}
	
	
	public double totalTime(int zigzagSections, double time) {
		// total time is calculated
		double totalTime =time*zigzagSections;
		return totalTime;	
	}
	
	public double totalStraightDistance(int zigzagSectionLength, int zigzagSections) {
		// total straight distance covere by finch is calculated using Pythagoras theorem
		double straightDistance= (zigzagSections *(Math.sqrt((2*(Math.pow(zigzagSectionLength,2))))));
		return straightDistance;
	}
}
