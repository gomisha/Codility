package test.com.codility.lesson03.timecomplexity;

//https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/

import org.testng.Assert;
import org.testng.annotations.*;

import com.codility.lesson03.timecomplexity.PermutationMissingElement;


public class PermutationMissingElementTests {
	private PermutationMissingElement solution;
	
	@BeforeTest
	public void setUp() {
		solution = new PermutationMissingElement();
	}
	
	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] { new int [] {                        }, 1 },
			new Object [] { new int [] {                      1 }, 2 },
			new Object [] { new int [] {                      2 }, 1 },
			new Object [] { new int [] {                   1, 3 }, 2 },
			new Object [] { new int [] {                   2, 3 }, 1 },
			new Object [] { new int [] {                1, 2    }, 3 },
			new Object [] { new int [] {                1, 3, 4 }, 2 },
			new Object [] { new int [] {                2, 4, 3 }, 1 },
			new Object [] { new int [] {             2, 3, 1, 5 }, 4 },
			new Object [] { new int [] { 4, 2, 3, 1, 5, 6, 8, 9 }, 7 },
			new Object [] { new int [] { 4, 2, 3, 1, 5, 6, 8, 7 }, 9 },
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int [] pA, int pExpectedMissingValue) {
		Assert.assertEquals(solution.solution(pA), pExpectedMissingValue);
	}
}
