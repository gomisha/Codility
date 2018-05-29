package test.com.codility.lesson7.stonewall;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson7.stonewall.Solution;

//https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/

public class SolutionTests {
	private Solution solution;
	
	@BeforeTest
	public void setUp() {
		solution = new Solution();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] { new int [] { 8, 8, 5, 7, 9, 8, 7, 4, 8 }, 7 }, 
			new Object [] { new int [] { 8, 8, 5, 7, 9, 8, 7, 5, 8 }, 6 },
			new Object [] { new int [] { 1, 2, 3, 4, 3 }, 4 },
			new Object [] { new int [] { 8, 8, 5 }, 2 },
			new Object [] { new int [] { 8, }, 1 },
			new Object [] { new int [] { 8, 8 }, 1 },
			new Object [] { new int [] { 8, 8, 8, 8, 8 }, 1 },
			new Object [] { new int [] { 1000000000 }, 1 },
			new Object [] { new int [] { 1000000000, 2 }, 2 },
			new Object [] { new int [] { 2, 1000000000, 2 }, 2 },
			new Object [] { new int [] { 2, 1000000000, 2, 1000000000 }, 3 },
			new Object [] { new int [] { 2, 1000000000, 2, 1000000000, 1000000000 }, 3 },
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int[] pA, int pExpected) {		
		Assert.assertEquals(solution.solution(pA), pExpected);
	}	
}
