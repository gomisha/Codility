package test.com.codility.lesson06.sorting;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson06.sorting.Distinct;

//https://app.codility.com/programmers/lessons/6-sorting/distinct/

public class DistinctTests {
	private Distinct solution;
	
	@BeforeTest
	public void setUp() {
		solution = new Distinct();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] {  new int [] { 2, 1, 1, 2, 3, 1  }, 3 }, //1, 2, 3
			new Object [] {  new int [] { -3, 1, -100, -2, -2, 5, 6  }, 6 }, //-100, -3, -2, 1, 5, 6
			new Object [] {  new int [] { -3, 1, -100}, 3}, //-100, -3, 1
			new Object [] {  new int [] { 0, 0, 0, 0}, 1}, //0
			new Object [] {  new int [] { 0, -1, 0, -1}, 2}, //-1, 0
			new Object [] {  new int [] { 10 }, 1 }, //10
			new Object [] {  new int [] { }, 0 },
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int[] pA, int pExpected) {		
		Assert.assertEquals(solution.solution(pA), pExpected);
	}	
}
