package com.codility.lesson07.stacksqueues;

import java.util.Stack;

//https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/
//
//almost the exact same implementation as Brackets problem - only difference is that that solution also
//checked for "{}[]" but this one only checks for "()"

public class Nesting {
	public int solution(String S) {
		if(S.length() % 2 != 0) return 0; //all odd numbered strings can't be properly nested
		
		Stack <Character> charStack = new Stack<Character>();
	
		for(int i=0; i<S.length(); i++) {
			char currentChar = S.charAt(i);
			if(isOpeningBracket(currentChar)) {
				charStack.push(currentChar);
			}
			else {
				//adding closing bracket to empty stack will never become properly nested
				if(charStack.size() == 0) {
					return 0;
				}
				char poppedChar = charStack.pop();
				if(isBracketMatch(poppedChar, currentChar)) {
					continue;
				}
				else return 0;
			}
		}
		if(charStack.isEmpty()) return 1;
		
		return 0;
	}

	boolean isOpeningBracket(char pC) {
		if(pC == '(') {
			return true;
		}
		return false;
	}
	
	boolean isBracketMatch(char pC1, char pC2) {
		if(pC1 == '(' && pC2 == ')') return true;
		
		return false;
	}
}
