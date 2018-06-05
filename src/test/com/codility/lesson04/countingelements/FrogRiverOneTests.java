package test.com.codility.lesson04.countingelements;

//https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/

import org.testng.Assert;
import org.testng.annotations.*;

import com.codility.lesson04.countingelements.FrogRiverOne;

public class FrogRiverOneTests {
	private FrogRiverOne solution;
	
	@BeforeTest
	public void setUp() {
		solution = new FrogRiverOne();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] { 5, new int [] {             1, 3, 1, 4, 2, 3, 5, 4 },  6 },
			new Object [] { 3, new int [] {                               1, 3 }, -1 }, //never gets across
			new Object [] { 2, new int [] {                         1, 1, 1, 1 }, -1 }, //never gets across
			new Object [] { 3, new int [] {                         1, 4, 2, 3 },  3 },
			new Object [] { 2, new int [] {                         1, 4, 2, 3 },  2 },
			new Object [] { 4, new int [] { 1, 2, 3, 2, 3, 3, 1, 2, 2, 4, 2, 1 },  9 },
			new Object [] { 4, new int [] { 1, 2, 3, 2, 3, 3, 1, 2, 4, 4, 2, 1 },  8 },
			new Object [] { 4, new int [] { 1, 2, 3, 4, 3, 3, 1, 2, 4, 4, 2, 1 },  3 },
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int pX, int [] pA, int pExpected) {
		Assert.assertEquals(solution.solution(pX, pA), pExpected);
	}
}
