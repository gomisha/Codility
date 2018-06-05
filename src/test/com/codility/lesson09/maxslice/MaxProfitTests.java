package test.com.codility.lesson09.maxslice;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson09.maxslice.MaxProfit;

//https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_profit/

public class MaxProfitTests {
	private MaxProfit solution;
	
	@BeforeTest
	public void setUp() {
		solution = new MaxProfit();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] { new int [] { 23171, 21011, 21123, 21366, 21013, 21367 }, 356 },
			new Object [] { new int [] { 23171 }, 0 },
			new Object [] { new int [] { }, 0 },
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int [] pA, int pExpected) {		
		Assert.assertEquals(solution.solution(pA), pExpected);
	}	
}
