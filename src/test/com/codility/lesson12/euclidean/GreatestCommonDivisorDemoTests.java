package test.com.codility.lesson12.euclidean;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson12.euclidean.GreatestCommonDivisorDemo;

public class GreatestCommonDivisorDemoTests {
	private GreatestCommonDivisorDemo solution;
	
	@BeforeTest
	public void setUp() {
		solution = new GreatestCommonDivisorDemo();
	}

	@DataProvider(name = "gcd")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] { 4, 2, 2  },
			new Object [] { 10, 100, 10  },
			new Object [] { 25, 35, 5  },
			new Object [] { 25, 26, 1  },
			new Object [] { 100, 1125, 25  },
		};
	}

	@DataProvider(name = "lcm")
	public Object [][] createData2() {
		return new Object [][] {
			new Object [] { 4, 2, 2  },
			new Object [] { 10, 100, 2  },
			new Object [] { 25, 35, 5  },
			new Object [] { 25, 26, 1  },
			new Object [] { 100, 1125, 25  },
		};
	}
	
	@Test(dataProvider = "gcd")
	public void verifySolution(int pA, int pB, int pExpected) {			
		Assert.assertEquals(solution.gcdBySubtraction(pA, pB), pExpected);		
	}
	
	@Test(dataProvider = "gcd")
	public void verifySolution2(int pA, int pB, int pExpected) {			
		Assert.assertEquals(solution.gcdByDivision(pA, pB), pExpected);		
	}
}
