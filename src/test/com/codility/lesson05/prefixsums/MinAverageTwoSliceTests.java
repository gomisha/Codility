package test.com.codility.lesson05.prefixsums;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson05.prefixsums.MinAverageTwoSlice;

//https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/

public class MinAverageTwoSliceTests {
	private MinAverageTwoSlice solution;
	
	@BeforeTest
	public void setUp() {
		solution = new MinAverageTwoSlice();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] {  new int [] { 4, 2, 2, 5, 1, 5, 8 }, 1 },
			new Object [] {  new int [] { 10000, -10000 }, 0 }
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int [] pA, int pExpected) {		
		Assert.assertEquals(solution.solution(pA), pExpected);
	}		
}
