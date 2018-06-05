package com.codility.lesson07.stacksqueues;

import java.util.Stack;

//https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/

//Strategy:
//break up each array element into sub-blocks to store on a stack
//for each subsequent array element, check if there are existing blocks on the stack that can create it
//only add new block to the stack if impossible to reuse sub-blocks from stack
//e.g. { 8, 8, 5, 7, 9, 8, 7, 4, 8 }
//will be broken down as follows:
//7 unique blocks would be created:
// (0,8) //8
// (0,8) //8
// (0,5) //5 (after clearing stack)
// (0,5), (5,7) //7
// (0,5), (5,7), (7,9) //9
// (0,5), (5,7), (7,8) //8 (after popping stack)
// (0,5), (5,7) //7 (after popping stack)
// (0,4) // 4 (after clearing stack)
// (0,4), (4,8) //8

public class StoneWall {
	public int solution(int[] H) {

		//e.g. H[0] = 2 would be a block of size (0, 2)
		Block currentBlock = new Block(0, H[0]);
		Stack<Block> blockStack = new Stack<Block>();
		
		blockStack.add(currentBlock);
		int blocksRequired = 1;

		for(int i=1; i<H.length; i++) {
			Block topStackBlock = blockStack.peek();
			
			//remove any stack blocks that are taller than current block
			while(topStackBlock.upperHeight > H[i] ) {
				blockStack.pop();
				if(!blockStack.isEmpty()) {
					topStackBlock = blockStack.peek();
				}
				else break;
			}
			
			if(blockStack.isEmpty()) {
				blockStack.push(new Block(0, H[i]));
				blocksRequired++;
			}
			//block already exists in stack
			else if(blockStack.peek().upperHeight - H[i] == 0) {
				continue;
			}
			//put in a new block - need to calculate delta between tallest stack block and current block
			else {
				topStackBlock = blockStack.peek();
				blockStack.push(new Block(blockStack.peek().upperHeight, H[i]));
				blocksRequired++;
			}
		}
		
		return blocksRequired;
	}
	
	class Block {
		int lowerHeight;
		int upperHeight;
		
		Block(int pLowerHeight, int pUpperHeight) {
			lowerHeight = pLowerHeight;
			upperHeight = pUpperHeight;
		}
	}
}
