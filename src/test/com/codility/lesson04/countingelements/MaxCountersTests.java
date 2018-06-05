package test.com.codility.lesson04.countingelements;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson04.countingelements.MaxCounters;

//https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/

public class MaxCountersTests {
	private MaxCounters solution;
	
	@BeforeTest
	public void setUp() {
		solution = new MaxCounters();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] { 5, new int [] { 3, 4, 4, 6, 1, 4, 4 }, new int [] { 3, 2, 2, 4, 2 } },
			new Object [] { 3, new int [] {             2, 1, 2 }, new int [] {       1, 2, 0 } },
			new Object [] { 3, new int [] {    2, 1, 2, 2, 1, 2 }, new int [] {       2, 4, 0 } },
			new Object [] { 2, new int [] {          2, 1, 3, 2 }, new int [] {          1, 2 } },
			new Object [] { 2, new int [] { 2, 1, 3, 2, 3, 1, 2 }, new int [] {          3, 3 } },
			new Object [] { 1, new int [] {             2, 1, 2 }, new int [] {             1 } },
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int pInt, int [] pA, int [] pExpected) {
		int [] actual = solution.solution(pInt, pA);
		Assert.assertEquals(actual.length, pExpected.length);
		for(int i=0; i<actual.length; i++) {
			Assert.assertEquals(actual[i], pExpected[i]);
		}
	}
}
