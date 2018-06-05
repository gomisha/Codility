package test.com.codility.lesson08.leader;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson08.leader.Dominator;

//https://app.codility.com/programmers/lessons/8-leader/dominator/

public class DominatorTests {
	private Dominator solution;
	
	@BeforeTest
	public void setUp() {
		solution = new Dominator();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] { new int [] { 3, 4, 3, 2, 3, -1, 3, 3 }, 0 },
			new Object [] { new int [] { 100, 100, 100, 100, 100, 100  }, 0 },
			new Object [] { new int [] { 100, -1000, 100, -1000, -1000  }, 1 },
			new Object [] { new int [] { 1, 2, 3  }, -1 },
			new Object [] { new int [] { 1000000000  }, 0 },
			new Object [] { new int [] { 1000, 1  }, -1 },
			new Object [] { new int [] { 0, 0  }, 0 },
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int [] pA, int pExpected) {		
		Assert.assertEquals(solution.solution(pA), pExpected);
	}	
}
