package test.com.codility.lesson6.maxproductofthree;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson6.maxproductofthree.Solution;

//https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/

public class SolutionTests {
	private Solution solution;
	
	@BeforeTest
	public void setUp() {
		solution = new Solution();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] {  new int [] { -3, 1, 2, -2, 5, 6  }, 60 }, //2 * 5 * 60
			new Object [] {  new int [] { -3, 1, -100, 2, -2, 5, 6  }, 1800 }, //-100 * -3 * 6
			new Object [] {  new int [] { -3, 1, -100}, 300},
			new Object [] {  new int [] { -3, 1, 0, -100}, 300}, //-100 * -3 * 1
			new Object [] {  new int [] { -3, 1, 2, 0, -100}, 600},  //-100 * -3 * 2
			new Object [] {  new int [] { 10, 10, 10 }, 1000 },
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int[] pA, int pExpected) {		
		Assert.assertEquals(solution.solution(pA), pExpected);
	}	
}
