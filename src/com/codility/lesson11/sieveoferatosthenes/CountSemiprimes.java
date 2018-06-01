package com.codility.lesson11.sieveoferatosthenes;

import java.util.ArrayList;
import java.util.List;

//https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_semiprimes/

public class CountSemiprimes {
	public int[] solution(int N, int[] P, int[] Q) {
		//make size N+1 so will have direct mapping from array index
		boolean [] arePrimes = new boolean[N+1];

		arePrimes[0] = false; //0 is never prime
		arePrimes[1] = false; //1 is never prime
		for(int i=2; i<arePrimes.length; i++) {
			arePrimes[i] = true;
		}

		int nSquareRoot = (int) Math.sqrt(N);
		for(int i=2; i<=nSquareRoot; i++) {
			if(arePrimes[i]) {
				//start checking from i^2 because lower numbers will have already been checked
				//keep checking very multiple of i
				for(int j=i*i; j<=N; j+=i) {
					arePrimes[j] = false;
				}
			}
		}

		List<Integer> primesList = new ArrayList<Integer>();
		for(int i=2; i<arePrimes.length; i++) {
			if(arePrimes[i]) {
				primesList.add(i);
			}
		}

		//https://stackoverflow.com/questions/960431/how-to-convert-listinteger-to-int-in-java
		int[] primes = primesList.stream().mapToInt(i->i).toArray();

		int [] semiPrimes = new int[N + 1];	

		//populate semi primes set in order
		//reference: https://codesays.com/2014/solution-to-count-semiprimes-by-codility/
		for(int i=0; i<primes.length-1; i++) {
			if(primes[i] * primes[i] > N) {
				continue;
			}
			semiPrimes[primes[i]*primes[i]] = 1;  //square of the prime
			for(int j=i+1; j<primes.length; j++) {
				if(primes[i] * primes[j] > N) {
					break; //semi primes are larger than N so can stop calculating them
				}
				semiPrimes[primes[i]*primes[j]] = 1;
			}
		}
		
		for(int i=1; i<semiPrimes.length; i++) {
			semiPrimes[i] += semiPrimes[i-1];
		}
		
		int [] results = new int[P.length];
		for(int i=0; i<P.length; i++) {
			results[i] = semiPrimes[Q[i]] - semiPrimes[P[i] - 1];
		}
		return results;
	}
}
