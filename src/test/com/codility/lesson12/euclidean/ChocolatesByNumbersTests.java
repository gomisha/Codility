package test.com.codility.lesson12.euclidean;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson12.euclidean.ChocolatesByNumbers;

//https://app.codility.com/programmers/lessons/12-euclidean_algorithm/chocolates_by_numbers/

public class ChocolatesByNumbersTests {
	private ChocolatesByNumbers solution;
	
	@BeforeTest
	public void setUp() {
		solution = new ChocolatesByNumbers();
	}

	@DataProvider(name = "data1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] { 10, 4, 5 },
			new Object [] { 10, 3, 10 },
			new Object [] { 5, 6, 5 },
			new Object [] { 5, 7, 5 },
			new Object [] { 1, 1, 1 },
			new Object [] { 2, 1, 2 },
			new Object [] { 100, 1, 100 },
		};
	}
	
	@Test(dataProvider = "data1")
	public void verifySolution(int pN, int pM, int pExpected) {			
		Assert.assertEquals(solution.solve(pN, pM), pExpected);		
	}
}
