package test.com.codility.lesson09.maxslice;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson09.maxslice.MaxDoubleSlice;

//https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/

public class MaxDoubleSliceSumTests {
	private MaxDoubleSlice solution;
	
	@BeforeTest
	public void setUp() {
		solution = new MaxDoubleSlice();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] { new int [] { 3, 2, 6, -1, 4, 5, -1, 2 }, 17 },
			new Object [] { new int [] { -2 -3, 4, -1, -2, 1, 5, -3 }, 9 },
			new Object [] { new int [] { 1, 2, 3 }, 0 },
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int [] pA, int pExpected) {		
		Assert.assertEquals(solution.solution(pA), pExpected);
	}	
}
