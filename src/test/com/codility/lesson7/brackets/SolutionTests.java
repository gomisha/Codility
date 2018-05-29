package test.com.codility.lesson7.brackets;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson7.brackets.Solution;

//https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/

public class SolutionTests {
	private Solution solution;
	
	@BeforeTest
	public void setUp() {
		solution = new Solution();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] { "{[()()]}", 1 }, 
			new Object [] { "{[(){([])}()]}", 1 },
			new Object [] { "{}", 1 },
			new Object [] { "()", 1 },
			new Object [] { "[]", 1 },
			new Object [] { "[([][])()]", 1 },
			new Object [] { "([)()]", 0 },
			new Object [] { "(]", 0 },
			new Object [] { "", 1 },
			new Object [] { "{{{{", 0 },
			new Object [] { "))", 0 },
			
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(String pS, int pExpected) {		
		Assert.assertEquals(solution.solution(pS), pExpected);
	}	
}
