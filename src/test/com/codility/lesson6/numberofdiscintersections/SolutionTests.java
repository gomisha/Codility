package test.com.codility.lesson6.numberofdiscintersections;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson6.numberofdiscintersections.Solution;

//https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/

public class SolutionTests {
	private Solution solution;
	
	@BeforeTest
	public void setUp() {
		solution = new Solution();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] { new int [] { 1, 5, 2, 1, 4, 0 }, 11 }, 
			new Object [] { new int [] { 2, 1, 0, 4 }, 6 },
			new Object [] { new int [] {  }, 0 },
			new Object [] { new int [] { 1, 2147483647, 0 }, 2 },
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int[] pA, int pExpected) {		
		Assert.assertEquals(solution.solution(pA), pExpected);
	}	

}
