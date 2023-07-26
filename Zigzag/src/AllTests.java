import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AllTests {// this class acts as a test suite which consists of multiple test cases to test calculations

	//test cases to tests calculations to perform zigzag
	@Test
	void testForTime() {//tests whether the time is calculated properly
		Calculations test= new Calculations(); 
		test.setTime(5, 15);// sets speed as 5cm/s and distance as 15cm
		double result= test.getTime();
		assertEquals(3.0,result); //the result should equal to 3cm/s
	}


	@Test
	void testingTimeForTurn () {// testcase to test time for turn
		Calculations test= new Calculations(); 
		test.setTimeForTurn(5);// sets speed as 5cm/s 
		int result= test.getTimeForTurn();
		assertEquals(1600,result); 
	}


	
	@Test
	void testingTotalDistanceForReport() {//test cases to test calculations needed for report
		Calculations test= new Calculations(); 
		int result= test.totalDistance(15, 2);// sets section length to 15 and number of sections to 2	
		assertEquals(30,result); 
	}

	@Test
	void testingTotalTime() {
		Calculations test= new Calculations(); 
		double result= test.totalTime(2,3.0);// sets No. of sections as 2 and time as 3s
		assertEquals(6.0,result);
	}

	@Test
	void testingStraightLineDistance() {
		Calculations test= new Calculations(); 
		double result= test.totalStraightDistance(15, 2);// sets section length to 15 and number of sections to 2	
		assertEquals((2*(Math.sqrt(450))),result);
	}

}
