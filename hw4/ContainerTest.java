package hw4;
/**
 *  Wenhan Cai
 *  CS 5004 homework 4-2
 */
class Container {
    Integer capacity;
    Integer quantity;

    public Container(int capacity){
        this.capacity = capacity;
        this.quantity = 0;
    }

    public int quantity(){
        return quantity;
    }

    public int leftOver(){
        return capacity-quantity;
    }

    public void full(){
        quantity = capacity;
    }

    public void empty(){
        quantity = 0;
    }

    public void transfer(Container receiver, int amount){
        if(amount > receiver.capacity){
            System.out.println("Failed. No enough room left to fill the receiver container.");
        } else if( amount > this.quantity){
            System.out.println("Failed. No enough liquid in the giver container.");
        } else {
            this.quantity = this.quantity - amount;
            receiver.quantity = receiver.quantity + amount;
        }
    }

    public void displayQuantity(){
        System.out.print("There are " + quantity + " liters of liquid");
    }
}

public class ContainerTest {
    public static void main(String[] args) {

        System.out.println("-----Initialize container1 with capacity 10 and container2 with capacity 15-----");
        Container container1 = new Container(10);
        Container container2 = new Container(15);

        System.out.println("-----Test displayQuantity() on empty container1-----");
        container1.displayQuantity();

        System.out.println("\n-----Test full() on container1-----");
        container1.full();
        container1.displayQuantity();

        System.out.println("\n-----Test empty() on container1-----");
        container1.empty();
        container1.displayQuantity();

        System.out.println("\n-----Test full() container1 and transfer all liquid in container1 to container2-----");
        container1.full();
        container1.transfer(container2, 10);
        container2.displayQuantity();
        System.out.println(" in container2");
        container1.displayQuantity();
        System.out.println(" in container1");

        System.out.println("\n-----Now full() container1 again and try to transfer all liquid in container1 " +
                "to container2 this time-----");
        container1.full();
        container1.transfer(container2, 10);
        container2.displayQuantity();
        System.out.println(" in container2");
        container1.displayQuantity();
        System.out.println(" in container1");

        System.out.println("-----Test leftOver() on container2-----");
        System.out.println("The current quantity of liquid that can be filled in container2 before it is full: "
                + container2.leftOver());

        System.out.println("-----Test quantity() on container2-----");
        System.out.println("The current quantity of liquid in container2: " + container2.quantity());
    }
}
