package test.com.codility.lesson09.maxslice;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson09.maxslice.MaxSliceDemo;

public class MaxSliceDemoTests {
	private MaxSliceDemo solution;
	
	@BeforeTest
	public void setUp() {
		solution = new MaxSliceDemo();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] { new int [] { 5, -7, 3, 5, -2, 4, -1 }, 10 },
			new Object [] { new int [] { -2, -3, 4, -1, -2, 1, 5, -3 } , 7 },
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int [] pA, int pExpected) {		
		Assert.assertEquals(solution.solution(pA), pExpected);
	}	
}
