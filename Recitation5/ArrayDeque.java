package Recitation5;

public class ArrayDeque {

    /** Character array for values as circular array. */
    char[] dequeArr;

    /** Points to the front element in the queue. */
    private int front = 0;

    /** Points to next available space from rear element. */
    private int rear = 0;

    /** Number of elements in the queue. */
    private int numOfElements = 0;

    /**
     * Constructor, to initialize the capacity of the queue.
     * If the input capacity is less than 1, then capacity
     * is reinitialized as one.
     *
     * @param capacity capacity of the queue.
     */
    public ArrayDeque(int capacity) {
        if (capacity < 1) {
            capacity = 1;
        }
        dequeArr = new char[capacity];
    }

    public char peekFirst(){
        if(isEmpty()){
            throw new IllegalArgumentException("Deque is empty.");
        }
        return dequeArr[front];
    }

    public char peekLast(){
        if(isEmpty()){
            throw new IllegalArgumentException("Deque is empty.");
        }
        if(rear == 0) return dequeArr[capacity()-1];
        return dequeArr[rear-1];
    }

    /**
     * Inserts an element to the front of the deque.
     *
     * @param c element to be inserted.
     */
    public void addFirst(char c) {
        if (isFull()) resize();

        if(front == 0) front = capacity()-1;
        else front=front-1;
        dequeArr[front] = c;
        numOfElements++;
    }

    public void addLast(char c){
        if (isFull()) resize();

        dequeArr[rear] = c;
        rear = (rear + 1) % capacity();
        numOfElements++;
    }

    public char removeFirst(){
        if(isEmpty()) return '\0';
        char frontElement = peekFirst();
        dequeArr[front] = '\0';
        front = (front + 1) % capacity();
        numOfElements--;  // decrease number elements in queue
        return frontElement;
    }

    /**
     * Gives the front element entered in the queue.
     *
     * @return front element of queue or '\0' if empty
     */
    public char removeLast() {
        // return null character if empty
        if(isEmpty()) return '\0';
        char rearElement = peekLast();
        if(rear == 0) rear = capacity()-1;
        rear = rear -1;
        dequeArr[rear] = '\0';
        numOfElements--;
        return rearElement;
    }

    /**
     * Determines whether queue is empty or not.
     *
     * @return true if queue is empty
     */
    public boolean isEmpty() {
        // number of elements is zero
        return size() == 0;
    }

    /**
     * Determines whether queue is full or not
     *
     * @return true if the queue is full.
     */
    public boolean isFull() {
        // number of elements is equal to size of the queue.
        return size() == capacity();
    }

    /**
     * Number of elements the queue can occupy.
     *
     * @return capacity of the queue.
     */
    public int capacity() {
        return dequeArr.length;
    }

    /**
     * Number of elements in the queue.
     *
     * @return size of queue.
     */
    public int size() {
        return numOfElements;
    }

    /**
     * Resize the capacity of the queue array.
     */
    public void resize() {
        // allocate a new array twice the size
        char[] resizedArr = new char[2 * capacity()];

        // copy elements of the old array to a new array
        int oldIndex = front;
        for (int i = 0; i < size(); i++) {
            resizedArr[i] = dequeArr[oldIndex];
            oldIndex = (oldIndex + 1) % capacity();
        }

        // replace the old array with the new array.
        dequeArr = resizedArr;

        // reset the array of the queue indices.
        front = 0;
        rear = size();
    }

    /**
     * Return string representation of queue. Format is:
     * "[capacity: n, size: n, values: [v1, v2, ..., vn]]"
     *
     * @return string representation of queue
     */
    public String toString() {
        // create string builder
        StringBuilder sb = new StringBuilder();

        // add opening [
        sb.append('[');

        // add capacity
        sb.append("capacity: ");
        sb.append(capacity());

        // add size
        sb.append(", size: ");
        sb.append(size());

        // add opening [ for values
        sb.append(", values: [");

        // add values in dequeue order
        int nextIndex = front;
        for (int i = 0; i < size(); i++) {
            sb.append(dequeArr[nextIndex]);
            nextIndex = (nextIndex + 1) % capacity();
            if (nextIndex != rear) { // more chars to print
                sb.append(", ");
            }
        }

        // add closing ] for values
        sb.append("]");

        // add closing ] for queue
        sb.append(']');

        // return builder as string
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}


