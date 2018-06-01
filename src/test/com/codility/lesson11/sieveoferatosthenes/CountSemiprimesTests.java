package test.com.codility.lesson11.sieveoferatosthenes;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson11.sieveoferatosthenes.CountSemiprimes;

//https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_semiprimes/

public class CountSemiprimesTests {
	private CountSemiprimes solution;
	
	@BeforeTest
	public void setUp() {
		solution = new CountSemiprimes();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] { 26, new int [] { 1, 4, 16 }, new int [] { 26, 10, 20 }, new int [] { 10, 4, 0 } },
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int pInt, int [] pP, int [] pQ, int [] pExpected) {			
		int [] actual = solution.solution(pInt, pP, pQ);		
		Assert.assertEquals(actual.length, pExpected.length);		
		for(int i=0; i<actual.length; i++) {		
			Assert.assertEquals(actual[i], pExpected[i]);	
		}		
	}
}
