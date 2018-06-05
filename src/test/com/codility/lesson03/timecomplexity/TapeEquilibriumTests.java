package test.com.codility.lesson03.timecomplexity;

//https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/

import org.testng.Assert;
import org.testng.annotations.*;

import com.codility.lesson03.timecomplexity.TapeEquilibrium;

public class TapeEquilibriumTests {
	private TapeEquilibrium solution;
	
	@BeforeTest
	public void setUp() {
		solution = new TapeEquilibrium();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] { new int [] {  3,    1,    2,    4,   3 }, 1 },
			new Object [] { new int [] { -3,    1,    2,   -4,   3 }, 1 },
			new Object [] { new int [] {        5,    2,    7,  10 }, 4 },
			new Object [] { new int [] {    -1000, 1000, -500, 990 }, 490 },
			new Object [] { new int [] {                    1,   2 }, 1 },
			new Object [] { new int [] {                  100, -25 }, 125 },
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int [] pA, int pExpectedMissingValue) {
		Assert.assertEquals(solution.solution(pA), pExpectedMissingValue);
	}
}
