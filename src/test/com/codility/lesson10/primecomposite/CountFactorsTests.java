package test.com.codility.lesson10.primecomposite;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson10.primecomposite.CountFactors;

//https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/

public class CountFactorsTests {
	private CountFactors solution;
	
	@BeforeTest
	public void setUp() {
		solution = new CountFactors();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] {   1, 1 },
			new Object [] {   2, 2 }, //1, 2
			new Object [] {   3, 2 }, //1, 3
			new Object [] {   4, 3 }, //1, 2, 4
			new Object [] {  10, 4 }, //1, 2, 5, 10
			new Object [] {  24, 8 }, //1, 2, 3, 4, 6, 8, 12, 24
			new Object [] {  25, 3 }, //1, 5, 25
			new Object [] {  36, 9 }, //1, 2, 3, 4, 6, 9, 12, 18, 36
			new Object [] {  56, 8 }, //1, 2, 4, 7, 8, 14, 28, 56
			new Object [] { 100, 9 }, //1, 2, 4, 5, 10, 20, 25, 50, 100
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int pA, int pExpected) {		
		Assert.assertEquals(solution.solution(pA), pExpected);
	}	
}
