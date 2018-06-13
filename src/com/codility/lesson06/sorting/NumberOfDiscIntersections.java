package com.codility.lesson06.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/

//main strategy:
//create an ordered array of circles, each item consisting of (leftmost x, rightmost x)
//have a custom Comparator to order the Circles based on where their radius starts and stops
//check intersection by comparing rightmost x with leftmost x of next element

public class NumberOfDiscIntersections {
	public int solution(int[] A) {
		List<Circle> aList = new ArrayList<Circle>();
		
        for(int i=0; i<A.length; i++) {
        	//need explicit cast to long on right side for case when A[i] is Integer.MAX_VALUE and adding would cause overflow
        	long leftMost = i - (long) A[i];
        	long rightMost = i + (long) A[i];

        	aList.add(new Circle(leftMost, rightMost));
        }
        
    	Collections.sort(aList, new CircleComparator());
    	
    	Circle [] aOrderedCircles = new Circle[A.length];
    	int index = 0;
        
    	for(Circle circle : aList) {
    		aOrderedCircles[index++] = circle;
    	}

    	int intersections = 0;
		
		for(int i=0; i<aOrderedCircles.length-1; i++) {
			for(int j=i+1; j<aOrderedCircles.length; j++) {
				//check intersection by comparing rightmost x with leftmost x of next element
				if(aOrderedCircles[i].rightMostX >= aOrderedCircles[j].leftMostX) {
					intersections++;
					
					if(intersections > 10000000) return -1;
				}
				//as soon as don't find intersection, stop counting cause circles are ordered so all subsequent circles won't intersect
				else break; 
			}
		}
		return intersections;
    }
	
	class Circle {
		long leftMostX;
		long rightMostX;
		
		Circle(long pLeftMostX, long pRightMostX) {
			leftMostX = pLeftMostX;
			rightMostX = pRightMostX;
		}
	}
	
	//reference: https://stackoverflow.com/questions/2839137/how-to-use-comparator-in-java-to-sort
	class CircleComparator implements Comparator<Circle> {

		@Override
		public int compare(Circle pCircle1, Circle pCircle2) {
			if(pCircle1.leftMostX < pCircle2.leftMostX) return -1; //e.g. circle1 (-4, 6) < circle2 (-2, 9)
			if(pCircle2.leftMostX < pCircle1.leftMostX) return 1;  //e.g. circle2 (-4, 6) < circle1 (-3, 1)
			if(pCircle1.rightMostX < pCircle2.rightMostX) return -1; //e.g. circle1 (-4, 3) < circle2 (-4, 6)
			if(pCircle2.rightMostX < pCircle1.rightMostX) return 1;  //e.g. circle2 (-4, 3) < circle1 (-4, 1)
			
			return 0;  //e.g. circle1 (-2, 2), circle2 (-2, 2)
		}
	}
}
