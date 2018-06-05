package test.com.codility.lesson08.leader;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson08.leader.EquiLeader;

//https://app.codility.com/programmers/lessons/8-leader/equi_leader/

public class EquiLeaderTests {
	private EquiLeader solution;
	
	@BeforeTest
	public void setUp() {
		solution = new EquiLeader();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] { new int [] { 4, 3, 4, 4, 4, 2 }, 2 },
			new Object [] { new int [] { 1, 5, 1, 5, 5, 5, 5, 5 }, 3 },
			new Object [] { new int [] { 1, 1, 1, 1, 1, 1 }, 5 },
			new Object [] { new int [] { 4, 4, 2, 5, 3, 4, 4, 4 }, 3 },
			
			new Object [] { new int [] { 1, 2, 3  }, 0 },
			new Object [] { new int [] { 1000000000  }, 0 },
			new Object [] { new int [] { 1000, 1  }, 0 },
			new Object [] { new int [] { 0, 0  }, 1 },
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int [] pA, int pExpected) {		
		Assert.assertEquals(solution.solution(pA), pExpected);
	}	
}
