package test.com.codility.lesson04.countingelements;
import org.testng.Assert;
import org.testng.annotations.*;

import com.codility.lesson04.countingelements.PermutationCheck;

//https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/

public class PermutationCheckTests {
	private PermutationCheck solution;
	
	@BeforeTest
	public void setUp() {
		solution = new PermutationCheck();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] { new int [] {                1 }, 1 },
			new Object [] { new int [] {                2 }, 0 },
			new Object [] { new int [] {             1, 2 }, 1 },
			new Object [] { new int [] {             2, 2 }, 0 },
			new Object [] { new int [] {          1, 3, 2 }, 1 },
			new Object [] { new int [] {          1, 3, 3 }, 0 },
			new Object [] { new int [] {       4, 1, 3, 2 }, 1 },
			new Object [] { new int [] {          4, 1, 3 }, 0 },
			new Object [] { new int [] {    1, 3, 5, 4, 2 }, 1 },
			new Object [] { new int [] { 1, 3, 6, 4, 1, 2 }, 0 },
			new Object [] { new int [] { 1, 3, 5, 4, 6, 2 }, 1 },
			new Object [] { new int [] {          1000000 }, 0 },
			new Object [] { new int [] {       1, 1000000 }, 0 },
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int [] pA, int pExpected) {
		Assert.assertEquals(solution.solution(pA), pExpected);
	}
}
