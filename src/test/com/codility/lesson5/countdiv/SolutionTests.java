package test.com.codility.lesson5.countdiv;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson5.countdiv.Solution;

//https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/

public class SolutionTests {
	private Solution solution;
	
	@BeforeTest
	public void setUp() {
		solution = new Solution();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] {  5, 11, 2,  3 },
			new Object [] {  0, 11, 5,  2 },
			new Object [] {  0, 11, 12, 0 }, //K>B
			new Object [] { 11, 33, 3, 8 },
			new Object [] { 33, 33, 33, 1 }, //A == B
			new Object [] { 100000, 1000000, 1000, 901 },
			new Object [] { 1000, 10000, 10, 901 },
			new Object [] { 100, 1000, 1, 901 },
			new Object [] { 0, 2000000000, 2000000000, 1 }, //max B
			new Object [] { 2000000000, 2000000000, 2000000000, 1 }, //max A, B
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int pA, int pB, int pK, int pExpected) {
		Assert.assertEquals(solution.solution(pA, pB, pK), pExpected);
	}
}
