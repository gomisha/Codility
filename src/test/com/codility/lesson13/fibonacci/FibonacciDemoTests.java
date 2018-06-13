package test.com.codility.lesson13.fibonacci;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson13.fibonacci.FibonacciDemo;

//https://app.codility.com/programmers/lessons/13-fibonacci_numbers/

public class FibonacciDemoTests {
	private FibonacciDemo solution;
	
	@BeforeTest
	public void setUp() {
		solution = new FibonacciDemo();
	}

	@DataProvider(name = "data1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] { 1,  new int [] { 0 } },
			new Object [] { 3,  new int [] { 0, 1, 1 } },
			new Object [] { 6,  new int [] { 0, 1, 1, 2, 3, 5 } },
			new Object [] { 12, new int [] { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 } },
		};
	}
	
	@Test(dataProvider = "data1")
	public void verifyGetFibs(int pN, int [] pExpectedFibs) {
		int [] actualFibs = solution.getFibs(pN);
		Assert.assertEquals(actualFibs.length, pExpectedFibs.length);
		for(int i=0; i<pExpectedFibs.length; i++) {
			Assert.assertEquals(actualFibs[i], pExpectedFibs[i]);	
		}
	}
	
	@Test(dataProvider = "data1")
	public void verifyGetFibsFast(int pN, int [] pExpectedFibs) {
		int [] actualFibs = solution.getFibsFast(pN);
		Assert.assertEquals(actualFibs.length, pExpectedFibs.length);
		for(int i=0; i<pExpectedFibs.length; i++) {
			Assert.assertEquals(actualFibs[i], pExpectedFibs[i]);	
		}
	}
}
