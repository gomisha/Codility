package test.com.codility.lesson11.sieveoferatosthenes;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson11.sieveoferatosthenes.PrimesDemo;

//reference: https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/

public class PrimesDemoTests {
	private PrimesDemo solution;
	
	@BeforeTest
	public void setUp() {
		solution = new PrimesDemo();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] { 2, new int [] { 2 } },
			new Object [] { 3, new int [] { 2, 3 } },
			new Object [] { 4, new int [] { 2, 3 } },
			new Object [] { 5, new int [] { 2, 3, 5 } },
			new Object [] { 10, new int [] { 2, 3, 5, 7 } },
			new Object [] { 11, new int [] { 2, 3, 5, 7, 11 } },
			new Object [] { 25, new int [] { 2, 3, 5, 7, 11, 13, 17, 19, 23 } },
			new Object [] { 36, new int [] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 } },
			new Object [] { 49, new int [] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47 } },
			new Object [] { 64, new int [] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61 } },
			new Object [] { 66, new int [] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61 } },
			new Object [] { 67, new int [] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67 } },
			new Object [] { 68, new int [] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67 } },
			new Object [] { 69, new int [] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67 } },
			new Object [] { 70, new int [] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67 } },
			new Object [] { 80, new int [] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79 } },
			new Object [] { 90, new int [] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89 } },
			new Object [] { 100, new int [] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 } },
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int pInt, int [] pExpected) {			
		int [] actual = solution.solution(pInt);		
		Assert.assertEquals(actual.length, pExpected.length);		
		for(int i=0; i<actual.length; i++) {		
			Assert.assertEquals(actual[i], pExpected[i]);	
		}		
	}					
}
