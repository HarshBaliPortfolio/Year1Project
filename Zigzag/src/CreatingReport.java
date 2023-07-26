import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CreatingReport {

	// String array is created 
	ArrayList<String> array = new ArrayList<String>();
	DecimalFormat threeDP= new DecimalFormat("0.000");
	Calculations reportCalculations = new Calculations();

	public void creatingReport(int zigzagSectionLength, int zigzagSections, double speed, double time) throws IOException {

		// all the integers and double are converted into strings and added to array
		
		array.add("USERINPUT:");// all user inputs are added to array
		array.add("Length of one sections is "+conversionToString(zigzagSectionLength)+" cm");
		array.add("Total Number of zigzag sections are "+conversionToString(zigzagSections));
		
		array.add("");
		array.add("SPEED & TIME CALCULATIONS FOR ZIGZAG MOVEMENT:");// Both speed (randomly generated or input by user) and time added to array
		array.add("The random speed generated or enterred by you is "+conversionToString(speed)+ "cm/s");
		array.add("The time required for one section is  "+threeDP.format(time)+ "s");
		
		array.add("");
		array.add("CALCULATIONS MADE FOR REPORT:");// All calculations for report are added to array
		//method chaining
		array.add("The total distance of zigzag is"+conversionToString(reportCalculations.totalDistance(zigzagSectionLength,zigzagSections))+ "cm");
		
		array.add("The total time required "+conversionToString(reportCalculations.totalTime(zigzagSections, time))+ "s");
		
		array.add("The total Straight line distance is "+conversionToString(reportCalculations.totalStraightDistance(zigzagSectionLength, zigzagSections))+"cm");
		writingReport();
	}

	
	//Polymorphing
	private String conversionToString(double number) {// converts the double number into string
		String input =Double.toString(number);
		return input;
	}

	private String conversionToString(int number) {// converts the integer number into the string
		String input = Integer.toString(number);
		return input;
	}


	private void writingReport() throws IOException {
		// makes a report into temp folder and the elements of the array is printed onto the report
		FileWriter writehandle= new FileWriter("report.txt");
		BufferedWriter bw= new BufferedWriter(writehandle);

		for (int i=0; i<array.size(); ++i) {
			bw.write(array.get(i));
			bw.newLine();
		}
		bw.close();
		writehandle.close();
		JOptionPane.showMessageDialog(null, "Check ECLIPLSE WORKSPACE folder for the report");
		JOptionPane.showMessageDialog(null, "The game ends");
		System.exit(10);
	}
	

}
