package test.com.codility.lesson4.missinginteger;

import org.testng.Assert;
import org.testng.annotations.*;

import com.codility.lesson4.missinginteger.Solution;

//https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/

public class SolutionTests {
	private Solution solution;
	
	@BeforeTest
	public void setUp() {
		solution = new Solution();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] { new int [] {              1, 3, 6, 4, 1, 2 }, 5 },
			new Object [] { new int [] {           1, 3, 6, 4, 1, 2, 5 }, 7 },
			new Object [] { new int [] {                       1, 2, 3 }, 4 }, 
			new Object [] { new int [] {                         -1,-3 }, 1 }, 
			new Object [] { new int [] {                      -1,-3, 2 }, 1 },
			new Object [] { new int [] {                      -1,-3, 1 }, 2 },
			new Object [] { new int [] {                             0 }, 1 },
			new Object [] { new int [] {                      -1000000 }, 1 },
			new Object [] { new int [] {             -1000000,       1 }, 2 },
			new Object [] { new int [] {                       1000000 }, 1 },
			new Object [] { new int [] {       999999, 999998, 1000000 }, 1 },
			new Object [] { new int [] { 1, 3, 999999, 999998, 1000000 }, 2 },
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int [] pA, int pExpected) {
		Assert.assertEquals(solution.solution(pA), pExpected);
	}
}
