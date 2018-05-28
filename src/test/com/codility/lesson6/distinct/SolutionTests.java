package test.com.codility.lesson6.distinct;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson6.distinct.Solution;

//https://app.codility.com/programmers/lessons/6-sorting/distinct/

public class SolutionTests {
	private Solution solution;
	
	@BeforeTest
	public void setUp() {
		solution = new Solution();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] {  new int [] { 2, 1, 1, 2, 3, 1  }, 3 }, //1, 2, 3
			new Object [] {  new int [] { -3, 1, -100, -2, -2, 5, 6  }, 6 }, //100, -3, -2, 1, 5, 6
			new Object [] {  new int [] { -3, 1, -100}, 3}, //-100, -3, 1
			new Object [] {  new int [] { 0, 0, 0, 0}, 1}, //0
			new Object [] {  new int [] { 0, -1, 0, -1}, 2}, //-1, 0
			new Object [] {  new int [] { 10 }, 1 }, //10
			new Object [] {  new int [] { }, 0 }, //10
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int[] pA, int pExpected) {		
		Assert.assertEquals(solution.solution(pA), pExpected);
	}	
}
