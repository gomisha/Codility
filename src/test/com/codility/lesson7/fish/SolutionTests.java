package test.com.codility.lesson7.fish;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson7.fish.Solution;

//https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/

public class SolutionTests {
	private Solution solution;
	
	@BeforeTest
	public void setUp() {
		solution = new Solution();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] {  new int [] { 4, 3, 2, 1, 5 }, new int [] { 1, 0, 1, 0, 1 },  3 },
			new Object [] {  new int [] { 4, 3, 2, 0, 5 }, new int [] { 0, 1, 0, 0, 0 },  2 },
			new Object [] {  new int [] { 4, 3, 2, 1, 5 }, new int [] { 0, 1, 0, 0, 0 },  2 },
			new Object [] {  new int [] { 4, 3, 2, 1, 5 }, new int [] { 0, 1, 1, 0, 0 },  3 },
			new Object [] {  new int [] { 4, 3, 2, 5, 6 }, new int [] { 1, 0, 1, 0, 1 },  2 },
			new Object [] {  new int [] { 7, 4, 3, 2, 5, 6 }, new int [] { 0, 1, 1, 1, 0, 1 },  3 },
			new Object [] {  new int [] { 3, 4, 2, 1, 5 }, new int [] { 1, 0, 0, 0, 0 },  4 },
			new Object [] {  new int [] { 3 }, new int [] { 1 },  1 },
			new Object [] {  new int [] { 3 }, new int [] { 0 },  1 },
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int [] pA, int [] pB, int pExpected) {		
		Assert.assertEquals(solution.solution(pA, pB), pExpected);
	}	
}
