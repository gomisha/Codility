package com.codility.lesson13.fibonacci;

import java.util.ArrayList;
import java.util.List;

//https://app.codility.com/programmers/lessons/13-fibonacci_numbers/

public class FibonacciDemo {
	public int[] getFibs(int pN) {
		if(pN == 1) { return new int [] { 0 }; }
		if(pN == 2) { return new int [] { 0, 1 }; }
		
		List<Integer> fibList = new ArrayList<Integer>();
		
		fibList.add(0);
		fibList.add(1);
		generateFibs(fibList, 2, pN);
		
		int [] fibs = new int [fibList.size()];

		for(int i=0; i<fibList.size(); i++) {
			fibs[i] = fibList.get(i);
		}
		
		return fibs;
	}
	
	
	//naive/slowest implementation: fib(n) = fib(n-1) + fib(n-2)
	void generateFibs(List<Integer> pFibList, int pCurrent, int pMax) {
		int currentFib = pFibList.get(pCurrent - 1).intValue() + pFibList.get(pCurrent - 2).intValue();
		pFibList.add(currentFib);

		pCurrent++;
		if(pCurrent == pMax) return;
		else {
			generateFibs(pFibList, pCurrent, pMax);
		}
	}

}
