package test.com.codility.practice;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.practice.Demo;

//MissingInteger test
//test result: https://app.codility.com/demo/results/demoNZ5ZRY-FT7/
//test result: 100%

public class DemoTests {
	private Demo solution;
	
	@BeforeTest
	public void setUp() {
		solution = new Demo();
	}

	@DataProvider(name = "data1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] { new int [] { 1, 3, 6, 4, 1, 2 }, 5 },
			new Object [] { new int [] { 1, 2, 3 }, 4 },
			new Object [] { new int [] { -1, -3 }, 1 },
			new Object [] { new int [] { -10, 10 }, 1 },
			new Object [] { new int [] { -10, 10, 1, 2, 3 }, 4 },
			new Object [] { new int [] { 0, 0, 0, 0, 0 }, 1 },
			new Object [] { new int [] { 0, -1000000, 1000000, 0, 0 }, 1 },
			new Object [] { new int [] { 0, -1000000, 1000000, 0, 1 }, 2 },
			new Object [] { new int [] { 0, -1000000, 1000000, 999999, 1, 2 }, 3 },
			new Object [] { new int [] { -998123, -1000000, 1000000, 999999, 1, 2, 5, 7, 4 }, 3 },
		};
	}
	
	@Test(dataProvider = "data1")
	public void verifySolution(int [] pA, int pExpected) {
		Assert.assertEquals(solution.solution(pA), pExpected);
	}
}
