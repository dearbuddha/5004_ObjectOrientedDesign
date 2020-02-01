package Recitation2;

/**
 * CS 5005 Recitation - Session 2.
 *
 * This class provides methods to implement stack with character array.
 */
public class ArrayStack {

    /**  character array of size 10 to represent a stack. */
    char[] items = new char[10];

    /** index of the top element. */
    int topIndex = -1;

    /**
     * Push a character item to the stack.
     * @param item item to be pushed.
     */
    public void push(char item) {
        if (topIndex >= 9) {
            System.out.println("Stack is full");
            return;
        }

        topIndex = topIndex + 1;
        items[topIndex] = item;

        System.out.println("Element " + item + " is pushed.");
    }

    /**
     * Remove and return the top character element out of the stack.
     *
     * @return top character element of stack.
     */
    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty.");
            return ' ';
        }

        char poppedElement = items[topIndex];
        items[topIndex] = '\0';
        topIndex = topIndex - 1;

        return poppedElement;
    }

    /**
     * Peeks the top character element of the stack.
     *
     * @return top element of the stack
     */
    public char peek() {

        if (isEmpty()) {
            System.out.println("Stack is Empty.");
            return '\0';
        }

        return items[topIndex];
    }

    /**
     * Determines whether stack is empty or not.
     *
     * @return true if stack is empty.
     */
    public boolean isEmpty() {
        return topIndex == -1;
    }

    /**
     * Tests the stack implementation.
     * @param args (unused)
     */
    public static void main(String[] args) {

        ArrayStack arrayStack = new ArrayStack();

        String helloStr = "hello";
        for (int i = 0; i < helloStr.length(); i++) {
            arrayStack.push(helloStr.charAt(i));
        }

        while(!arrayStack.isEmpty()) {
            System.out.println(arrayStack.pop());
        }
    }
}