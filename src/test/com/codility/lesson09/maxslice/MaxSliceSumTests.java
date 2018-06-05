package test.com.codility.lesson09.maxslice;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson09.maxslice.MaxSliceSum;

//https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum/

public class MaxSliceSumTests {
	private MaxSliceSum solution;
	
	@BeforeTest
	public void setUp() {
		solution = new MaxSliceSum();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] { new int [] { 5, -7, 3, 5, -2, 4, -1 }, 10 },
			new Object [] { new int [] { -2, -3, 4, -1, -2, 1, 5, -3 } , 7 },
			new Object [] { new int [] { 3, 2, -6, 4, 0 } , 5 },
			
			//https://en.wikipedia.org/wiki/Maximum_subarray_problem
			new Object [] { new int [] {-2, 1, -3, 4, -1, 2, 1, -5, 4 }, 6 }, 
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int [] pA, int pExpected) {		
		Assert.assertEquals(solution.solution(pA), pExpected);
	}	
}
