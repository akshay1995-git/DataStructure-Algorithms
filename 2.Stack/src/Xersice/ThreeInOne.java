package Xersice;

public class ThreeInOne {
	  private int numberOfStacks = 3;
	  private int stackCapacity;
	  private int[] values;
	  private int[] numOfStack;

	  public ThreeInOne(int stackSize) {
	    // TODO
		  this.stackCapacity=stackSize;
		  this.values=new int[stackSize*numberOfStacks];
		  numOfStack=new int[numberOfStacks];
	  }

	  // isFull
	  public boolean isFull(int stackNum) {
	    // TODO
		  if(numOfStack[stackNum]==stackCapacity) {
			  return true;
		  }
		  return false;
	  }

//	  // isEmpty
//	  public boolean isEmpty(int stackNum) {
//	      // TODO
//	  }
//
//	  // indexOfTop - this is helper method for push, pop and peek methods
//
//	  private int indexOfTop(int stackNum) {
//	    // TODO
//	  }
//
//	  // push
//	  public void push(int stackNum, int value) {
//	    // TODO
//	  }
//
//	  // pop
//	  public int pop(int stackNum) {
//	    // TODO
//	  }
//
//	  // peek
//
//	  public int peek(int stackNum) {
//	    // TODO
//	  }

	}
