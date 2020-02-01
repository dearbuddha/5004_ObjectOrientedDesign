package Recitation2;/*
 * String Stack.java
 * 
 *  This file was created in recitation session 2.
 */

/**
 * This class provides methods for a character stack
 * implemented as a String.
 * 
 * @author phil
 * @since 2020-01-16
 */
public class StringStack {
	/** The string representing the stack */
	String stk = "";
	
	/**
	 * Pop top character from the stack
	 * 
	 * @return the top character from the stack
	 *   or '\0' if empty
	 */
	public char pop() {
		// return null character
		if (stk.isEmpty()) {
			return '\0';
		}
		
		// remove last character from string
		char lastc = stk.charAt(stk.length()-1);
		stk = stk.substring(0, stk.length()-1);
		
		// return last character
		return lastc;
	}
	
	/**
	 * Push character onto the stack.
	 * 
	 * @param c the character to push
	 */
	public void push(char c) {
		// append character to end of string
		stk = stk + c;  
		// note: to create a string from a character:
		// "" + c
	}
	
	/**
	 * Determines whether stack is empty.
	 * 
	 * @return true if stack is empty, false otherwise
	 */
	public boolean isEmpty() {
		// return true if string is empty
		return stk.isEmpty();
	}
	
	/**
	 * Determines whether stack is full.
	 * 
	 * @return true if stack is full, false otherwise
	 */
	public boolean isFull() {
		// return true never because string has no capacity
		return false;
	}
	
	/**
	 * This function tests the stack methods
	 * @param args (unused)
	 */
	public static void main(String[] args) {
		StringStack s = new StringStack();
		
		System.out.printf("isEmpty() ? %b\n", s.isEmpty());
		System.out.printf("isFull() ? %b\n", s.isFull());

		s.push('a');
		System.out.printf("push('%c')\n", 'a');
		System.out.printf("isEmpty() ? %b\n", s.isEmpty());
		System.out.printf("isFull() ? %b\n", s.isFull());
		
		s.push('b');
		System.out.printf("push('%c')\n", 'b');
		System.out.printf("isEmpty() ? %b\n", s.isEmpty());
		System.out.printf("isFull() ? %b\n", s.isFull());

		s.push('c');
		System.out.printf("push('%c')\n", 'c');
		System.out.printf("isEmpty() ? %b\n", s.isEmpty());
		System.out.printf("isFull() ? %b\n", s.isFull());
		
		char c;
		c = s.pop();
		System.out.printf("pop() : '%c'\n", c);
		c = s.pop();
		System.out.printf("pop() : '%c'\n", c);
		c = s.pop();
		System.out.printf("pop() : '%c'\n", c);

		c = s.pop();
		System.out.printf("pop() : '%c'\n", c);

		System.out.printf("isEmpty() ? %b\n", s.isEmpty());
		System.out.printf("isFull() ? %b\n", s.isFull());
	}
}
