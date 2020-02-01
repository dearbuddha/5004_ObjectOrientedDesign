package Recitation2;

public class CharStack {

    char items[] = new char[10];
    int topIndex = -1;

    public void push(char item){
        if (topIndex >= 9){
            System.out.println("Stack is full.");
            return;
        }

        topIndex ++;
        items[topIndex] = item;
    }

    public char pop() {
        if(isEmpty()) {
            System.out.println("Stack is empty.");
            return ' ';
        }

        char poppedItem = items[topIndex];
        items[topIndex] = ' ';
        topIndex --;
        return poppedItem;
    }

    public char peek(){
        if (isEmpty()){
            System.out.println("Stack is Empty.");
            return ' ';
        }
        return items[topIndex];
    }

    public boolean isEmpty(){
        return topIndex == -1;
    }

    public static void main(String[] args) {
        CharStack stack = new CharStack();
        String helloStr = "hello";
        for(int i = 0; i<helloStr.length(); i ++){
            stack.push(helloStr.charAt(i));
        }

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
