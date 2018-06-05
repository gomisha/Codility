package test.com.codility.lesson03.timecomplexity;

//https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/

import org.testng.Assert;
import org.testng.annotations.*;

import com.codility.lesson03.timecomplexity.FrogJump;

public class FrogJumpTests {
	private FrogJump solution;
	
	@BeforeTest
	public void setUp() {
		solution = new FrogJump();
	}
	
	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] { new int [] {    10,      85,     30 },   3 },
			new Object [] { new int [] {     1,      14,      3 },   5 },
			new Object [] { new int [] {   100,    1001,    100 },  10 },
			new Object [] { new int [] {150000,  999999,  10000 },  85 },
			new Object [] { new int [] {150000, 1000000,  10000 },  85 },
			
			//X and Y are the same - no jumps required
			new Object [] { new int [] {     14,      14,      3 },   0 },
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int [] pArgs, int pExpectedJumps) {
		Assert.assertEquals(solution.solution(pArgs[0], pArgs[1], pArgs[2]), pExpectedJumps);
	}
}
